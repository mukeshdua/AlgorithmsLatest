import java.util.ArrayList;
import java.util.List;

public class Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p ==null && q==null))
        {
            return true;
        }
        return p!=null && q!=null && p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right==null)
        {
            return true;
        }
        else if((root.left == null && root.right!=null) || (root.left != null && root.right==null))
        {
            return false;
        }
        return isSymmetric(root.left) && isSymmetric(root.right);
    }

    boolean ans=true;
    public int solve(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=solve(root.left);
        int right=solve(root.right);
        if(Math.abs(left-right)> 1)
        {
            ans=false;
        }
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        solve(root);
        return ans;

    }

    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right) + 1;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
        {
            return false;
        }
        return checkPathSum(root, targetSum);
    }

    public boolean checkPathSum(TreeNode root, int targetSum)
    {
        if((root == null && targetSum !=0) || (root !=null && targetSum==0))
        {
            return false;
        }
        else if(root == null && targetSum == 0)
        {
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray(nums, 0, nums.length-1);
    }

    public TreeNode sortedArray(int[] nums, int start, int end)
    {
        if(start>end)
        {
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left= sortedArray(nums, start, mid-1);
        root.right= sortedArray(nums, mid+1, end);
        return root;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        inOrderTraverse(root,traversal);
        return traversal;
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        inOrderTraverse(root,traversal);
        for(int i=0;i<traversal.size()-1;i++)
        {
            if(traversal.get(i)>traversal.get(i+1))
            {
                return false;
            }
        }
        return true;

    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> traversal = new ArrayList();
        inOrderTraverse(root,traversal);
        return traversal.get(k-1);
    }

    private void inOrderTraverse(TreeNode root, List<Integer> traversal)
    {
        if(root==null)
        {
            return;
        }
        inOrderTraverse(root.left,traversal);
        traversal.add(root.val);
        inOrderTraverse(root.right,traversal);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        preOrderTraverse(root,traversal);
        return traversal;
    }

    private void preOrderTraverse(TreeNode root, List<Integer> traversal)
    {
        if(root==null)
        {
            return;
        }
        traversal.add(root.val);
        preOrderTraverse(root.left,traversal);
        preOrderTraverse(root.right,traversal);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList();
        postOrderTraverse(root,traversal);
        return traversal;
    }

    private void postOrderTraverse(TreeNode root, List<Integer> traversal)
    {
        if(root==null)
        {
            return;
        }
        postOrderTraverse(root.left,traversal);
        postOrderTraverse(root.right,traversal);
        traversal.add(root.val);
    }

}
