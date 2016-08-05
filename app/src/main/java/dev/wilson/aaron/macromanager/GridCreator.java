package dev.wilson.aaron.macromanager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GridCreator extends AppCompatActivity{

    NumberPicker rowPicker;
    NumberPicker columnPicker;
    EditText titleField;
    Button gridCreate;
    String title = null;
    int rowNum = 0;
    int columnNum = 0;
    ArrayList<GridObject> gridList;
    FileInputStream fis;
    ObjectInputStream ois;

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
        rowPicker.setMinValue(1);
        rowPicker.setMaxValue(9);
        rowPicker.setWrapSelectorWheel(false);
        columnPicker.setMinValue(1);
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
        if(validate(title, rowNum, columnNum)){
            GridObject newGrid = new GridObject(title, rowNum, columnNum);
            saveGrid(newGrid);
            Intent gridEditorIntent = new Intent(GridCreator.this, GridEditor.class);
            gridEditorIntent.putExtra("rowNum", rowNum);
            gridEditorIntent.putExtra("columnNum", columnNum);
            startActivity(gridEditorIntent);
        }else{
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.existingTitle);
            alertDialogBuilder.setMessage(R.string.existingTitleMessage);
            alertDialogBuilder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface arg0, int arg1){

                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }
    public void saveGrid(GridObject grid){
        file = new File(this.getFilesDir(), filename);
        try{
            file = new File(this.getFilesDir(), filename);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            try{
                gridList = (ArrayList<GridObject>) ois.readObject();
            }catch(Exception e){
                e.printStackTrace();
            }
            if(gridList == null){
                gridList = new ArrayList<GridObject>();
            }
            fis.close();
            ois.close();
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            gridList.add(grid);
            oos.writeObject(gridList);
            oos.close();
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean validate(String title, int row, int col){
        //Make sure title doesn't exist
        try{
            file = new File(this.getFilesDir(), filename);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            gridList = (ArrayList<GridObject>) ois.readObject();
        }catch(Exception e){
            e.printStackTrace();
        }
        if(gridList != null){
            for(GridObject grid:gridList){
                if(grid.getTitle().equals(title)){
                    return false;
                }
            }
        }
        return true;
    }
}
