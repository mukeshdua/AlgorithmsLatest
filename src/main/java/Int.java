import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Int {

    public static int getReverse(int x) {
        int rev = 0;
        int remainder = 0;
        while (x != 0) {
            remainder=x%10;
            x=x/10;
            rev=rev*10+remainder;
        }
        return rev;

    }

    public static int climbStairsorFibonacci(int stairCount)
    {
        if(stairCount == 0 || stairCount==1)
        {
            return 1;
        }
        int a=1;
        int b=1;
        for(int i=2;i<=stairCount;i++)
        {
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }


    public static boolean isNumberPalindrome(int x)
    {
        return getReverse(x) == x;
    }



    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber > 0){
            int rem = (columnNumber-1)%26;
            sb.append((char)('A' + rem));
            columnNumber = (columnNumber-1)/26;
        }

        sb.reverse();
        return sb.toString();
    }

    public int mySqrt(int x) {
        if(x==1)
        {
            return x;
        }

        for(int i=0;i<=x;i++)
        {
            if(i*i > x)
            {
                return i-1;
            }
        }
        return 0;

    }

    public static int fib(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibDynamic(int n) {
        int[] mem= new int[n+1];
        return fibDynamic(n,mem);
    }

    public static int fibDynamic(int n, int[] mem) {
        if(mem[n] != 0)
        {
            return mem[n];
        }
        int result=0;
        if (n == 1 || n == 2) {
            result=1;
        }
        else {
            result=fibDynamic(n - 1,mem) + fibDynamic(n - 2,mem);
        }
        return result;
    }

    public boolean isUgly(int n) {
        if (n == 1)
            return true;
        while (n > 0) {
            if (n == 1) {
                return true;
            } else if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }

    public int firstBadVersion(int n) {
        if( n== 1)
        {
            //return isBadVersion(n)?1:-1;
        }

        for(int i=n;i>1;i--)
        {
//            if(isBadVersion(i) && !isBadVersion(i-1))
//            {
//                return i;
//            }

        }
        return -1;
    }

    /*
    You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.
     */
    public boolean canWinNim(int n) {
        return !(n%4==0);

    }

    public boolean isPerfectSquare(int num) {
        return isPerfectSquare(num,1,num);

    }
    public boolean isPerfectSquare(int num, long start, long end)
    {
        if(start > end)
        {
            return false;
        }
        long mid = (start+end)/2;
        if(mid * mid == num)
        {
            return true;
        }
        if(mid*mid > num)
        {
            return isPerfectSquare(num,start,mid-1);
        }
        else
        {
            return isPerfectSquare(num,mid+1,end);
        }

    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList();
        for(int hour=0; hour<12; hour++){
            for(int minute=0; minute<60; minute++){
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                    String minuteVal = minute<10? "0" + String.valueOf(minute):String.valueOf(minute);
                    result.add(String.format("%d:%s",hour,minuteVal));
                }
            }
        }
        return result;


    }

    public static void main(String args[])
    {
        System.out.println(Instant.now());
        //for(int i=1;i<10;i++) {
        System.out.println(fibDynamic(100));
        //}
        System.out.println(Instant.now());
        //System.out.println(isNumberPalindrome(121));
    }


}
