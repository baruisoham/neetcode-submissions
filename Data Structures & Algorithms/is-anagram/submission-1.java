class Solution {
    public boolean isAnagram(String s, String t) {
        final HashMap<Character, Integer> sFreqMap = freqMap(s);
        
        final HashMap<Character, Integer> tFreqMap = freqMap(t);

        return (tFreqMap.equals(sFreqMap)) ? true : false;

    }


    public HashMap<Character ,Integer> freqMap(String string){
        HashMap<Character,Integer> freqMap = new HashMap<>();
        final char[] charArr = string.toCharArray();
        for(char c: charArr){
            int freq = freqMap.getOrDefault(c, 0);
            freq++;
            freqMap.put(c, freq); 
        }
        return freqMap;
    }
}
