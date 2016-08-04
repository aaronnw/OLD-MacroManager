package dev.wilson.aaron.macromanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridManager extends AppCompatActivity{

    Button bOpenGrid;
    Button bNewGrid;
    Button bEditGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_manager);
        bOpenGrid = (Button) findViewById(R.id.bOpenGrid);
        bNewGrid = (Button) findViewById(R.id.bNewGrid);
        bEditGrid = (Button) findViewById(R.id.bEditGrid);
        setListeners();
    }
    void setListeners(){
        bOpenGrid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent openGridIntent = new Intent(GridManager.this, GridActivity.class);
                startActivity(openGridIntent);
            }
        });
        bNewGrid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent createGridIntent = new Intent(GridManager.this, GridCreator.class);
                startActivity(createGridIntent);
            }
        });
        bEditGrid.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent editGridIntent = new Intent(GridManager.this, GridEditor.class);
                startActivity(editGridIntent);
            }
        });

    }
}
