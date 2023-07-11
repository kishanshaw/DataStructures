package com.demo;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SingleLinkedList {

    static final Logger logger = Logger.getLogger(SingleLinkedList.class.getName());
    
    Node head;

    class Node {
        int data;
        Node next;
    
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    
    void pushAtFront(int data) {
        Node newNode = new Node(data);
        if(Objects.isNull(head)) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    void pushAtEnd(int data) {
        Node newNode = new Node(data);
        Node temp = head;
    
        if (Objects.isNull(head)) {
            head = newNode;
        }
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    public void printList()
    {
        Node tnode = head;
        while (tnode != null)
        {
           logger.log(Level.INFO, "{0}", tnode.data);
            tnode = tnode.next;
        }
    }
    
    public void addAfterNode(int key, int data) {
        Node newNode = new Node(data) ;
        if(Objects.isNull(head)) {
            head = newNode;
        } else {
            Node temp = head;
            while (Objects.nonNull(temp) && temp.data != key) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    
    public void deleteNode(int key) {
        Node temp = head;
        if(Objects.isNull(head)) {
            logger.log(Level.INFO,"List is empty! So the element : {0} can not be deleted", key);
        }
        if (head!= null && head.data == key) {
            head = null;
        }
        else {
            while (temp!= null && Objects.nonNull(temp.next) && temp.next.data != key) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
    }
    
    public void reverseList() {
        Node nextNode = null;
        Node prevNode = null;
        Node curr = head;
        while(Objects.nonNull(curr)) {
            nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        head = prevNode;
        
    }

    public void reverseListV2() {
        Node prevNode = null;
        Node currNode = head;
        Node nextNode = null;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        if (prevNode != null) {
            head = prevNode;
        }
    }
    
    public static void main(String[] args) {
	   
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.pushAtFront(1);
        singleLinkedList.pushAtFront(7);
        singleLinkedList.pushAtFront(16);
        singleLinkedList.pushAtEnd(15);
        singleLinkedList.addAfterNode(1, 2);
        singleLinkedList.addAfterNode(15, 17);
        singleLinkedList.printList();
        logger.info("\n");
        singleLinkedList.reverseListV2();
        singleLinkedList.printList();
    }
}
