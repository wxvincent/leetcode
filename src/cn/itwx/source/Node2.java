package cn.itwx.source;

import java.util.List;

public class Node2 {

    public int val;
    public List<Node2> neighbors;

    public Node2() {
    }

    public Node2(int _val, List<Node2> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
