package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println("result = " + result);
    }
    public static List<String> generateParenthesis(int n){
        List<String> ret = new ArrayList<>();
        process(n, 0, 0, "", ret);
        return ret;
    }

    public static void process(int n, int openCount, int closeCount, String str, List<String> ret){
        // termination
        if(openCount == n && closeCount == n){
            ret.add(str);
            return;
        }
        // recurse next
        if(openCount<n){
            process(n, openCount+1, closeCount, str+"(", ret);// add open bracket
        }
        if(openCount > closeCount){
            process(n, openCount, closeCount+1, str+")", ret);// add close bracket
        }
    }


}
