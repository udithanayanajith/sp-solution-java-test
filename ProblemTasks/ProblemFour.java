import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemFour {
    public static String formLargestNumber(List<Integer> numbers) {
        List<String> asStrings = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        Comparator<String> comparator = (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        };

        Collections.sort(asStrings, comparator);

        if (asStrings.get(0).equals("0")) {
            return "0";
        }
        return String.join("", asStrings);
    }

    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(50, 2, 1, 9);
        String largestNumber = formLargestNumber(numList);
        System.out.println(largestNumber);
    }
}