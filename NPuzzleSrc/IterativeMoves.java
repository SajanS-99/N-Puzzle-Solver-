package fifteenpuzzle;

import java.util.ArrayList;

public class IterativeMoves {

    public static void move0Up(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){
       int zeroRow = state.getZeroRow();
       int zeroCol = state.getZeroCol();
       int[][] board = state.getPuzzle().getBoard();

       board[zeroRow][zeroCol] = board[zeroRow-1][zeroCol];
       MoveMade currentMoveMade = new MoveMade((board[zeroRow-1][zeroCol]),1);
       board[zeroRow-1][zeroCol] = 0;
       state.setZeroRow(zeroRow-1);
       allMovesMade.add(currentMoveMade);

       return;
    }

    public static void move0Down(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){
        int zeroRow = state.getZeroRow();
        int zeroCol = state.getZeroCol();
        int[][] board = state.getPuzzle().getBoard();
 
        board[zeroRow][zeroCol] = board[zeroRow+1][zeroCol];
        MoveMade currentMoveMade = new MoveMade((board[zeroRow+1][zeroCol]),0);
        board[zeroRow+1][zeroCol] = 0;
        state.setZeroRow(zeroRow+1);
        allMovesMade.add(currentMoveMade);
 
        return;
     }

     public static void move0Left(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){
        int zeroRow = state.getZeroRow();
        int zeroCol = state.getZeroCol();
        int[][] board = state.getPuzzle().getBoard();
 
        board[zeroRow][zeroCol] = board[zeroRow][zeroCol-1];
        MoveMade currentMoveMade = new MoveMade((board[zeroRow][zeroCol-1]),3);
        board[zeroRow][zeroCol-1] = 0;
        state.setZeroCol(zeroCol-1);
        allMovesMade.add(currentMoveMade);
 
        return;
     }

     public static void move0Right(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){
        int zeroRow = state.getZeroRow();
        int zeroCol = state.getZeroCol();
        int[][] board = state.getPuzzle().getBoard();
 
        board[zeroRow][zeroCol] = board[zeroRow][zeroCol+1];
        MoveMade currentMoveMade = new MoveMade((board[zeroRow][zeroCol+1]),2);
        board[zeroRow][zeroCol+1] = 0;
        state.setZeroCol(zeroCol+1);
        allMovesMade.add(currentMoveMade);
 
        return;
     }

     // Assumes the tile you wish to move is to left of the 0 tile(ie, 0 tile is right of tile you want to move)

     public static void upTile(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){ // doesn't work if 0 on topmost row or leftmost column
        move0Up(state, allMovesMade);
        move0Left(state, allMovesMade);
        move0Down(state, allMovesMade);
        move0Right(state, allMovesMade);
        move0Up(state, allMovesMade);
     }
     
     public static void downTile(BoardStateIterative state, ArrayList<MoveMade> allMovesMade){ // doesn't work if 0 on bottommost row or leftmost column
        move0Down(state, allMovesMade);
        move0Left(state, allMovesMade);
        move0Up(state, allMovesMade);
        move0Right(state, allMovesMade);
        move0Down(state, allMovesMade);
     }

     public static void leftTile(BoardStateIterative state, ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on  or leftmost column or 2nd leftmost column
      if (state.getZeroRow() != state.getPuzzle().getSIZE() - 1){ // if not on bottomost row(since have to move down, which would cause array out of bounds)
        move0Down(state, allMoveMades);                                          
        move0Left(state, allMoveMades);
        move0Left(state, allMoveMades);
        move0Up(state, allMoveMades); 
        move0Right(state, allMoveMades);
      } else {
        move0Up(state, allMoveMades);                                       
        move0Left(state, allMoveMades);
        move0Left(state, allMoveMades);
        move0Down(state, allMoveMades);
        move0Right(state, allMoveMades);
      }
     }

     public static void rightTile(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on leftmost column, or rightmost column
        if (state.getZeroRow() != state.getPuzzle().getSIZE() - 1){ //if not on bottomost row(since have to move down, which would cause array out of bounds)
        move0Left(state, allMoveMades);
        move0Down(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Up(state, allMoveMades);
        } else {
         move0Left(state, allMoveMades);
         move0Up(state, allMoveMades);
         move0Right(state, allMoveMades);
         move0Right(state, allMoveMades);
         move0Down(state, allMoveMades);
        }
     }

     public static void diagonalUpleft(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on topmost row,
        move0Up(state, allMoveMades);                                               // leftmost/2nd leftmost column  
        move0Left(state, allMoveMades);  
        move0Down(state, allMoveMades);
        move0Left(state, allMoveMades);
        move0Up(state, allMoveMades);
        move0Right(state, allMoveMades);
     }

     public static void diagonalUpRight(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on topmost row
        move0Left(state, allMoveMades);                                                // or on leftmost column or rightmost column
        move0Up(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Down(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Up(state, allMoveMades);
     }

     public static void diagonalDownLeft(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on bottommost row
        move0Down(state, allMoveMades);                        // on leftmost or 2nd leftmost column
        move0Left(state, allMoveMades);  
        move0Up(state, allMoveMades);
        move0Left(state, allMoveMades);
        move0Down(state, allMoveMades);
        move0Right(state, allMoveMades);
     }

     public static void diagonalDownRight(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){ // doesn't work if 0 on bottommost row
        move0Left(state, allMoveMades);                      // on rightmost column, or leftmost column
        move0Down(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Up(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Down(state, allMoveMades);
     }

     // assumes starting 0 on left of tile you want to move, doesn't work on topmost row
     public static void uptileRightmostCol(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){
        move0Up(state, allMoveMades);
        move0Right(state, allMoveMades);
        move0Down(state, allMoveMades);
        move0Left(state, allMoveMades);
        move0Up(state, allMoveMades);
     }

     // not on same column or will mess up target location
     public static void move0UpOrDownOfTarget(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int targetRow){
      if (state.getZeroRow() < targetRow){ // lower index for row, means closer to top. If lower than targer, that above target row
         while (state.getZeroRow() < targetRow){
            move0Down(state, allMoveMades);
         }
      }

      if (state.getZeroRow() > targetRow){ // higher index for row means closer to bottom. If larger than target, then below target row
         while (state.getZeroRow() > targetRow){
            move0Up(state, allMoveMades);
         }
      }
     }

     public static void move0LeftOrRightOfTarget(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int targetCol){
      if (state.getZeroCol() < targetCol){
         while (state.getZeroCol() < targetCol){ // lower index means further to left, so under target col means 0 is left of target
            move0Right(state, allMoveMades);
         }
      }

      if (state.getZeroCol() - 1 > targetCol){ // higher index means further to right, so over target col means 0 is to right of target
         while (state.getZeroCol() - 1 > targetCol){ // -1 is to ensure does not accidently move target tile to the right
            move0Left(state, allMoveMades);  // since if 0 col = 3, and targe col = 2, position of 0 is to right of target
         }                                    // but while loop would still run if -1 isn't there even though 0 in right position
      }
     }

     public static void move0toInitialTileRight(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int targetTile){
      int targetRow = 0;
      int targetCol = 0;
      int[][] board = state.getPuzzle().getBoard();
      int size = state.getPuzzle().getSIZE();

      outerloop:
      for (int i = 0; i < size; i++){
         for (int j = 0; j < size; j++ ){
            if (board[i][j] == targetTile){
               targetRow = i;
               targetCol = j;
               break outerloop;
            }
         }
      }

      if (targetCol == size - 1){ // target on rightmost column
         if (state.getZeroCol() == size - 1){

            move0Left(state, allMoveMades);

            move0UpOrDownOfTarget(state, allMoveMades, targetRow);

            move0Right(state, allMoveMades);   // 0 will be on left of target, after moving up/down, so move right once more to be on right         

         } else {

            move0UpOrDownOfTarget(state, allMoveMades, targetRow);

            move0LeftOrRightOfTarget(state, allMoveMades, targetCol); 

         }
      } else if (state.getZeroCol() == targetCol){ // target and zero on same column, and not on rightmost column

         move0Right(state, allMoveMades);

         move0UpOrDownOfTarget(state, allMoveMades, targetRow);

      } else { // target and 0 not on same col, and target not on rightmost column
         
         move0UpOrDownOfTarget(state, allMoveMades, targetRow);

         move0LeftOrRightOfTarget(state, allMoveMades, targetCol);

      }

     }
      // assumes 0 right of target
     public static void moveTargetToFirstRowExLast2(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int targetRow, int targetCol){

      if (targetRow == state.getZeroRow()){
         while (state.getZeroCol() > targetCol + 1){
            leftTile(state, allMoveMades);
         }
         return;
      }

      if (targetCol + 1 == state.getZeroCol()){
         while (state.getZeroRow() > targetRow){
            upTile(state, allMoveMades);
         }
         return;
      }

      if (targetCol + 1 < state.getZeroCol()){ // right of target, and below it
         while (targetCol + 1 < state.getZeroCol() && targetRow + 1 < state.getZeroRow()){
            diagonalUpleft(state, allMoveMades);
         }

         if (targetCol + 1 == state.getZeroCol()){
            while (state.getZeroRow() > targetRow){
               upTile(state, allMoveMades);
            }
         }

         if (targetRow + 1 == state.getZeroRow()){
            while (targetCol +1 < state.getZeroCol()){
               leftTile(state, allMoveMades);
            }
            upTile(state, allMoveMades);
         }

         return;
      }

      if (targetCol + 1 > state.getZeroCol()){ // left of target, and below it
         while (targetCol + 1 > state.getZeroCol() && targetRow + 1 < state.getZeroRow()){
            diagonalUpRight(state, allMoveMades);  
         }

         if (targetCol + 1 == state.getZeroCol()){
            while (state.getZeroRow() > targetRow){
               upTile(state, allMoveMades);
            }
         }

         if (targetRow + 1 == state.getZeroRow()){
            while (targetCol +1 > state.getZeroCol()){
               rightTile(state, allMoveMades);
            }
            upTile(state, allMoveMades);
         }

         return;
      }
     }

     public static void move2TargetsToRowEnd(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int nMinus1Tile, int nthTile, int targetRow){

         int[][] board = state.getPuzzle().getBoard();
         int size = state.getPuzzle().getSIZE();

         if (board[targetRow][size-1] != nMinus1Tile){
            move0toInitialTileRight(state, allMoveMades, nMinus1Tile);
            
            while(state.getZeroCol() < size - 1){ // moves target to 2nd rightmost col
               rightTile(state, allMoveMades);
            }
            move0Left(state, allMoveMades); // puts 0 on left of target tile

            while (state.getZeroRow() != targetRow){
               uptileRightmostCol(state, allMoveMades);
            }

         }

         if (board[targetRow+1][size-2] == nthTile){ // complex edge case, shortest path was found by A*

            while(state.getZeroCol() != targetRow){ //zero tile at 2nd rightmost col, top row. Move all to leftmost col
               move0Left(state, allMoveMades);
            }

            move0Down(state, allMoveMades); // go down twice
            move0Down(state, allMoveMades);

            while(state.getZeroCol() < size - 1){ // go all the way to the right
               move0Right(state, allMoveMades);
            }

            move0Up(state, allMoveMades); // go up

            while(state.getZeroCol() != targetRow){
               move0Left(state, allMoveMades); // moves ntile under n-1 tile, and goes all way back to left
            }

            move0Up(state, allMoveMades); //go up

            while(state.getZeroCol() < size - 1){ // moves back all top row tiles to original position
               move0Right(state, allMoveMades);
            }

            move0Down(state, allMoveMades);  //moves n-1 tile to top right position

         } else {
            move0Down(state, allMoveMades);
            move0toInitialTileRight(state, allMoveMades, nthTile);

            while(state.getZeroCol() < size - 1){ // moves target to 2nd rightmost col
               rightTile(state, allMoveMades);
            }
            move0Left(state, allMoveMades); // puts 0 on left of target tile

            while (state.getZeroRow() > targetRow + 1){
               uptileRightmostCol(state, allMoveMades); //nth tile under n-1 tile, at rightmost col and 2nd topmost row
            } // 0 is to left of n-1 tile, 

            move0Up(state, allMoveMades);
            move0Right(state, allMoveMades);
            move0Down(state, allMoveMades);

         }
         
     }

     public static void solveRow(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int rowToSolve, int startingCol, Integer[] targets){
      int i;
      for (i = 0; i < targets.length-2 ; i++){
         move0toInitialTileRight(state, allMoveMades, targets[i]);
         moveTargetToFirstRowExLast2(state, allMoveMades, rowToSolve, startingCol+i);
      }

      move2TargetsToRowEnd(state, allMoveMades, targets[i], targets[i+1], rowToSolve);


     }
     // could be more effienct as does not use diagonal tile moves
     public static void moveTargetToFirstColExLast2(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int targetRow, int targetCol){

      if (targetRow == state.getZeroRow()){
         while (state.getZeroCol() > targetCol + 1){
            leftTile(state, allMoveMades);
         }
         return;
      }

      if (targetCol + 1 == state.getZeroCol()){
         while (state.getZeroRow() > targetRow){
            upTile(state, allMoveMades);
         }
         return;
      }

      if (targetRow > state.getZeroRow()){
         while (targetRow > state.getZeroRow()){
            downTile(state, allMoveMades);
         }

         while( targetCol + 1 < state.getZeroCol()){
            leftTile(state, allMoveMades);
         }

      }

      if (targetRow < state.getZeroRow()){
         while (targetRow < state.getZeroRow()){
            upTile(state, allMoveMades);
         }

         while( targetCol + 1 < state.getZeroCol()){
            leftTile(state, allMoveMades);
         }
         
      }

     }

     public static void move2TargetsToColEnd(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int nMinus1Tile, int nthTile, int targetCol){

         int[][] board = state.getPuzzle().getBoard();
         int size = state.getPuzzle().getSIZE();

        if (board[size-1][targetCol] == nthTile && board[size-2][targetCol] == nMinus1Tile){
         return;
        } 

        if (board[size-1][targetCol] != nMinus1Tile){
         move0toInitialTileRight(state, allMoveMades, nMinus1Tile);

         while(state.getZeroRow() < size - 1){
            downTile(state, allMoveMades);
         }

         while(state.getZeroCol() > targetCol + 1){
            leftTile(state, allMoveMades);
         }
        }

        if (board[size-2][targetCol] == nthTile){ // complex edge case, short path/algorithm  was obtained by running a star in similar scenario
         move0toInitialTileRight(state, allMoveMades, nMinus1Tile);
         move0Left(state, allMoveMades);
         move0Up(state, allMoveMades);
         move0Up(state, allMoveMades);

         while(state.getZeroCol() < size - 1){
            move0Right(state, allMoveMades);
         }

         move0Down(state, allMoveMades);

         while(state.getZeroCol() > targetCol+1){
            move0Left(state, allMoveMades);
         }

         move0Down(state, allMoveMades);

         while(state.getZeroCol() < size - 1){
            move0Right(state, allMoveMades);
         }

         move0Up(state, allMoveMades);
         move0Up(state, allMoveMades);

         while(state.getZeroCol() > targetCol){
            move0Left(state, allMoveMades);
         }

          move0Down(state, allMoveMades);
          move0Right(state, allMoveMades);

        } else {
         move0toInitialTileRight(state, allMoveMades, nthTile);

         while(state.getZeroRow() < size - 1){
            downTile(state, allMoveMades);
         }

         while(state.getZeroCol() > targetCol + 2){
            leftTile(state, allMoveMades);
         }

         move0Up(state, allMoveMades);
         move0Left(state, allMoveMades);
         move0Left(state, allMoveMades);
         move0Down(state, allMoveMades);
         move0Right(state, allMoveMades);

        }

     }

     public static void solveCol(BoardStateIterative state,ArrayList<MoveMade> allMoveMades, int colToSolve, int startingRow, Integer[] targets){
      int i;
      for (i = 0; i < targets.length-2 ; i++){
         move0toInitialTileRight(state, allMoveMades, targets[i]);
         moveTargetToFirstColExLast2(state, allMoveMades, startingRow+i, colToSolve);
         }

         move2TargetsToColEnd(state, allMoveMades, targets[i], targets[i+1], colToSolve);
      }

      public static void solve2by2(BoardStateIterative state,ArrayList<MoveMade> allMoveMades){
         /* Main solver solves everything but 2 by 2 portion. After last solve col, 0 will be either at 2nd to last place on board, or
         2nd to last place and up one row, since solve col always ends you up besides the col you just solved. Also, a 2 by 2 board has
         4! total states, but only 4!/2 are actually solvabe. Since the 0 will always end up on the 2nd to last col, we only need to worry about
         (4!/2)/2 states. But also, in the situation where 0 is on the 2nd to last row on the 2nd to last col, we can just move it down and then only
         consider the states where 0 is on the last row in the 2nd to last col, giving us ((4!/2)/2)/2 states, or simply 3 states. In this case
         we only need to find those 3 solvable states, and simply find the moves to solve it manually. Then we can simply call the correct solver
         depending on the current 2 by 2 state */ 
         
         /* After more testing, in theory the board can start out solved except for the 2 by 2, so 0 can be in the wrong position at the end of
          solving the rows and columns, since it won't neccesarily put 0 in the right position since it won't move 0 if it's already solved.
         Although inefficient, an easy solution is to move 0 in the bottom row and 2nd to */

         int size = state.getPuzzle().getSIZE();
         int[][] board = state.getPuzzle().getBoard();

         if (state.getZeroCol() == size-2 && state.getZeroRow() == size-2){
            move0Down(state, allMoveMades);
         } else if (state.getZeroCol() == size-1 && state.getZeroRow() == size-2){
            move0Down(state, allMoveMades);
            move0Left(state, allMoveMades);
         } else if (state.getZeroCol() == size-1 && state.getZeroRow() == size-1){
            move0Left(state, allMoveMades);
         }

         /* 3 solvable states are : 71 72 | 0 80 , 72 80 | 0 71 ,  80 71 | 0 72 */

         if (board[size-1][size-1] == ((size*size)-1)){
               move0Right(state, allMoveMades);
         } else if (board[size-1][size-1] == ((size*size)-size-1)){
            move0Right(state, allMoveMades);
            move0Up(state, allMoveMades);
            move0Left(state, allMoveMades);
            move0Down(state, allMoveMades);
            move0Right(state, allMoveMades);
         } else if (board[size-1][size-1] == ((size*size)-size)){
            move0Up(state, allMoveMades);
            move0Right(state, allMoveMades);
            move0Down(state, allMoveMades);
         }


      }

}
