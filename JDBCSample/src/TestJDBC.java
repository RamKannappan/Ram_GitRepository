import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
public class TestJDBC {
	//Create JDBC Connection

	public static Connection con =null;
	public static PreparedStatement ps = null;
	
	
	
	public static void createJDBC_Connector_For_MSSQL_Database()
	{
		try {
			//Load Driver Jar
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//connecting the URL
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TestDataBase;user=ram;password=Veer@ji7");
		
			System.out.println("JDB Connetcion is created!!");
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
	}
	
	//Insert [Create]
	public static void insert_Values_In_Table(String ename, int eage, float esalary) {
	try {
	ps = con.prepareStatement("insert into employee values(?,?,?)");
	ps.setString(1, ename);
	ps.setInt(2, eage);
	ps.setFloat(3, esalary);
	int x= ps.executeUpdate();
	if(x > 0) {
	System.out.println("Inserted.");
	}
	else {
		
		System.out.println("Not Inserted.");
	}
	
	
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		createJDBC_Connector_For_MSSQL_Database();
		insert_Values_In_Table("Ram", 32, 1234.56F);
		
		
	}
}
