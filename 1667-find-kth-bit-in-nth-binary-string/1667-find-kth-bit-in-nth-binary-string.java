class Solution {
    public char findKthBit(int n, int k) {
         LinkedList<Character> t = new LinkedList<>();
    LinkedList<Character> cur = new LinkedList<>();
    int i = 1;
    cur.add('0');
    while (i < n) {
        i++;
        t.addAll(cur);
        t.add('1');
        while (!cur.isEmpty()) {
            char c = cur.removeLast();
            t.add(c == '0' ? '1' : '0');
        }
        cur = t;
        t = new LinkedList<>();
    }
    char res = 0;
    while (k > 0) {
        k--;
        res = cur.removeFirst();
    }
    return res;
    }
}