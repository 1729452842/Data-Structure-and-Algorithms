package com.atguigu.linkedlist;

import org.junit.Test;

import java.util.Stack;

/**
 * 此程序为含头单链表的增删改查
 */
public class SingLikedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        SingLikedList singLikedList = new SingLikedList();
        singLikedList.addByOrder(hero1);

        singLikedList.addByOrder(hero4);

        singLikedList.addByOrder(hero3);

        singLikedList.addByOrder(hero2);
//        singLikedList.show();
//        HeroNode newHeroNode = new HeroNode(2,"小卢","玉麒麟1");
//        singLikedList.update(newHeroNode);
//        System.out.println("------------");
//        singLikedList.show();
////        singLikedList.del(4);
////        singLikedList.del(1);
////        singLikedList.del(2);
////        singLikedList.del(3);
//        System.out.println("------------");
//        singLikedList.show();
//        System.out.println("节点个数："+getLength(singLikedList.getHead()));
//        System.out.println("------------");
//        HeroNode res = findLastNode(singLikedList.getHead(),2);
//        System.out.println(res);
//        System.out.println("------------");
        reversetList(singLikedList.getHead());
        singLikedList.show();
          reversePrint(singLikedList.getHead());

    }
    /**
     * 逆序打印单链表
     */
    public static void reversePrint(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }
        Stack<HeroNode> stack = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }
    }
    /**
     * 单链表的反转

    public static HeroNode reversalrNode(HeroNode head){
        SingLikedList singLikedList = new SingLikedList();
        HeroNode temp;
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        for (int i = 1; i <= 2; i++) {
            temp  = findLastNode(head,i);

            singLikedList.add(temp);
            System.out.println("第"+i+"次数据："+singLikedList.getHead());
        }
        return singLikedList.getHead();
    }
     */

    public static void reversetList(HeroNode head){
        if(head.next == null || head.next.next == null){
            return ;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        while(cur != null){
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        head.next = reverseHead.next;
    }
    /**
     * 查找链表中的倒数第K个节点
     */
    public static HeroNode findLastNode(HeroNode head, int index){
        if(head.next == null){
            return null;
        }
        int size = getLength(head);
        if(index <= 0 || index >size){
            return null;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 获取单链表的节点个数(如果是带头节点的链表，需要不统计头节点)
     */
    public static int getLength(HeroNode heroNode){
        if(heroNode.next == null){
            return 0;
        }
        int length = 0;
        HeroNode cur = heroNode.next;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        return length;
    }


    @Test
    public void test(){
        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(3,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(5,"吴用","智多星");
        HeroNode hero4 = new HeroNode(7,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(2,"宋江1","及时雨");
        HeroNode hero6 = new HeroNode(4,"卢俊义1","玉麒麟");
        HeroNode hero7 = new HeroNode(6,"吴用1","智多星");
        HeroNode hero8 = new HeroNode(8,"林冲1","豹子头");

        SingLikedList singLikedList1 = new SingLikedList();
        singLikedList1.addByOrder(hero1);
        singLikedList1.addByOrder(hero2);
        singLikedList1.addByOrder(hero3);
        singLikedList1.addByOrder(hero4);
        System.out.println("第一个链表：");
        singLikedList1.show();
        SingLikedList singLikedList2 = new SingLikedList();
        singLikedList2.addByOrder(hero5);
        singLikedList2.addByOrder(hero6);
        singLikedList2.addByOrder(hero7);
        singLikedList2.addByOrder(hero8);
        System.out.println("第二个链表：");
        singLikedList2.show();

        HeroNode newHero = new HeroNode(0,"","");
        HeroNode next1 = singLikedList1.getHead();//第一个链表
        HeroNode next2 = singLikedList2.getHead();//第二个链表
        newHero.next = singLikedList1.getHead().next;
        System.out.println(newHero);

        HeroNode cur = singLikedList2.getHead();

        while(cur != null){
            next1 = next1.next;
            next2 = next2.next;

            while(newHero.next != null){
                if(newHero.next.no > cur.next.no){
                    cur.next = newHero.next;
                    newHero.next = cur;
                    break;
                }
                newHero = next1;
            }
            cur = next2;
        }

    }
}

//单链表
class SingLikedList{
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode heroNode){
        HeroNode temp = head;

        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("准备插入的英雄的编号"+heroNode.no+"已经存在");
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void update(HeroNode newHeroNode){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode temp = head;
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

    public void del(int no){
        HeroNode temp = head;
        boolean flag = false;
        while(true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no == no){
               flag = true;
               break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else{
            System.out.println("要删除编号为"+no+"的英雄熊不存在！！！");
        }
    }

    public void show(){
        if(head.next == null){
            System.out.println("链表为空！！！");
            return;
        }
        HeroNode temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}



//英雄实体类
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int hNo, String hName, String hNickname){
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


