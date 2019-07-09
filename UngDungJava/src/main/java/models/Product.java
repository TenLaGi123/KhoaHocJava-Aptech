package models;

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
