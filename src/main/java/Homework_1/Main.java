package Homework_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6,7,2,1,23,1,5,6,7,8,10,12));

        double result = list.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(i -> i.intValue()).average().getAsDouble();
        System.out.println(result);
    }
}
