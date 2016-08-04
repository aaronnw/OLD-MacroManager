package dev.wilson.aaron.macromanager;

import java.io.Serializable;

/**
 * Created by Aaron.Wilson on 8/2/2016.
 */
public class MacroObject implements Serializable{
    String title;
    String command;
    public MacroObject(){
        title = "Empty";
        command = null;
    }
    public void MacroObject(String title, String command){
        this.title = title;
        this.command = command;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCommand(String command){
        this.command = command;
    }
    public String getTitle(){
        return title;
    }
    public String getCommand(){
        return command;
    }

}
