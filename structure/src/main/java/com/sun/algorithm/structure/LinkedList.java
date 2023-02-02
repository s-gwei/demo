package com.sun.algorithm.structure;

/**
 * @Author sungw
 * @Date 2023/2/2 12:16
 * 手动实现linkedList
 **/
public class LinkedList<E> {
    private int size;

    private NodeTwo<E> first;

    private NodeTwo<E> last;

    public boolean add(E element) {
        addAtLast(element);
        return true;
    }

    private void addAtLast(E element) {
        NodeTwo<E> oldLast = last;
        NodeTwo newLast = new NodeTwo(element,null,oldLast);
        this.last = newLast;
        if(oldLast == null){
            this.first = newLast;
        }else {
            oldLast.next = newLast;
        }
        size++;
    }

    private int index(E element){
        int index = 0;
        NodeTwo<E> node = first;
        while(node != null){
            if(node != null){
                if(node.item.equals(element)) {
                    return index;
                }
            }else{
                if (node.item == null) {
                    return index;
                }
            }
            node = node.next;
            index++;
        }
        return -1;
    }

    private boolean remove(E element){
        NodeTwo<E> node = this.first;
        while(node != null){
            if(node.item.equals(element)){
                if(node.item.equals(first.item)){
                    this.first = first.next;
                }else{
                    node.prev = node.next;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

}
