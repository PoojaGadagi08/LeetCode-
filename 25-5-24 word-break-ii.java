class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        List<String>[] str = DP(s, wordDict, dp);
        if(!dp[n]) return Collections.emptyList();

        List<String> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtracking(result, builder, 0, str);
        return result;
    }

    private void backtracking(List<String> result, StringBuilder builder, int index, List<String>[] str) {

        if(index == str.length - 1) {
            result.add(builder.deleteCharAt(builder.length() - 1).toString());
            return;
        }
        List<String> list = str[index];
        for(String next : list) {
            int size = builder.length();
            builder.append(next);
            builder.append(" ");
            backtracking(result, builder, index + next.length(), str);
            builder.delete(size, builder.length());
        }

    }

    private List<String>[] DP(String s, List<String> wordDict, boolean[] dp) {

        List<String>[] str = new List[dp.length];
        for(int i = 0; i < dp.length - 1; i++) {
            if(dp[i]) {
                List<String> list = new LinkedList<>();
                for (String word: wordDict) {
                    if(s.indexOf(word, i) == i) {
                        dp[i + word.length()] = true;
                        list.add(word);
                    }
                }
                str[i] = list;
            }
        }
        return str;
    }
}
