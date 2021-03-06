package org.pgr112.lesson5;

public class CallStackExample {
    public void run() {
        System.out.println("In run");
        System.out.println("Calling callStackExample");
        callStackExample();
        System.out.println("run done");
    }

    private void callStackExample() {
        System.out.println("In callStackExample");
        System.out.println("Calling helperMethod1");
        //helperMethod1();


        try {
            helperMethod1();
        }
        catch (NullPointerException npe){
            System.out.println("Fanger NullPointerException");
        }
        catch (ArithmeticException ae){
            System.out.println("Fanger ArithmeticException");
            System.out.println(ae.getMessage());
            //ae.printStackTrace();
        }
        finally{
            System.out.println("Finally final answer.");
        }

        System.out.println("callStackExample done");
    }

    private void helperMethod1() {
        System.out.println("In helperMethod1");
        System.out.println("Calling helperMethod2");
        helperMethod2();
        System.out.println("helperMethod1 done");
    }

    private void helperMethod2() {
        System.out.println("In helperMethod2");
        System.out.println("Calculating 1/0");

        String myObject = "Some string";

        //int answer = 1/0;
        //System.out.println("The answer is:"+answer);

        myObject = null;

        System.out.println("My object is" + myObject.toUpperCase());
        System.out.println("helperMethod2 done");
    }
}
