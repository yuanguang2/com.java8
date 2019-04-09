package Stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumbricStream {
    public static void main(String[] args) {
        Stream<Integer> streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        Integer count=  streamInteger.filter(integer -> integer>5).reduce(0,(i,j)->i+j);
       // System.out.println(count);
        streamInteger= Arrays.stream(new Integer[]{1,2,3,4,5,6,7,8,9,10});
        int countInt= streamInteger.mapToInt(Integer::intValue).filter(i->i%2==0).sum();
       // System.out.println(countInt);

        int a= 9;
        IntStream.rangeClosed(1,100).filter(b->Math.sqrt(a*a+b*b)%1==0).

                boxed().map(b->new int[]{a,b,(int)Math.sqrt(a*a+b*b)}).forEach(r-> System.out.println("a:"+r[0]+"\t"+"b:"+r[1]+"\t"+"c:"+r[2]));
    }
}
