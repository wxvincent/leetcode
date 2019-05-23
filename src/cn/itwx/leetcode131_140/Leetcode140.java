package cn.itwx.leetcode131_140;

import java.util.ArrayList;
import java.util.List;

public class Leetcode140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        if (wordBreak_check(s, wordDict)) {
            add(list, wordList, s, wordDict);
        }
        return list;
    }

    private void add(List<String> list, List<String> wordList, String s, List<String> wordDict) {
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                if (s.length() == str.length()) {
                    StringBuilder b = new StringBuilder();
                    for (String word : wordList) {
                        b.append(word).append(" ");
                    }
                    b.append(str);
                    list.add(b.toString());
                } else {
                    wordList.add(str);
                    add(list, wordList, s.substring(str.length()), wordDict);
                    wordList.remove(wordList.size() - 1);
                }
            }
        }
    }

    public boolean wordBreak_check(String s, List<String> wordDict) {
        int maxWordLength = 0;//字典中单词最长长度
        for (int i = 0; i < wordDict.size(); i++) {
            maxWordLength = Math.max(maxWordLength, wordDict.get(i).length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            int x = i - maxWordLength > 0 ? i - maxWordLength : 0;
            for (int j = x; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {//s存在以第j位为末尾的单词并且截取第j到i位的单词存在于字典中
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
