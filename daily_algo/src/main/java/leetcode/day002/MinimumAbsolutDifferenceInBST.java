package leetcode.day002;


public class MinimumAbsolutDifferenceInBST {
    // 트리 순회 (재귀)
    // preorder : self left right
    // inorder : left self right
    // postorder : left right self
    // 이진검색트리 성질 -> inorder -> 오름차순 정렬이 됨!
    static boolean init;
    static int prev;
    static int min;
    public static int getMinimumDifference(TreeNode root){
        init = false;
        int min = Integer.MAX_VALUE;
        inorder(root);
        return min;
    }

    public static void inorder(TreeNode root){
        // 예외 처리
        if(root==null) return;

        inorder(root.left);
        //self처리
        if(!init){
            init = true;
        }else{
            min = Math.min(min,root.val - min);
        }
        prev = root.val;
        inorder(root.right);
    }
}
