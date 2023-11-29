public abstract class Employee {
    Long pesel;
    String name;
    String secondName;
    char position;
    int payment;
    int number;
    int cardNumber;

    void show() {
        System.out.println("1. List of employees");
        System.out.println("\tPESEL               :   " + pesel);
        System.out.println("\tName                :   " + name);
        System.out.println("\tSecond name         :   " + secondName);
        System.out.println("\tPosition            :   " + position);
        System.out.println("\tPayment(zl)         :   " + payment);
        System.out.println("\tWork number         :   " + number);
        System.out.println("\tDuty allowance(zl)  :   " + cardNumber);
    }
}
