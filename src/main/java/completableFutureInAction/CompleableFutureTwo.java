package completableFutureInAction;

import org.omg.CORBA.Object;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompleableFutureTwo {
    public static void main(String[] args) {
        //sace();
        sa();
       // CompletableFuture.supplyAsync(CompleableFutureOne::get).whenComplete(v,x)
    }
    public static  Double get() throws InterruptedException {
        Thread.sleep(1000L);

        return 1.2;
    }
    public  static void sace(){
       Optional.of( Stream.of("3","2","1")
               .collect(Collectors.
                       toMap(o ->o,o1 -> o1,(o1, o)->o1,Hashtable::new))).
               ifPresent(System.out::println);
        //System.out.println(map);
    }
    public static void sa(){
        Map<String,String> map = Stream.of("3","2","1").collect(Collectors.toMap(o->o,o->o,(o1, o)->o1,Hashtable::new));
        map.keySet().forEach(o-> System.out.println(o+":"+map.get(o)));

    }

}
