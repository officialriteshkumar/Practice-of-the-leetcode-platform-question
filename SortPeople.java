class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Integer[] indices = new Integer[names.length];
        for (int i = 0; i < names.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(heights[i2], heights[i1]);
            }
        });
        String[] result = new String[names.length];
        for (int i = 0; i < indices.length; i++) {
            result[i] = names[indices[i]];
        }

        return result;
    }
}
