class Solution {

    int[][] image;
    int oldColor;
    int newColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        this.image = image;

        this.oldColor = image[sr][sc];
        this.newColor = color;
    
        updateColor(sr, sc);
        return this.image;
        
    }

    private void updateColor(int currR, int currC){

        if (currR>=this.image.length || currR<0 || currC>=this.image[0].length || currC<0 || oldColor!=image[currR][currC] || oldColor==newColor) return;

        image[currR][currC] = newColor;
        updateColor(currR-1, currC);
        updateColor(currR+1, currC);
        updateColor(currR, currC-1);
        updateColor(currR, currC+1);
        return;
    }


}