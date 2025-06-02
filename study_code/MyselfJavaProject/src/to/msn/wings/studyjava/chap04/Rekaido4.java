package to.msn.wings.studyjava.chap04;

public class Rekaido4 {
    public static void main(String[] args) {
        System.out.println("[1]:");
        // practice1
        for (var value : args) {
            var i = Integer.parseInt(value);
            System.out.println(i * 1.5);
        }

        System.out.println("[2]:");
        practice2();

        System.out.println("[3]:");
        practice3();

        System.out.println("[4]:");
        practice4();

        System.out.println("[5]:");
        practice5();
    }

    public static void practice2() {
        int i = 1;
        int sum = 0;

        while (i <= 100) {
            sum += i;
            if (sum > 1000) {
                break;
            }
            i++;
        }
        System.out.println("合計が1000を超えるのは、1～" + i + "を加算したときです");
    }

    public static void practice3() {
        var sum = 0;
        for (var i = 100; i <= 200; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.println("100~200までの奇数の合計値は" + sum + "です");
    }

    public static void practice4() {
        var language = "C#";

        System.out.println(switch (language) {
            case "Scala", "Kotlin", "Groovy" -> "JVM言語";
            case "C#", "Visual Basic", "F#" -> ".NET言語";
            default -> "不明";
        });
    }

    public static void practice5() {
        var language = "C#";

        if (language.equals("Scala") || language.equals("Kotlin") || language.equals("Groovy")) {
            System.out.println("JVM言語");
        } else if (language.equals("C#") || language.equals("Visual Basic") || language.equals("F#")) {
            System.out.println(".NET言語");
        } else {
            System.out.println("不明");
        }
    }
}