package com.atguigu.datastructure.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {

        System.out.println("双向链表的测试");
        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
        System.out.println("双向链表的添加");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.show();
        System.out.println("双向链表的修改");
        HeroNode2 newHeroNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.show();

        System.out.println("双向链表的删除");
        doubleLinkedList.del(1);
        doubleLinkedList.show();

    }
}


class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");

    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表
    public void show(){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode2 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
    //双向链表的添加
    public void add(HeroNode2 heroNode){
        HeroNode2 temp = head;

        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //修改一个节点的内容
    public void update(HeroNode2 newHeroNode){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode2 temp = head;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag =true;
                break;
            }
            temp = temp.next;

        }
        if (flag){
            temp.name=newHeroNode.name;
            temp.nickname=newHeroNode.nickname;
        }else {
            System.out.println("没有找到编号为"+newHeroNode.no+"的英雄，不能修改！！！");
        }
    }

    //从双向链表中删除一个节点
    public void del(int no){
        if(head.next == null){
            System.out.println("链表为空不能删除！！！");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.pre.next = temp.next;
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        }else{
            System.out.println("要删除编号为"+no+"的英雄不存在！！！");
        }
    }
}


class HeroNode2{

    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int hNo, String hName, String hNickname){
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", next=" + next +
                '}';
    }

}