package views;

import javafx.stage.Stage;
import models.Database;
import models.User;

public class MyStage extends Stage {

    public void checkUserStatus(){
        if (!Database.getInstance().checkUserStatus(User.logInUser.getEmail())){
            Navigation.getInstance().popToStage(new LoginStage());
            ((LoginStage)Navigation.getInstance().getCurrentStage()).show();
        }
    }
}
