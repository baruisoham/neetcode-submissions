class Solution {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()){
            if(isOpenBracket(ch)){
                stack.push(ch);
                continue;
            }
            else if (!stack.isEmpty() && isMatchingPair(stack.peek(), ch)){
                stack.pop();
                continue;
            }
            else return false;
        }
        return stack.isEmpty();
    }

    private boolean isOpenBracket(Character ch){
        if (ch =='(' || ch =='{' || ch =='[') return true;
        return false;
    }

    private boolean isMatchingPair(Character openCh, Character closedCh){
        if ((openCh =='(' && closedCh ==')') || (openCh =='{' && closedCh =='}') || (openCh =='[' && closedCh ==']')) return true;
        return false;
    }
}
