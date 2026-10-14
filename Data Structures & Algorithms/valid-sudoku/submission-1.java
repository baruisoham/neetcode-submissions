class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // IMPORTANT HOW ROW SIZE AND COL SIZE IS FOUND
        int rowSize = board.length;
        int colSize = board[0].length;


        final HashSet<Integer>[] rowChecker = new HashSet[rowSize];
        final HashSet<Integer>[] colChecker = new HashSet[colSize];   // you have created an array which will hold hash sets, but those hashsets as elements have not yet been intialised and calling them will be null pointer exception.
        final HashSet<Integer>[][] squareChecker = new HashSet[3][3];

        for(int r=0; r<rowSize; r++){
            for(int c=0; c<colSize; c++){
                if(rowChecker[r]==null) rowChecker[r] = new HashSet<>();    // we initialised an array that will hold hashsets, but the elements (hashsets) are not initialised, they will be null. Hence we should initialise all the elements first, then start using them
                if(colChecker[c]==null) colChecker[c] = new HashSet<>();
                if(squareChecker[r/3][c/3]==null) squareChecker[r/3][c/3] = new HashSet<>();



                if (board[r][c]=='.') continue;
                if ((rowChecker[r].contains(Integer.valueOf(board[r][c]))) || colChecker[c].contains(Integer.valueOf(board[r][c])) || squareChecker[r/3][c/3].contains(Integer.valueOf(board[r][c]))) return false;

                colChecker[c].add(Integer.valueOf(board[r][c]));
                rowChecker[r].add(Integer.valueOf(board[r][c]));
                squareChecker[r/3][c/3].add(Integer.valueOf(board[r][c]));
            }



        }
        return true;
    }
}