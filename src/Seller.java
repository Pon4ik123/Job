import java.util.Scanner;

public class Seller extends Employee {
    int commissionLimit;
    short commissionRate;

    void creatSeller() {
        Scanner rm = new Scanner(System.in);

        Seller seller = new Seller();
        System.out.print("\tPESEL:\t ");
        seller.pesel = rm.nextLong();
        System.out.print("\tName:\t ");
        seller.name = rm.next();
        System.out.print("\tSecond name:\t ");
        seller.secondName = rm.next();
        System.out.print("\tPayment(zl):\t ");
        seller.payment = rm.nextInt();
        System.out.print("\tWork number:\t ");
        seller.number = rm.nextInt();
        System.out.print("\tCommission Rate:\t ");
        seller.commissionRate = rm.nextShort();
        System.out.print("\tCommission Limit:\t ");
        seller.commissionLimit = rm.nextInt();
    }

    @Override
    void show() {
        super.show();
        System.out.println("Commission Rate       :   " + commissionRate);
        System.out.println("Commission Limit      :   " + commissionLimit);
    }
}
