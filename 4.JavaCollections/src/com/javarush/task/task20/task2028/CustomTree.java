package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    private int size;

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }
    Entry<String> root;
    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        int count = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (!currentEntry.availableToAddRightChildren && currentEntry.rightChild!=null) {
                count++;
                queue.add(currentEntry.rightChild);
            }
            if (!currentEntry.availableToAddLeftChildren && currentEntry.leftChild!=null) {
                count++;
                queue.add(currentEntry.leftChild);
            }
        }
        return count;
    }
    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void add(int index, String element) {

    }
    public boolean add(String s) {
        try {
            if (root == null) {
                root = new Entry<>(s);
                size++;
                return true;
            }
            List<Entry<String>> queue = new ArrayList<>();
            Entry<String> iter = root;
            if (!iter.isAvailableToAddChildren()) {
                queue.add(root);
            }
            while (!queue.isEmpty()) {
                Entry<String> temp = queue.get(0);
                if (temp.leftChild != null && temp.leftChild.isAvailableToAddChildren()) {
                    iter = temp.leftChild;
                    break;
                } else if (temp.rightChild != null && temp.rightChild.isAvailableToAddChildren()) {
                    iter = temp.rightChild;
                    break;
                }
                if (temp.leftChild != null)
                    queue.add(queue.size(), temp.leftChild);
                if (temp.rightChild != null)
                    queue.add(queue.size(), temp.rightChild);
                queue.remove(0);
            }
            if (iter.availableToAddLeftChildren) {
                iter.leftChild = new Entry<>(s);
                iter.leftChild.parent = iter;
                iter.checkChildren();
            } else {
                iter.rightChild = new Entry<>(s);
                iter.rightChild.parent = iter;
                iter.checkChildren();
            }
            size++;
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public String getParent(String s) {
        if (root == null) {
            return null;
        }
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        String parentName = null;
        while (parentName == null && !queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (currentEntry.leftChild != null ) {
                if (!currentEntry.leftChild.elementName.equals(s)) {
                    queue.add(currentEntry.leftChild);
                } else {
                    parentName = currentEntry.elementName;
                }
            }
            if (currentEntry.rightChild != null) {
                if (!currentEntry.rightChild.elementName.equals(s)) {
                    queue.add(currentEntry.rightChild);
                } else {
                    parentName = currentEntry.elementName;
                }
            }
        }
        return parentName;
    }
    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }
    @Override
    public boolean remove(Object o) {
        String s = (String) o;
        this.remove(s);
        return false;
    }
    public void remove(String s) {
        if (root == null) {
            return;
        }
        Queue<Entry<String>> queue = new ConcurrentLinkedQueue<>();
        queue.add(root);
        boolean isRemoved = false;
        while (!isRemoved && !queue.isEmpty()) {
            Entry<String> currentEntry = queue.remove();
            if (!currentEntry.leftChild.elementName.equals(s)) {
                queue.add(currentEntry.leftChild);
            } else {
                if (!isRemoved) {
                    currentEntry.leftChild = null;
                    isRemoved = true;
                }
            }
            if (!currentEntry.rightChild.elementName.equals(s)) {
                queue.add(currentEntry.rightChild);
            } else {
                if (!isRemoved) {
                    currentEntry.rightChild = null;
                    isRemoved = true;
                }
            }
        }
    }
    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }
    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 0; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }
    static class Entry<T> implements Serializable {
        String elementName;
        int lineNumber;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }
        void checkChildren() {
            if (leftChild != null) {
                availableToAddLeftChildren = false;
            }
            if (rightChild != null) {
                availableToAddRightChildren = false;
            }
        }
        boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }
}