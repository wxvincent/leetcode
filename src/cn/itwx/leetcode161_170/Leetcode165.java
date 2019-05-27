package cn.itwx.leetcode161_170;

public class Leetcode165 {

    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 || version2.length() == 0) return 0;

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int len = Math.min(split1.length, split2.length);

        for (int i = 0; i < len; i++) {
            int i1 = Integer.parseInt(split1[i]);
            int i2 = Integer.parseInt(split2[i]);
            if (i1 < i2) {
                return -1;
            } else if (i1 > i2) {
                return 1;
            }
        }

        if (split1.length == split2.length) return 0;
        if (split1.length > len) {
            for (int i = len; i < split1.length; i++) {
                int temp = Integer.parseInt(split1[i]);
                if (temp > 0) return 1;
            }
        } else {
            for (int i = len; i < split2.length; i++) {
                int temp = Integer.parseInt(split2[i]);
                if (temp > 0) return -1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Leetcode165 leetcode165 = new Leetcode165();
        int i = leetcode165.compareVersion("0.1", "1.1");
        System.out.println(i);
    }
}
