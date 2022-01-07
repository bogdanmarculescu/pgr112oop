package org.pgr112.lesson4;

public class Trouble {
    public int sumNaturalNumbers(int n){
        int answer = helperMethod(n);
        return answer;
    }

    private int helperMethod(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
