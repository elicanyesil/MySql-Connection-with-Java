package a;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;


public class MySQL_Connection {
	private static Connection con = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	public static int Id ;
public ResultSet GetTable () {
	
	
	
	String url       = "jdbc:mysql://localhost:3306/javaschoolproject?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
	String user      = "root";
	String password  = "sucukcuk2";
	String sql = "SELECT * FROM javaschoolproject.info_table";	
	
	try {
		con = DriverManager.getConnection(url, user, password);
		
		 System.out.println(String.format("Connected to database %s "+ "successfully.", con.getCatalog()));
		 statement = con.createStatement();
		 resultSet = statement.executeQuery(sql);
		 return resultSet ;
		 
	}
	catch(Exception e){
		System.out.print(e);
		return null;
	}
	
	
}	

public void Add(int Id, String inputAd,String inputSoyad, String inputOrtalama, String inputYorum) throws SQLException{
	
	int NextId = Id +1;
	String query_insert = "insert into info_table Values( "+"\""+NextId+"\","+"\""+inputAd+"\","+"\""+inputSoyad+"\","+"\""+inputOrtalama+"\","+"\""+inputYorum+"\");";
	statement.executeUpdate(query_insert);
	return;
}
	public int Id () throws SQLException {
		String query_GetId = "SELECT MAX(Id) from info_table";
		resultSet = statement.executeQuery(query_GetId);
		while(resultSet.next()) {
			 Id = resultSet.getInt("MAX(Id)");}
		return Id;
		
	}
}
