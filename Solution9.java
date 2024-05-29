 import java.math.BigInteger;
    public class Solution9 {
    public static void main(String[] args) {
        String s1 = "1101";
        String s2 = "10";
        String s3 = "1";
        String s4 = "1111011110000011100000110001011011110010111001010111110001"; 

        Solution solution = new Solution();
        System.out.println(solution.numSteps(s1)); 
        System.out.println(solution.numSteps(s2)); 
        System.out.println(solution.numSteps(s3)); 
        System.out.println(solution.numSteps(s4)); // Test the large input case
    }

    public int numSteps(String s) {
        BigInteger num = new BigInteger(s, 2);
        int steps = 0;
        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.TWO);
            } else {
                num = num.add(BigInteger.ONE);
            }
            steps++;
        }
        return steps;
    }
}
