package com.atguigu.text.guaziershouche.text1;


public class Question3 {

    static void Permutation(int[] an,int start,int end)
    {
        if(start==end)
        {
            for(int i=0;i<=end;i++)
            {
                System.out.print(an[i]);
            }
            System.out.println("");
        }
        else
        {
            for(int cur=start;cur<=end;cur++)
            {
                int temp = an[cur];
                an[cur] = an[start];
                an[start] = temp;
                Permutation(an,start+1,end);
                temp = an[cur];
                an[cur] = an[start];
                an[start] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 3;
        int[] an = new int[3];
        for(int i = 0;i<n;i++)
        {
            an[i] = i+1;
        }
        Permutation(an,0,n-1);
    }
}