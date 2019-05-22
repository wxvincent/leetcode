package cn.itwx.leetcode131_140;

import cn.itwx.source.Node2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode133 {

    //深拷贝时，指向是双向的，用map记录已构造的结点即可，不然就是没完没了的递归了
    //简单思考一下：因为图是循环的，会回到起点不停循环，所以代码里只有递归的话，肯定是错的，
    //所以必须有个打破递归的地方
    HashMap<Integer, Node2> map = new HashMap<>();

    public Node2 cloneGraph(Node2 node) {
        if (node == null) return null;
        List<Node2> list = new ArrayList<>();
        //构造在前
        Node2 now = new Node2(node.val, new ArrayList<>());
        map.put(node.val, now);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node2 t = node.neighbors.get(i);
            if (map.containsKey(t.val)) {//打破递归的地方
                list.add(map.get(t.val));
            } else {
                Node2 tmp = cloneGraph(t);
                map.put(tmp.val, tmp);
                list.add(tmp);
            }
        }
        //再去修改
        now.neighbors = list;
        return now;
    }
}

