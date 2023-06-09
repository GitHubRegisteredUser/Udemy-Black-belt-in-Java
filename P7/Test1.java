package P7;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        list.add("How are you");
        list.add("Fine");
        list.add("Bye");

//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);
        List<Integer> list2 = list.stream().map(element -> element.length()).
                collect(Collectors.toList());
//        System.out.println(list2);

        int[] array = {5, 9, 3, 4, 2};
        array = Arrays.stream(array).map(element ->
        {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
//        System.out.println(Arrays.toString(array));

        Set<String> set = new TreeSet<>();
        set.add("Hi");
        set.add("How are you");
        set.add("Fine");
        set.add("Bye");
        System.out.println(set);
        Set<Integer> set2 = set.stream().map((e -> e.length())).
                collect(Collectors.toSet());
        List<Integer> list3 = set.stream().map((e -> e.length())).
                collect(Collectors.toList());
        System.out.println(set2);
        System.out.println(list3);
    }

}
