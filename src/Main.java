import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Map<Long, Employee> employees = new HashMap<>();
        Scanner rm = new Scanner(System.in);
        short choice;

        do {
            System.out.println("MENU");
            System.out.println("\t1. List of employees");
            System.out.println("\t2. Add employee");
            System.out.println("\t3. Delete employee");
            System.out.println("\t4. Write to file");
            System.out.println("\t5. Read the file");
            System.out.println("\t6. Exit\n");
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
                    Controller.writeEmployeesToZip(employees, "1.gzip");
                    break;
                case 5:
                    Controller.readEmployeesFromZip("1.gzip");
                    break;
            }
        } while (choice != 6);
    }
}