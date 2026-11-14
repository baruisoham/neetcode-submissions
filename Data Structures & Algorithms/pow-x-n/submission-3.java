class Solution {
    public double myPow(double x, int n) {
        if(n<0) x=1/x;
        if(n==0 || x==1) return (double) 1;
        if(x==-1){
            return n%2==0 ? 1 : -1;
        }
        double result = x;
        long iter=Math.abs((long) n);
        System.out.println(n);
        for(int i=2; i<=iter; i++){
            if(result==(double) 0) break;
            result*=x;
        }
        return result;
    }
}
