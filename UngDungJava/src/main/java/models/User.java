package models;

import com.sun.istack.internal.NotNull;
/*
   create table tblUsers(
      id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
      name nvarchar(200),
      email nvarchar(500),
      password nvarchar(300),
      phoneNumber text,
      description text
   );

   insert into tblUsers(name, email, password, phoneNumber, description)
   values("LongNguyen", "duong.nguyen13600@gmail.com","ABC123","0946592586","Student"),
   ("ThuanNguyen", "duong.nguyen13700@gmail.com","asd123","0946592587","Student");
 */

public class User {
    @NotNull private Integer id;
    @NotNull private String name = "";
    @NotNull private String email = "";
    @NotNull private String password = "";
    private String phoneNumber;
    private String description;

    public static User logInUser;

    public User(Integer id, String name, String email, String password, String phoneNumber, String description) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
