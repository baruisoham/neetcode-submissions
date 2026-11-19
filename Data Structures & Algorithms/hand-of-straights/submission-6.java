class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);

        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for(int num: hand){
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        if(hand.length%groupSize != 0) return false;

        final int numGroups = hand.length/groupSize;

        final HashMap<Integer, Integer> freqMap = new HashMap<>();

        int lowestNum = minNum;
        for(int num: hand){
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        }

        for(int i = 0; i<numGroups; i++){
            for(int num = lowestNum; num<lowestNum+groupSize; num++){
                if(freqMap.getOrDefault(num, 0)==0) return false;
                else{
                    freqMap.put(num, freqMap.get(num)-1);
                }
            }

            while(true){
                if(lowestNum>maxNum) break;
                if(freqMap.getOrDefault(lowestNum, 0)==0){
                    lowestNum++;
                }
                else break;
            }
        }
        return true;
    }
}
