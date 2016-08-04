package dev.wilson.aaron.macromanager;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Aaron.Wilson on 8/3/2016.
 */
public class ConnectionObject extends AsyncTask<Void,Void,Void>{
    private String server;
    //Use a port between 1024-49151
    private int port;
    private Socket client;

    public ConnectionObject(){
        server = null;
        port = 0;
    }

    @Override
    protected Void doInBackground(Void... voids){
        start();
        return null;
    }

    public ConnectionObject(String server, int port){
        this.server = server;
        this.port = port;
    }

    public void start(){
        //scan for an empty port
        try{
            client = new Socket(server, port);
        }catch(IOException e){
        }
    }

    boolean checkConnection(){
        if(client != null){
            if(client.isConnected()){
                return true;
            }else{
                return false;
            }
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
