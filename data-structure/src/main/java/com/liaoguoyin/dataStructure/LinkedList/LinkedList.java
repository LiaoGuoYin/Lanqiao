package com.liaoguoyin.dataStructure.LinkedList;


/**
 * 链表LinkedList
 * 实现了：增加节点、删除节点、输出所有元素（同时删除）、test
 * 注意体会：链表的head和tail都是实实在在的节点（似乎是废话..）
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // test
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addHead("111");
        linkedList.addHead("000");
        linkedList.display();
        linkedList.addTail("222");
        linkedList.addTail("333");
        linkedList.addTail("444");
        linkedList.addTail("555");
        linkedList.deleteHead();
        linkedList.deleteTail();
        linkedList.display();
    }

    /**
     * 增加头节点
     *
     * @param object
     */
    public void addHead(Object object) {
        Node node = new Node(object);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
            size++;
        }
    }

    /**
     * 删除头节点
     */
    public void deleteHead() {
        if (size != 0) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    /**
     * 在尾节点添加元素
     *
     * @param object
     */
    public void addTail(Object object) {
        Node node = new Node(object);
        if (size == 0) {
            tail = node;
            head = node;
            size++;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }

    /**
     * 删除尾节点
     */
    public void deleteTail() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    /**
     * 输出所有元素（同时删除）
     */
    public void display() {
        Node node = head;
        while (size > 0) {
            if (size == 1) {
                System.out.println(node.data);
            } else {
                System.out.print(node.data + " -> ");
            }
            node = node.next;
            size--;
        }
    }


    /**
     * 双端链表
     */
    public class Node {
        private Node prev;
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
}
