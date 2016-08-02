package dev.wilson.aaron.macromanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridManager extends AppCompatActivity{

    Button bGridlayout;
    Button bNewLayout;
    Button bEditGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_manager);
        bGridlayout = (Button) findViewById(R.id.bTestOption1);
        bNewLayout = (Button) findViewById(R.id.bTestOption2);
        bEditGrid = (Button) findViewById(R.id.bEditGrid);
        setListeners();
    }
    void setListeners(){
        bGridlayout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent gridIntent = new Intent(GridManager.this, GridActivity.class);
                startActivity(gridIntent);
            }
        });
        bNewLayout.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent linearGridIntent = new Intent(GridManager.this, LinearGridActivity.class);
                startActivity(linearGridIntent);
            }
        });

    }
}
