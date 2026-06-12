package onlineshopping;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbonlineshopping {
    private static final String URL = "jdbc:mysql://localhost:3306/onlineshopping_new";
    private static final String USER = "root";  
    private static final String PASSWORD = ""; 

    public static Connection connect() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("connection  successful !  ");
            return conn;
        } 
        catch (SQLException e) {
            System.out.println(" connection falled: " + e.getMessage());
            return null;
        }
    }


public static void addCategory(String categoryName) {
    String sql = "INSERT INTO category (name) VALUES (?)";
    try (Connection conn = connect(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, categoryName);
        pstmt.executeUpdate();
        System.out.println("add was successful!");
    } 
    catch (SQLException e) {
        System.out.println(" wrong in add  : " + e.getMessage());
    }
}


public static void updateCustomerAddress(int customerId, String newAddress) {
    String sql = "UPDATE Customer SET address = ? WHERE customerID = ?";
    try (Connection conn = connect(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, newAddress);
        pstmt.setInt(2, customerId);
        pstmt.executeUpdate();
        System.out.println("address was edited successful!");
    }
    catch (SQLException e) {
    	System.out.println("error in update address : " + e.getMessage());
    }
    }




public static void deleteProduct(int productId) {
    String sql = "DELETE FROM product WHERE productid = ?";
    try (Connection conn = connect(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, productId);
        pstmt.executeUpdate();
        System.out.println("delete was successful!");
    } 
    catch (SQLException e) {
        System.out.println("error delete : " + e.getMessage());
    }
}
public static void addOrderItem(int orderId, int productId, int quantity, double price) {
    String sql = "INSERT INTO orderitem (orderid, productid, quantity, priceAtpurchase) VALUES (?, ?, ?, ?)";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, orderId);
        pstmt.setInt(2, productId);
        pstmt.setInt(3, quantity);
        pstmt.setDouble(4, price);
        pstmt.executeUpdate();
    } catch (SQLException e) { System.out.println(e.getMessage()); }
}
public static void searchProduct(String name) {
    String sql = "SELECT * FROM product WHERE productname LIKE ?";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, "%" + name + "%");
        var rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("productname: " + rs.getString("productname") + " price: " + rs.getDouble("Price"));
        }
    }
    catch (SQLException e) { System.out.println(e.getMessage()); }
}
public static void viewCustomerOrders(int customerId) {
    String sql = "SELECT * FROM orders WHERE customerid = ?";
    try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, customerId);
        var rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("orderid: " + rs.getInt("orderid") + " - status: " + rs.getString("status"));
        }
    } catch (SQLException e) { System.out.println(e.getMessage()); }
}
}





