import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.UnaryOperator;


/**
 * Created by Arry on 2017/9/1.
 */
public class ImageTest extends Application{
    public static void main(String[] args) {

        launch(args);
    }

    private static Image transform(Image image, UnaryOperator<Color> brighter, UnaryOperator<Color> grayscale) {

        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        WritableImage out = new WritableImage(width,height);
        for (int x=0 ; x< width; x++)
            for (int y=0; y< height; y++){
            out.getPixelWriter().setColor(x,y,brighter.compose(grayscale).apply(image.getPixelReader().getColor(x,y)));
            }

        return out;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("http://images2015.cnblogs.com/blog/552712/201611/552712-20161129145243193-511707840.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        ImageView imageView2 = new ImageView();
        Image brightenedImage = transform(image, Color::darker, Color::grayscale);
        imageView2.setImage(brightenedImage);
        // Display image on screen
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);
        Scene scene = new Scene(root, 600, 250);
        primaryStage.setTitle("Image Read Test");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}
