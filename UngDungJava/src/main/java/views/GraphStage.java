package views;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class GraphStage extends Stage implements IMyStage {

    private CategoryAxis xAxis = new CategoryAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<String,Number> lineChart;
    private XYChart.Series series = new XYChart.Series();
    private Scene scene;
    private TableStage tableStage;
    GraphStage(TableStage tableStage){
        this.tableStage = tableStage;
        setUpUi();
        setUpAction();

    }

    @Override
    public void setUpUi() {

        lineChart = new LineChart<String, Number>(xAxis,yAxis);
        lineChart.setTitle("Product versus Price");
        series.setName("Sales during 19th century");

        reloadgraph();

        xAxis.setLabel("Product Name");
        yAxis.setLabel("Price");
        scene = new Scene(lineChart,800,900);
        lineChart.getData().addAll(series);
        this.setScene(scene);
    }

    @Override
    public void setUpAction() {

    }

    public void reloadgraph(){
        lineChart.setAnimated(false);
        series.getData().removeAll(series.getData());
        tableStage.getProducts().forEach(product -> {
            series.getData().add(new XYChart.Data<String,Number>(product.getProductName(),product.getPrice()));
        });
    }


}
