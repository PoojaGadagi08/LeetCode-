class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
         int left = 0, right = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        int maxLength = 0;

        for (right = 0; right < nums.length; right++) {
            frequency.put(nums[right], frequency.getOrDefault(nums[right], 0) + 1);

            if (frequency.get(nums[right]) > k) {
                while (frequency.get(nums[right]) > k) {
                    frequency.put(nums[left], frequency.get(nums[left]) - 1);
                    if (frequency.get(nums[left]) == 0) {
                        frequency.remove(nums[left]);
                    }
                    left++;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
