package cn.zou.mianshi.bolizi;

public class Node {
    private Integer value;
    // You can add fields if you need
    private Node next;

    public Node(Integer v) {
        value = v;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
