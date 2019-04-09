package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamFilter {
    public static void main(String[] args) {

        List<Integer> result=Arrays.asList(1,2,3,4,5,6,7,8,9,9,9,7,7,8,8);

        result.stream().filter(n ->n%2==0).collect(toList());
        result.stream().distinct().collect(toList());
        result.stream().limit(5).collect(toList());
        result.stream().skip(6).collect(toList());


    }
}
