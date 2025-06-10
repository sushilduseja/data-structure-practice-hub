import java.util.*;

class AlphabetSoup {
    public static String AlphabetSoup(String str) {

        // code goes here
    /* Note: In Java the return type of a function and the
       parameter types being passed are defined, so this return
       call must match the return type of the function.
       You are free to modify the return type. */
        List<Character> chars = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            chars.add(str.charAt(i));
        }

        Collections.sort(chars);

        /*Collections.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if (Character.isSpaceChar(o1) || Character.isSpaceChar(o2) || o1.equals(o2)) {
                    return 0;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });*/

        StringBuilder s = new StringBuilder();
        for (Character c : chars) s.append(c);
    /*char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if(Character.isSpaceChar(chars[i])) {
        continue;
      }
      s.append(chars[i]);
    }*/


        return s.toString();
    }

    public static void main(String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        String nextLine = String.valueOf(s.nextLine());
        System.out.print(AlphabetSoup(nextLine));
    }

}
