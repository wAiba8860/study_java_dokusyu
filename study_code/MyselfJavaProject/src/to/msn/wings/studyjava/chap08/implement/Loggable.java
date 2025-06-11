package to.msn.wings.studyjava.chap08.implement;

public interface Loggable {

    default void log(String msg) {
        System.out.println("Log: " + msg);
    }
}

class LoggableImpl implements Loggable {
    @Override
    public void log(String msg) {
        Loggable.super.log(msg);
        System.out.println("LogImpl: " + msg);
    }
}

class LoggableValue {
    public static void main(String[] args) {
        var l = new LoggableImpl();
        l.log("WINGS");
    }
}