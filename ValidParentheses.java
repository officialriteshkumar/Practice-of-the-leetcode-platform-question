package Ritesh;
    import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            } else {
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));     
        System.out.println(isValid("()[]{}"));   
        System.out.println(isValid("(]"));       
    }
}

    
