package cn.itwx.leetcode121_130;

import java.util.*;

public class Leetcode127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int level = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordArray = word.toCharArray();
                for (char j = 'a'; j < 'z'; j++) {//将26个字母挨个试，用map存储他们变换的次数
                    if (wordArray[i] == j) continue;
                    wordArray[i] = j;
                    String newWord = new String(wordArray);

                    if (newWord.equals(endWord)) return level + 1;
                    if (set.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, level + 1);
                        queue.add(newWord);
                    }
                }
            }
        }

        return 0;
    }

}
