class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<Integer>();
        int sum = 0;

        for(String op: operations){
                int num;
            switch(op){
                case "+": 
                    num = list.get(list.size()-1)+list.get(list.size()-2);
                    list.add(num);
                    sum+=num;
                    break;

                case "D": 
                    num = 2*list.get(list.size()-1);
                    list.add(num);
                    sum+=num;
                    break;

                case "C": 
                    num = list.get(list.size()-1);
                    sum -= num;
                    list.remove(list.size()-1);
                    break;

                default: 
                    num = Integer.valueOf(op);
                    list.add(num);
                    sum+=num;
                    break;
            }
        }
        return sum;
    }
}