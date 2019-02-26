package sample;

public class Map {
    private final int height;
    private final int width;
    private final Cell[][] map;

    public Map(int height, int width){
        this.height = height;
        this.width = width;
        this.map = new Cell[height][width];
    }

    public String[][] getMapColors(){
        String[][] mapColors = new String[height][width];
    }
}
