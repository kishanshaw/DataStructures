package com.demo;


import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class CheckFullBinaryTree {
  
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
  
  
  public static boolean isFullBinaryTree(Node root) {
    if(Objects.isNull(root)) {
      return true;
    }
    
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    
    while(!queue.isEmpty()) {
      
      Node node = queue.peek();
      queue.remove();
      
      if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
        continue;
      }
      
      else if(Objects.isNull(node.left) || Objects.isNull(node.right)) {
        return false;
      }
      
      queue.add(node.left);
      queue.add(node.right);
      
    }
    return true;
  }
  public static void main(String arr[]) {
    Node root = new Node();
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    
    if(isFullBinaryTree(root)) {
      System.out.println("Yes");
    }
    else {
      System.out.println("No");
    }
  }
}
