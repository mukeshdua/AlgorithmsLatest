import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {

    public int rob(int[] nums) {
        int oddSum=0;
        for(int i=0;i<nums.length;i=i+2)
        {
            oddSum += nums[i];
        }
        int evenSum=0;
        for(int i=1;i<nums.length;i=i+2)
        {
            evenSum += nums[i];
        }

        return Math.max(evenSum,oddSum);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];

        f[0] = true;

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxArea(int[] height) {
        int maxArea=0;
        for(int i=0;i<height.length;i++)
        {
            for(int j=1;j<height.length;j++)
            {
                maxArea = Math.max(maxArea,(Math.min(height[j],height[i]) * (j-i)));
            }
        }
        return maxArea;
    }

    public static void main(String[] args)
    {
        lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        wordBreak("catsandog",new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat")));
    }


}
