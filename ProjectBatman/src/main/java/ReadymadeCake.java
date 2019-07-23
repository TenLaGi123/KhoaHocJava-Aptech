public class ReadymadeCake extends Cake {

     static String name;
     static double rate;
     private Integer quantity;

     ReadymadeCake(){
         super(name,rate);
     }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        ReadymadeCake.name = name;
    }

    public static double getRate() {
        return rate;
    }

    public static void setRate(double rate) {
        ReadymadeCake.rate = rate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calcPrice() {
         return rate*quantity;
    }
}
