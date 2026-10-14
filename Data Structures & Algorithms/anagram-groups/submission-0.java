class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, List<String>> listHolderMap= new HashMap<>();
        for(String str: strs){
            final int[] freqArr = createFreqArr(str);
            final String freqArrAsString = Arrays.toString(freqArr);
            listHolderMap.computeIfAbsent(freqArrAsString, k -> new ArrayList<>()).add(str);
        }
        final List<List<String>> result = new ArrayList<>(); 
        for(Map.Entry<String, List<String>> list: listHolderMap.entrySet()) result.add(list.getValue());
        return result;
    }

    public int[] createFreqArr(String s){
        final char[] chars = s.toCharArray();
        final int[] freqArr = new int[(int)('z'-'A'+1)];
        for(char ch : chars){
            final int index = ch - 'A';
            freqArr[index]++;
        }
        return freqArr;
    }
}
