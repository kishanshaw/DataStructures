package com.demo;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class CrudInBinaryTree {
  
  static Node root;
  
  static class Node {
    
    int data;
    Node left;
    Node right;
    
    Node() {
      left = right = null;
    }
    
    Node(int key) {
      data = key;
      left=right=null;
    }
  }
  
  static void inorder(Node root) {
    
    if(Objects.isNull(root))
      return;
    
    else {
      inorder(root.left);
      System.out.print(root.data+ " " );
      inorder(root.right);
    }
  }
  
  static void insert(Node node, int key) {
    if(Objects.isNull(root)) {
      root = new Node(key);
      return;
    }
  
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    
    while(!queue.isEmpty()) {
      Node temp = queue.peek();
      queue.remove();
      
      if(Objects.isNull(temp.left)) {
        temp.left = new Node(key);
        break;
      }
      else {
        queue.add(temp.left);
      }
      if(Objects.isNull(temp.right)) {
        temp.right = new Node(key);
        break;
      }
      else {
        queue.add(temp.right);
      }
    }
    
  }
  
  public static void  main(String arr[]) {
    root = new Node(10);
    root.left = new Node(11);
    root.left.left = new Node(7);
    root.right = new Node(9);
    root.right.left = new Node(15);
    root.right.right = new Node(8);
  
    System.out.print( "Inorder traversal before insertion:");
    inorder(root);
  
    int key = 12;
    insert(root, key);
  
    System.out.print("\nInorder traversal after insertion:");
    inorder(root);
  
  }
}
