package com.liaoguoyin.pat.团体程序设计天梯赛.L2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static LinkedList linkedList = new LinkedList();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        int firstLocation = Integer.parseInt(line.split(" ")[0]);
        int capacity = Integer.parseInt(line.split(" ")[1]);

        System.out.println(firstLocation + " " + capacity);
        String[] allNodes = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            allNodes[i] = bufferedReader.readLine();
        }

        System.out.println(Arrays.toString(allNodes));
        while (count <= capacity) {
            addNode(allNodes, "-1");
        }

    }

    public static void addNode(String[] strings, String nextLocation) {

        for (int i = 0; i < strings.length; i++) {
            if (nextLocation.equals(strings[i].split(" ")[0])) {
                linkedList.addHead(strings[i].split(" ")[1]);
                nextLocation = strings[i].split(" ")[2];
                count++;
                addNode(strings, nextLocation);
            }
        }

    }
}

class LinkedList {
    private int location;
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        this.size = 0;
    }

    public void addTail(Object object) {
        Node node = new Node(object);
        if (size == 0) {
            tail = node;
            head = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
    }

    public void addHead(Object object) {
        Node node = new Node(object);
        if (size == 0) {
            tail = node;
            head = node;
            size++;
        } else {
            node.next = head;
            head = node;
            size++;
        }
    }

    class Node {
        private Node location;
        private Object data;
        private Node next;

        public Node(Object object) {
            this.data = object;
        }
    }


}


