package leetcode.day004;

import java.util.Stack;

/**
 * 짝 맞추기
 * 대표적은 Stack 문제
 *
 * 3 types of brackets (total 6 brackets)
 * 주어진 input에서 charByChar로 for문을 돌면서 쌍을 비교
 */
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        char[] arr = s.toCharArray();
        for(char c:arr){
            // open bracket check
            if(c == '(' || c=='{' || c=='['){
                stk.push(c);
            }else if(c==')'){
                // stack의 쌍 비교
                if(stk.size() == 0 || stk.pop() !='(')
                    return false;
            }else if(c=='}'){
                // stack의 쌍 비교
                if(stk.size() == 0 || stk.pop() !='{')
                    return false;
            }else if(c==']'){
                // stack의 쌍 비교
                if(stk.size() == 0 || stk.pop() !='[')
                    return false;
            }else{
                    return false;
            }
//            if(stk.size() != 0){
//                return false;
//            }
        }
//        return true;
        return stk.size() == 0;
    }
}
