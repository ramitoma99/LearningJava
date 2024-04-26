package com.rami.serverclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client{
  public void startClient() throws IOException {
    int clientPort = 1234;

    Socket clientSocket = new Socket("localhost", clientPort);
    if (clientSocket.isConnected()){
      System.out.println("Client is connected to port " + clientPort);
    } else {
      System.out.println("Client is not connected to port " + clientPort);
    }
    DataOutputStream clientMsg = new DataOutputStream(clientSocket.getOutputStream());
    clientMsg.writeUTF("Hello server");
    clientMsg.writeUTF("close server");
  }
}
