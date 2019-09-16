package com.atguigu.linkedlist;

/**
 * 单向的环形链表
 */
public class Josepfu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);
        circleSingleLinkedList.shouBoy();

        circleSingleLinkedList.countBoy(1,2,25);
    }
}

class CircleSingleLinkedList{
    //创建一个first节点，当前没有编号
    private  Boy first = new Boy(-1);

    public void addBoy(int nums){
        if(nums < 1){
            System.out.println("nums的值不正确！！！");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void shouBoy(){
        if(first == null){
            System.out.println("链表为空！！！");
            return;
        }
        Boy curBoy = first;
        while(true){
            System.out.println("小孩的编号"+curBoy.getNo());
            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    /**
     *
     * @param startNo 从哪一个小孩开始
     * @param countNum 数几下
     * @param nums 小孩的个数
     */
    //根据用户的输入，计算出小孩出圈的顺序
    public void countBoy(int startNo, int countNum, int nums){
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误！！！");
            return;
        }
        Boy helper = first;
        while(true){
            if (helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if(helper == first){
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.println("小孩"+first.getNo()+"出圈");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后圈中小孩的编号："+first.getNo());
    }

}


class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
