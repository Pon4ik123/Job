import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Director extends Employee {
    int dutyAllowance;
    int costLimit;
    int cardNumber;

    public Director(Long pesel, String name, String secondName, int payment, int number, int cardNumber, int dutyAllowance, int costLimit) {
        super(pesel, name, secondName, payment, number, "Director");
        this.dutyAllowance = dutyAllowance;
        this.costLimit = costLimit;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tDuty Allowance (zł) : " + dutyAllowance +
                "\n\tCard number : " + cardNumber +
                "\n\tCommission Limit (zł) : " + costLimit + "\n";
    }
}