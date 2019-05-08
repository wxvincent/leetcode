package cn.itwx.leetcode61_70;

import java.util.ArrayList;
import java.util.List;

public class Leetcode68 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> reLi = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int j;
            int lineLength = 0;
            int wordRealLength = 0;
            for (j = i; j < words.length; j++) {
                if (lineLength + words[j].length() <= maxWidth) {
                    lineLength += words[j].length() + 1;
                    wordRealLength += words[j].length();
                } else
                    break;
            }
            StringBuffer temp = new StringBuffer();
            if (j - i > 1 && j < words.length) {
                int blankCount = (maxWidth - wordRealLength) % (j - i - 1);
                int blankLength = (maxWidth - wordRealLength) / (j - i - 1);
                for (int k = i; k < j; k++) {
                    int count1 = blankLength;
                    temp.append(words[k]);
                    while (k < j - 1 && count1-- > 0)
                        temp.append(" ");
                    temp.append(blankCount-- > 0 ? " " : "");
                }
            } else {
                int lastLength = 0;
                for (int k = i; k < j; k++) {
                    temp.append(words[k]);
                    lastLength += words[k].length();
                    if (lastLength < maxWidth) {
                        temp.append(" ");
                        lastLength += 1;
                    }
                }
                int count3 = maxWidth - lastLength;
                while (count3-- > 0)
                    temp.append(" ");
            }
            reLi.add(temp.toString());
            i = j;
        }
        return reLi;
    }
}
