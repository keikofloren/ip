import java.util.Scanner;

public class Koko {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
                "Hello! I'm Koko\n"
                + "What can I do for you?\n"
        );
        String input = sc.nextLine();
        echo(input);
    }

    private static void echo(String input) {
        if (input.equals("bye")) {
            System.out.println("Bye. Hope to see you again soon!\n");
        } else {
            System.out.println(input);
            echo(sc.nextLine());
        }
    }
}
