class Solution {

    private HashSet<String> wordSet;

    private HashMap<String, Set<String>> wordMap;
    private String targetWord;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length()!=endWord.length()) return 0;
        this.wordSet = new HashSet<>(wordList);
        if( !wordSet.contains(endWord) ) return 0;
        this.targetWord = endWord;
        this.wordMap = new HashMap<String, Set<String>>();
        wordSet.add(beginWord);

        for(String word: wordSet){
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
                Set<String> wordSet = wordMap.computeIfAbsent(word, k -> new HashSet<String>());
                Set<String> otherWordSet = wordMap.computeIfAbsent(otherWord, k -> new HashSet<String>());
                if(diffCount==1) {
                    wordSet.add(otherWord);
                    otherWordSet.add(word);
                }
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        return countDist(new HashSet<String>(), queue);
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
    
    }

}