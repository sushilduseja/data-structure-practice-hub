import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> list1 = new LinkedHashSet<>(Arrays.asList(names1));
        Set<String> list2 = new LinkedHashSet<>(Arrays.asList(names2));
        list1.addAll(list2);
        Object[] objectArray = list1.toArray();
        List<Object> objects = Arrays.asList(objectArray);
        String[] array = objects.toArray(new String[0]);
        return array;

    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}