package com.demo;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoublyLinkedList {
  static final Logger logger = Logger.getLogger(DoublyLinkedList.class.getName());

  Node head;

  class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
      this.data = data;
      prev = next = null;
    }
  }

  void pustAtFront(int data) {
    Node node = new Node(data);

    if (Objects.isNull(head)) {
      head = node;
    } else {
      node.next = head;
      head.prev = node;
      head = node;
    }

  }

  void pustAtEnd(int data) {
    Node node = new Node(data);

    if (Objects.isNull(head)) {
      head = node;
    } else {
      Node temp = head;
      while (Objects.nonNull(temp.next)) {
        temp = temp.next;
      }
      temp.next = node;
      node.prev = temp;
    }
  }

  void deleteNode(int key) {

    if (Objects.isNull(head)) {
      logger.info("List is empty!");
    }
    if (head.data == key) {
      head = head.next;
    } else {
      Node temp = head;
      Node prev = head;
      while (Objects.nonNull(temp) && temp.data != key) {
        prev = temp;
        temp = temp.next;
      }

      if (Objects.isNull(temp.next)) {
        prev.next = null;
      } else {
        prev.next = temp.next;
        temp.next.prev = prev;
      }

    }

  }

  void deleteNodeAfterPos(int pos) {
    if (Objects.isNull(head)) {
      logger.info("list is empty!");
    } else if (pos == 1) {
      head = head.next;
    } else {
      Node temp = head;
      Node prev = null;
      int index = 0;
      while (Objects.nonNull(temp.next) && index != pos) {
        prev = temp;
        temp = temp.next;
        index++;
      }
      prev.next = temp.next;
      temp.next.prev = prev;
    }
  }

  void deleteNodeAtPos(int pos) {
    if (Objects.isNull(head)) {
      logger.info("List is empty, deletion can not be performed!");
    } else if (pos == 1) {
      head = head.next;
    } else {
      Node temp = head;
      Node prev = null;
      int index = 1;
      while (Objects.nonNull(temp) && index != pos) {
        prev = temp;
        temp = temp.next;
        index++;
      }
      prev.next = temp.next;
      temp.next.prev = prev;
    }
  }

  void pushAfterNode(int data, int key) {
    Node node = new Node(data);
    if (Objects.isNull(head)) {
      head = node;
    }

    if (head.data == key) {
      node.next = head.next;
      if (Objects.nonNull(head.next)) {
        head.next.prev = node;
        node.prev = head;
        head.next = node;
      } else {
        node.prev = head;
      }
    }

    else {
      Node temp = head;

      while (Objects.nonNull(temp) && temp.data != key) {
        temp = temp.next;
      }

      if (Objects.nonNull(temp.next)) {
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        node.prev = temp;
      } else {
        node.next = null;
        node.prev = temp;
        temp.next = node;
      }
    }
  }

  public void printList() {
    Node tnode = head;
    while (tnode != null) {
      logger.log(Level.INFO, "{0}", tnode.data);
      tnode = tnode.next;
    }
    logger.fine("\n");
  }

  public void reverseList() {
    Node temp = null;
    Node currentNode = head;
    while (currentNode != null) {
      temp = currentNode.prev;
      currentNode.prev = currentNode.next;
      currentNode.next = temp;
      currentNode = currentNode.prev;
    }
    if (temp != null) {
      head = temp.prev;
    }
  }

  public void reverseListV2() {
    Node ptr1 = head;
    Node ptr2 = head.next;
    ptr1.next = null;
    ptr1.prev = ptr2;

    while (ptr2 != null) {
      ptr2.prev = ptr2.next;
      ptr2.next = ptr1;
      ptr1 = ptr2;
      ptr2 = ptr2.prev;
    }
    head = ptr1;
  }

  public static void main(String a[]) {
    DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
    doublyLinkedList.pustAtFront(1);
    doublyLinkedList.pustAtFront(2);
    doublyLinkedList.pustAtFront(3);
    doublyLinkedList.pustAtEnd(4);
    doublyLinkedList.pustAtEnd(5);
    doublyLinkedList.pustAtFront(0);
    doublyLinkedList.pushAfterNode(6, 2);
    doublyLinkedList.pushAfterNode(8, 6);
    doublyLinkedList.printList();
    doublyLinkedList.reverseListV2();
    doublyLinkedList.printList();
  }
}
