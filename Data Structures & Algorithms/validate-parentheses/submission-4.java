class Solution {
    final private Map<Character, Character> matchingMap = new HashMap<>();
    {
    matchingMap.put(')', '(');
    matchingMap.put(']', '[');
    matchingMap.put('}', '{');
    }
    public boolean isValid(String s) {
        if ( s.length()%2!=0) return false;
        final Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()){
            if (!stack.isEmpty() && stack.peek().equals(matchingMap.get(ch))){
                stack.pop();
            }
            else stack.push(ch);
        }
        return stack.isEmpty();
    }
}
