package dev.wilson.aaron.macromanager;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.net.Socket;

public class GridActivity extends AppCompatActivity{
    private String title = "test";
    private int rows = 5;
    private int columns = 4;
    private TextView result;
    private GridObject gridObject;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        GridLayout grid = new GridLayout(this);
        grid.setRowCount(rows +1);
        grid.setColumnCount(columns);

        gridObject = new GridObject(title, rows, columns);

        gridObject.addMacro("title", "Test command");

        Button[][] buttons = new Button[rows][columns];
        for(int i = 0; i < rows; i ++){
            for (int j = 0; j < columns; j++){
                buttons[i][j] = new Button(this);
                buttons[i][j].setText(gridObject.getMacroAtPos(i,j).getTitle());
                final int row = i;
                final int column = j;
                buttons[i][j].setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        sendMacro(row , column);
                    }
                });
                grid.addView(buttons[i][j]);
            }
        }
        GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams();
        gridParams.width = GridLayout.LayoutParams.WRAP_CONTENT;
        gridParams.height = GridLayout.LayoutParams.WRAP_CONTENT;
        grid.setLayoutParams(gridParams);
        grid.setBackgroundColor(Color.RED);

        LinearLayout test = new LinearLayout(this);
        test.setOrientation(LinearLayout.VERTICAL);
        test.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linearParams.gravity = Gravity.CENTER_HORIZONTAL;
        test.setBackgroundColor(Color.BLUE);
        test.setLayoutParams(linearParams);
        test.addView(grid);
        result = new TextView(this);
        result.setText("0");
        test.addView(result);



        setContentView(test);

    }

    void sendMacro(int i, int j){
        //For now just change the text
        //Later call the send method on the object at i, j
        String command = (gridObject.getMacroAtPos(i,j).getCommand());
        result.setText(command);
    }
}
