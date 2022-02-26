package com.practice.datastruct.skiplist;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 跳表
 *
 * @author zengsl
 * @version V1.0
 * @date 2022/2/14 10:02 AM
 */
@Slf4j
public class SkipList<T> {


    public int count;

    public int level;

    SkipListEntry<T> head;

    SkipListEntry<T> tail;

    public Random r;

    private double radio = 0.5D;


    public SkipList() {
        this.head = new SkipListEntry<>(Integer.MIN_VALUE, null);
        this.tail = new SkipListEntry<>(Integer.MAX_VALUE, null);
        this.head.right = this.tail;
        this.tail.left = this.head;
        this.count = 0;
        this.level = 0;
        this.r = new Random();
    }

    public SkipListEntry<T> findKey(int key) {

        SkipListEntry<T> node = getSmallerEntry(key);
        if (node.key == key) {
            return node;
        }
        return null;
    }

    private SkipListEntry<T> getSmallerEntry(int key) {
        SkipListEntry<T> node = head;
        while (node.key <= key) {
            if (node.right.key > key) {
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


    public void add(int key, T value) {
        SkipListEntry<T> startNode = getSmallerEntry(key);
        /*if (startNode.key == key) {
            startNode.data = value;
            return;
        }*/
        SkipListEntry<T> newNode = new SkipListEntry<>(key, value);
        newNode.left = startNode;
        newNode.right = startNode.right;
        startNode.right.left = newNode;
        startNode.right = newNode;
        log.info("链表新增key={}", key);

        if (newNode.key.equals(newNode.left.key)) {
            return;
        }

        int targetLevel = 1;
        boolean hasGrow = false;
        while (this.r.nextDouble() < radio) {

            if (targetLevel > level) {
                SkipListEntry<T> newHead = new SkipListEntry<>(Integer.MIN_VALUE, null);
                SkipListEntry<T> newTail = new SkipListEntry<>(Integer.MAX_VALUE, null);
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
                log.info("$链表新增索引层级 key={}，level={}", key, level);
            }
            while (startNode.up == null && startNode.left != null) {
                startNode = startNode.left;
            }
            if (startNode.up == null) {
                return;
            }
            startNode = startNode.up;
            SkipListEntry<T> newLevelNode = new SkipListEntry<>(key, null);
            newLevelNode.left = startNode;
            newLevelNode.right = startNode.right;
            startNode.right.left = newLevelNode;
            startNode.right = newLevelNode;
            newLevelNode.down = newNode;
            newNode.up = newLevelNode;
            newNode = newLevelNode;
            log.info("@链表新增索引层级元素 key={}，level={}", key, level);

            targetLevel++;
            if (hasGrow) {
                break;
            }
        }

        count++;
    }


    public boolean remove(int key) {
        SkipListEntry<T> startNode = getSmallerEntry(key);
        while (startNode.key != key && startNode.right != null) {
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

    public void print() {
        for (SkipListEntry<T> node = head; ; ) {
            for (SkipListEntry<T> tmpNode = node.right; ; ) {
                if (tmpNode == null) {
                    break;
                }
                if (tmpNode.right != null) {
                    System.out.print(tmpNode.key + " ");
                }
                tmpNode = tmpNode.right;
            }
            if (node.down == null) {
                break;
            }
            System.out.println("");
            node = node.down;
        }
        System.out.println("");
    }
}
