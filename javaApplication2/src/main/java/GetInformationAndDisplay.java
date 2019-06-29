import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Scanner;


public class GetInformationAndDisplay extends Stage implements ISetUp {

    GetInformationAndDisplay(){
        setUpUI();
        setUpAction();

    }
    private ProductStage productStage = new ProductStage();
    private Scene scene;

    private TextField textFieldX = new TextField("");
    //private TextField textFieldY = new TextField();
    private PasswordField passwordField = new PasswordField();
    private Button button = new Button("Click this");
    private Label label = new Label();
    private String userName = new String();
    private VBox vbox = new VBox();
    private BackgroundFill backgroundFill = new BackgroundFill(Color.GOLD, CornerRadii.EMPTY, Insets.EMPTY);
    private Background background = new Background(backgroundFill);
    public void setUpUI(){
        passwordField.setPromptText("");
        scene = new Scene(vbox, 900, 800);
        this.setScene(scene);
        vbox.getChildren().add(textFieldX);
        //vbox.getChildren().add(textFieldY);
        vbox.getChildren().add(passwordField);
        vbox.getChildren().add(button);
        vbox.getChildren().add(label);
        vbox.setBackground(background);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.CENTER);
        label.setFont(Font.font(12.5));
        label.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC.REGULAR, 20));
        label.setUnderline(true);

     }

    public void displayInfo(){
        label.setText(textFieldX.getText());
        label.setTextFill(Color.hsb(12,13,14));
    }
    public void setUpAction(){
      button.setOnAction(new EventHandler<ActionEvent>() {
          public void handle(ActionEvent event) {
              productStage.setTitle("Product Stage");
              productStage.show();


          }
      });
    }
}
