class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> nums = new ArrayList<>();

        for (int i : asteroids) {
            boolean alive = true;

            while (alive && i < 0 && !nums.isEmpty() 
                   && nums.get(nums.size() - 1) > 0) {

                int last = nums.get(nums.size() - 1);

                if (last < -i) {
                    nums.remove(nums.size() - 1);
                } else if (last == -i) {
                    nums.remove(nums.size() - 1);
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                nums.add(i);
            }
        }

        int[] result = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }

        return result;
    }
}