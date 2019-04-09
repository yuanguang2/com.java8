package Stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamFind {
    public static void main(String[] args) {

        Stream<Integer> streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
       Optional<Integer> optionalInteger= streamInteger.filter(integer -> integer%2==0).findAny();
        optionalInteger.orElse(-1);
        streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        Optional<Integer> optionalInteger1=  streamInteger.filter(integer -> integer>3).findFirst();
        optionalInteger1.ifPresent(System.out::println);

        find(new Integer[]{1,2,3,4,5,6,7,8,9,10},1,a->a>2);

    }

    private static Integer find(Integer[] a, int defaults, Predicate<Integer> predicate){
    for (Integer integer:a){
        if(predicate.test(integer)){
            return defaults;
        }else{
            return 1;
        }
    }
    return 1;
    }
}
