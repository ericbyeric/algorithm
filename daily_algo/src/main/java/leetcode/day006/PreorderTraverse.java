package leetcode.day006;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


// pre self children
public class PreorderTraverse {

    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<>();
        recursiveTraverse(root, ret);
        return ret;
    }

    public static void recursiveTraverse(Node root, List<Integer> ret){
        if(root == null) return;
        ret.add(root.val);
        for(Node child : root.children){
            recursiveTraverse(child, ret);
        }
    }
}
class PreorderIterativeTraverse{
    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<Node> st = new Stack<>();

        if (root == null) return ret;

        st.push(root);

        while(!st.isEmpty()){
            Node cur = st.pop();
            ret.add(cur.val);

            for(int idx = cur.children.size() - 1; idx >= 0; idx--){
                st.push(cur.children.get(idx));
            }
        }
        return ret;
    }
}





