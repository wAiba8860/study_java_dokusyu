package to.msn.wings.selfjava.chap11;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadSchedule {

  public static void main(String[] args) {
    try(var sche = Executors.newScheduledThreadPool(2)) {
      sche.scheduleAtFixedRate(() -> {
        System.out.println(LocalDateTime.now());
      }, 0, 5, TimeUnit.SECONDS);
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
}
