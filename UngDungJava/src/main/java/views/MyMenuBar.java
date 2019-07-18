package views;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MyMenuBar extends MenuBar {


    // Tạo các Menu
    private Menu fileMenu = new Menu("Account");

    private Menu helpMenu = new Menu("Help");


    // Tạo các MenuItem
    private MenuItem itemSignOut = new MenuItem("Sign Out");
    private MenuItem exitItem = new MenuItem("Exit");

    private MenuItem itemContactMe = new MenuItem("Contact Me");
    private MenuItem itemAboutMe = new MenuItem(" About Me");

    MyMenuBar(){
     // Thêm các MenuItem vào Menu.
        fileMenu.getItems().addAll(itemSignOut, exitItem);
         helpMenu.getItems().addAll(itemContactMe, itemAboutMe);

        // Thêm các Menu vào MenuBar
        this.getMenus().addAll(fileMenu,helpMenu);
        setUpAction();
    }

    public void setUpAction(){
       itemSignOut.setOnAction(event -> {
           Navigation.getInstance().popToStage(new LoginStage());
           ((LoginStage)Navigation.getInstance().getCurrentStage()).show();
       });
    }

}
