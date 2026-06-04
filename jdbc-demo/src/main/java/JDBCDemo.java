import java.sql.*;

public class JDBCDemo {
    private static final String URL = "jdbc:mysql://localhost:3306/user";
    private static final String USER = "root";
    private static final String PASSWORD = "Saba@1234";

    static void main() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected Successfully!");
         //   insertStudent(conn, "Alice", "alice@gmail.com");
            updateStudent(conn,1,"Bob","alice@gmail.com");
            selectStudents(conn);
            deleteStudent(conn,1);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                System.out.println("Connection closed!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void insertStudent(Connection conn, String name, String email) {
        String sql = "insert into users(name,email) values('" + name + "','" + email + "')";
        try (Statement stmt = conn.createStatement()) {
            int rows = stmt.executeUpdate(sql);
            System.out.println("Inserted: " + rows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectStudents(Connection conn) throws SQLException {
        String sql = "Select * from users";
        try (Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(sql);
            System.out.println("Selected Students: ");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                System.out.println(id + " : " + name + " : " + email + " : ");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void updateStudent(Connection conn,int id,String name,String email) {
        String sql = "Update users set name='"+name+"',email='"+email+"' where id="+id;
        try(Statement stmt = conn.createStatement())
        {
            int rows = stmt.executeUpdate(sql);
            System.out.println("Updated: " + rows);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection conn,int id) {
        String sql ="Delete from users where id="+id;
        try(Statement stmt = conn.createStatement())
        {
            int rows = stmt.executeUpdate(sql);
            System.out.println("Deleted: " + rows);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

