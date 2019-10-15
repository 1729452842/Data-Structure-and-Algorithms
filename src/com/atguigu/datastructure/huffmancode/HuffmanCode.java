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
        //huffmancode.preOrder();
        Map<Byte, String> huffmanCodes1 = getCodes(huffmancode);
        System.out.println(huffmanCodes);

        byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
        System.out.println(Arrays.toString(huffmanCodeBytes));
    }

    /**
     *
     * @param bytes 原始字符串对应的byte[]
     * @param huffmanCodes  生成的赫夫曼编码map
     * @return  返回赫夫曼编码处理后的byte数组
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){

        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(huffmanCodes.get(b));
        }
        System.out.println(stringBuilder);
        int len;
        if(stringBuilder.length() % 8 == 0){
            len = stringBuilder.length() / 8;
        }else{
            len = stringBuilder.length() / 8 + 1;
        }

        byte [] huffmanCodeBytes = new byte [len];
        int index = 0;
        for (int i = 0; i < stringBuilder.length(); i+=8){
            String strByte;
            if(i + 8 > stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else{
                strByte = stringBuilder.substring(i, i+8);
            }

            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
            index++;
        }
        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String> ();

    static StringBuilder build = new StringBuilder();

    private static Map<Byte, String> getCodes(Node root){
        if(root == null){
            return null;
        }
        getCodes(root.left,"0",build);
        getCodes(root.right, "1", build);
        return huffmanCodes;
    }

    /**
     * 将传入的node节点的所有叶子节点的赫夫曼编码得到，并打入到hummanCodes集合中
     * @param node  传入的节点
     * @param code  路径：左子节点是0 右子节点1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(Node node, String code, StringBuilder stringBuilder){
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node != null){
            if(node.data == null){  //非叶子结点
                getCodes(node.left,"0",stringBuilder1);
                getCodes(node.right,"1",stringBuilder1);
            }else{
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }
    }

    //前序遍历
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
