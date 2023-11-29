import java.util.Map;

public abstract class Employee {
    Long pesel;
    String name;
    String secondName;
    char position;
    int payment;
    int number;


    public Employee(Long pesel, String name, String secondName, char position, int payment, int number) {
        this.pesel = pesel;
        this.name = name;
        this.secondName = secondName;
        this.position = position;
        this.payment = payment;
        this.number = number;
    }
}
