import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
      GetInformationAndDisplay myStage = new GetInformationAndDisplay();
      myStage.setTitle("My First Program");
      myStage.show();
    }

    public static void main(String [] args){
        Application.launch();
    }
}
