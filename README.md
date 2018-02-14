# ChatRoom
@By Jeremy Zhang
## Project Description
1. java socket, java multithread, JFrame
2. OOP
3. TCP protocol

The Chat Room is a instant message application implemented in Java.

The server need to be executed first to accept incoming connection from client. Therefore, thanks to multithread implemented in server side, clients will be able to talk to each other by using a simple GUI.

Once a new connection is built, on the server side, the server will create a particular thread to server the particular client.

Connected client socket will be stored in the static vector in the server side, server can update the number of connection once a new connection's established or a old one's finished.

#### remote client
![chatroom](https://user-images.githubusercontent.com/29811075/36135435-f11dc524-103f-11e8-9d17-54fe877a3896.png)

#### local client
![2018-02-12 9 57 40](https://user-images.githubusercontent.com/29811075/36135476-3dd1aa66-1040-11e8-8be6-bcb7d0a44fc1.png)
