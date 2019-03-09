package com.liaoguoyin.dataStructure.Queue;

/**
 * 单向队列Queue
 * 实现了：构造方法、入队、出队、顺序存储结构实现Queue、链式存储结构实现Queue
 * （队头队尾都是用一个变量来指向，队列元素本身的地址不发生改变）
 */
public class Queue {
    private Object[] objectQueue;
    private int size;
    private int top;
    private int bottom;
    private int item;
    private NodeQueue queueTop;
    private NodeQueue queueBottom;
    private int queueSize;


    // 顺序存储结构实现Queue
    public Queue(int size) {
        this.size = size;
        top = 0;
        bottom = -1;
        objectQueue = new Object[size];
    }

    public Queue() {
        queueBottom = null;
        queueTop = null;
        size = 0;
    }

    /**
     * 入队
     *
     * @param object
     */
    public void enQueue(Object object) {
        if (item == size) {
            throw new RuntimeException("Queue is full!!");
        }
        // 循环队列，首尾组合
        if (bottom == size - 1) {
            bottom = -1;
        }
        objectQueue[++item] = object;
        top++;
    }

    /**
     * 出队
     *
     * @return 返回下标为top的元素
     */
    public Object outQueue() {
        if (item == 0) {
            throw new RuntimeException("Queue is void");
        }
        Object obj = objectQueue[top];
        top++;

        if (top == size) {
            top = 0;
        }
        item--;
        return obj;
    }

    public void addNodeQueue(Object obj) {
        if (size == 0) {
            queueTop = new NodeQueue(obj, null);
            queueBottom = queueTop;
        } else {
            NodeQueue<Object> nodeQueue = new NodeQueue(obj, null);
            queueBottom.next = nodeQueue;
            queueBottom = nodeQueue;
        }
        size++;
    }

    public Object removeQueue() {
        if (size == 0) {
            throw new RuntimeException("Queue is null");
        }
        NodeQueue nodeQueue = queueTop;
        queueTop = queueTop.next;
        nodeQueue.next = null;

        size--;
        return nodeQueue.data;
    }

    // 链式存储结构实现Queue
    private class NodeQueue<Object> {
        private Object data;
        private NodeQueue next;

        public NodeQueue(Object data, NodeQueue next) {
            this.data = data;
            this.next = next;
        }
    }

}
