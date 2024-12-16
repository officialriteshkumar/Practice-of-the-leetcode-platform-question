class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=0;
        for(int i=m; i<m+n; i++){
            nums1[i] = nums2[index];
            index++;
        }
       for(int i=0; i<nums1.length; i++){
            for(int j=0; j<nums1.length-i-1; j++)
           if(nums1[j] > nums1[j+1]){
            int temp = nums1[j];
            nums1[j] = nums1[j+1];
            nums1[j+1] = temp;
           }
       }
        
    }
}