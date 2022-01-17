/** 
	Lab 7 - Task 1 - Connecting to a Database Server
	Author: Mahmoud Mohamed Kamal
	Date:   16-01-2022
*/

import java.sql.*;
public class FirstDatabaseApp
{
	public FirstDatabaseApp(){}
	public static void main(String args[]) 
	{
		try
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/os42", "root", "mmk731998mmk731998mmkiti");
			//Statement stmt = con.createStatement() ;
			//String queryString = new String("select * from students");
			//ResultSet rs = stmt.executeQuery(queryString) ;
			/* Insert */
			System.out.println("Insert");
			Statement stmt1 = con.createStatement();
			String queryString = new String("insert into students(first_name, last_name, gender, birth_date) values ('Kamal', 'Mahmoud', 'male', '1998-6-5')");
			int output = stmt1.executeUpdate(queryString);
			
			PreparedStatement pst3 = con.prepareStatement("select * from students where gender = ? AND first_name = ?");
			pst3.setString(1, "male");
			pst3.setString(2, "Kamal");
			ResultSet rs3 = pst3.executeQuery() ;
			while(rs3.next())
			{
				System.out.println(rs3.getString(2));
			}
			
			/* Delete */
			System.out.println("");
			System.out.println("Delete");
			PreparedStatement pst4= con.prepareStatement("DELETE FROM students WHERE student_id = ?");
			pst4.setInt(1, 8);
			int output1 = pst4.executeUpdate() ;
			PreparedStatement pst5= con.prepareStatement("select * from students");
			ResultSet rs4 = pst5.executeQuery() ;
			while(rs4.next())
			{
				System.out.println(rs4.getString(1));
			}
			
			/* Update */
			System.out.println("");
			System.out.println("Update");
			PreparedStatement pst2= con.prepareStatement("UPDATE students SET birth_date = ? WHERE student_id = ?");
			pst2.setString(1, "1998-3-7");
			pst2.setInt(2, 6);
			int output2 = pst2.executeUpdate() ;
			PreparedStatement pst= con.prepareStatement("select * from students where gender = ? AND first_name = ?");
			pst.setString(1, "male");
			pst.setString(2, "Mahmoud");
			ResultSet rs = pst.executeQuery() ;
			while(rs.next())
			{
				System.out.println(rs.getString(7));
			}
			//rs.close();
			//stmt.close();
			//stmt1.close();
			con.close();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
}