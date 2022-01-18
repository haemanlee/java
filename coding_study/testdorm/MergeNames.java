package hello.proxy.hyper.coding_study.testdorm;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeNames {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        String[] rtn = Stream.concat(Arrays.stream(names1),Arrays.stream(names2))
                .distinct()
                .toArray(String[]::new);
        return rtn;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};

        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}