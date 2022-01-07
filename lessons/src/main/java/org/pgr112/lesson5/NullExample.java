package org.pgr112.lesson5;

public class NullExample {
    public void trickyNull(){
        String s1 = giveMeAString(0);
        String s2 = giveMeAString(1);
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println("s1.length():"+s1.length());
        if(s2!=null){
            System.out.println("s2.length():"+s2.length());
        } else{
            System.out.println("s2 has no length as it is null!");
        }
    }

    private String giveMeAString(int i) {
        if(i==0){
            return "viskelær";
        }
        return null;
    }
}
