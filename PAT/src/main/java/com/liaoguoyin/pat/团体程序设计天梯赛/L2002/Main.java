package com.liaoguoyin.pat.团体程序设计天梯赛.L2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = bufferedReader.readLine();
        int headAddress = Integer.parseInt(tmp.split(" ")[0]);
        int N = Integer.parseInt(tmp.split(" ")[1]);

        String[] strings = new String[N];
        Deque<Node> deque = new ArrayDeque<>();
        Deque<Node> repeatDeque = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            strings[i] = bufferedReader.readLine();
            if (Integer.parseInt(strings[i].split(" ")[0]) == headAddress) {
                int address = Integer.parseInt(strings[i].split(" ")[0]);
                int data = Integer.parseInt(strings[i].split(" ")[1]);
                int next = Integer.parseInt(strings[i].split(" ")[2]);
                deque.addLast(new Node(address, data, next));
                map.put(Math.abs(data), 1);
            }
        }

        while (deque.size() + repeatDeque.size() != N) {
            for (int i = 0; i < N; i++) {
                int address = Integer.parseInt(strings[i].split(" ")[0]);
                int data = Integer.parseInt(strings[i].split(" ")[1]);
                int next = Integer.parseInt(strings[i].split(" ")[2]);

                if (deque.getLast().next == address) {
                    deque.addLast(new Node(address, data, next));
                }
            }
        }


        for (int i = 0; i < deque.size(); ) {
            System.out.println(deque.poll().toString());
        }

        System.out.println("repeat");
        for (int i = 0; i < repeatDeque.size(); ) {
            System.out.println(repeatDeque.poll().toString());
        }
    }
}


class Node {
    int address;
    int data;
    int next;

    Node(int address, int data, int next) {
        this.address = address;
        this.data = data;
        this.next = next;
    }

    public String toString() {
        return String.format("%05d %d %05d", address, data, next);
    }

}

