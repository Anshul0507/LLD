package LRUCache;

import java.util.HashMap;

public class LRUCache {

  public class Node{
    int key;
    int val;
    Node left;
    Node right;

    public Node(){}

    public Node(int key, int val){
      this.key=key;
      this.val=val;
    }
  }

  HashMap<Integer,Node> nodeMap;
  Node head, tail;
  int size;
  int capacity;

  public LRUCache(int capacity){
    nodeMap=new HashMap<>();
    this.capacity=capacity;
    this.head=new Node();
    this.tail=new Node();
    head.right=tail;
    tail.left=head;
  }

  private void addNodeNextToHead(Node node){
    Node headRight = head.right;
    head.right=node;
    headRight.left=node;
    node.right=headRight;
    node.left=head;
  }

  private void removeNode(Node node){
    Node leftNode = node.left;
    Node rightNode = node.right;
    leftNode.right=rightNode;
    rightNode.left=leftNode;
  }

  private void moveToFront(Node node){
    //remove from the current position
    removeNode(node);
    //Now move it next to head
    addNodeNextToHead(node);
  }

  private Node popLastNode(){
    Node node = tail.left;
    removeNode(node);
    return node;
  }

  public void put(int key, int val){
    Node node = nodeMap.get(key);
    if(node != null){
      //node is already present, so update its value
      node.val = val;
      moveToFront(node);
    }
    else{
      if(size<capacity){
        size++;
      }
      else{
        Node lastNode = popLastNode();
        nodeMap.remove(lastNode.key);
      }
      Node newNode = new Node(key,val);
      addNodeNextToHead(newNode);
      nodeMap.put(key,newNode);
    }
  }

  public int get(int key){
    Node node = nodeMap.get(key);
    if(node == null)
      return -1;
    moveToFront(node);
    return node.val;
  }

  public void displayCache(){
    Node node = head.right;
    System.out.print("{ ");
    while(node.right!=tail){
      System.out.print(node.key + " = " + node.val + ", ");
      node = node.right;
    }
    System.out.print(node.key + " = " + node.val + " ");
    System.out.println("}");
  }

}
