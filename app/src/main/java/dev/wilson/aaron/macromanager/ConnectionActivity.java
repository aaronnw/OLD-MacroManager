package dev.wilson.aaron.macromanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.net.*;

public class ConnectionActivity extends AppCompatActivity{

    private String serverLocation = "localhost";
    private int port = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        TextView connection = (TextView) findViewById(R.id.tvConnectionStatus);
        boolean status = checkConnection();
        if(status){
            connection.setText("Connected");
        }else{
            connection.setText("Not connected");
        }
    }

    boolean checkConnection(){
        try {
            Socket client = new Socket(serverLocation, port);
            if(client.isConnected()){
                return true;
            }else{
                return false;
            }

        }
        catch(Exception e) {
            return false;
        }
    }
}
