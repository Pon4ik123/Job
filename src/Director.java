import java.util.Map;
import java.util.Scanner;

public class Director extends Employee {
    int dutyAllowance;
    int costLimit;

    void creatDirector(){
        Scanner rm = new Scanner(System.in);

        Director director = new Director();
        System.out.print("\tPESEL:\t ");
        director.pesel = rm.nextLong();
        System.out.print("\tName:\t ");
        director.name = rm.next();
        System.out.print("\tSecond name:\t ");
        director.secondName = rm.next();
        System.out.print("\tPayment(zl):\t ");
        director.payment = rm.nextInt();
        System.out.print("\tWork number:\t ");
        director.number = rm.nextInt();
        System.out.print("\tDuty allowance(zl):\t ");
        director.dutyAllowance = rm.nextInt();
        System.out.print("\tNumber of card:\t ");
        director.cardNumber = rm.nextInt();
        System.out.print("\tCost limit/month:\t ");
        director.costLimit = rm.nextInt();
    }

    @Override
    void show() {
        super.show();
        System.out.println("Duty allowance(zl)    :   " + dutyAllowance);
        System.out.println("Number of card        :   " + cardNumber);
        System.out.println("Cost limit/month      :   " + costLimit);
    }
}