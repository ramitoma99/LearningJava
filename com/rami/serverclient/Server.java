package com.rami.serverclient;

import java.net.*;
import java.io.*;

public class Server{
  int port = 1234;
  boolean serverRunning = true;
  public void startServer() throws IOException{

    ServerSocket serverSocket1 = new ServerSocket(port);

    if(serverSocket1.isBound()){
      System.out.println("Server is listening on port " + port);
      } else {
      System.out.println("Server is not listening on port " + port);
      }

    while (serverRunning){
      try {
        Socket clientSocket = serverSocket1.accept();
        DataInputStream recievedClientMsg = new DataInputStream(clientSocket.getInputStream());
        System.out.println("Client connected");
        String clientMsg = recievedClientMsg.readUTF();
        System.out.println("Client message: " + clientMsg);
        if (clientMsg.equals("close server")) {
          serverRunning = false;
        }
      } catch (IOException e) {
        System.out.println("Error handling client connection");
        e.printStackTrace();
      }
    }
    serverSocket1.close();
  }
}

