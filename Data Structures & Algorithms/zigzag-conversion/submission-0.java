class Solution {
    public String convert(String s, int numRows) {
        final List<List<Character>> matrix = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            matrix.add(new ArrayList<Character>());
        }

        int pos=0;
        boolean inc = true;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            matrix.get(pos).add(ch);
            if(pos==numRows-1) inc = false;
            else if(pos==0) inc = true;

            pos = inc ? ++pos: --pos;
        }

        final StringBuilder sb = new StringBuilder();

        for(List<Character> list: matrix){
            for(Character ch: list){
                sb.append(ch);
            }
        }

        return sb.toString();

    }


}