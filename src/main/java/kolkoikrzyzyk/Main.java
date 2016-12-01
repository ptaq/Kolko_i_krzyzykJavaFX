package kolkoikrzyzyk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by ptaq on 30.11.2016.
 */
public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Scene.fxml"));
        GridPane gridPane = loader.load();


        Scene scene = new Scene(gridPane);

        stage.setTitle("Kółko i krzyżyk");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
