  // Map to store the first occurrence of each modulo value
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initial modulo value before any elements are added is 0 at index -1
        map.put(0, -1);
        
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int modValue = prefixSum % k;
            
            // Normalize modValue to be positive
            if (modValue < 0) {
                modValue += k;
            }
            
            if (map.containsKey(modValue)) {
                // Check if the subarray length is at least 2
                if (i - map.get(modValue) > 1) {
                    return true;
                }
            } else {
                // Store the first occurrence of this modValue
                map.put(modValue, i);
            }
        }
        
        return false;
