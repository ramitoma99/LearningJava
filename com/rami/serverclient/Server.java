package com.rami.serverclient;

import java.net.*;
import java.io.*;

public class Server{
  int serverPort;
  boolean serverRunning = true;
  public void startServer(int serverPort) throws IOException{
    this.serverPort = serverPort;

    ServerSocket serverSocket1 = new ServerSocket(serverPort);

    if(serverSocket1.isBound()){
      System.out.println("Server is listening on port " + serverPort);
      } else {
      System.out.println("Server is not listening on port " + serverPort);
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

