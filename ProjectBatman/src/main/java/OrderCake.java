public class OrderCake extends Cake {
    static String name;
    static Double rate;

    private Double weight;

    OrderCake(){
        super(name,rate);
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        OrderCake.name = name;
    }

    public static Double getRate() {
        return rate;
    }

    public static void setRate(Double rate) {
        OrderCake.rate = rate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public double calcPrice() {
        return rate*weight;
    }
}
