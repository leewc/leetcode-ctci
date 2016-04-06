public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray())
        {
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') return false;
                    break;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray())
        {
            switch(c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if(stack.isEmpty()) return false;
                    Character popped = stack.pop();
                    if(c == '}' && popped != '{' ) return false;
                    else if(c == ']' && popped != '[') return false;
                    else if(c == ')' && popped != '(') return false;
                    break;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}