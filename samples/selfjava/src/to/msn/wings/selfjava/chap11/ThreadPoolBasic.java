package to.msn.wings.selfjava.chap11;

import java.util.concurrent.Executors;

public class ThreadPoolBasic {

  public static void main(String[] args) {
    try(var es = Executors.newFixedThreadPool(10)) {
      es.execute(new ThreadPool());
      es.execute(new ThreadPool());
      es.execute(new ThreadPool());
    }

    // var es = Executors.newFixedThreadPool(10);
    // try {
    //   es.execute(new ThreadPool()); 
    //   es.execute(new ThreadPool());
    //   es.execute(new ThreadPool()); 
    // } finally {
    //   es.shutdown();
    // }
  }
}
