package completableFutureInAction;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CompleableFutureOne {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture=new CompletableFuture<String>();
        new Thread(()->{

                String v = get();
                completableFuture.whenComplete((s, throwable) -> {
                    Optional.ofNullable(s).ifPresent(System.out::println);
                    Optional.ofNullable(throwable).ifPresent(x->x.printStackTrace());
                });
                if(completableFuture.complete(v)){
                    System.out.println(v);
                }




        }).start();
        System.out.println("等你来打我啊");
    }

    public static  String get()  {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "傻逼";
    }

}
