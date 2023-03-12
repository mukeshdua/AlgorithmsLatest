import java.util.*;

public class Array {

    public int[] productExceptSelf(int[] nums) {
        int N= nums.length;
        int[] left_product = new int[N];
        int[] right_product = new int[N];
        int[] output = new int[N];

        left_product[0]=1;
        right_product[N-1]=1;
        for(int i=1;i<N;i++)
        {
            left_product[i] = left_product[i-1] * nums[i-1];
        }
        for(int i=N-2;i>=0;i--)
        {
            right_product[i] = right_product[i+1] * nums[i+1];
        }

        for(int i=0;i<N;i++)
        {
            output[i] = left_product[i] * right_product[i];
        }

        return output;


    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int diff = target - num;
            if (values.containsKey(diff)) {
                int[] arr = {values.get(diff), index};
                return arr;
            }
            values.put(num, index);

        }
        int[] arr = {-1, -1};
        return arr;
    }

    public static boolean isValid(String s) {
        Map<Character,Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('[',']');
        brackets.put('{','}');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(brackets.containsKey(s.charAt(i)))
            {
                stack.push(s.charAt(i));
            }
            else if (stack.isEmpty()) {
                return false;
            }
            else {
                char character = stack.pop();
                if (brackets.containsKey(character) && brackets.get(character) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++)
        {
            while(strs[i].indexOf(prefix) !=0)
            {
                prefix=prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }

    public int[] plusOne(int[] digits) {

        int size = digits[digits.length - 1] == 9 ? digits.length + 1 : digits.length;
        int[] val = new int[size];
        if (size > digits.length) {
            val[size - 1] = 0;
            val[size - 2] = 1;
        } else {
            val[size - 1] = digits[size - 1] + 1;
        }

        for (int i = digits.length - 2; i >= 0; i--) {
            val[i] = digits[i];
        }
        return val;

    }

    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        for(int i=0;i<s.length()/2;i++)
        {
            if(s.charAt(i) != s.charAt(s.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }

    /* Remove Duplicates from Sorted Array
         https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
     */

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> val= new HashMap();
        for(int num:nums)
        {
            int count=1;
            if(val.containsKey(num))
            {
                count++;
            }
            val.put(num,count);
        }

        for(Integer key:val.keySet())
        {
            if(val.get(key)==1)
            {
                return key;
            }
        }
        return -1;

    }

    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result= new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            List<Integer> row= new ArrayList<>();
            for(int j=0;j<i;j++)
            {
                if(j==0 || j==i-1)
                {
                    row.add(1);
                }
                else {
                    row.add(result.get(i-2).get(j) + result.get(i-2).get(j-1));
                }
            }
            result.add(row);
        }
        return result;

    }

    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            for(int j=i+1;j<prices.length;j++)
            {
                int tempProfit= prices[j]-prices[i];
                if(tempProfit > profit)
                {
                    profit=tempProfit;
                }
            }
        }
        return profit;
    }
    public int maxProfitOn(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> values= new HashMap();
        for(int num:nums)
        {
            int count=values.containsKey(num)?values.get(num)+1:1;
            values.put(num,count);
        }
        for(int val:values.keySet())
        {
            if(values.get(val)> nums.length/2)
            {
                return val;
            }
        }
        return -1;
    }

    public static boolean isIsomorphic(String s, String t)
    {
        Map<Character,Character> st = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(!st.containsValue(t.charAt(i)))
            {
                st.put(s.charAt(i),t.charAt(i));
            }
        }
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            sb.append(st.get(s.charAt(i)));
        }
        return (sb.toString().equals(t));


    }




    public int searchInsert(int[] nums, int target) {
        return search(nums,0, nums.length-1,target);

    }

    public int search(int[] nums, int start, int end, int target)
    {
        int middle = start+(end-start)/2;
        if(start>end || nums[middle]== target)
        {
            return middle;
        }
        else if (nums[middle] > target)
        {
            return search(nums, start,middle-1,target);
        }
        else
        {
            return search(nums, middle+1,end,target);
        }

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1=m-1;
        int p2=n-1;
        int num1IndexToInsert=m+n-1;
        int num2Index=0;
        while(p2>=0)
        {
            if(p1>=0 && nums1[p1]>nums2[p2])
            {
                nums1[num1IndexToInsert]=nums1[p1];
                p1=p1-1;
            }
            else
            {
                nums1[num1IndexToInsert]=nums2[p2];
                p2=p2-1;
            }
            num1IndexToInsert=num1IndexToInsert-1;
        }
    }

    public static int maxSubArray(int[] nums) {

        int maxSum=nums[0];
        int currentSum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            currentSum= Math.max(nums[i],currentSum+nums[i]);
            maxSum= Math.max(maxSum,currentSum);

        }
        return maxSum;

    }

    public int maxProduct(int[] nums) {
        int maxSum=nums[0];
        int currentSum=nums[0];

        for(int i=1;i<nums.length;i++)
        {
            currentSum= Math.max(nums[i],currentSum*nums[i]);
            maxSum= Math.max(maxSum,currentSum);

        }
        return maxSum;
    }

    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public int findMinRotatedSubArrON(int[] nums) {

        int first =nums[0];
        int last = nums[nums.length-1];
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i-1] && nums[i]<nums[i+1])
            {
                return nums[i];
            }
        }
        return Math.min(first,last);

    }



    public static void main(String args[])
    {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(isIsomorphic("pee","egg"));
//        removeDuplicates(new int[]{3,2,2,1});
//        isPalindrome("A man, a plan, a canal: Panama");
//        int[] arr={1,2,3};
//        //plusOne(arr);
//
//        //isValid("(]");
    }
}
