package Lambda;

import java.util.Comparator;
import java.util.function.Supplier;

public class LambdaStart {
    public static void main(String[] args) {
        Comparator<Apple> comparator = new Comparator<Apple>() {

            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        Comparator<Apple> comparatorLambdaReturn=(o1, o2) -> {return o1.getColor().compareTo(o2.getColor());};
        Comparator<Apple> comparatorLambda=((o1, o2) -> o1.getColor().compareTo(o2.getColor()));
        System.out.println(comparatorLambda);
        Supplier<Apple> a = Apple ::new ;
    }
}
