import java.util.Map;
import java.util.Scanner;

public class Seller extends Employee {
    int commissionLimit;
    short commissionRate;

    public Seller(Long pesel, String name, String secondName, int payment, int number, int commissionLimit, short commissionRate) {
        super(pesel, name, secondName, payment, number);
        this.commissionLimit = commissionLimit;
        this.commissionRate = commissionRate;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tPosition : Seller" +
                "\n\tPayment (zł) : " + payment +
                "\n\tWork number : " + number +
                "\n\tCommission Rate (%) : " + commissionRate +
                "\n\tCommission Limit (zł) : " + commissionLimit + "\n";

    }
}
