class Solution {
    public int heightChecker(int[] heights) {
               int[] expected = new int[heights.length]; 
        for (int i = 0; i < heights.length; i++) {
            expected[i] = heights[i];
        }
        BubbleSort(heights);
        return check(heights,expected);
    }
    
    public int check(int[] heights,int[] expected){
        int count = 0;
        for(int i = 0;i < heights.length;i++){
            if(heights[i] != expected[i]){
                count++;
            }
        }
        return count;
    }
    
    public void BubbleSort(int[] arr){
        boolean swapped;
       
        for (int i = 0; i < arr.length; i++) {
           
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                            arr[j-1] = temp;
                    swapped = true;
                }
            }
            
            if(swapped == false){
                break;
            }
        }
 
    }
}