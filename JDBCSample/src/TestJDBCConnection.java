import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class TestJDBCConnection {

    public static Connection con = null;
    public static PreparedStatement ps = null;

    //Create JDBC Connection Method
    public static void create_JDBC_Connection_For_MSSQL_Database() {
        try {
            //Load Driver [jar]
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //Load URL
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=TestDataBase;user=ram;password=Veer@ji7");
           
            
            System.out.println("Created JDBC Connection...");
        } catch (Exception e) {
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
            int x = ps.executeUpdate();
            if(x > 0) {
                System.out.println("Inserted 123.");
            }else {
                System.out.println("Not Inserted 123.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //try {
            //    con.close();
            //} catch (SQLException e) {
            //    e.printStackTrace();
           // }
        }
    }

    //Delete
    public static void delete_Row_In_Table(String ename) {
        try {
            String deleteQuery = "delete from employee where name ='"+ename+"'";
            System.out.println(deleteQuery);
            ps = con.prepareStatement(deleteQuery);
            int x = ps.executeUpdate();
            if(x > 0) {
                System.out.println("Deleted.");
            }else {
                System.out.println("Not Deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //try {
                //con.close();
           // } catch (SQLException e) {
            //    e.printStackTrace();
            //}
        }
    }

    //Update
    public static void update_Row_In_Table(String ename, int eage) {
        try {
            String updateQuery = "update employee set age="+eage+"where name='"+ename+"'";
            ps = con.prepareStatement(updateQuery);
            int x = ps.executeUpdate();
            if(x > 0) {
                System.out.println("Updated.");
            }else {
                System.out.println("Not Updated.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //try {
            //    con.close();
           // } catch (SQLException e) {
            //    e.printStackTrace();
           // }
        }
    }
 
    //Select
    public static void select_Rows_In_Table() {
        try {
            ps = con.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String employeeName = rs.getString(1);
                int employeeAge = rs.getInt(2);
                float employeeSalary = rs.getFloat(3);
                System.out.println(employeeName+ "  "+employeeAge+"  "+employeeSalary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //try {
            //    con.close();
           // } catch (SQLException e) {
            //    e.printStackTrace();
           // }
        }
    }

    public static void main(String[] args) {
        create_JDBC_Connection_For_MSSQL_Database();
        insert_Values_In_Table("Prabhu", 27, 34000.12F);
        delete_Row_In_Table("Raja");
        update_Row_In_Table("Sathya", 20);
        select_Rows_In_Table();
    }
}