package com.leetcode;

class MaxQueue {
    private int[] values;
    private int[] max;
    private int head;
    private int tail;
    private int maxHead;
    private int maxTail;
    private int length;


    public MaxQueue() {
        values = new int[10000];
        max = new int[10000];
        head = 1;
        tail = 0;
        maxHead = 1;
        maxTail = 0;

    }
    
    public int max_value() {
        if (maxHead >= maxTail) {
            return -1;
        }
        return values[max[maxHead]];
    }
    
    public void push_back(int value) {
        values[++tail] = value;


        if (maxTail == 0) {
            max[1] = tail;
            maxTail = 1;
            maxHead = 1;
        }

       int temp = maxTail;

       while (maxHead <= temp && values[max[temp]] <= value) {
           temp--;
       }

        if (temp < maxTail) {
            maxTail = temp + 1;
        }
        max[maxTail++] = tail;
    }
    
    public int pop_front() {
        if (head > tail) {
            return -1;
        }
        length--;

        if (head == max[maxHead]) {
            maxHead ++;
        }

        return values[head++];
    }

    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();


        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        queue.push_back(46);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());


        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());




        queue.push_back(3);
        queue.push_back(1);
        queue.push_back(2);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
        System.out.println(queue.max_value());
    }
}