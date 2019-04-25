import java.util.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Produk {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/galeri_itera";
    static final String USER = "root";
    static final String PASS = "";
    
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
      
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int pilih;
        
        System.out.println("Silahkan pilih: ");
       
        pilih=input.nextInt();
        
        switch (pilih){
            case 1 : System.out.println("create");
                
                Scanner tambah = new Scanner(System.in);
        
                try {
                    String sql = "INSERT INTO Produk VALUES ('" + tambah.nextInt() + "','" + tambah.next()+  "','" + tambah.nextInt() + "')";
                    
                    Class.forName(JDBC_DRIVER);
            
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
                } catch (Exception e) {
                    
                }
                                  
            break;
          
            case 2 : System.out.println("read"); 
            
                try {
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    stmt = conn.createStatement();
            
                    String sql = "SELECT * FROM Produk";
            
                    rs = stmt.executeQuery(sql);
            
                    while(rs.next()){
                        System.out.println("ID Produk : " + rs.getInt("id_produk"));
                        System.out.println("Nama : " + rs.getString("nama_produk"));
                        System.out.println("Harga : " + rs.getInt("Harga") + "\n");
                    }
            
                    stmt.close();
                    conn.close();
                
                } catch (Exception e){
                    e.printStackTrace();
                }
            break;
        }           
    }
}
