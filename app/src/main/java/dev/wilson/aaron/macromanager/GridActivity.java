package dev.wilson.aaron.macromanager;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class GridActivity extends AppCompatActivity{
    int rows = 5;
    int columns = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        GridLayout grid = new GridLayout(this);
        grid.setRowCount(rows);
        grid.setColumnCount(columns);
        Button[][] buttons = new Button[rows][columns];
        for(int i = 0; i < rows; i ++){
            for (int j = 0; j < columns; j++){
                buttons[i][j] = new Button(this);
                buttons[i][j].setText(i + ", " + j);
                grid.addView(buttons[i][j]);
            }
        }
        setContentView(grid);

    }
}
