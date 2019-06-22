package cn.itwx.leetcode131_140;

import java.util.ArrayList;
import java.util.List;

public class Leetcode140 {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> list = new ArrayList<>();//最终装单词
        List<String> wordList = new ArrayList<>();//临时装单词
        if (wordBreak_check(s, wordDict)) {//判断一下，可能会出现不能匹配的情况
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
        int n = s.length();
        boolean[] word = new boolean[n + 1];
        word[0] = true;

        for (int i = 1; i <= n; i++) {
            //从0到i不断试，看看是否可以匹配
            for (int j = 0; j < i; j++) {
                if (word[j] && wordDict.contains(s.substring(j, i))) {
                    word[i] = true;
                    break;
                }
            }
        }

        return word[n];
    }
}
