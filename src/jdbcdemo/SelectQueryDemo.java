package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class SelectQueryDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// This is DB connection string
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dburl="jdbc:mysql://localhost:3306/animated_movies";
		String username="root";
		String password="root";
		
		Connection con = DriverManager.getConnection(dburl,username,password);
		
		System.out.println("successfull connected to database");
		// run a query on db
		String query="select * from movies";
		//send query to db
		Statement stmt=con.createStatement();
		//execute the query and fetch the o/p  and stored in a object type of result
		ResultSet rs =stmt.executeQuery(query);
		
		while(rs.next()){
			
			System.out.print("Title: " +rs.getString("title") + " \t ");
			System.out.print("genre: " +rs.getString("genre") + " \t ");
			System.out.print("director: "  +rs.getString("director") + " \t ");
			System.out.println("release_year: " +rs.getString("release_year") + " \t ");
		}
		//close the connection
		con.close();
		

	}

}
