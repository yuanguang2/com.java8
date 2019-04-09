package Collectios;

import Stream.Dish;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectiosAction {
    static final List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));


    public static void main(String[] args) {
        //求平均数
        //averagingDouble();
        //做完是之后还要干什么
        //collectingAndThen();
        //查询条数
        collectiongCount();
        //分组
        collectionGroupby();
        //分组并且返回每组的平均数
        collectionGroupbyFunctionAndCollector();
        collectionSummarizInt();
    }
    private  static  void averagingDouble(){

        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(a->a.getCalories()))).ifPresent(aDouble -> System.out.println(aDouble));
        Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(a->a.getCalories()))).ifPresent(System.out::println);

    }
    private static  void collectingAndThen(){
        //Optional.ofNullable(menu.stream().collect(Collectors.averagingDouble(a->a.getCalories()))).ifPresent(System.out::println);
        Optional.ofNullable(menu.stream().collect(Collectors.
                collectingAndThen(Collectors.averagingDouble(Dish::getCalories),a->"王八蛋啊"+a))).
                ifPresent(System.out::println);

     List <Dish> list=  menu.stream().filter(a->a.getType().equals(Dish.Type.MEAT)).collect(
                Collectors.collectingAndThen(Collectors.toList(),c->Collections.unmodifiableList(c)));
        //list.add( new Dish("salmon", false, 450, Dish.Type.FISH));
    }
    private static  void collectiongCount(){
        Optional.of(menu.stream().collect(Collectors.counting())).ifPresent(System.out::println);
    }
    private static  void collectionGroupby(){
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType))).ifPresent(System.out::println);
    }
    private static  void collectionGroupbyFunctionAndCollector(){
        Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.averagingDouble(Dish::getCalories)))).ifPresent(System.out::println);
    }
    private static  void collectionSummarizInt(){
        Optional.ofNullable(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories))).ifPresent(System.out::println);
    }
}
