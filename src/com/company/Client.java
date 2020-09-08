package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static int PORT = 8189;
    private static final String IP_ADDRESS = "localhost";

    public static void main(String[] args) {
        Socket socket;
        Scanner in;
        Scanner scanner = new Scanner(System.in);
        PrintWriter out;
        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Мы подключились!");
            in = new Scanner(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        out.println(scanner.nextLine());
                    }
                }
            }).start();

            while (true) {
                String str = in.nextLine();

                if (str.equals("/end")) {
                    System.out.println("Мы отключились от сервера");
                    break;
                }

                System.out.println("Сервер: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
