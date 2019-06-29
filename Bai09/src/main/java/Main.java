import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginStage loginStage = new LoginStage();
        loginStage.show();
    }

    public static void main(String [] args){
        Application.launch(args);
    }
}
