package dev.wilson.aaron.macromanager;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GridEditor extends AppCompatActivity{
    private String title = "test";
    private int rows = 5;
    private int columns = 4;
    private TextView result;
    private GridObject gridObject;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        GridLayout grid = new GridLayout(this);
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            rows = extras.getInt("rowNum");
            columns = extras.getInt("columnNum");
        }
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
                        Intent editMacroIntent = new Intent(GridEditor.this , EditMacroActivity.class);
                        startActivity(editMacroIntent);
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
}
