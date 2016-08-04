package dev.wilson.aaron.macromanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class GridCreator extends AppCompatActivity{

    NumberPicker rowPicker;
    NumberPicker columnPicker;
    EditText titleField;
    Button gridCreate;
    String title = null;
    int rowNum = 0;
    int columnNum = 0;

    String filename = "savedGrid";
    File file;
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_creator);
        rowPicker = (NumberPicker) findViewById(R.id.rowPicker);
        columnPicker = (NumberPicker) findViewById(R.id.columnPicker);
        titleField = (EditText) findViewById(R.id.etGridTitle);
        gridCreate = (Button) findViewById(R.id.bGridCreate);

        //TODO change based on device size
        rowPicker.setMaxValue(9);
        rowPicker.setWrapSelectorWheel(false);
        columnPicker.setMaxValue(4);
        columnPicker.setWrapSelectorWheel(false);

        gridCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
               createGrid();
            }
        });

    }
    public void createGrid(){
        //TODO add validation
        title = titleField.getText().toString();
        rowNum = rowPicker.getValue();
        columnNum = columnPicker.getValue();
        GridObject newGrid = new GridObject(title, rowNum, columnNum);
        saveGrid(newGrid);
        Intent gridManagerIntent = new Intent(GridCreator.this, GridManager.class);
        startActivity(gridManagerIntent);
    }
    public void saveGrid(GridObject grid){
        file = new File(this.getFilesDir(), filename);
        try{
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(grid);
        }catch(Exception e){
            e.printStackTrace();
            e.notify();
        }
    }
}
