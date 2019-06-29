
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginStage extends Stage implements IMyStage{

    LoginStage(){
        setUpUi();
        setUpAction();
    }

    private Scene scene;
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();
    private Button btnSignIn = new Button("Sign in");
    private GridPane gridPane = new GridPane();
    private MyLabel myLabel = new MyLabel("Welcome");
    private TextField txtUserName = new TextField();
    private PasswordField txtPassword = new PasswordField();

    private StackPane stackPane = new StackPane();
    private ToggleButton toggleButton = new ToggleButton("Show password");
    private TextField txtField = new TextField();

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

        txtUserName.setPromptText("Enter User Name");

        hBox.getChildren().addAll(btnSignIn,toggleButton);
        gridPane.add(new Label("User Name: "), 0, 0  );
        gridPane.add(txtUserName, 1, 0);

        gridPane.add(new Label("Password: "), 0,1);

        gridPane.add(stackPane,1,1);
        gridPane.add(hBox,1,2);
        txtPassword.setPromptText("Enter your password");
        txtField.setPromptText("Enter your password");
        vBox.getChildren().addAll(myLabel,gridPane);


    }

    public void setUpAction() {
         btnSignIn.setOnAction(event -> {
                 this.hide();
                 TableStage tableStage = new TableStage();
                 tableStage.show();
         });

         toggleButton.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                 txtPassword.textProperty().bindBidirectional(txtField.textProperty());
                 txtPassword.visibleProperty().bind(toggleButton.selectedProperty().not());
                 txtField.visibleProperty().bind(toggleButton.selectedProperty());
             }
         });


    }
}
