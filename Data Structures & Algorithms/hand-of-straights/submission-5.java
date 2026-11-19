class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);

        if(hand.length%groupSize != 0) return false;

        final int numGroups = hand.length/groupSize;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int lowestNum = hand[0];
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
                if(lowestNum>hand[hand.length-1]) break;
                if(freqMap.getOrDefault(lowestNum, 0)==0){
                    lowestNum++;
                }
                else break;
            }
        }
        return true;
    }
}
