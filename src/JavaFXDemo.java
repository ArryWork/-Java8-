import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Created by Arry on 2017/9/2.
 */
public class JavaFXDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label message = new Label("Hello JavaFX");
        message.setFont(new Font(100));
        primaryStage.setScene(new Scene(message));
        primaryStage.setTitle("Hellooooooooooooooooooo");
        primaryStage.show();
    }
}
