package to.msn.wings.studyjava.chap09;

record SwitchPerson(String name) {
}

record SwitchStudent(String name) {
}

public class RecordSwitch {
    public static void main(String[] args) {
        Object obj = new SwitchStudent("山田太郎");

        // 変数objの型に応じて処理を分岐
        switch (obj) {
            case SwitchPerson(var name):
                System.out.println("Person: " + name);
                break;

            case SwitchStudent(var name):
                System.out.println("Student: " + name);
                break;

            // フォールスルーはエラー
            // case SwitchPerson(var name):
            // case SwitchStudent(var name):
            default:
                System.out.println("Unknown...");
                break;
        }
    }
}