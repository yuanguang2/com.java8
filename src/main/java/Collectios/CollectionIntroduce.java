package Collectios;

import Lambda.Apple;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

public class CollectionIntroduce {
    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(new Apple("green", 150), new Apple("yellow", 120), new Apple("green", 170));
       //Optional.ofNullable(getall(list)).ifPresent(stringListMap -> System.out.println(stringListMap));
        System.out.println("--------------------------");
       // System.out.println(getGroupColor(list));
        System.out.println("--------------------------");

        System.out.println (getGroupColorall(list));
    }
    private  static Map<String,List<Apple>> getall(List<Apple> appleList){
         Map<String,List<Apple>> map=new HashMap<>();
          for (Apple apple:appleList){
           List<Apple> list=  map.get(apple.getColor());
           if(list==null){
               list=new ArrayList<>();
               map.put(apple.getColor(),list);

           }
           list.add(apple);
          }
          return map;
    }
    private static  Map<String,List<Apple>> getGroupColor(List<Apple> appleList){
        Map<String,List<Apple>> map=new HashMap<>();
        appleList.stream().forEach(apple -> {
        List<Apple> applesList=  Optional.ofNullable(map.get(apple.getColor())).orElseGet(()->{
                List<Apple>lists=new ArrayList<>();
                map.put(apple.getColor(),lists);
                return lists;
            });
            applesList.add(apple);
        });
        return map;
    }

    private static  Map<String,List<Apple>> getGroupColorall(List<Apple> appleList){
       // return appleList.stream().collect(Collectors.groupingBy(a->a.getColor()));
        return appleList.stream().collect(groupingBy(Apple::getColor));

    }
}
