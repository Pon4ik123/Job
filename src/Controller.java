import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipInputStream;

public class Controller implements Serializable{
    public static void show(Map<Long, Employee> employees) {
        if(employees.isEmpty()){
            return;
        }
        Scanner rm = new Scanner(System.in);
        System.out.println("1. List of employees:");
        ArrayList<Employee> list = new ArrayList<>(employees.values());
        int i = 0;
        while (i < list.size()) {
            System.out.println(list.get(i));
            System.out.println("[Enter] - Next page\n[Q] - Cancel");
            String s = rm.nextLine();
            if (s.toUpperCase().equals("Q")) {
                break;
            }
            i++;
        }
    }
    public static void add(Map<Long, Employee> employees, Scanner rm) {
        System.out.println("2. Add employee");
        System.out.print("[D]irector/[S]eller: ");
        String employeeType = rm.next();

        if (!"SsDd".contains(employeeType) && employeeType.length()==1) {
            System.out.println("Wrong choice.");
            return;
        }

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

        Employee employee;
        if (employeeType.equals("D")) {
            System.out.print("\tCard number:\t");
            int cardNumber = rm.nextInt();
            System.out.print("\tDutyAllowance (zł) :\t");
            int dutyAllowance = rm.nextInt();
            System.out.print("\tCommission Limit:\t ");
            int costLimit = rm.nextInt();

            employee = new Director(pesel, name, secondName, payment, number, cardNumber, dutyAllowance, costLimit);

        } else {
            System.out.print("\tCommission Limit (zł) :\t");
            int commissionLimit = rm.nextInt();
            System.out.print("\tCommission Rate (%) :\t");
            short commissionRate = rm.nextShort();

            employee = new Seller(pesel, name, secondName, payment, number, commissionLimit, commissionRate);
        }
        employees.put(employee.pesel, employee);

        System.out.println("------------------------------------------------------------------");
    }

    public static void remove(Map<Long, Employee> employees, Scanner rm) {
        System.out.print("Write employee's PESEL to delete: ");
        Long peselToRemove = rm.nextLong();
        if (employees.containsKey(peselToRemove)) {
            employees.remove(peselToRemove);
            System.out.println("Employee with PESEL " + peselToRemove + " is deleted.");
        } else {
            System.out.println("Unidentified PESEL.");
        }
    }

    public static void writeEmployeesToZip(Map<Long, Employee> employees, String fileName) {
        if (employees.isEmpty()) {
            System.out.println("No employees to write to the zip file.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            for (Map.Entry<Long, Employee> entry : employees.entrySet()) {
                Long pesel = entry.getKey();
                Employee employee = entry.getValue();

                // Create a new entry in the zip file for each employee
                ZipEntry entryInZip = new ZipEntry(pesel + ".txt");
                zos.putNextEntry(entryInZip);

                // Convert employee details to bytes and write to the zip file
                byte[] employeeBytes = employee.toString().getBytes();
                zos.write(employeeBytes, 0, employeeBytes.length);

                // Close the entry
                zos.closeEntry();
            }

            System.out.println("Employees written to the zip file: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readEmployeesFromZip(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                System.out.println("Employee details from " + entry.getName() + ":");

                // Read employee details from the zip file
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = zis.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }

                // Display employee details in the terminal
                System.out.println(baos.toString());

                // Close the entry
                zis.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
