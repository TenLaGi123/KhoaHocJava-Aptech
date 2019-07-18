package views;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Database;
import models.User;

public class LoginStage extends Stage implements IMyStage{

    LoginStage(){
        super();
        setUpUi();
        setUpAction();
    }

    private User user;
    private Scene scene;
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();
    private Button btnSignIn = new Button("Sign in");
    private GridPane gridPane = new GridPane();
    private MyLabel myLabel = new MyLabel("Welcome");
    private TextField txtEmail = new TextField();
    private PasswordField txtPassword = new PasswordField();

    private StackPane stackPane = new StackPane();
    private ToggleButton toggleButton = new ToggleButton("Show password");
    private TextField txtField = new TextField();

    private FlowPane flowPane = new FlowPane();
    private Hyperlink hyperlink = new Hyperlink("Don't have an account? sign up here");

    public void setUpUi() {
        scene = new Scene(vBox, 290, 250);
        this.setScene(scene);
        this.setTitle("My Program");

        stackPane.getChildren().addAll(txtPassword,txtField);

        vBox.setSpacing(12);
        vBox.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        hBox.getChildren().addAll(stackPane);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        txtEmail.setPromptText("Enter User Name");

        hBox.getChildren().addAll(btnSignIn,toggleButton);
        gridPane.add(new Label("User Name: "), 0, 0  );
        gridPane.add(txtEmail, 1, 0);

        gridPane.add(new Label("Password: "), 0,1);

        gridPane.add(stackPane,1,1);
        gridPane.add(hBox,1,2);
        txtPassword.setPromptText("Enter your password");
        txtField.setPromptText("Enter your password");

        hyperlink.setTextAlignment(TextAlignment.CENTER);
        hyperlink.setBorder(Border.EMPTY);
        hyperlink.setPadding(new Insets(4, 0, 4, 0));
        flowPane.getChildren().addAll(hyperlink);
        vBox.getChildren().addAll(myLabel,gridPane,flowPane);


       txtEmail.setText("duong.nguyen13600@gmail.com");
       txtPassword.setText("ABC123");
       txtField.setText("ABC123");
//        txtEmail.setText("quangdang123@gmail.com");
//        txtPassword.setText("LCD123");
//        txtField.setText("LCD123");

    }

    public void setUpAction() {
         btnSignIn.setOnAction(event -> {

             try{
                 user = Database.getInstance().findUser(txtEmail.getText().trim(),txtPassword.getText());
             }
             catch (Exception e){
                 Alert alert = new Alert(Alert.AlertType.ERROR);
                 alert.setTitle("Test Connection");

                 // alert.setHeaderText("Results:");
                 alert.setContentText("Error! Cannot login! Because " +e.toString());

                 alert.showAndWait();
             }
             //if successful
             if(user != null){
                 this.hide();
                 User.logInUser = user;
                 TableStage tableStage = new TableStage();
                 Navigation.getInstance().pushItem(tableStage);
                 tableStage.show();
                 tableStage.checkUserStatus();
             }

         });
         
         txtPassword.textProperty().bindBidirectional(txtField.textProperty());
         toggleButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                 //txtPassword.textProperty().bindBidirectional(txtField.textProperty());
                 txtPassword.visibleProperty().bind(toggleButton.selectedProperty().not());
                 txtField.visibleProperty().bind(toggleButton.selectedProperty());
             }
         });

         hyperlink.setOnAction(event -> {
             SignUp signUp = new SignUp();
             signUp.show();
         });
    }
}
