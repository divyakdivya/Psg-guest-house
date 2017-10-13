/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @autho Divya
 */
import java.sql.*;
import java.util.Scanner


public class Room {
	private Connection conn;
    private Statement stmt;
    private ResultSet result;
	
	private String room_type;
	private int room_number;
	private String room_status;
	private String reserved_by;
	private String reserved_on;
	private String guest_name;
	private String from_date;
	private String to_date;
	private String check_in;
	private String check_out;
	
	Scanner in=new Scanner(System.in);
	public Room(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
            stmt=conn.createStatement();
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
	
	public int Reservation(){
		try{
			int reservation_id=1000;
            System.out.println("Please enter the room type");
			room_type=in.nextInt();
			result=stmt.executeQuery("select room_number from room_details where room_type='"+room_type+"' and room_status='Available'");
            if(result.next()){
                System.out.println("Available rooms are:");
                System.out.println(result.getString("room_number"));
            }
            else
                System.out.println("There are no rooms available in room type "+room_type);
				return -1;
            while(result.next()){
                System.out.println(result.getString("room_number"));
            }
			System.out.println("Please select a room number");
			room_number=in.nextInt();
			System.out.println("Please enter the name of the requestor");
			reserved_by=in.nextLine();
			System.out.println("Please enter the name of the guest");
			guest_name=in.nextLine();
			System.out.println("Please enter the date");
			reserved_on=in.nextLine();
			System.out.println("Please enter the check in date");
			from_date=in.nextLine();
			System.out.println("Please enter the check out date");
			to_date=in.nextLine();
			System.out.println("Please enter the check in time");
			check_in=in.nextLine();
			System.out.println("Please enter the check out time");
			check_out=in.nextLine();
			result=stmt.executeQuery("select max(booking_id) from reservation_details");
                while(result.next()){
                    booking_id=result.getInt("max(reservation_id)");
                }
			result=stmt.executeQuery("insert into reservation_details VALUES ('"+reservation_id+"', '"+room_number+"', '"+reserved_by+"', '"+guest_name+"','"+reserved_on+"','"+from_date+"', '"+to_date+"', '"+check_in+"', '"+check_out+"')");
			result=stmt.executeQuery("update room_details set room_status="Reserved" where room_number='"+room_number+"'");
			return room_number;
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
	}
	
	public int Cancellation()
	{
		try{
			System.out.println("Please enter the name of the guest");
			guest_name=in.nextLine();
			System.out.println("Please enter the check in date");
			from_date=in.nextLine();
			result=stmt.executeQuery("select room_number from room_details where guest_name='"+guest_name+"' and from_date='"+from_date+"'");
			if(result.next()){
                room_number=result.getInt("room_number");
            }
            else
                System.out.println("There are no reservation available");
				return -1;
			result=stmt.executeQuery("delete from room_details where guest_name='"+guest_name+"' and from_date='"+from_date+"'");
			return room_number
		}
		catch(Exception ex){
            System.out.println(ex.getMessage());
        }
	}
	
	public int Allotment(){
		try{
			int reservation_id;
            System.out.println("Please enter the reservation_id");
			reservation_id=in.nextInt();
			System.out.println("Please enter the check in time");
			check_in=in.nextInt();
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
			result=stmt.executeQuery("update reservation_details set exact_check_in='"+check_in+"',no_of_persons='"+no_of_persons+"',ID_number='"+ID_number+"',contact_number='"+contact_number+"',address='"+address+"',services='"+services+"' where reservation_id='"+reservation_id+"'");
			return 0;
            
            
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
	}

}