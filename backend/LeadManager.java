import java.sql.*;
public class LeadManager {
    public void addLead(String name, String email, String status) {
        String query = "INSERT INTO leads (full_name, email_address, lead_status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, status);
            pstmt.executeUpdate();
            System.out.println("Lead added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewAllLeads() {
        String query = "SELECT * FROM leads";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("lead_id") +
                                   ", Name: " + rs.getString("full_name") +
                                   ", Status: " + rs.getString("lead_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
