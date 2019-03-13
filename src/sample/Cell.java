package sample;

import java.util.ArrayList;

public class Cell {
    private int state;
    private String color;
    private ArrayList<Cell> cellTypes = new ArrayList<>();

    public Cell(String color, String[] transitionFunction, int state){
        this.color = color;
        this.state = state;
        cellTypes.add(this);
    }

    public String getColor() {
        return color;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int[] getMyCoords(Map map){
        for(int y = 0; y < map.getHeight(); y++){
            for(int x = 0; x < map.getWidth(); x++){
                if(map.getMap()[y][x] == this){
                    return new int[]{y, x};
                }
            }
        }
        return null;
    }

    public String getNeighborhood(Map map, int y, int x){
        String neighborhood = Integer.toString(state);
        neighborhood += Integer.toString(map.getMap()[y + 1][x].getState());
        neighborhood += Integer.toString(map.getMap()[y - 1][x].getState());
        neighborhood += Integer.toString(map.getMap()[y][x + 1].getState());
        neighborhood += Integer.toString(map.getMap()[y][x - 1].getState());
        return neighborhood;
    }
}
