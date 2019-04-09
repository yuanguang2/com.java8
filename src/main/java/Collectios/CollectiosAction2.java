package Collectios;

import Stream.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectiosAction2 {
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
        //CollectionsGroupbyConcurrent();
        //提取名称
        testJoining();
        //提取名称用分隔符分割
        testJoinings();
        //提取名称用分隔符分割加前缀
        testJoiningsAnd();
        //与joings()相同
        testMapping();
        //返回最大的
        testMaxBy();
        //返回最小的
        testMinBy();
    }

    private static  void CollectionsGroupbyConcurrent(){
        Optional.of(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType))).ifPresent(System.out::println);
    }

    private static  void CollectionsGroupbyConcurrentAll(){
        ConcurrentSkipListMap<Dish.Type, Double> collect = menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType,
                ConcurrentSkipListMap::new, Collectors.averagingDouble(Dish::getCalories)));

    }
    private static void testJoining(){
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining())).ifPresent(System.out::println);
    }
    private static void testJoinings(){
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(","))).ifPresent(System.out::println);
    }
    private static void testJoiningsAnd(){
        Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(",","Name[","]"))).ifPresent(System.out::println);
    }
    private static void testMapping(){
       Optional.of(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining("-")))).ifPresent(s -> System.out.println(s));

    }
    private static void testMaxBy(){
        menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }

    private static void testMinBy(){
        menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
    }
}
