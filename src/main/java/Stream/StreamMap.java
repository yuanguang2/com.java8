package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {

        List<Integer> result=Arrays.asList(1,2,3,4,5,6,7,8,9,9,9,7,7,8,8);

        result.stream().map(integer -> integer*2).collect(Collectors.toList());

        String[] strings={"hellow","yellow"};
      Stream<String[]> stringStream= Arrays.stream(strings).map(a ->a.split(""));
      Stream<String> stringStream1=  stringStream.flatMap(Arrays::stream);
        stringStream1.forEach(System.out::print);
    }
}
