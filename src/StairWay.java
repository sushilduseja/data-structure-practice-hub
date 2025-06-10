import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/**

 1 1 1 1
 1 2 - 2

 1 1 1 1 -1
 1 1 2 - 3
 2 2 -1
 */
class StairWay {


    public static int numberOfPossibleWays(int numberOfStepsOnStairs) {
        //TODO finish me

        if(numberOfStepsOnStairs == 1){
            return 1;
        }

        if(numberOfStepsOnStairs == 2){
            return 2;
        }

        int[] ways = new int[numberOfStepsOnStairs+1];

        ways[1] = 1;
        ways[2] = 2;

        for(int i = 3; i <= numberOfStepsOnStairs; i++){

            ways[i] = ways[i-2] + ways[i-1];
        }

        return ways[numberOfStepsOnStairs];


    }

    public static void check(int numberOfStepsOnStairs,int expectedAnswer) {
        if (numberOfPossibleWays(numberOfStepsOnStairs) == expectedAnswer) {
            System.out.println("ok for " + numberOfStepsOnStairs + " steps");
        }
        else {
            System.out.println("wrong for " + numberOfStepsOnStairs +" steps");
        }
    }

    public static void main(String[] args) {
        check(1,1);
        check(2,2);
        check(3,3);
        check(4,5);
        check(5,8);
        check(6,13);
        check(7,21);
    }
}
