package dev.wilson.aaron.macromanager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.Socket;
import java.sql.Connection;

public class MainMenu extends AppCompatActivity {
    private static boolean status = false;
    private TextView tvStatus;
    private Button bConnect;
    private Button bGrid;
    private ConnectionObject connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
        bConnect = (Button) findViewById(R.id.bConnect);
        bGrid = (Button) findViewById(R.id.bGrid);
        connection = new ConnectionObject("localhost", 1234);
        setListeners();

    }

    void updateStatus(){
        status = connection.checkConnection();
        if(status){
            tvStatus.setTextColor(Color.parseColor("#3fd300"));
            tvStatus.setText(R.string.connected);
        }else{
            tvStatus.setTextColor(Color.parseColor("#FF0000"));
            tvStatus.setText(R.string.disconnected);
        }
    }

    void setListeners(){
        bConnect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                connection.start();
                updateStatus();
            }
        });
        bGrid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent gridManagerIntent = new Intent(MainMenu.this, GridManager.class);
                startActivity(gridManagerIntent);
            }
        });
    }
}
