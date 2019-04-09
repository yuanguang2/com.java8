package Stream;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class CreateStream {

    public static void main(String[] args) {

    }

    private Stream<String> getStream(){
       //return Arrays.asList("a","b","c").stream();
        return Stream.of("a","b","c");
    }

    private Stream<String> getStreamIo(){
       Path path= Paths.get("E:\\comjava8\\src\\main\\java\\Stream\\CreateStream.java");

       try(Stream<String> list= Files.lines(path)){
           list.forEach(System.out::print);
           return list;
       }catch (Exception e){
           throw  new RuntimeException(e);

       }

    }

    private Stream<Integer> getIterate(){
      return Stream.iterate(1,n ->n+2).limit(10);
    }
    private Stream<Double> getDobule(){

        return Stream.generate(Math::random);
    }

}
