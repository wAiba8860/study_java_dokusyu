package mylib.lib;

public class MainLib extends Thread {
    private String name;
    private Integer age;

    public MainLib(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        System.out.println("MainLibRun!");
    }
}
