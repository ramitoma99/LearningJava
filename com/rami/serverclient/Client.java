package com.rami.serverclient;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client{
  int clientPort;
  public void startClient(int clientPort) throws IOException {
    this.clientPort = clientPort;
    Socket clientSocket = new Socket("localhost", clientPort);
    if (clientSocket.isConnected()){
      System.out.println("Client is connected to port " + clientPort);
    } else {
      System.out.println("Client is not connected to port " + clientPort);
    }
  }
  public void sendMsg() throws IOException {
    boolean sendingMsg = true;
    while (sendingMsg) {
      System.out.println("Please enter your message to the server or \"x\" to exit:");
      Scanner userInput = new Scanner(System.in);
      String userMsg = userInput.nextLine();

      if (userMsg.equals("x")){
        sendingMsg = false;
      } else {
        try {
          Socket clientSocket = new Socket("localhost", clientPort);
          DataOutputStream clientMsg = new DataOutputStream(clientSocket.getOutputStream());
          clientMsg.writeUTF(userMsg);
          System.out.println("Message sent to server: " + userMsg);
        } catch (IOException e){
          System.out.println("Failed to send message to server");
          e.printStackTrace();
        }
      }
    }
  }
}
