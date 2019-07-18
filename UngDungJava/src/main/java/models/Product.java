package models;
/*
create table tblProducts(
   productID VARCHAR(500) NOT NULL PRIMARY KEY ,
   productName VARCHAR(200) NOT NULL,
   year INT,
   description TEXT,
   price FLOAT NOT NULL
);
insert into tblProducts(productID,productName,year,description,price,userID)
values ("ID1245", "Iphone XS", 2018, "Good Condition", 1000.23,1),
("ID6789", "Acer Predator", 2017, "In Bad Condition", 1800.24,1),
("ID3675", "Macbook", 2019, "Good Condition", 3000.23,1),
("ID2370", "Gucci", 2017, "In Repairing Condition", 800.12,1),
("ID5698", "Samsung Galaxy", 2019, "In Bad Condition", 1000.23,1)

alter table tblProducts
add userID int;
* */
public class Product {

    private String productID;

    public String getProductID() {
        return productID;
    }

    private String productName;
    private Integer year;
    private String description;
    private Double price;

    public Product(String productID,String productName, Integer year, String description, Double price) {
        this.productID = productID;
        this.productName = productName;
        this.year = year;
        this.description = description;
        this.price = price;

    }

    public String getProductName() {
        return productName;
    }

    public Integer getYear() {
        return year;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
}
