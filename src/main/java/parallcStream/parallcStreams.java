package parallcStream;

import java.util.stream.LongStream;

public class parallcStreams {
    public static void main(String[] args) {
        parallcStreams2(100);
    }

    public  static void parallcStreams2(int limit){
        System.out.println(LongStream.rangeClosed(0,limit).sum()/2);
    }
}
