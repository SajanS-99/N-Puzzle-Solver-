package fifteenpuzzle;

public class BoardStateIterative {

    private FifteenPuzzle puzzle;
    private int zeroRow, zeroCol;

    public BoardStateIterative(FifteenPuzzle puzzle){
        this.puzzle = puzzle;
        outerloop:
        for (int i = 0; i < puzzle.getSIZE(); i++){
            for (int j = 0; j < puzzle.getSIZE(); j++){
                if (puzzle.getBoard()[i][j] == 0){
                    this.zeroRow = i;
                    this.zeroCol = j;
                    break outerloop;
                }
            }
        }
    }

    public int getZeroRow() {
        return zeroRow;
    }

    public void setZeroRow(int zeroRow) {
        this.zeroRow = zeroRow;
    }

    public int getZeroCol() {
        return zeroCol;
    }

    public void setZeroCol(int zeroCol) {
        this.zeroCol = zeroCol;
    }

    public FifteenPuzzle getPuzzle() {
        return puzzle;
    }

}
