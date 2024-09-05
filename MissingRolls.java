import java.util.Arrays;

public class MissingRolls {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalRolls = m + n;
        int totalSum = mean * totalRolls;
        int currentSum = 0;
        for (int roll : rolls){
            currentSum += roll;

        }
        int requiredSum = totalSum - currentSum;
        if(requiredSum < n || requiredSum >6 *n){
            return new int [0];

        }
        int[] result = new int [n];
        Arrays.fill(result,1);
        requiredSum -= n;
        for(int i = 0; i<n; i++){
            int add = Math.min(5, requiredSum);
            result[i] += add;
            requiredSum -= add;
            if(requiredSum == 0){
                break;
            }
        }
        return result;

    }
}

