package com.atguigu.datastructure.huffmancode;
import java.util.*;

public class HuffmanCode {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte [] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40

        List<Node> nodes = getNodes(contentBytes);
        System.out.println(nodes);

        System.out.println("赫夫曼树：");
        Node huffmancode = createHuffmanTree(nodes);
        huffmancode.preOrder();
        //前序遍历
    }

    private static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }else{
            System.out.println("赫夫曼树为空！！！");
        }
    }

    private static List <Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b, count + 1);
            }
        }
        //entrySet()：返回Map集合中的各个键值对映射关系的集合
        //System.out.println(counts.entrySet());
        //
        for(Map.Entry<Byte, Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes){

        while (nodes.size() > 1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;
            //移除旧的节点，添加新的节点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node>{
    Byte data;  //  字符
    int weight; //  权值
    Node left;
    Node right;

    public Node(Byte data, int weight){
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this);

        if(this.left != null){
            this.left.preOrder();
        }

        if(this.right != null){
            this.right.preOrder();
        }
    }
}
