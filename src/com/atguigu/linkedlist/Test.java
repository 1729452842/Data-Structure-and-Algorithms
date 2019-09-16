package com.atguigu.linkedlist;

public class Test {
    public static void main(String[] args) {
        HeroNode1 hero1 = new HeroNode1(1,"宋江","及时雨");
        HeroNode1 hero2 = new HeroNode1(3,"卢俊义","玉麒麟");
        HeroNode1 hero3 = new HeroNode1(5,"吴用","智多星");
        HeroNode1 hero4 = new HeroNode1(7,"林冲","豹子头");
        HeroNode1 hero5 = new HeroNode1(2,"宋江1","及时雨");
        HeroNode1 hero6 = new HeroNode1(4,"卢俊义1","玉麒麟");
        HeroNode1 hero7 = new HeroNode1(6,"吴用1","智多星");
        HeroNode1 hero8 = new HeroNode1(8,"林冲1","豹子头");

        SingLikedList1 singLikedList1 = new SingLikedList1();
        singLikedList1.addByOrder(hero1);
        singLikedList1.addByOrder(hero2);
        singLikedList1.addByOrder(hero3);
        singLikedList1.addByOrder(hero4);
        System.out.println("第一个链表：");
//        singLikedList1.show();
        SingLikedList1 singLikedList2 = new SingLikedList1();
        singLikedList2.addByOrder(hero5);
        singLikedList2.addByOrder(hero6);
        singLikedList2.addByOrder(hero7);
        singLikedList2.addByOrder(hero8);
        System.out.println("第二个链表：");
//        singLikedList2.show();

        HeroNode1 newHero = mergeTwoList2(singLikedList1.getHead().next,singLikedList2.getHead().next);
        System.out.println(newHero);
    }

    public static HeroNode1 mergeTwoList(HeroNode1 head1, HeroNode1 head2){
        if (head1 == null && head2 == null) {
            return null; }
        if (head1 == null) {
            return head2; }
        if (head2 == null) {
            return head1; }
        //合并后的链表
        HeroNode1 head = null;
        if (head1.no > head2.no) {
            //把head较小的结点给头结点
            head = head2;
            //继续递归head2
             head.next = mergeTwoList(head1,head2.next);
        } else {
            head = head1;
            head.next = mergeTwoList(head1.next, head2);
        }
        return head;
    }

    public static HeroNode1 mergeTwoList2(HeroNode1 head1, HeroNode1 head2) {
        if (head1 == null || head2 == null) {
            return head1 != null ? head1 : head2;
        }
        //合并后单链表头结点
        HeroNode1 head = head1.no < head2.no ? head1 : head2;

        HeroNode1 cur1 = head == head1 ? head1 : head2;
        HeroNode1 cur2 = head == head1 ? head2 : head1;

        HeroNode1 pre = null;//cur1前一个元素
        HeroNode1 next = null;//cur2的后一个元素

        while (cur1 != null && cur2 != null) {
            //第一次进来肯定走这里
            if (cur1.no <= cur2.no) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}

class HeroNode1{
    public int no;
    public String name;
    public String nickname;
    public HeroNode1 next;

    public HeroNode1(int hNo, String hName, String hNickname){
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

class SingLikedList1{
    private HeroNode1 head = new HeroNode1(0,"","");

    public HeroNode1 getHead() {
        return head;
    }

    public void add(HeroNode1 heroNode){
        HeroNode1 temp = head;

        while (true){
            if(temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode1 heroNode){
        HeroNode1 temp = head;
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
        HeroNode1 temp = head;
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
        HeroNode1 temp = head;
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
        HeroNode1 temp = head.next;
        while(true){
            if(temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
}
