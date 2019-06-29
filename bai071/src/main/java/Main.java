import javafx.application.Application;
import javafx.stage.Stage;

import java.util.concurrent.Callable;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CalculationStage calculationStage = new CalculationStage();
        calculationStage.show();
    }


    public static void main(String [] args){
        Application.launch();
    }
}
