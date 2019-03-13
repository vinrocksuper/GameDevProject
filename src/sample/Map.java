package sample;
//
public class Map {
    private final int height;
    private final int width;
    private final Cell[][] map;
    private String[] transitionFunction;
    private String[] stateColors = {"#FFFFAA", "#666688"};

    public Map(int height, int width, String[] transitionFunction){
        this.height = height;
        this.width = width;
        this.map = new Cell[height][width];
        this.transitionFunction = transitionFunction;
    }

    public String[][] getMapColors(){
        String[][] mapColors = new String[height][width];
        for(int y = 0; y < this.height; y++){
            for(int x = 0; x < this.width; x++){
                mapColors[y][x] = stateColors[map[y][x].getState()];
            }
        }
        return mapColors;
    }

    public void updateCells(){
        Cell[][] newMap = new Cell[height][width];
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                String neighborhood = map[y][x].getNeighborhood(this, y, x);
                for(String function : transitionFunction){
                    if(function.substring(0, function.length() - 1).equals(neighborhood)){
                        newMap[y][x].setState(function.charAt(function.length()));
                    }
                }
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Cell[][] getMap() {
        return map;
    }
}
