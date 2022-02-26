package com.practice.datastruct.skiplist2;

import java.util.Random;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/2/14 3:54 PM
 */
class Skiplist {

    public int count;

    public int level;

    SkipListEntry head;

    SkipListEntry tail;

    public Random r;

    private double radio = 0.5D;

    public Skiplist() {
        this.head = new SkipListEntry(Integer.MIN_VALUE);
        this.tail = new SkipListEntry(Integer.MAX_VALUE);
        this.head.right = this.tail;
        this.tail.left = this.head;
        this.count = 0;
        this.level = 0;
        this.r = new Random();
    }

    public boolean search(int target) {
        SkipListEntry node = getSmallerEntry(target);
        return node.data == target;
    }

    private SkipListEntry getSmallerEntry(int data) {
        SkipListEntry node = head;
        while (node.data <= data) {
            if (node.right.data > data) {
                if (node.down != null) {
                    node = node.down;
                } else {
                    return node;
                }
            } else {
                node = node.right;
            }
        }
        return node;
    }

    public void add(int num) {
        SkipListEntry startNode = getSmallerEntry(num);

        SkipListEntry newNode = new SkipListEntry(num);
        newNode.left = startNode;
        newNode.right = startNode.right;
        startNode.right.left = newNode;
        startNode.right = newNode;

        if (newNode.data == newNode.left.data) {
            return;
        }
        int targetLevel = 1;
        boolean hasGrow = false;
        while (this.r.nextDouble() < radio) {

            if (targetLevel > level) {
                SkipListEntry newHead = new SkipListEntry(Integer.MIN_VALUE);
                SkipListEntry newTail = new SkipListEntry(Integer.MAX_VALUE);
                newHead.right = newTail;
                newTail.left = newHead;
                newHead.down = this.head;
                this.head.up = newHead;
                newTail.down = this.tail;
                this.tail.up = newTail;
                this.head = newHead;
                this.tail = newTail;
                level++;
                hasGrow = true;
            }
            while (startNode.up == null && startNode.left != null) {
                startNode = startNode.left;
            }
            if (startNode.up == null) {
                return;
            }
            startNode = startNode.up;
            SkipListEntry newLevelNode = new SkipListEntry(num);
            newLevelNode.left = startNode;
            newLevelNode.right = startNode.right;
            startNode.right.left = newLevelNode;
            startNode.right = newLevelNode;
            newLevelNode.down = newNode;
            newNode.up = newLevelNode;
            newNode = newLevelNode;

            targetLevel++;
            if (hasGrow) {
                break;
            }
        }

        count++;
    }

    public boolean erase(int num) {
        SkipListEntry startNode = getSmallerEntry(num);
        while (startNode.data != num && startNode.right != null) {
            startNode = startNode.right;
        }
        if (startNode.right == null) {
            return false;
        }
        startNode.left.right = startNode.right;
        startNode.right.left = startNode.left;
        startNode.left = null;
        startNode.right = null;

        while (startNode.up != null) {
            startNode = startNode.up;
            startNode.left.right = startNode.right;
            startNode.right.left = startNode.left;
            startNode.left = null;
            startNode.right = null;
        }

        return true;
    }

    class SkipListEntry {

        public int data;

        public SkipListEntry left;
        public SkipListEntry right;
        public SkipListEntry up;
        public SkipListEntry down;

        public SkipListEntry(int data) {
            this.data = data;
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public SkipListEntry getLeft() {
            return left;
        }

        public void setLeft(SkipListEntry left) {
            this.left = left;
        }

        public SkipListEntry getRight() {
            return right;
        }

        public void setRight(SkipListEntry right) {
            this.right = right;
        }

        public SkipListEntry getUp() {
            return up;
        }

        public void setUp(SkipListEntry up) {
            this.up = up;
        }

        public SkipListEntry getDown() {
            return down;
        }

        public void setDown(SkipListEntry down) {
            this.down = down;
        }
    }
}

