import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Director extends Employee {
    int dutyAllowance;
    int costLimit;
    int cardNumber;

    public Director(Long pesel, String name, String secondName, char position, int payment, int number, int cardNumber, int dutyAllowance, int costLimit) {
        super(pesel, name, secondName, position, payment, number);
        this.dutyAllowance = dutyAllowance;
        this.costLimit = costLimit;
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "\tPESEL : " + pesel +
                "\n\tImię : " + name +
                "\n\tNazwisko : " + secondName +
                "\n\tStanowisko : Dyrektor" +
                "\n\tPayment (zł) : " + payment +
                "\n\tWork number : " + number +
                "\n\tDutyAllowance (zł) : " + dutyAllowance +
                "\n\tCard number : " + cardNumber +
                "\n\tCommission Limit (zł) : " + costLimit + "\n";
    }
}