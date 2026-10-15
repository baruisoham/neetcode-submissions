class Solution {

    private final Set<String> operators = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if (!operators.contains(token)) stack.push(Integer.valueOf(token));
            else{
                final Integer operand2 = stack.pop();
                final Integer operand1 = stack.pop();
                stack.push(calculate(operand1, operand2, token));
            }
        }
        return stack.pop();
    }

    private static int calculate(int op1, int op2, String token){
        switch (token){
            case "+": return op1+op2;
            case "-": return op1-op2;
            case "*": return op1*op2;
            default: return op1/op2;

        }

    }
}
