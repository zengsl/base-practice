package com.practice.datastruct.skiplist;

import lombok.Data;

/**
 * @author zengsl
 * @version V1.0
 * @date 2022/2/14 9:59 AM
 */
public class SkipListEntry<T> {

    public Integer key;
    public T data;

    public SkipListEntry<T> left;
    public SkipListEntry<T> right;
    public SkipListEntry<T> up;
    public SkipListEntry<T> down;

    public SkipListEntry(Integer key, T data) {
        this.key = key;
        this.data = data;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public SkipListEntry<T> getLeft() {
        return left;
    }

    public void setLeft(SkipListEntry<T> left) {
        this.left = left;
    }

    public SkipListEntry<T> getRight() {
        return right;
    }

    public void setRight(SkipListEntry<T> right) {
        this.right = right;
    }

    public SkipListEntry<T> getUp() {
        return up;
    }

    public void setUp(SkipListEntry<T> up) {
        this.up = up;
    }

    public SkipListEntry<T> getDown() {
        return down;
    }

    public void setDown(SkipListEntry<T> down) {
        this.down = down;
    }
}
