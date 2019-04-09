package Lambda;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class MethodReference {
    public static void main(String[] args) {
        Consumer <String> consumers=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("hello");
            }
        };
        Consumer<Integer> consumerInteger=integer -> System.out.println("222");
        useConsumer(consumers,"sss");
        useConsumer(System.out::println,"sss");

        List<Apple> list= Arrays.asList(new Apple("绿色",123),new Apple("黑色",145));
        list.sort((a1,a2)->a1.getColor().compareTo(a2.getColor()));
        list.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(list);
        list.stream().forEach(apple-> {if (list != null) {
            System.out.println("ss");
        } else {
            System.out.println("a");

        }});
    }

    public  static <T> void useConsumer(Consumer<T> consumer,T t){
        consumer.accept(t);
        consumer.accept(t);
    }
}
