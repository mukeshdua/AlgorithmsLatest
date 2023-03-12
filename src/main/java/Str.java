import java.util.*;

public class Str {

    public static int romanToInt(String s) {
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>()
        {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M',1000);
        }};

        int curValue=0;
        int finalValue=0;
        for(int i=0;i< s.length();i++)
        {
            int temp = hashMap.get(s.charAt(i));
            if(curValue < temp)
            {
                finalValue+=Math.abs(curValue-temp);
            }
            else
            {
                finalValue+=temp;
            }
            curValue=temp;
        }
        return finalValue;

    }

    public String gcdOfStrings(String str1, String str2) {
        String bigger = str1.length()> str2.length()?str1:str2;
        String smaller = str1.length()> str2.length()?str2:str1;

        if(bigger.equals(smaller))
        {
            return smaller;
        }
        else if(!bigger.startsWith(smaller))
        {
            return "";
        }
        else
        {
            return gcdOfStrings(bigger.substring(smaller.length()),smaller);
        }

    }

    public List<String> fizzBuzz(int n) {
        List<String> fizzBuzzLst = new ArrayList();

        for(int i=1;i<=n;i++)
        {
            boolean found=false;
            StringBuilder str = new StringBuilder();
            if(i%3 == 0)
            {
                str.append("Fizz");
                found=true;
            }
            if(i%5 == 0)
            {
                str.append("Buzz");
                found=true;
            }
            fizzBuzzLst.add(found?str.toString():String.valueOf(i));
        }
        return fizzBuzzLst;
    }

    public void reverseString(char[] s) {
        int start=0;
        int end= s.length-1;
        while(start < end)
        {
            char temp= s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }

    public String reverseVowels(String s) {
        Set vowels = new HashSet(Arrays.asList('a', 'e','i','o','u'));
        char[] sArr = s.toCharArray();
        int start=0;
        int end= sArr.length-1;
        while(start < end)
        {
            if(
                    (vowels.contains(sArr[start]) && vowels.contains(sArr[end]))
            )
            {
                char temp= sArr[start];
                sArr[start]=sArr[end];
                sArr[end]=temp;
                start++;
                end--;
            }
            else if(!vowels.contains(sArr[start]) && !vowels.contains(sArr[end]))
            {
                start++;
                end--;
            }
            else if(vowels.contains(sArr[start]))
            {
                end--;
            }
            else
            {
                start++;
            }


        }
        return String.valueOf(sArr);
    }

    public boolean canPermutePalindrome(String s) {
        HashSet<Character> app = new HashSet<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (app.contains(c)) {
                app.remove(c);
            }
            else {
                app.add(c);
            }
        }
        return app.size() <=1;
    }

        public boolean isPowerOfThree(int n) {

        if(n <=0)
        {
            return false;
        }
        n = Math.abs(n);
        if(n==1)
        {
            return true;
        }
        while(n>1)
        {
            if(n % 3 != 0)
            {
                return false;
            }
            n=n/3;

        }
        return true;
    }

    public static void main(String args[])
    {
        romanToInt("LVIII");
    }
}
