package cn.zou.mianshi.bolizi;

import java.util.HashMap;
import java.util.Map;

public class LinkListImpl implements LinkList {

    private Node first = null;
    private Map<Integer, Integer> map;

    public LinkListImpl(){
        map = new HashMap<>();
    }

    @Override
    public boolean isExists(Integer value) {
        return map.get(value) != null;
    }

    @Override
    public void add(Node node) {
        if (first == null) {
            first = node;
            map.put(node.getValue(), 1);
        } else {
            first.setNext(node);
            map.put(node.getValue(), map.get(node.getValue()) + 1);
        }
    }

}



