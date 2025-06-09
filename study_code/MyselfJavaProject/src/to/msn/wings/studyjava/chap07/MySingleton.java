package to.msn.wings.studyjava.chap07;

public class MySingleton {

    private static MySingleton instance = new MySingleton();

    private MySingleton() {

    }

    public static MySingleton getInstance() {
        return instance;
    }
}