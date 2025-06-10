
public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        //java.util.List<java.util.List<Integer>> pairs = new java.util.ArrayList<>(new java.util.ArrayList<>());

        /*java.util.List<Integer> tempList = new java.util.ArrayList<>();
        tempList.add(1);tempList.add(area);
        pairs.add(tempList);*/

        for (int i = 1; i <= area; i++) {
            if(area % i == 0) {
                //java.util.List<Integer> tempList = new java.util.ArrayList<>();
                int L = i;
                int B = area/i;
                if(L < B) {
                    continue;
                }
                int diff = L - B;
                result[0] = L;
                result[1] = B;
                /*tempList.add(L);
                tempList.add(B);
                pairs.add(tempList);*/
                break;

            }
        }

       /* tempList = new java.util.ArrayList<>();
        tempList.add(area);tempList.add(1);
        pairs.add(tempList);*/

        //System.out.println(java.util.Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        ConstructRectangle constructRectangle = new ConstructRectangle();
        int input = 21;
        int[] result = constructRectangle.constructRectangle(input);
        System.out.println(result);
    }


}
