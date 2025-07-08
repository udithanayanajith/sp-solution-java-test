import java.util.ArrayList;
import java.util.List;

public class ProblemTwo {

    public static void main(String[] args) {
        List<String> list1 = List.of("a", "b", "c");
        List<String> list2 = List.of("1", "2", "3");
        List<String> result = new ArrayList<>();
        int maxSize;
        if(list1.size() < list2.size() || list1.size()==list2.size()){
            maxSize=list2.size();
        }else {maxSize=list1.size();}
        for (int i = 0; i < maxSize; i++) {
            result.add(list1.get(i));
            result.add(list2.get(i));
        }

        System.out.println(result);
    }
}
