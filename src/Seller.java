import java.util.Map;
import java.util.Scanner;

public class Seller extends Employee {
    int commissionLimit;
    short commissionRate;

    public Seller(Long pesel, String name, String secondName, char position, int payment, int number, int commissionLimit, short commissionRate) {
        super(pesel, name, secondName, position, payment, number);
        this.commissionLimit = commissionLimit;
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        return "\tPESEL : " + pesel +
                "\n\tName : " + name +
                "\n\tSecond name : " + secondName +
                "\n\tPosition : Handlowiec" +
                "\n\tPayment (zł) : " + payment +
                "\n\tWork number : - none -" +
                "\n\tCommission Rate (%) : " + commissionRate +
                "\n\tCommission Limit (zł) : " + commissionLimit + "\n";
    }
}
