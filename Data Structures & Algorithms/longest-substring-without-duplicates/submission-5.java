class Solution {
    public int lengthOfLongestSubstring(String s) {
        int idx1 = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            while(set.contains(ch)){
                set.remove(s.charAt(idx1));
                idx1++;
            }
                set.add(ch);
            
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}
