# daily_algorithm

## Leetcode
### Day 001 - 22. Generate Parentheses
```java
class Solution {
    // backtracking
    // ~ recursion + termination check
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        process(n, 0, 0, "", ret);
        return ret;
    }

    public void process(int n, int numOfOpened, int numOfClosed, String str, List<String> ret ){
        // termination
        if(numOfOpened==n && numOfClosed==n){
            ret.add(str);
            return;
        }
        // recurse next
        if(numOfOpened < n){
            process(n, numOfOpened+1, numOfClosed, str+"(", ret);  // add open bracket
        }
        if(numOfOpened > numOfClosed){
            process(n, numOfOpened, numOfClosed+1, str+")", ret);  // add closed bracket
        }

    }
}
```
