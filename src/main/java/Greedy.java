import java.util.Arrays;

public class Greedy {
    public int minimumSum(int num) {
        int[] nums = new int[4];
        int i=0;
        while(num > 0)
        {
            nums[i]= num%10;
            num = num/10;
            i++;
        }
        Arrays.sort(nums);
        return nums[0]*10+ nums[2] + nums[1]*10 + nums[3];
    }

    /*
  https://leetcode.com/problems/array-partition/description/
   */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans=0;

        for(int i=0;i<nums.length;i+=2)
        {
            ans+=nums[i];
        }
        return ans;

    }

    public int balancedStringSplit(String s) {
        int count=0;
        int charCount=0;

        for(int i=0;i<s.length();i++)
        {
            charCount= s.charAt(i) == 'R'? charCount+1:charCount-1;
            if(charCount == 0)
            {
                count++;
            }
        }
        return count;

    }
}
