package com.lateagain;

import java.sql.*;

public class loginDao
{
	String url= "jdbc:mysql://localhost:3306/febdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user= "root";
	String password= "M0rh55f0!";
	String query= "select * from student where username=? and password=?";
	public boolean check(String uname, String pass)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, uname);
			st.setString(2, pass);
			ResultSet rs= st.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		
		return false;
		
	}
}
