package text;

public class Test {

    @org.junit.Test
    public void test(){
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(i+" * "+j +" = "+ i* j );
            }
            System.out.println();
        }

    }


}
