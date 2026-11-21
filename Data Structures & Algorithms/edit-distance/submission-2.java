class Solution {
    public int minDistance(String word1, String word2) {

        if(word1.equals(word2)) return 0;
        
        Queue<CurrState> queue = new ArrayDeque<>();

        boolean allowDel = true;
        boolean allowAdd = true;

        // if(word1.length()<word2.length()) allowDel = false;

        // if(word1.length()>word2.length()) allowAdd = false;

        queue.add(new CurrState(word1, 0));

        int level = 0;

        HashSet<String> visited = new HashSet<>();

        while(!queue.isEmpty()){

            level++;
            int size = queue.size();

            for(int i=0; i<size; i++){
                CurrState currState = queue.poll();
                String currString = currState.currString;
                if(currString.equals(word2)) return level;

                CurrState replaceEntry = replace(currState, word2);
                if(replaceEntry.currString.equals(word2) )return level;
                String replaceEntryString = replaceEntry.currString;
                if(!visited.contains(replaceEntryString)){
                    queue.add(replaceEntry);
                    visited.add(replaceEntryString);
                }
                if(allowAdd) {
                    CurrState insertEntry = insert(currState, word2);
                    if(insertEntry.currString.equals(word2) )return level;
                    String insertEntryString = insertEntry.currString;
                    if(!visited.contains(insertEntryString)){
                    queue.add(insertEntry);
                    visited.add(insertEntryString);
                    }

                }
                if(allowDel){
                    CurrState deleteEntry = delete(currState, word2);
                    if(deleteEntry.currString.equals(word2)) return level;
                    String deleteEntryString = deleteEntry.currString;
                    if(!visited.contains(deleteEntryString)){
                    queue.add(deleteEntry);
                    visited.add(deleteEntryString);
                    }
                } 
            }
        }
        return -1;

    }

    private int findIndex(String curr, String ideal){
        for(int i=0; i<curr.length(); i++){
            if(i>=ideal.length()) return i;
            else if(curr.charAt(i)!=ideal.charAt(i)) return i;
        }
        return curr.length();
    } 


    private CurrState replace(CurrState currState, String ideal){
        String currString = currState.currString;
        int currIdx = currState.currIdx;
        for(; currIdx<currString.length() && currIdx<ideal.length(); currIdx++){
            if(currString.charAt(currIdx) == ideal.charAt(currIdx)){
            }
            else{
                String endStr = "";
                if(currIdx+1<currString.length()) endStr = currString.substring(currIdx+1);
                currString = currString.substring(0,currIdx) + ideal.charAt(currIdx) + endStr;
                break;
            }
        }
        return new CurrState(currString, currIdx);
    }


    private CurrState insert(CurrState currState, String ideal){

        String currString = currState.currString;
        int currIdx = currState.currIdx;
        for(;currIdx<ideal.length(); currIdx++){
            if(currIdx<currString.length() && currString.charAt(currIdx) == ideal.charAt(currIdx)){
            }
            else{
                String endStr = "";
                if(currIdx<currString.length()) endStr = currString.substring(currIdx);
                currString = currString.substring(0,currIdx) + ideal.charAt(currIdx) + endStr;
                break;
            }
        }
        return new CurrState(currString, currIdx);

    }


    private CurrState delete(CurrState currState, String ideal){

        String currString = currState.currString;
        int currIdx = currState.currIdx;
        for(; currIdx<currString.length(); currIdx++){
            if(currIdx<ideal.length() && currString.charAt(currIdx) == ideal.charAt(currIdx)){
            }
            else{
                String endStr = "";
                if(currIdx+1<currString.length()) endStr = currString.substring(currIdx+1);
                currString = currString.substring(0,currIdx) + endStr;
                break;
            }
            
        }
        return new CurrState(currString, currIdx);

    }


    private record CurrState(String currString, int currIdx){};

}
