import java.util.Map;

public abstract class Employee {
    Long pesel;
    String name;
    String secondName;
    int payment;
    int number;


    public Employee(Long pesel, String name, String secondName, int payment, int number) {
        this.pesel = pesel;
        this.name = name;
        this.secondName = secondName;
        this.payment = payment;
        this.number = number;
    }

    public String toString() {
        return "\tPESEL : " + pesel +
                "\n\tName : " + name +
                "\n\tSecond name : " + secondName;
    }
}
