package dev.wilson.aaron.macromanager;

/**
 * Created by Aaron.Wilson on 8/2/2016.
 */
public class GridObject{
    MacroObject[][] macros;
    int rowSize;
    int columnSize;

    public GridObject(int rowSize, int columnSize){
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        macros = new MacroObject[rowSize][columnSize];
        for(int i = 0; i <rowSize; i++){
            for(int j = 0; j < columnSize; j++){
                macros[i][j] = new MacroObject();
            }
        }
    }
    public void addMacro(String title, String command){
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < columnSize; j++){
                if(macros[i][j].getCommand() == null){
                    macros[i][j].setTitle(title);
                    macros[i][j].setCommand(command);
                    return;
                }
            }
        }
    }
    public void addMacroToPos(String title, String command, int xPos, int yPos){
        macros[xPos][yPos].setTitle(title);
        macros[xPos][yPos].setCommand(command);
    }
    public MacroObject getMacroAtPos(int xPos, int yPos){
        return macros[xPos][yPos];
    }
}
