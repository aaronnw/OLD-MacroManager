package dev.wilson.aaron.macromanager;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron.Wilson on 8/3/2016.
 */
public class ConnectionObject{
    private String server;
    //Use a port between 1024-49151
    private int port;
    private Socket client;

    public ConnectionObject(){
        server = null;
        port = 0;
    }
    public ConnectionObject(String server, int port){
        this.server = server;
        this.port = port;
    }

    public int start(){
        //scan for an empty port
        int result = 0;
        try{
            client = new Socket(server, port);
            if(client.isConnected()){
                result = 1;
            }
        }catch(IOException e){
            result = 0;
        }
        return result;
    }

    boolean checkConnection(){
        if(client.isConnected()){
            return true;
        }else{
            return false;
        }
    }

    void close(){
        if(checkConnection()){
            try{
                client.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    void setServer(String server){
        this.server = server;
    }
    void setPort(int port){
        this.port = port;
    }
}
