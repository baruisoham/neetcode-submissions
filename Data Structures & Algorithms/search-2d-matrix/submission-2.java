class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int length = matrix.length*matrix[0].length;

        int s = 0;
        int e = length-1;

        while(s<=e){
            int mid = s+(e-s)/2;
            int midc = mid/c; 
            int midr = mid%c;

            if(target==matrix[midc][midr]) return true;
            else if(target<matrix[midc][midr]) e = mid-1;
            else s = mid+1;
        }

        return false;
    }
}
