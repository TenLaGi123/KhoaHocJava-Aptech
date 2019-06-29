import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class CalculationStage extends Stage implements IMyStage {

    CalculationStage(){
        setUpUI();
        setUpAction();
    }


    private Scene scene ;
    private HBox hBox = new HBox();
    private VBox vBox = new VBox();
    private TextField textFieldX = new TextField();
    private TextField textFieldY = new TextField();
    private TextField textFieldZ = new TextField();
    private Button button = new Button("Calculate this");
    private Button btnSum = new Button("+");
    private Button btnMinus = new Button("-");
    private Button btnMulti = new Button("x");
    private Button btnDiv = new Button(":");
    private MyLabel label = new MyLabel(12.3f);
    private Label labelEpiration = new Label("Het han roi");
    private String operator = "";
    Timer timer = new Timer();
    public void setUpUI() {
        scene = new Scene(vBox, 800, 700);

        this.setScene(scene);
       final DefaultExpiration defaultExpiration = new DefaultExpiration();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                vBox.getChildren().removeAll();
                System.out.println("1s");
                if(defaultExpiration.dateChecking()) {
                    vBox.getChildren().add(textFieldX);
                    hBox.getChildren().addAll(btnSum,btnMinus, btnMulti, btnDiv);
                    vBox.getChildren().add(hBox);
                    vBox.getChildren().add(textFieldY);
                    vBox.getChildren().add(button);
                    vBox.getChildren().add(label);
                } else {
                    vBox.getChildren().add(labelEpiration);
                }
            }
        }, 0,1000);


    }


    public void calulateXY(){
        try {
            Integer x = Integer.valueOf(textFieldX.getText());
            Integer y = Integer.valueOf(textFieldY.getText());
            Integer result;
            if (operator.equals("+")) {
                result = x + y;
                label.setText("result = " + result);
            }

            else if(operator.equals("-")) {
                result = x - y;
                label.setText("result = " + result);
            }

            else if(operator.equals("*")) {
                result = x * y;
                label.setText("result = " + result);
            }

            else if(operator.equals(":")) {
                result = x / y;
                label.setText("result = " + result);

            }

        }
        catch(Exception e){
            label.setText("error: " + e.toString());
        }
        finally{

        }


    }

    public void setUpAction() {
         button.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                  calulateXY();
              }

         });

         btnSum.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
                CalculationStage.this.operator = "+";
             }
         });

        btnMinus.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CalculationStage.this.operator = "-";
            }
        });

        btnMulti.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CalculationStage.this.operator = "*";
            }
        });

        btnDiv.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                CalculationStage.this.operator = ":";
            }
        });
    }
}
