class Solution {

    int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        this.image = image;
    
        updateColor(image[sr][sc], color, sr, sc);
        return this.image;
        
    }

    private void updateColor(int oldColor, int newColor, int currR, int currC){

        if (currR>=this.image.length || currR<0 || currC>=this.image[0].length || currC<0 || oldColor!=image[currR][currC] || oldColor==newColor) return;

        image[currR][currC] = newColor;
        updateColor(oldColor, newColor, currR-1, currC);
        updateColor(oldColor, newColor, currR+1, currC);
        updateColor(oldColor, newColor, currR, currC-1);
        updateColor(oldColor, newColor, currR, currC+1);
        return;
    }


}