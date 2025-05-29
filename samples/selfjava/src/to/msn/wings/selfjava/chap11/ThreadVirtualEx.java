package to.msn.wings.selfjava.chap11;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadVirtualEx {
  public static void main(String[] args) {
    try(var es = Executors.newVirtualThreadPerTaskExecutor()){
      IntStream.range(0, 100000).forEach(i -> {
        es.execute(() ->{
          try {
            Thread.sleep(50000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("Thread: " + i);
        });
      });
    }    
    
    // var factory = Thread.ofPlatform().factory();
    // try(var es = Executors.newThreadPerTaskExecutor(factory)){
    //   IntStream.range(0, 100000).forEach(i -> {
    //     es.execute(() ->{
    //       try {
    //         Thread.sleep(50000);
    //       } catch (InterruptedException e) {
    //         e.printStackTrace();
    //       }
    //       System.out.println("Thread: " + i);
    //     });
    //   });
    // }
  }  
}
