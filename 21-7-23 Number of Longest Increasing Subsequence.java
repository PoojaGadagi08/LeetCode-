
Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.

 

Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 

Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106












class Solution {
    public int findNumberOfLIS(int[] a) {
        int n = a.length, max = 1;
        // need to maintain list of decks for each length
        // in the list we need list of ending values (bottom up descending), and its counts prefix sum (bottom up)
        List<List<int[]>> decks = new ArrayList<>(); // int[0]: tail value, int[1]: count's prefix sum

        // step1 push
        for (int i = 0; i < n; i++) {
            int idx4insert = bs(a[i], decks); // key logic of 300, find where I(a[i]) belongs

            // find cnt from previous list
            int cnt = idx4insert == 0 ? 1 : getCount(decks.get(idx4insert-1), a[i]);

            // create the new element
            int[] cur = new int[] {a[i], cnt};
            List<int[]> deck;
            if (idx4insert == decks.size()) {
                decks.add(deck = new ArrayList<>());
            } else {
                deck = decks.get(idx4insert); // find the right deck
                cur[1] += deck.get(deck.size() - 1)[1]; // [1] is prefix sum of count
            }
            deck.add(cur);
        }

        // System.out.printf("Input Array:\n%s\nDecks:\n%s\n", Arrays.toString(a), toString(decks));

        var deck = decks.get(decks.size() - 1);
        return deck.get(deck.size() - 1)[1];
    }

    private int getCount(List<int[]> deck, int x) { // in a descending order list find largest smaller (no equal) 5 4 4 3: 4        
        int l = 0, r = deck.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (deck.get(m)[0] >= x) l = m + 1;
            else r = m;
        }
        if (l == deck.size()) return 1; // first # of LIS, so count is 1;
        return deck.get(deck.size() - 1)[1] - (l == 0 ? 0 : deck.get(l-1)[1]);
    }

    private int bs(int x, List<List<int[]>> decks) { // smallest >=, i.e. insertion index, 1 3 4 4 5: 4
        int l = 0, r = decks.size();
        while (l < r) { // find smallest larger
            int m = l + (r - l) / 2;
            var deck = decks.get(m);
            int cur = deck.get(deck.size() - 1)[0];
            if (cur < x) l = m + 1;
            else r = m;
        }
        return l;
    }

    private StringBuilder toString(List<List<int[]>> decks) {
        return toString(decks, 1);
    }
    private StringBuilder toString(List<List<int[]>> decks, int w) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (var deck : decks)
            sb.append(decktosb(deck, w));

        sb.append("]\n");
        return sb;
    }

    private StringBuilder decktosb(List<int[]> deck) {
        return decktosb(deck, 1);
    }

    private StringBuilder decktosb(List<int[]> deck, int w) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (var arr : deck)
            sb.append(String.format("[%"+ w + "d, %"+ w + "d], ", arr[0], arr[1]));

        sb.setLength(sb.length() - 2);
        return sb.append("]\n");
    }
}
