package dev.wilson.aaron.macromanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditMacroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_macro);
    }
    //Runs on save button click
    public void saveMacro(){
        EditText etTitle = (EditText) findViewById(R.id.etMacroTitle);
        String title = etTitle.getText().toString();
        EditText etCommand = (EditText) findViewById(R.id.etMacroCommand);
        String command = etCommand.getText().toString();

    }
}
