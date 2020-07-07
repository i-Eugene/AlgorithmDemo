package com.ieugene.algorithmdemo;

import com.ieugene.algorithmdemo.LinkedListBaseOperation.NodeTW;

import java.util.HashMap;

public class LRUCache {
    private NodeTW head;
    private NodeTW end;
    //存储上限
    private final int limit;
    private final HashMap<String, NodeTW> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        hashMap = new HashMap<>();
    }

    public Integer get(String key) {
        NodeTW node = hashMap.get(key);
        if (node == null) return null;
        refreshNode(node);
        return node.data;
    }

    public void put(String key, int value) {
        NodeTW node = hashMap.get(key);
        if (node == null) {
            //key不存在，插入数据
            if (hashMap.size() >= limit) {
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new NodeTW(value);
            node.key = key;
            addNode(node);
            hashMap.put(key, node);
        } else {
            //key存在，刷新数据
            node.data = value;
            refreshNode(node);
        }
    }

    public void remove(String key) {
        NodeTW node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新被访问的节点
     *
     * @param node 被访问的节点
     */
    private void refreshNode(NodeTW node) {
        //尾节点不需要重排
        if (node == end) {
            return;
        }
        //先删除
        removeNode(node);
        //在重新添加
        addNode(node);
    }

    /**
     * 删除节点
     *
     * @param node 被删除的节点
     * @return 被删除的节点的key
     */
    private String removeNode(NodeTW node) {
        //只有一个节点
        if (node == head && node == end) {
            head = null;
            end = null;
        } else if (node == end) {
            end = end.prev;
            end.next = null;
        } else if (node == head) {
            head = head.next;
            head.prev = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        return node.key;
    }

    /**
     * 插入节点
     *
     * @param node 被插入的节点
     */
    private void addNode(NodeTW node) {
        if (end != null) {
            end.next = node;
            node.prev = end;
            node.next = null;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001", 1);
        lruCache.put("002", 1);
        lruCache.put("003", 1);
        lruCache.put("004", 1);
        lruCache.put("005", 1);
        lruCache.get("002");
        lruCache.put("004", 2);
        lruCache.put("006", 6);
        System.out.println(lruCache.get("001"));
        System.out.println(lruCache.get("006"));
    }
}
