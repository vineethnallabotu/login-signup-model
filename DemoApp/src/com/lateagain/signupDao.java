package com.lateagain;

import java.sql.*;

public class signupDao
{
	String url= "jdbc:mysql://localhost:3306/febdata?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String user= "root";
	String password= "M0rh55f0!";
	String query1= "select * from student where username=?";
	String query= "insert into student values (?,?)";
	int counter=0;
	Connection con;
	public void insert(String suname, String spass) throws SQLException
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,password);
			PreparedStatement st1 = con.prepareStatement(query1);
			st1.setString(1, suname);
			ResultSet rs1=  st1.executeQuery();
			if(rs1.next())
			{
				counter=1;
			}
			else
			{
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, suname);
				st.setString(2, spass);
				st.executeUpdate();
				counter=0;
			}
				
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
		
		
}
}

