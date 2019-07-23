import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //(i)
         ArrayList<Cake> cakes = new ArrayList<Cake>();

         //(ii)
        Cake cake1 = new OrderCake();
        cake1.name = "Chocolate";
        cake1.rate = 12.3;

        Cake cake2 = new OrderCake();
        cake2.name = "Strawberry";
        cake2.rate = 12.4;

        Cake cake3 = new OrderCake();
        cake2.name = "Vanilla";
        cake2.rate = 22.4;

        Cake cake4 = new ReadymadeCake();
        cake4.name = "Cream";
        cake4.rate = 22.6;

        Cake cake5 = new ReadymadeCake();
        cake5.name = "Matcha";
        cake5.rate = 30.6;

        cakes.add(cake1);
        cakes.add(cake2);
        cakes.add(cake3);
        cakes.add(cake4);
        cakes.add(cake5);


    }

}





