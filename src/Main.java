/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Monisha
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
        
          String room_type;
	 int room_number;
	 String room_status;
	 String reserved_by;
	 String reserved_on;
	 String guest_name;
	 String from_date;
	 String to_date;
	 String check_in;
	 String check_out;  
		Room connect=new Room();                            
        System.out.println("1.Reservation\n2.Cancellation\n3.Allotment\n4.Exit");
        System.out.println("Enter yout choice");
        choice=in.nextInt();
        String choice1=in.nextLine();
        
        switch(choice){
            case 1:               
                 System.out.println("Please enter the room type");
			room_type=in.nextLine();              
                 System.out.println(connect.Reservation(room_type));
                break;                           
            case 2:
                System.out.println("Please enter the name of the guest");
			guest_name=in.nextLine();
			System.out.println("Please enter the check in date");
			from_date=in.nextLine();
                System.out.println(connect.Cancellation(guest_name,from_date));
                break;
            case 3:
                
                  System.out.println("Please enter the reservation_id");
			reservation_id=in.nextLine();
			System.out.println("Please enter the check in time");
			check_in=in.nextLine();
			System.out.println("Please enter the number of persons");
			int no_of_persons=in.nextLine();
			System.out.println("Please enter the ID card number");
			String Id_number=in.nextLine();
			System.out.println("Please enter the contact number");
			String contact_number=in.nextLine();
			System.out.println("Please enter the address");
			String address=in.nextLine();
			System.out.println("Please enter the services availed (Breakfast Lunch Dinner)");
			String services=in.nextLine();
                        System.out.println(connect.Allotment( reservation_id,check_in,int no_of_persons,String Id_number,String contact_number,String address,String address,String services));
                break;
            case 4:
                System.out.println("Thank you");
                break;
            default:
                System.out.println("Please enter a valid choice");
                
        }
        
    }
}
