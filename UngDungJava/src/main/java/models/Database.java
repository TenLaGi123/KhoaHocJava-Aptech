package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Properties;
/*
ALTER TABLE tblUsers
ADD COLUMN isDisabled int AFTER name;
update tblUsers set isDisabled = 1 where email = "duong.nguyen13600@gmail.com";
* */
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
                   Integer isDisabled = resultSet.getInt("isDisabled");
                   if(isDisabled == 1) {
                       throw new SQLException("Lisence expired");
                   }
                   return new User(id, name, emailBase, passwordBase, phoneNumber, description);
               }
            throw new SQLException("Wrong user or password");
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

    public boolean checkUserStatus(String email){
        try {
            Statement statement = this.getConnection().createStatement();
            String sql = "select * from tblUsers where email = '" + email + "' and isDisabled = 0";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                return true;
            }
            return false;
        }
        catch(Exception e){
            return false;
        }
    }

    public ObservableList<Product> getAllProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        try {
            Statement statement = this.getConnection().createStatement();
            String sql = "select * from tblProducts";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String productID = resultSet.getString("productID");
                String productName = resultSet.getString("productName");
                Integer year = resultSet.getInt("year");
                String description = resultSet.getString("description");
                Double price = resultSet.getDouble("price");
                Product product = new Product(productID,productName,year,description,price);
                products.add(product);
            }
            return products;
        }
        catch(Exception e){
            return products;
        }
    }
}
