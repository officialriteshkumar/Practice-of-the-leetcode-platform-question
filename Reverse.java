package Ritesh;

public class Reverse {
    public int reverse(int x) {
        int reversed = 0;  
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;
            
            reversed = reversed * 10 + digit;
        }
        
        return reversed;
    }
    
    public static void main(String[] args) {
        Reverse reverseObj = new Reverse(); 
        int example1 = 123;
        int example2 = -123;
        int example3 = 120;
        
        System.out.println("Example 1: Input = " + example1 + ", Output = " + reverseObj.reverse(example1));
        System.out.println("Example 2: Input = " + example2 + ", Output = " + reverseObj.reverse(example2));
        System.out.println("Example 3: Input = " + example3 + ", Output = " + reverseObj.reverse(example3));
    }
}
