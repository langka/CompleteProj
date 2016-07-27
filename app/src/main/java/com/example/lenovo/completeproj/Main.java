package com.example.lenovo.completeproj;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by lenovo on 2016/7/26.
 */
//192.168.1.115
public class Main {
    private  static final int port = 8000;
    public static  void main(){
        new Main();
    }
    public Main(){
        try{
            ServerSocket serverSocket  = new ServerSocket(port);
            System.out.println("Server Start...");
        }
        catch(IOException e){
            System.out.println("SOMETHING HAPPENED");
        }
    }
}
