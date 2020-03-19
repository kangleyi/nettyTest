package org.netty.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient implements Runnable{

    final Socket socket;

    public ServerClient(Socket socket) {
        this.socket = socket;
        System.out.println("已建立连接，目标主机"+socket.getInetAddress().getHostAddress()+":"+socket.getPort());
    }

    @Override
    public void run() {
        String line;
        BufferedReader is;
        try {
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输出流，并构造PrintWriter对象
            PrintWriter os=new PrintWriter(socket.getOutputStream());
            //由系统标准输入设备构造BufferedReader对象
            BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
            //在标准输出上打印从客户端读入的字符串
            System.out.println("Client:"+is.readLine());
            //从标准输入读入一字符串
            line=sin.readLine();
            //如果该字符串为 "bye"，则停止循环
            while(!line.equals("bye")){
                //向客户端输出该字符串
                os.println(line);
                //刷新输出流，使Client马上收到该字符串
                os.flush();
                //在系统标准输出上打印读入的字符串
                System.out.println("Server:"+line);
                //从Client读入一字符串，并打印到标准输出上
                System.out.println("Client:"+is.readLine());
                //从系统标准输入读入一字符串
                line=sin.readLine();
            }

            os.close(); //关闭Socket输出流
            is.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
