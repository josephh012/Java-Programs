#include<stdio.h>
#include<winsock2.h>
#include <ws2tcpip.h>
#include<string.h>
#include<unistd.h>
int main(){
	int serversocket,clientsocket,length,port=8080;
	struct sockaddr_in serveraddr,clientaddr;
	char message[500];
	length=sizeof(clientaddr);
	serversocket=socket(AF_INET,SOCK_STREAM,0);
	serveraddr.sin_family=AF_INET;
	serveraddr.sin_port=htons(port);
	serveraddr.sin_addr.s_addr=INADDR_ANY;
	bind(serversocket(struct sockaddr*),&serveraddr,sizeof(serveraddr));
	listen(serversocket,5);
	clientsocket=accept(serversocket(struct sockaddr*),&clientaddr,&length);
	printf("connection recieved");
	write(clientsocket,"heyclient",sizeof("heyclient");
	read(clientsocket,&message,sizeof(message));
	printf("message from client: %s",message);
	close(serversocket);
	close(clientsocket);
	return 0;
}
	
	
	