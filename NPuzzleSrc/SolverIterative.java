package fifteenpuzzle;
import java.util.ArrayList;

public class SolverIterative {
    
    public static ArrayList<MoveMade> solve(String puzzleName){

        ArrayList<MoveMade> allMoves = new ArrayList<MoveMade>();
        
        try {

        FifteenPuzzle puzzle = new FifteenPuzzle(puzzleName);
        BoardStateIterative state = new BoardStateIterative(puzzle);

        int size = state.getPuzzle().getSIZE();

        int[][] boardSolved = new int[size][size];

        int counter = 1;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                boardSolved[i][j] = counter;
                counter++;
            }
        }

        boardSolved[size-1][size-1] = 0;

        ArrayList<ArrayList<Integer>> rowTargets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size-2; i++){
            ArrayList<Integer> thisRow = new ArrayList<Integer>();
            rowTargets.add(thisRow);
            for (int j = i; j < size; j++){
                rowTargets.get(i).add(boardSolved[i][j]);
            }
        } 

        ArrayList<ArrayList<Integer>> colTargets = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size-2; i++){
            ArrayList<Integer> thisCol = new ArrayList<Integer>();
            colTargets.add(thisCol);
            for (int j = i+1; j < size; j++){
                colTargets.get(i).add(boardSolved[j][i]);
            }
        } 

        for (int i = 0; i < size-2; i++){
            Integer[] rowArray = rowTargets.get(i).toArray(new Integer[rowTargets.get(i).size()]);
            Integer[] colArray = colTargets.get(i).toArray(new Integer[colTargets.get(i).size()]);
            IterativeMoves.solveRow(state, allMoves, i, i, rowArray);
            IterativeMoves.solveCol(state, allMoves, i, i+1, colArray);
        }

        IterativeMoves.solve2by2(state, allMoves);

        

        } catch (Exception e){
            System.out.println("Unexpected error occured");
        }

        return allMoves;
    }

}
