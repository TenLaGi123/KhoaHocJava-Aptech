import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginStage loginStage = new LoginStage();
        loginStage.initStyle(StageStyle.UNIFIED);
        loginStage.show();
    }

    public static void main(String [] args){
        Application.launch(args);
    }
}
