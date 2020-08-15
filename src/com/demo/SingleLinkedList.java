package com.demo;

import java.util.Objects;

public class SingleLinkedList {
    
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
            System.out.print(tnode.data+" ");
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
            System.out.println("List is empty! So the element : "+ key+ " can not be deleted");
        }
        if (head.data == key) {
            head = null;
        }
        else {
            while (Objects.nonNull(temp.next) && temp.next.data != key) {
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
    
    public static void main(String[] args) {
	   
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.pushAtFront(1);
        singleLinkedList.pushAtFront(7);
        singleLinkedList.pushAtFront(16);
        singleLinkedList.pushAtEnd(15);
        singleLinkedList.addAfterNode(1, 2);
        singleLinkedList.addAfterNode(15, 17);
        singleLinkedList.printList();
        System.out.println("\n");
        singleLinkedList.reverseList();
        singleLinkedList.printList();
    }
}
