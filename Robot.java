class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();
        for (int[] robot : robots) {
            if (robot[2] == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek()[2] == 'R') {
                    int[] rightRobot = stack.peek();
                    if (rightRobot[1] == robot[1]) {
                        stack.pop();
                        robot[1] = -1; 
                        break;
                    } else if (rightRobot[1] > robot[1]) {
                        rightRobot[1] -= 1;
                        robot[1] = -1; 
                        break;
                    } else {
                        stack.pop();
                        robot[1] -= 1;
                    }
                }
                if (robot[1] > 0) {
                    stack.push(robot);
                }
            }
        }

        List<int[]> remainingRobots = new ArrayList<>();
        for (int[] robot : stack) {
            if (robot[1] > 0) {
                remainingRobots.add(robot);
            }
        }

        Collections.sort(remainingRobots, Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : remainingRobots) {
            result.add(robot[1]);
        }

        return result;
    }
    }

