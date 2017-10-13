/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Divya
 */
import java.util.Scanner

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        Scanner in=new Scanner(System.in);
		Room connect=new Room();
        System.out.println("1.Reservation\n2.Cancellation\n3.Allotment\n4.Exit");
        System.out.println("Enter yout choice");
        choice=in.nextInt();
        String choice1=in.nextLine();
        switch(choice){
            case 1:
                System.out.println(connect.Reservation());
                break;
            case 2:
                System.out.println(connect.Cancellation());
                break;
            case 3:
                System.out.println(connect.Allotment());
                break;
            case 4:
                System.out.println("Thank you");
                break;
            default:
                System.out.println("Please enter a valid choice");
                
        }
        
    }
}
