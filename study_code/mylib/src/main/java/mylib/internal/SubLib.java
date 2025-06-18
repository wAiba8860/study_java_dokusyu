package mylib.internal;

public class SubLib extends Thread {
    public static void main(String[] args) {
        System.out.println("exports用");
    }

    @Override
    public void run() {
        System.out.println("SubLibRun!");
    }
}
