Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n













import java.util.*;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    void solve1(int num, int tot, int k, List<Integer> ans) {
        if (num == tot + 1) {
            if (ans.size() == k) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        ans.add(num);
        solve1(num + 1, tot, k, ans);
        ans.remove(ans.size() - 1);
        solve1(num + 1, tot, k, ans);
    }

    void solve2(int num, int tot, int k, List<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = num; i <= tot; i++) {
            ans.add(i);
            solve2(i + 1, tot, k, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        solve2(1, n, k, ans);
        return res;
    }
}
