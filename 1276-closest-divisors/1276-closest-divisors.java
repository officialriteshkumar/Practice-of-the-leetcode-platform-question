 class Solution {
    public int[] closestDivisors(int num) {
        int[] k1 = divisors(num+1);
        int[] k2 = divisors(num+2);
        return (k1[1] - k1[0] > k2[1] - k2[0]) ? k2 : k1;
    }

    private int[] divisors(int n){
        int[] arr = new int[2];
        int right = (int)Math.sqrt(n);
        for(int i = right; i > 0; i--)
            if(n % i == 0){
                arr[0] = i;
                arr[1] = n / i;
                break;
            }
        return arr;
    }
}