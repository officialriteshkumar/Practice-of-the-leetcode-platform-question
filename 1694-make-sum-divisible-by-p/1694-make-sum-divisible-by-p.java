class Solution {
    public int minSubarray(int[] nums, int p) {
         int n = nums.length;
    int[] mod = new int[n + 1];
    for(int i = 0; i < n; i++){
        mod[i + 1] = ((mod[i] + nums[i]) % p + p) % p;
    }
    if(mod[n] == 0) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int res = n;
    for(int i = 1; i <= n; i++){
        int temp = ((mod[i] -  mod[n]) % p + p) % p;
        if(map.containsKey(temp)){
            int l = i - map.get(temp);
            res = Math.min(l, res);
        }
        map.put(mod[i], i);

    }
    return res == n ? -1 : res;
}
}