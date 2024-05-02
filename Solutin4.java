package Ritesh;

public class Solutin4 {
        public static boolean isPalindrome(int x) {
            String s = Integer.toString(x);
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    
        public static void main(String[] args) {
            int x1 = 121;
            int x2 = -121;
            int x3 = 10;
    
            System.out.println("Is " + x1 + " a palindrome? " + isPalindrome(x1));
            System.out.println("Is " + x2 + " a palindrome? " + isPalindrome(x2));
            System.out.println("Is " + x3 + " a palindrome? " + isPalindrome(x3));
        }
    }
    
