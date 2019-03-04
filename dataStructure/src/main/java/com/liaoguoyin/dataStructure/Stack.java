package com.liaoguoyin.dataStructure;

import java.util.Arrays;

/**
 * 栈Stack
 * 方法有：构造方法、入栈、出栈、查看栈顶、动态扩容、基于动态数组的栈实现、基于链表的栈实现
 */
public class Stack {
    private Object[] objArray;
    private int maxSize;
    private int top;
    private Node nodeTop;
    private int size;

    public Stack(int maxSize) {
        if (maxSize > 0) {
            objArray = new Object[maxSize];
            this.maxSize = maxSize;
            top = -1;
        } else {
            throw new RuntimeException("栈容量不可能为负数:" + maxSize);
        }
    }

    // test
    public static void main(String[] args) {
        Stack stack = new Stack(1);
        stack.objPush("111");
        stack.objPush("test2");
        stack.objPush("test333");
        stack.objPush("44444444");
        System.out.println(stack.objPop());
        System.out.println(stack.peekTop());

        stack.nodePush("111");
        stack.nodePush("222");
        stack.nodePush("33333");
        System.out.println(stack.toString());
    }

    /**
     * 动态扩容
     */
    public void grow() {
        if (top == maxSize - 1) {
            maxSize = maxSize << 1;// 位运算，扩容位原来的2倍
            objArray = Arrays.copyOf(objArray, maxSize);
        }
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    public Object peekTop() {
        if (top > 0) {
            return objArray[top];
        } else {
            throw new RuntimeException("stack is null now");
        }
    }

    /**
     * 入栈
     *
     * @param value
     */
    public void objPush(Object value) {
        grow();// 入栈前看容量是否足够
        objArray[++top] = value;
    }

    /**
     * 出栈
     *
     * @return
     */
    public Object objPop() {
        Object object = peekTop();
        objArray[top--] = null;
        return object;
    }

    public void nodePush(Object obj) {
        // 栈顶指向新元素，新元素的next指向原栈顶元素
        nodeTop = new Node(obj, nodeTop);
        size++;
    }

    public Object nodePop() {
        Node old = nodeTop;
        old.next = null;
        nodeTop = nodeTop.next;
        size--;
        return old.data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Node<Object> node = nodeTop; node != null; node = node.next) {
            stringBuilder.append(node.data).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append("]");
        return stringBuilder.toString();
    }

    /*基于链表的栈实现*/
    private class Node<Object> {
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}
