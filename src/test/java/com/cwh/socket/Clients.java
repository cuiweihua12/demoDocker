package com.cwh.socket;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author cwh
 * @date 2020/12/28 10:07
 */
public class Clients {
    @SneakyThrows
    public static void main(String[] args) {

        String readline = null;
        String inTemp = null;
        //String outTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        Socket socket = new Socket("localhost",4000);
        //系统输入流
        BufferedReader systemInBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //socket输入流
        BufferedReader socketbBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //socket输出流
        PrintStream socketbuPrintStream = new PrintStream(socket.getOutputStream());


        while(readline != "bye"){

            System.out.println(client);
            readline = systemInBufferedReader.readLine();
            //System.out.println(readline);

            socketbuPrintStream.println(readline);
            socketbuPrintStream.flush();    //赶快刷新使Server收到

            //outTemp = readline;
            inTemp = socketbBufferedReader.readLine();

            //System.out.println(client + outTemp);
            System.out.println(server + turnLine + inTemp);

        }

        systemInBufferedReader.close();
        socketbBufferedReader.close();
        socketbuPrintStream.close();
        socket.close();
    }
}
