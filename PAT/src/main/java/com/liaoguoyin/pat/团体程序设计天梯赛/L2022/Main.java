package com.liaoguoyin.pat.团体程序设计天梯赛.L2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * L2-022 重排链表 （25 分)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bufferedReader.readLine();

        int headAddress = Integer.parseInt(firstLine.split(" ")[0]);
        int N = Integer.parseInt(firstLine.split(" ")[1]);

        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = bufferedReader.readLine();
        }

        int address = 0;
        int data = 0;
        int next = 0;
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (strings[i].split(" ")[2].equals("-1")) {
                address = Integer.parseInt(strings[i].split(" ")[0]);
                data = Integer.parseInt(strings[i].split(" ")[1]);
                next = Integer.parseInt(strings[i].split(" ")[2]);
                deque.addLast(new Node(address, data, next));
            }
        }


        while (deque.getFirst().address != headAddress) {
            for (int i = 0; i < strings.length; i++) {
                if (deque.getFirst().address == Integer.parseInt(strings[i].split(" ")[2])) {
                    address = Integer.parseInt(strings[i].split(" ")[0]);
                    data = Integer.parseInt(strings[i].split(" ")[1]);
                    next = Integer.parseInt(strings[i].split(" ")[2]);
                    deque.addFirst(new Node(address, data, next));
                }
            }
        }

        Deque<Node> orderedDeque = new LinkedList<>();
        while (!deque.isEmpty()) {
            orderedDeque.addLast(deque.pollLast());
            orderedDeque.addLast(deque.pollFirst());
        }

        for (int i = 0; i < orderedDeque.size() - 1; i++) {
            ((LinkedList<Node>) orderedDeque).get(i).next = ((LinkedList<Node>) orderedDeque).get(i + 1).address;
            System.out.format("%05d %d %05d%n", ((LinkedList<Node>) orderedDeque).get(i).address, ((LinkedList<Node>) orderedDeque).get(i).data, ((LinkedList<Node>) orderedDeque).get(i).next);
        }
        ((LinkedList<Node>) orderedDeque).get(orderedDeque.size() - 1).next = -1;
        System.out.format("%05d %d %d%n", ((LinkedList<Node>) orderedDeque).get(orderedDeque.size() - 1).address, ((LinkedList<Node>) orderedDeque).get(orderedDeque.size() - 1).data, ((LinkedList<Node>) orderedDeque).get(orderedDeque.size() - 1).next);

    }
}


class Node {
    int address;
    int data;
    int next;

    public Node(int address, int data, int next) {
        this.address = address;
        this.data = data;
        this.next = next;
    }
}
