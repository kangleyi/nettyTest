package org.netty.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public static void main(String[] args) {

        try {
            ServerSocket sc=new ServerSocket(8888);
            System.out.println("服务启动成功！端口：8888");
            Socket socket;
            while (true){
                System.out.println("等待连接。。。！");
                socket=sc.accept();
                new Thread(new ServerClient(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
