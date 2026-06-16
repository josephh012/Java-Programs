import threading 
import time 
from typing import List 

class VehicleNotAvailableException(Exception): 
    pass 

class PaymentFailedException(Exception): 
    pass 

class Vehicle: 
    def __init__(self, vehicle_id: int, vehicle_type: str, rent_per_hour: float): 
        self.vehicle_id = vehicle_id 
        self.vehicle_type = vehicle_type 
        self.rent_per_hour = rent_per_hour 
        self.is_available = True 
    
    def book(self): 
        if not self.is_available: 
            raise VehicleNotAvailableException("Vehicle is not available for booking.") 
        self.is_available = False 
    
    def return_vehicle(self): 
        self.is_available = True 

class User: 
    def __init__(self, user_id: int, name: str): 
        self.user_id = user_id 
        self.name = name 

class Payment: 
    @staticmethod 
    def process_payment(amount: float) -> bool: 
        if amount <= 0: 
            raise PaymentFailedException("Invalid payment amount.") 
        time.sleep(1)  # Simulate payment processing delay 
        return True 

class RentalSystem: 
    def __init__(self): 
        self.vehicles: List[Vehicle] = [] 
        self.lock = threading.Lock() 
    
    def add_vehicle(self, vehicle: Vehicle): 
        self.vehicles.append(vehicle) 
    
    def rent_vehicle(self, user: User, vehicle_id: int, hours: int): 
        with self.lock: 
            vehicle = next((v for v in self.vehicles if v.vehicle_id == vehicle_id), None) 
            if not vehicle or not vehicle.is_available: 
                raise VehicleNotAvailableException("Vehicle not available.") 
            
            total_cost = vehicle.rent_per_hour * hours 
            if Payment.process_payment(total_cost): 
                vehicle.book() 
                print(f"{user.name} has rented {vehicle.vehicle_type} (ID: {vehicle.vehicle_id}) for {hours} hours.") 
    
    def return_vehicle(self, vehicle_id: int): 
        with self.lock: 
            vehicle = next((v for v in self.vehicles if v.vehicle_id == vehicle_id), None) 
            if vehicle: 
                vehicle.return_vehicle() 
                print(f"Vehicle ID {vehicle_id} has been returned and is now available.") 

def rental_request(rental_system: RentalSystem, user: User, vehicle_id: int, hours: int): 
    try: 
        rental_system.rent_vehicle(user, vehicle_id, hours) 
    except (VehicleNotAvailableException, PaymentFailedException) as e: 
        print(f"Error for {user.name}: {e}") 

if __name__ == "__main__": 
    rental_system = RentalSystem() 
    rental_system.add_vehicle(Vehicle(1, "Car", 10)) 
    rental_system.add_vehicle(Vehicle(2, "Bike", 5)) 
    
    user1 = User(101, "Alice") 
    user2 = User(102, "Bob") 
    
    t1 = threading.Thread(target=rental_request, args=(rental_system, user1, 1, 3)) 
    t2 = threading.Thread(target=rental_request, args=(rental_system, user2, 1, 2)) 
    
    t1.start() 
    t2.start() 
    
    t1.join() 
    t2.join() 
    
    rental_system.return_vehicle(1)
