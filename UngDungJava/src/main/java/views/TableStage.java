package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import models.Product;

import java.util.Iterator;
import java.util.UUID;

public class TableStage extends Stage implements IMyStage {

    private Product selectedProduct;

    public ObservableList<Product> getProducts() {
        return products;
    }

    TableStage(){
        setUpUi();
        setUpAction();
    }

    private MyMenuBar myMenuBar = new MyMenuBar();
    private MyLabel label = new MyLabel("Address Book");
    private Scene scene;
    private TableView<Product> tableView = new TableView<Product>();
    private TableColumn<Product,String> columnID = new TableColumn<Product, String>("ID");
    private TableColumn<Product,String> columnProductName = new TableColumn<Product, String>("Product Name");
    private TableColumn<Product,Integer> columnProductYear = new TableColumn<Product, Integer>("Product Year");
    private TableColumn<Product,String> columnProductDescription = new TableColumn<Product, String>("Product Description");
    private TableColumn<Product,Double> columnProductPrice = new TableColumn<Product, Double>("Product Price");
    private VBox vBox = new VBox();
    private HBox hBox = new HBox();

    private TextField txtProductName = new TextField();
    private TextField txtProductYear = new TextField();
    private TextArea txtProductDescription = new TextArea();
    private TextField txtProductPrice = new TextField();
    private Button add = new Button("Add");
    private Label lblChecking = new Label("");

    private ContextMenu contextMenu = new ContextMenu();
    private MenuItem menuItemDelete = new MenuItem("Delete");
    private MenuItem menuItemProperties = new MenuItem("Properties");
    private Button showGraph = new Button("Show Graph");

    private GraphStage graphStage;

    private ObservableList<Product> products = FXCollections.observableArrayList(
            new Product("1001","Iphone",2007,"Good Condition",750.8),
            new Product("1022","Samsung Galaxy",2008,"Good Condition", 760.9),
            new Product("1234","Alienware",2009,"In Progress",1500.12),
            new Product("4563","Macbook",2011,"In Progress",2800.13),
            new Product("1587","Audi",2015,"In Repairation",50000.99)
            );

    public void setUpUi() {
        contextMenu.getItems().addAll(menuItemDelete,menuItemProperties);

        tableView.setItems(products);
        columnID.setCellValueFactory(new PropertyValueFactory<Product,String>("productID"));
        columnProductName.setCellValueFactory(new PropertyValueFactory<Product, String>("productName"));
        columnProductYear.setCellValueFactory(new PropertyValueFactory<Product, Integer>("year"));
        columnProductPrice.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        columnProductDescription.setCellValueFactory(new PropertyValueFactory<Product, String>("description"));

        tableView.getColumns().addAll(columnID,columnProductName ,columnProductYear,columnProductDescription, columnProductPrice);
        columnProductName.setMinWidth(200);
        columnProductYear.setMinWidth(200);
        columnProductDescription.setMinWidth(200);
        columnProductPrice.setMinWidth(200);

        scene = new Scene(vBox, 800,700);
        this.setScene(scene);
        this.setTitle("Address Book");
        txtProductName.setPromptText("Enter product name");
        txtProductDescription.setPromptText("");
        txtProductPrice.setPromptText("Enter price");
        txtProductYear.setPromptText("Enter year");
        hBox.getChildren().addAll(txtProductName,txtProductYear,txtProductPrice,add,showGraph);
        vBox.getChildren().addAll(myMenuBar,label,tableView,hBox,txtProductDescription,lblChecking);
    }

    public void setUpAction() {
          add.setOnAction(new EventHandler<ActionEvent>() {
              public void handle(ActionEvent event) {
                  try{
                      String productID = UUID.randomUUID().toString();
                      String name = txtProductName.getText().trim();
                      String description = txtProductDescription.getText().trim();
                      Integer year = Integer.valueOf(txtProductYear.getText());
                      Double price = Double.valueOf(txtProductPrice.getText());

                      if((name.length()>3) && (year > 1970)){
                          Product newProduct = new Product(productID,name,year,description,price);
                          products.add(newProduct);
                          if(graphStage != null) {
                              graphStage.reloadgraph();
                          }
                          clearText();
                          lblChecking.setText("");
                      }
                      else
                      {
                          lblChecking.setText("You enter wrong value");
                          lblChecking.setTextFill(Color.RED);
                      }
                  }catch (Exception e){
                      lblChecking.setText("You enter wrong value: " + e);
                      lblChecking.setTextFill(Color.RED);
                  }

              }
          });

          tableView.setRowFactory(tv -> {
              final TableRow<Product> row = new TableRow<Product>();
              row.setOnMouseClicked(event -> {

                  if(row.getItem() == null){
                      return;
                  }

                  selectedProduct = row.getItem();

                  contextMenu.hide();
                  if(event.getClickCount()== 2){
                       showDetailInfo();
                   }
                  else if(event.getButton()== MouseButton.SECONDARY){
                      contextMenu.show(tableView,event.getScreenX(),event.getScreenY());
                  }

              });
              return row;

          });

          menuItemDelete.setOnAction(event -> {

              Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
              alert.setTitle("Confirmation Dialog");
              alert.setHeaderText("Look, a Confirmation Dialog");
              alert.setContentText("Are you ok with this?");

              if (alert.showAndWait().get() == ButtonType.OK){
                  deleteItem(selectedProduct.getProductID());
              }

          });

          menuItemProperties.setOnAction(event -> {
              if(selectedProduct != null){
               showDetailInfo();
              }
          });

          showGraph.setOnAction(event -> {
               if(graphStage == null) {
                   graphStage = new GraphStage(this);
                   graphStage.setTitle("Graph Chart");
                   graphStage.show();
               }
          });

    }

    public void deleteItem(String productID){
        Iterator itr = products.iterator();
        while (itr.hasNext())
        {
            Product product = (Product)itr.next();
            if (product.getProductID() == productID ){
                itr.remove();
            }
        }

    }

    private void showDetailInfo(){
        DetailInfo detailInfoStage = new DetailInfo(this);
        Navigation.getInstance().pushItem(detailInfoStage);
        detailInfoStage.setSelectedProduct(selectedProduct);
        detailInfoStage.show();
    }

    public void reloadTableView(){
        if(graphStage != null) {
            graphStage.reloadgraph();
        }
        tableView.refresh();
    }

    public void clearText(){
        txtProductName.clear();
        txtProductYear.clear();
        txtProductPrice.clear();
        txtProductDescription.clear();
    }

}

