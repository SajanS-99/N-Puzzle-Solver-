# N-Puzzle-Solver-

A program to solve various sizes of the 15 puzzle tile game.

The input boards are formatted with their board size(3 by 3, 7 by 7, etc) and then the board state. The solver assumes the initial board state is solvable. 

The Src file containts Java files to read an input board state, pass it to the solver which attempts to solve and store the steps taken to solve the board state. Then the steps taken are written to a text file.

The algorithm implented for the solver is O(n^3) time, based off algorithm from this research paper: https://www.sciencedirect.com/science/article/abs/pii/002001909500134X

Solver.java containts the main function, which calls a SolverIterative function from SolverIterative.java which then calls various helper functions to solve the puzzle. The moves made are stored in a list, which is then used to write to an output file in the main function.
