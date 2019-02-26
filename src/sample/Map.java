package sample;

public class Map {
    private final int height;
    private final int width;
    private final String[][] board;

    public Map(int height, int width){
        this.height = height;
        this.width = width;
        this.board = new String[height][width];
    }


    
}
