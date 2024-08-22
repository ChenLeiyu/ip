import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Froggy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        List<Task> tasks = new ArrayList<>();

        String greeting = "Hello! I'm Froggy!\n"
                + "Enter tasks and I will store it.\n"
                + "Type 'list' to view tasks or 'bye' to exit.\n"
                + "_______________________________";
        String exit = "Bye. Hope to see you again soon!\n"
                + "_______________________________";
        String line = "_______________________________";

        System.out.println(greeting);

        while (true) {
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                System.out.println(exit);
                break;
            } else if (input.equalsIgnoreCase("list")) {
                System.out.println("Task List:");
                for (int i = 1; i <= tasks.size(); i++) {
                    System.out.println(i + "." + tasks.get(i - 1).toString());
                }
                System.out.println("_______________________________");
            } else if (input.toLowerCase().startsWith("mark ")) {
                int index = Integer.parseInt(input.substring(5)) - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).setStatus(true);
                    System.out.println("Marked the following task as done:");
                    System.out.println(tasks.get(index).toString());
                    System.out.println(line);
                } else {
                    System.out.println("Invalid index");
                    System.out.println(line);
                }
            } else if (input.toLowerCase().startsWith("unmark ")) {
                int index = Integer.parseInt(input.substring(7)) - 1;
                if (index >= 0 && index < tasks.size()) {
                    tasks.get(index).setStatus(false);
                    System.out.println("Marked the following task as undone:");
                    System.out.println(tasks.get(index).toString());
                    System.out.println(line);
                } else {
                    System.out.println("Invalid index");
                    System.out.println(line);
                }
            }
            else {
                Task current = new Task(input);
                tasks.add(current);
                System.out.println("Added this task:");
                System.out.println(current.toString());
                System.out.println(line);
            }
        }

        scanner.close();
    }
}
