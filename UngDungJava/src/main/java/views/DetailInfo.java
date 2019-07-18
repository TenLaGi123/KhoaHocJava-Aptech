package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Product;

public class DetailInfo extends Stage implements IMyStage {

    private Product selectedProduct;

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
        txtProductName.setText(selectedProduct.getProductName());
        txtProductDescription.setText(selectedProduct.getDescription());
        txtProductPrice.setText(String.valueOf(selectedProduct.getPrice()));
        txtProductYear.setText(String.valueOf(selectedProduct.getYear()));
    }

    private ProductListStage productListStage;
    DetailInfo(ProductListStage productListStage){
        setUpUi();
        setUpAction();
        this.productListStage = productListStage;
    }

    private Scene scene;
    private VBox vBox = new VBox();
    private MyLabel label = new MyLabel("Detail Information");

    private GridPane gridPane = new GridPane();

    private HBox hBox = new HBox();
    private Button btnSave = new Button("Save");
    private Button btnCancle = new Button("Cancle");

    private TextField txtProductName = new TextField();
    private TextField txtProductYear = new TextField();
    private TextField txtProductDescription = new TextField();
    private TextField txtProductPrice = new TextField();

    @Override
    public void setUpUi() {
        this.setTitle("Info");

        scene = new Scene(vBox,800,800);
        this.setScene(scene);

        vBox.setSpacing(12);
        vBox.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        gridPane.add(new Label("Product Name: "), 0, 0  );
        gridPane.add(txtProductName,1,0);
        gridPane.add(new Label("Product Year: "), 0, 1  );
        gridPane.add(txtProductYear,1,1);
        gridPane.add(new Label("Product Description: "), 0, 2  );
        gridPane.add(txtProductDescription,1,2);
        gridPane.add(new Label("Product price: "), 0, 3  );
        gridPane.add(txtProductPrice,1,3);

        hBox.getChildren().addAll(btnSave,btnCancle);

        vBox.getChildren().addAll(label,gridPane,hBox);


    }

    @Override
    public void setUpAction() {
        btnCancle.setOnAction(event -> {
              this.close();
        });

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeInformationSystem();
                productListStage.reloadTableView();
                DetailInfo.this.hide();
            }
        });
    }

    public void changeInformationSystem(){
        selectedProduct.setProductName(txtProductName.getText());
        selectedProduct.setPrice(Double.valueOf(txtProductPrice.getText()));
        selectedProduct.setYear(Integer.valueOf(txtProductYear.getText()));
        selectedProduct.setDescription(txtProductDescription.getText());
    }

}
