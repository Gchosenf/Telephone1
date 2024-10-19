package com.gml.Server;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("服务器启动，等待连接...");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("客户端连接：" + socket.getInetAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
            String line;
            while ((line = input.readLine()) != null) {
                output.println("接收到: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
