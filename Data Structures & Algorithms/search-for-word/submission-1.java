class Solution {

    private char[][] board;
    private String word;
    private Set<Pair<Integer, Integer>> selected;

    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word;
        this.selected = new HashSet<>();
        

        boolean isPresent = false;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(word.charAt(0) == board[i][j]) {
                    if(checkWord(i, j, 0)) {
                        isPresent = true;
                        break;
                    }
                }

            }
        }
        return isPresent;
    }


    private boolean checkWord(int i, int j, int idx){
        if (idx>=word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if(word.charAt(idx)!=board[i][j]) return false;

        if(selected.contains(new Pair<>(i,j))) return false;

        selected.add(new Pair<>(i,j));

        if( checkWord(i+1, j, idx+1) || checkWord(i, j+1, idx+1) || checkWord(i-1, j, idx+1) || checkWord(i, j-1, idx+1)) return true;
        else{
            selected.remove(new Pair<>(i,j));
            return false;
        }
    }
}
