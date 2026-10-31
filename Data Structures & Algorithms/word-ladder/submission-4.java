class Solution {

    private HashSet<String> wordSet;

    private HashMap<String, Set<String>> wordMap;

    private int currCount = 0;
    private String targetWord;

    private int minCount = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()!=endWord.length()) return 0;
        this.wordSet = new HashSet<>(wordList);
        this.targetWord = endWord;
        this.wordMap = new HashMap<String, Set<String>>();
        wordSet.add(beginWord);

        if( !wordSet.contains(targetWord) ) return 0;

        for(String word: wordSet){
            final Set<String> adjList = new HashSet<>();

            for(String otherWord: wordSet){
                if(otherWord.equals(word)) continue;
                if(otherWord.length()!=word.length()) continue;
                int diffCount = 0;
                for(int i=0; i<word.length(); i++){
                    if(word.charAt(i)!=otherWord.charAt(i)){
                        diffCount++;
                        if(diffCount>1) break;
                    }
                }
                if(diffCount==1) adjList.add(otherWord);
            }
            wordMap.put(word, adjList);
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        return countDist(new HashSet<String>(), queue);

        // return minCount==Integer.MAX_VALUE ? 0 : minCount;

    }



    private int countDist(Set<String> visitedSet, Queue<String> queue){
        int level=1;
        while(!queue.isEmpty()){
            
            int levelSize=queue.size();
            for(int i=0; i<levelSize; i++){
                String currWord = queue.poll();
                
                if(this.targetWord.equals(currWord)){
                    return level;
                }

                visitedSet.add(currWord);
                for(String nextWord: wordMap.get(currWord)){
                    if(!visitedSet.contains(nextWord)) queue.add(nextWord);
                }


            }
            level++;
        }
        return 0;



        // if(this.targetWord.equals(currWord)){
        //     minCount = Math.min(currCount, minCount);
        //     visitingSet.remove(currWord);
        //     currCount--;
        //     return currCount;
        // }

        // for(String nextWord: wordMap.get(currWord)){

        //     if(!visitingSet.contains(nextWord)) {
        //         countDist(currWord, nextWord, visitingSet);
        //     }

        // }

        // visitingSet.remove(currWord);
        // currCount--;
        // return currCount;

    
    }

}