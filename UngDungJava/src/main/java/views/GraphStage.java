package views;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;

public class GraphStage extends MyStage implements IMyStage {

    private MyMenuBar myMenuBar = new MyMenuBar();
    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<String,Number> lineChart;
    private XYChart.Series series = new XYChart.Series();
    private Scene scene;
    private ProductListStage productListStage;
    GraphStage(ProductListStage productListStage){
        super();
        this.productListStage = productListStage;
        setUpUi();
        setUpAction();

    }

    private VBox vBox = new VBox();
    @Override
    public void setUpUi() {

        lineChart = new LineChart<String, Number>(xAxis,yAxis);
        lineChart.setTitle("Product versus Price");
        series.setName("Sales during 19th century");

        reloadgraph();

        xAxis.setLabel("Product Name");
        yAxis.setLabel("Price");
        scene = new Scene(vBox,800,400);
        vBox.getChildren().addAll(myMenuBar,lineChart);
        lineChart.getData().addAll(series);
        this.setScene(scene);
    }

    @Override
    public void setUpAction() {

    }

    public void reloadgraph(){
        lineChart.setAnimated(false);
        series.getData().removeAll(series.getData());
        productListStage.getProducts().forEach(product -> {
            series.getData().add(new XYChart.Data<String,Number>(product.getProductName(),product.getPrice()));
        });
    }


}
