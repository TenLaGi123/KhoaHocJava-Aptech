package models;

import java.sql.*;
import java.util.Properties;

public class Database {
    public static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/javatutorials";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String MAX_POOL = "250";
    private static Database instance;
    private Database() {
        connection = getConnection();
    }
    //singleton constructor
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Connection connection;
    public Connection getConnection(){
        try {
            Class.forName(DATABASE_DRIVER);
            Properties properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);

            connection = DriverManager.getConnection(DATABASE_URL,properties);
            return connection;
        }
        catch(Exception e){
            System.out.println("loi: " + e);
            return null;
        }

    }

        public User findUser(String email, String password) throws SQLException {
               Statement statement = this.getConnection().createStatement();
               String sql = "select * from tblUsers where email = '" + email + "' and password = '" + password+"'";
               ResultSet resultSet = statement.executeQuery(sql);
               while(resultSet.next()) {
                   Integer id = resultSet.getInt("id");
                   String name = resultSet.getString("name");
                   String emailBase = resultSet.getString("email");
                   String passwordBase = resultSet.getString("password");
                   String phoneNumber = resultSet.getString("phoneNumber");
                   String description = resultSet.getString("description");
                   return new User(id, name, emailBase, passwordBase, phoneNumber, description);
               }
               return null;
        }

        public void signUpUser(String name, String email, String password, String phoneNumber,String description) throws SQLException{
         String sql = "insert into tblUsers(name,email,password,phoneNumber,description) values (?,?,?,?,?)";
         PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setString(2,email);
         preparedStatement.setString(3,password);
         preparedStatement.setString(4,phoneNumber);
         preparedStatement.setString(5,description);
         preparedStatement.executeUpdate();
        }

    public void disconnect(){
        try {
            connection.close();
            connection = null;
        }
        catch(Exception e){
            System.out.println("error: " + e);
        }
    }
}
