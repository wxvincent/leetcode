package cn.itwx.leetcode131_140;

public class Leetcode134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || gas.length != cost.length) return -1;

        for (int i = 0; i < gas.length; i++) {
            if (canComp(gas, cost, i)) return i;
        }

        return -1;
    }

    private boolean canComp(int[] gas, int[] cost, int index) {
        int size = gas[index];

        for (int i = 0; i < gas.length; i++) {
            if (size < cost[index]) return false;
            if (index == gas.length - 1) {
                size = size - cost[index] + gas[0];
                index = 0;
            } else {
                size = size - cost[index] + gas[index + 1];
                index++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        Leetcode134 leetcode134 = new Leetcode134();
        int i = leetcode134.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

}
