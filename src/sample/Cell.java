package sample;

import java.util.ArrayList;

public class Cell {
    private final int State;
    private final String[] transitionFunction;
    private final String color;
    private ArrayList<Cell> cellTypes = new ArrayList<>();

    public Cell(String color, String[] transitionFunction, int State){
        this.color = color;
        this.transitionFunction = transitionFunction;
        this.State = State;
        cellTypes.add(this);
    }
}
