package Stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMatch {
    public static void main(String[] args) {
        Stream<Integer> streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        Boolean isflag= streamInteger.allMatch(integer -> integer>10);
        System.out.println(isflag);
        streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});

        streamInteger.anyMatch(integer -> integer<0);
        streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        streamInteger.noneMatch(integer -> integer>20);
        streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        streamInteger.reduce(Integer::max).ifPresent(System.out::println);
        streamInteger.reduce((i,j)->i<j?i:j).ifPresent(System.out::println);
    }
}
