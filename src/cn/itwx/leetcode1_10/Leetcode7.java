package cn.itwx.leetcode1_10;

public class Leetcode7 {

    public static int reverse(int x) {
        if(x==0) return 0;
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while (left<right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;

        }

        StringBuilder sb = new StringBuilder();
        if (x<0){
            sb.append(String.valueOf(chars));
            sb.deleteCharAt(sb.length()-1);
            int index = 0;
            while (sb.charAt(index)=='0'){
                index++;
            }
            sb.substring(index,sb.length());
            sb.insert(0,'-');
        }else {
            sb.append(String.valueOf(chars));
            int index = 0;
            while (sb.charAt(index)=='0'){
                index++;
            }
            sb.substring(index,sb.length());
        }

        long num = Long.valueOf(sb.toString());
        if (num<Integer.MIN_VALUE || num>Integer.MAX_VALUE) return 0;
        return (int) num;

    }

    public static void main(String[] args) {
        int reverse = reverse(-789);
        System.out.println(reverse);
    }
}
