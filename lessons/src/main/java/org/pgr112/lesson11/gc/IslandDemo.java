package org.pgr112.lesson11.gc;

public class IslandDemo{
    IslandDemo i;
    public static void main(String[] args){
        IslandDemo my_ob_1 = new IslandDemo();
        System.out.println("Demo object one has been created");
        IslandDemo my_ob_2 = new IslandDemo();
        System.out.println("Demo object two has been created");

        my_ob_1.i = my_ob_2;
        my_ob_2.i = my_ob_1;
        // objects ob_1 and ob_2 still maintain references to each other.

        my_ob_1 = null;
        my_ob_2 = null;

        // At this point in the code, I can no longer refer to either object
        // even if they technically maintain references to each other.
        System.gc();
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("The finalize method has been called on the object");
    }
}
