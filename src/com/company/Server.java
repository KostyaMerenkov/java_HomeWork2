package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int PORT = 8189;

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(PORT);
            System.out.println("Сервер запущен");

            socket = server.accept();
            System.out.println("Клиент подключился");

            Scanner scanner = new Scanner(System.in);
            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

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
                    System.out.println("Клиент отключился");
                    out.println("/end");
                    break;
                }

                System.out.println("Клиент: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
