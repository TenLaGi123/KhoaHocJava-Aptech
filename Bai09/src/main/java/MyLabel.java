import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MyLabel extends Label {
    public MyLabel(String text) {
        super(text);
        this.setFont(Font.font("Arial", FontWeight.BOLD,30));
    }
}
