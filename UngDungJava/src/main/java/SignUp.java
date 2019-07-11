import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import models.Database;

public class SignUp extends Stage implements IMyStage {


    SignUp(){
        setUpUi();
        setUpAction();
    }

    private Scene scene;
    private VBox vBox = new VBox();
    private MyLabel myLabel = new MyLabel("Registration Form");
    private GridPane gridPane = new GridPane();
    private TextField txtName = new TextField();
    private TextField txtEmail = new TextField();
    private TextField txtPassWord = new TextField();
    private TextField txtPhoneNumber = new TextField();
    private TextArea description = new TextArea();
    private HBox hBox = new HBox();
    private Button btnSignUp = new Button("Sign Up");
    private Button btnCancel = new Button("Cancel");
    @Override
    public void setUpUi() {

        scene = new Scene(vBox, 290,450);
        this.setScene(scene);
        this.setTitle("Registration Form");

        hBox.getChildren().addAll(btnSignUp, btnCancel);
        gridPane.add(new Label("Name: "), 0, 0  );
        gridPane.add(txtName, 0, 1);
        gridPane.add(new Label("E-mail: "), 0, 2  );
        gridPane.add(txtEmail, 0, 3);
        gridPane.add(new Label("Password: "), 0, 4  );
        gridPane.add(txtPassWord, 0, 5);
        gridPane.add(new Label("Phone Number: "), 0, 6 );
        gridPane.add(txtPhoneNumber, 0, 7);
        gridPane.add(new Label("Description: "), 0, 8  );
        gridPane.add(description, 0, 9);


        myLabel.setTextAlignment(TextAlignment.CENTER);
        vBox.getChildren().addAll(myLabel,gridPane,hBox);
        hBox.setSpacing(15);
        hBox.setPadding(new Insets(10,0,10, 0));
        vBox.setPadding(new Insets(10,10,10, 10));
        vBox.setSpacing(10);

    }

    @Override
    public void setUpAction() {
        btnCancel.setOnAction(event -> {
            this.hide();
        });

        btnSignUp.setOnAction(event -> {
            try {
                Database.getInstance().signUpUser(txtName.getText().trim(),
                        txtEmail.getText().trim(), txtPassWord.getText(), txtPhoneNumber.getText(), description.getText());
                this.hide();
                TableStage tableStage = new TableStage();
                tableStage.show();
            }
            catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Test Connection");

                // alert.setHeaderText("Results:");
                alert.setContentText("Error! Cannot login! Because " +e.toString());

                alert.showAndWait();
            }
        });
    }
}
