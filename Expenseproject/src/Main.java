 import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ExpenseService service=new ExpenseService();

        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n1.add expenses");
            System.out.println("2. view Expences");
            System.out.println("3. Genrate Expences");
            System.out.println("4.date");


            System.out.println("Choose: ");
            int choose=sc.nextInt();

            switch (choose){
                case 1:
                    service.addexpence();
                    break;

                case 2:
                    service.viewexpence();
                    break;

                case 3:
                    service.generatereport();
                    break;

                case 4:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}