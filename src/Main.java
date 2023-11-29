import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Map<Long, Employee> employees = new HashMap<>();
        Scanner rm = new Scanner(System.in);
        int choice;

        do {
            System.out.println("MENU");
            System.out.println("\t1. List of employees");
            System.out.println("\t2. Add employee");
            System.out.println("\t3. Delete employee");
            System.out.println("\t4. Backups");
            System.out.println("\t5. Exit\n");
            System.out.print("Make your choice: ");

            choice = rm.nextShort();

            switch (choice) {
                case 1:
                    Controller.show(employees);
                    break;
                case 2:
                    Controller.add(employees, rm);
                    break;
                case 3:
                    Controller.remove(employees, rm);
                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }
}