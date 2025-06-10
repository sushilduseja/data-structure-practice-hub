import java.util.*;

class TimeConvert {
    public static String TimeConvert(int num) {
        int hours = num/60;
        int mins = num - hours * 60;
        return hours+":"+mins;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int num = Integer.valueOf(line);
        System.out.print(TimeConvert(num));
    }

}


  