package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int arr[] = {0, 3, 3, 5, 7, 8, 8, 8};
        /*
        int arr[] = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = (int)(Math.random() * 10);
        }

         */
        Node node = createHuffmanTree(arr);
        preOrder(node);
    }

    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("该树为空！！！");
        }
    }

    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }

        while(nodes.size() > 1){
            Collections.sort(nodes);
            System.out.println(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value + rightNode.value);

            if(leftNode.value <= rightNode.value){
                parent.left = leftNode;
                parent.right = rightNode;
            }else{
                parent.left = rightNode;
                parent.right = leftNode;
            }


            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}

class Node implements Comparable<Node>{
    int value; //结点权值
    Node left;//左子节点
    Node right;//右子节点

    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if (this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }
}
