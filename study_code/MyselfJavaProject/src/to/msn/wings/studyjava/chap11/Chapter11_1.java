package to.msn.wings.studyjava.chap11;

import java.io.InterruptedIOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Chapter11_1 {
    public static void main(String[] args) {
        futureAll();
    }

    public static void threadBasic() {
        // スレッドを生成
        var th1 = new MyThread();
        var th2 = new MyThread();
        var th3 = new MyThread();

        // スレッドを開始
        th1.start();
        th2.start();
        th3.start();
    }

    public static void runnableBasic() {
        // スレッドを生成
        var th1 = new Thread(new MyRunner());
        var th2 = new Thread(new MyRunner());
        var th3 = new Thread(new MyRunner());

        // スレッドを開始
        th1.start();
        th2.start();
        th3.start();
    }

    public static void anonymousThread() {
        // Thread派生クラス
        var th1 = new Thread() {
            @Override
            public void run() {
                for (var i = 0; i < 30; i++) {
                    System.out.println(this.getName() + ": " + i);
                }
            }
        };

        // Runnable実装クラス
        // var th2 = new Thread(new Runnable() {
        // @Override
        // public void run() {
        // for (var i = 0; i < 30; i++) {
        // System.out.println(Thread.currentThread().getName() + ": " + i);
        // }
        // }
        // });

        // ラムダ式
        var th2 = new Thread(() -> {
            for (var i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        });

        th1.start();
        th2.start();
    }

    public static void threadVirtual() {
        // 仮想スレッドを作成するファクトリーを準備
        var factory = Thread.ofVirtual().name("MyThread").factory();

        // スレッドを生成
        var th = factory.newThread(new MyRunner());

        // スレッドを開始＆待機
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void threadPoolBasic() {
        try (var es = Executors.newFixedThreadPool(10)) {
            es.execute(new ThreadPool());
            es.execute(new ThreadPool());
            es.execute(new ThreadPool());
        }
    }

    public static void threadSchedule() {
        // スレッドプールの準備
        try (var sche = Executors.newScheduledThreadPool(2)) {

            // スケジュール実行を登録
            sche.scheduleAtFixedRate(() -> {
                System.out.println(LocalDateTime.now());
            }, 0, 5, TimeUnit.SECONDS);

            // スケジュール実行を待ってメインスレッドを休止
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void threadVirtualEx() {
        try (var es = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10).forEach(i -> {
                es.execute(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println("Thread: " + i);
                });
            });
        }

        // ネイティブスレッド生成のためのファクトリーを準備
        var factory = Thread.ofPlatform().factory();

        try (var es = Executors.newThreadPerTaskExecutor(factory)) {
            IntStream.range(0, 10).forEach(i -> {
                es.execute(() -> {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println("Thread: " + i);
                });
            });
        }
    }

    public static void ThreadCallableBasic() {
        // スレッドを実行
        try (var exe = Executors.newSingleThreadExecutor()) {
            var r1 = exe.submit(new ThreadCallable());
            var r2 = exe.submit(new ThreadCallable());
            var r3 = exe.submit(new ThreadCallable());

            try {
                System.out.println("r1: " + r1.get());
                System.out.println("r2: " + r2.get());
                System.out.println("r3: " + r3.get());
            } catch (InterruptedException | ExecutionException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public static void futureBasic() {
        // 非同期処理を実行
        CompletableFuture.supplyAsync(() -> {
            var r = new Random();
            var num = r.nextInt(1000);
            heavy(num);
            return num;
        })
                // 完了後の処理
                .thenAcceptAsync(result -> {
                    System.out.println(result);
                });
        System.out.println("...任意の後処理...");
        heavy(7000);
    }

    // ダミーの重い処理（ここでは指定時間だけ処理を休止）
    public static void heavy(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void futureComplete() {
        // 非同期処理を実行
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            var r = new Random();
            var num = r.nextInt(1000);
            heavy(num);
            return num;
        });

        future.whenCompleteAsync((result, ex) -> {
            // 成功時
            if (ex == null) {
                System.out.println(result);
                // 失敗時
            } else {
                System.out.println(ex.getMessage());
            }
        });
        System.out.println("...任意の後処理...");

        // 非同期処理が完了するまでメインスレッドの処理を待機
        try {
            future.join();
        } catch (CompletionException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void futureSeq() {
        // 処理1（乱数の生成）
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            var r = new Random();
            var num = r.nextInt(5000);
            heavy(2000);
            System.out.printf("処理1: %d\n", num);
            return num;
        });

        // 処理2（乱数を倍に）
        CompletableFuture<Integer> future2 = future.thenApplyAsync(data -> {
            var result = data * 2;
            heavy(2000);
            System.out.printf("処理2: %d\n", result);
            return result;
        });

        // 処理3（乱数を更に倍に）
        CompletableFuture<Void> future3 = future2.thenAcceptAsync(data -> {
            var num = data * 2;
            heavy(2000);
            System.out.printf("処理3: %d\n", num);
        });

        // 非同期処理が完了するまでメインスレッドの処理を待機
        // future3のみでおｋ
        try {
            future3.join();
        } catch (CompletionException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    // 非同期で実行すべき処理（0～3000の乱数を生成＆出力）
    public static int myTask(String name) {
        var r = new Random();
        var num = r.nextInt(3000);
        heavy(num);
        System.out.println(name + ": " + num);
        return num;
    }

    public static void futureAll() {
        // 同時実行すべき処理をリスト化
        var list = List.of(CompletableFuture.supplyAsync(() -> {
            return myTask("First");
        }), CompletableFuture.supplyAsync(() -> {
            return myTask("Second");
        }), CompletableFuture.supplyAsync(() -> {
            return myTask("Third");
        }));


        // 複数の非同期処理を実行
        CompletableFuture<Void> futureThen =
                CompletableFuture.allOf(list.toArray(new CompletableFuture[list.size()]));
        // 全て完了したら
        futureThen.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("---------------------------");
                // 順に出力
                list.forEach(future -> {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                });
            } else {
                System.out.println(ex.getMessage());
            }
        });

        // 非同期処理が完了するまでメインスレッドの処理を待機
        try {
            futureThen.join();
        } catch (CompletionException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void futureAny() {
        // 同時実行すべき処理をリスト化
        var list = List.of(CompletableFuture.supplyAsync(() -> {
            return myTask("First");
        }), CompletableFuture.supplyAsync(() -> {
            return myTask("Second");
        }), CompletableFuture.supplyAsync(() -> {
            return myTask("Third");
        }));


        // 複数の非同期処理を実行
        CompletableFuture<Object> futureThen =
                CompletableFuture.anyOf(list.toArray(new CompletableFuture[list.size()]));

        futureThen.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("---------------------------");
                System.out.println(result);
                // 順に出力
                list.forEach(future -> {
                    try {
                        System.out.println(future.get());
                    } catch (InterruptedException | ExecutionException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                });
            } else {
                System.out.println(ex.getMessage());
            }
        });

        // 非同期処理が完了するまでメインスレッドの処理を待機
        try {
            futureThen.join();
        } catch (CompletionException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
