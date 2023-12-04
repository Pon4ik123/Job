public abstract class Employee {
    Long pesel;
    String name;
    String secondName;
    int payment;
    int number;
    String position;


    public Employee(Long pesel, String name, String secondName, int payment, int number, String position) {
        this.pesel = pesel;
        this.name = name;
        this.secondName = secondName;
        this.payment = payment;
        this.number = number;
        this.position = position;
    }

    public String toString() {
        return "\tPESEL : " + pesel +
                "\n\tName : " + name +
                "\n\tSecond name : " + secondName +
                "\n\tPosition :" + position +
                "\n\tPayment (zł) : " + payment +
                "\n\tWork number : " + number;
    }
}
