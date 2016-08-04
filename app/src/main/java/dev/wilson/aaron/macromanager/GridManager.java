package dev.wilson.aaron.macromanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GridManager extends AppCompatActivity{

    private ScrollView scroll;
    private ListView list;
    private Button bOpenGrid;
    private Button bNewGrid;
    private Button bEditGrid;
    private String filename = "savedGrid";
    private FileInputStream fis;
    private ObjectInputStream ois;
    private GridObject example;
    ArrayList<String> listItems;
    TextView test;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_manager);
        bOpenGrid = (Button) findViewById(R.id.bOpenGrid);
        bNewGrid = (Button) findViewById(R.id.bNewGrid);
        bEditGrid = (Button) findViewById(R.id.bEditGrid);
        scroll = (ScrollView) findViewById(R.id.svGridListScroll);
        list = (ListView) findViewById(R.id.lvGridList);
        listItems = new ArrayList<String>();
        test = (TextView) findViewById(R.id.tvTest);
        setListeners();
        loadContent();
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
    public void loadContent(){
        try{
            file = new File(this.getFilesDir(), filename);
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            GridObject example = (GridObject) ois.readObject();
            test.setText(example.getTitle());

        }catch(Exception e){
            test.setText(e.toString());
            e.printStackTrace();
        }
    }
}
