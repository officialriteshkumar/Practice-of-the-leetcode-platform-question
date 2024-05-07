package Ritesh;
public class Solution6 {
        public String convert(String s, int numRows) {
            if (numRows == 1 || numRows >= s.length()) {
                return s;
            }
            
            StringBuilder[] rows = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                rows[i] = new StringBuilder();
            }
            
            int direction = 1;
            int currentRow = 0;
            for (char c : s.toCharArray()) {
                rows[currentRow].append(c);
                if (currentRow == 0) {
                    direction = 1;
                } else if (currentRow == numRows - 1) {
                    direction = -1;
                }
                currentRow += direction;
            }
            
            StringBuilder result = new StringBuilder();
            for (StringBuilder row : rows) {
                result.append(row);
            }
            return result.toString();
        }
    }
    
