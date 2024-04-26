package com.rami.serverclient;

import java.net.*;
import java.io.*;

public class Server{
  public void startServer() throws IOException{
    
    int port = 1234;
    ServerSocket serverSocket1 = new ServerSocket(port);
    boolean serverRunning = true;

    if(serverSocket1.isBound()){
      System.out.println("Server is listening on port " + port);
      } else {
      System.out.println("Server is not listening on port " + port);
      }

    Client client1 = new Client();
    client1.startClient();

    while (serverRunning){
      Socket clientSocket = serverSocket1.accept();
      System.out.println("Client connected");
      DataInputStream recievedClientMsg = new DataInputStream(clientSocket.getInputStream());
      String clientMsg = recievedClientMsg.readUTF();
      System.out.println("Client message: " + clientMsg);
      if(clientMsg.equals("close server")){
        serverRunning = false;
      }
    }
    serverSocket1.close();
  }
}

