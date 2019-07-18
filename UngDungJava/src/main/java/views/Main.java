package views;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*
          Opening the login stage by creating a new scene
         */
        LoginStage loginStage = new LoginStage();
        Navigation.getInstance().pushItem(loginStage);
        loginStage.initStyle(StageStyle.UNIFIED);

//      ExcelManager excelManager = new ExcelManager();
//      excelManager.readExcelFile();

        //Showing the stage
        loginStage.show();
    }

    public static void main(String [] args){
        Application.launch(args);
    }
}
