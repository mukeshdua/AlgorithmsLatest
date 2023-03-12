public class BitOperator {

    public static int getSum(int a, int b) {
        return a==0 ? b : getSum((a&b)<<1,a^b);
    }

    //https://leetcode.com/problems/number-of-1-bits/solutions/
    public int hammingWeight(int n) {
        int count =0;
        while(n!=0)
        {
            int lastbit=n & 1;
            count +=lastbit;
            n=n>>>1;
        }
        return count;

    }

    public int[] countBits(int n) {
        int[] arr= new int[n+1];
        for(int i=0;i<=n;i++)
        {
            arr[i]=count1s(i);
        }
        return arr;
    }

    private int count1s(int n)
    {
        int count=0;
        while(n!=0)
        {
            int lastBit= n &1;
            count +=lastBit;
            n = n>>>1;
        }
        return count;
    }

    public int missingNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            ans^=nums[i];
            ans^=i+1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        getSum(2,2);
    }
}
