package views;

import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class Navigation {
    private ArrayList<Stage> stages;
    private static Navigation instance;

    private Navigation(){
        stages = new ArrayList<>();
    }

    public static Navigation getInstance(){
        if(instance == null){
            instance = new Navigation();
        }
        return instance;
    }
    public void pushItem(Stage stage){
          stages.add(stage);
    }

    public void popToStage(Stage stage){
        Boolean canDelete = false;

        for (Stage currentStage : new ArrayList<>(stages)) {
            if (currentStage.getClass().getSimpleName().equals(stage.getClass().getSimpleName())){
                canDelete = true;
                for(int i = stages.size() - 1; i>0;i--) {
                    if(stages.get(i) == currentStage) {
                        stages.set(i,stage);
                        break;
                    }
                }
                currentStage.close();
                stages.add(stage);
            }
            else{
                if(canDelete) {
                    stages.remove(currentStage);
                    currentStage.close();
                }

            }
        }

    }

    public Stage getCurrentStage(){
        Stage currentStage = stages.get(stages.size()-1);
        return currentStage;
    }
}
