package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInAction {
    public static void main(String[] args) {
        Trader guojin =new Trader("郭靖","桃花岛");
        Trader hongqigong=new Trader("洪七公","丐帮");
        Trader ouyangfeng=new Trader("欧阳锋","丐帮");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(guojin, 2011, 300),
                new Transaction(hongqigong, 2012, 1000),
                new Transaction(ouyangfeng, 2011, 400),
                new Transaction(guojin, 2012, 710),
                new Transaction(guojin, 2012, 700),
                new Transaction(ouyangfeng, 2012, 950)
        );
        List<Transaction> collect = transactions.stream().filter(transaction -> transaction.getYear() == 2011).
                sorted(Comparator.comparing(Transaction::getValue
                )).collect(Collectors.toList());
        System.out.println(collect);

        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
    }

}
