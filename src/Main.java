import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Long, Object> employees = new HashMap<>();
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
                    show(employees);
                    break;
                case 2:
                    add(employees, rm);
                    break;
                case 3:
                    remove(employees, rm);
                    break;
                case 4:
                    break;
            }
        } while (choice != 5);
    }

    public static void show(Map<Long, Object> employees) {
        System.out.println("1. List of employees:");
        for (Map.Entry<Long, Object> entry : employees.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void add(Map<Long, Object> employees, Scanner rm) {
        System.out.println("2. Add employee");
        System.out.print("[D]irector/[S]eller: ");
        char employeeType = rm.next().charAt(0);

        System.out.println("------------------------------------------------------------------");
        System.out.print("\tPESEL:\t");
        Long pesel = rm.nextLong();
        System.out.print("\tName:\t");
        String name = rm.next();
        System.out.print("\tSecond name:\t");
        String secondName = rm.next();
        System.out.print("\tPayment(zl):\t");
        int payment = rm.nextInt();
        System.out.print("\tWork number:\t");
        int number = rm.nextInt();

        if (employeeType == 'D' || employeeType == 'd') {
            System.out.print("\tCard number:\t");
            int cardNumber = rm.nextInt();
            System.out.print("\tDutyAllowance (zł) :\t");
            int dutyAllowance = rm.nextInt();
            System.out.print("\tCommission Limit:\t ");
            int costLimit = rm.nextInt();

            Director director = new Director(pesel, name, secondName, 'D', payment, number, cardNumber, dutyAllowance, costLimit);
            employees.put(pesel, director);

        } else if (employeeType == 'S' || employeeType == 's') {
            System.out.print("\tCommission Limit (zł) :\t");
            int commissionLimit = rm.nextInt();
            System.out.print("\tCommission Rate (%) :\t");
            short commissionRate = rm.nextShort();

            Seller seller = new Seller(pesel, name, secondName, 'H', payment, number, commissionLimit, commissionRate);
            employees.put(pesel, seller);
        } else {
            System.out.println("Wrong choice.");
        }

        System.out.println("------------------------------------------------------------------");
    }

    public static void remove(Map<Long, Object> employees, Scanner rm) {
        System.out.print("Write employee's PESEL to delete: ");
        Long peselToRemove = rm.nextLong();
        if (employees.containsKey(peselToRemove)) {
            employees.remove(peselToRemove);
            System.out.println("Employee with PESEL " + peselToRemove + " is deleted.");
        } else {
            System.out.println("Unidentified PESEL.");
        }
    }
}