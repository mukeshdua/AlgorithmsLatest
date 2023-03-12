import java.util.ArrayList;
import java.util.List;

public class BackTracking {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList();
        boolean[] mark = new boolean[nums.length];
        permute(nums,permutations,permutation,mark);
        return permutations;
    }

    public void permute(int[] nums,List<List<Integer>> permutations,List<Integer> permutation,boolean[] mark)
    {
        if(nums.length == permutation.size())
        {
            permutations.add(new ArrayList<>(permutation));
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!mark[i])
            {
                mark[i]=true;
                permutation.add(nums[i]);
                permute(nums,permutations,permutation,mark);
                mark[i]=false;
                permutation.remove(permutation.size()-1);
            }

        }

    }
}
