package dev.wilson.aaron.macromanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class LinearGridActivity extends AppCompatActivity{

    private int rows = 5;
    private int columns = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LinearLayout grid = new LinearLayout(this);
        LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        grid.setOrientation(LinearLayout.VERTICAL);
        grid.setLayoutParams(gridParams);

        Button[][] buttons = new Button[rows][columns];
        for(int i = 0; i < rows; i ++){
            for (int j = 0; j < columns; j++){
                buttons[i][j] = new Button(this);
                buttons[i][j].setText(i + ", " + j);
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
        setContentView(grid);

    }

    void sendMacro(int i, int j){

    }
}
