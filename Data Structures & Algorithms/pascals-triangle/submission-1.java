class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        final List<List<Integer>> result = new ArrayList<>();

        final List<Integer> rootNode = List.of(1);
        if(numRows==1) return List.of(rootNode);

        result.add(rootNode);
        numRows--;

        while(numRows>0){
            final List<Integer> prevlist = result.get(result.size()-1);
            final int size = prevlist.size();
            
            final List<Integer> newrow = new ArrayList<>(size+1);

            newrow.add(1);
            for(int i=0; i<size-1; i++){
                int val = prevlist.get(i) + prevlist.get(i+1);
                newrow.add(val);
            }
            newrow.add(1);
            result.add(newrow);
            numRows--;
        }
        return result;

    }
}