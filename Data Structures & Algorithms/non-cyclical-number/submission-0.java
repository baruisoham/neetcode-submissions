class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            n = findSumOfSquares(n);
            if(n==1) return true;
            if(set.contains(n)) return false;
            set.add(n);
        }
    }

    private int findSumOfSquares(int n){
        int result = 0;
        while(n/10!=0 || n%10!=0){
            int digit = n%10;
            digit = digit*digit;
            result+=digit;
            n=n/10;
        }
        return result;
    }
}
