package fifteenpuzzle;

public class MoveMade {

    private int direction;
    private int tile;

    public MoveMade(int tile, int direction){
        this.tile = tile;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public int getTile() {
        return tile;
    }

    public String toString(){
        String moveString = "Tile Moved: " + tile + ", Direction Moved: " + direction;

        return moveString;
    }

    public String fileString(){
        String directioString; 
        if (direction == 0){
            directioString = "U";
        } else if (direction == 1){
            directioString = "D";
        } else if (direction == 2){
            directioString = "L";
        } else {
            directioString = "R";
        }

        String totalString = tile + " " + directioString + "\n";

        return totalString;
    }
    
}
