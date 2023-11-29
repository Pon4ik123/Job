import javax.swing.plaf.SliderUI;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Long, Object> obj= new HashMap<Long, Object>();
        Director director = new Director();
        Seller seller = new Seller();
        char pos;

        Scanner rm = new Scanner(System.in);
        short choice;
        do{
            System.out.println("MENU");
            System.out.println("\t1. List of employees");
            System.out.println("\t2. Add employee");
            System.out.println("\t3. Delete employee");
            System.out.println("\t4. Backups");
            System.out.println("\t5. Exit\n");
            System.out.print("Make your choice: ");
            choice = rm.nextShort();

            switch (choice){
                case 1:
                    for (Map.Entry<Long, Object> me: obj.entrySet()) {
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("2. Add employee");
                    System.out.print("\t[D]irector/[S]eller:\t");
                    pos = rm.next().toUpperCase().charAt(0);
                    System.out.println("\t-------------------------------------------");
                    if (pos == 'D'){
                        director.creatDirector();
                        obj.put(director.pesel, director);
                    }
                    else if (pos == 'S'){
                        seller.creatSeller();
                        obj.put(seller.pesel, seller);
                    }
                    else{
                        System.out.println("Incorrect choice, try again");
                    }
                    System.out.println("\t-------------------------------------------");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        } while(choice != 5);
    }
}