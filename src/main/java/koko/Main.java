package koko;

import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The main JavaFX application class for Koko.
 * This class loads the GUI layout from FXML and starts the application window.
 */
public class Main extends Application {

    private static final String DEFAULT_FILE_PATH = "data/tasks.txt";

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.jpg"));
    private Image kokoImage = new Image(this.getClass().getResourceAsStream("/images/DaKoko.jpg"));
    private Koko koko = new Koko(DEFAULT_FILE_PATH);

    /**
     * Starts the JavaFX application by loading the main window layout from FXML and
     * displaying it on the stage.
     *
     * @param stage The stage for this application.
     */
    @Override
    public void start(Stage stage) {
        assert Main.class.getResourceAsStream("/images/DaUser.jpg") != null : "Missing DaUser.jpg image";
        assert Main.class.getResourceAsStream("/images/DaKoko.jpg") != null : "Missing DaKoko.jpg image";
        assert koko != null : "koko should not be null";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            stage.setMaxWidth(417);
            stage.setTitle("Koko");
            fxmlLoader.<MainWindow>getController().setKoko(koko);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a dialog box containing user input, and appends it to
     * the dialog container. Clears the user input after processing.
     */
    private void handleUserInput() {
        assert userInput != null : "userInput should not be null";
        assert dialogContainer != null : "dialogContainer should not be null";
        assert kokoImage != null : "kokoImage should not be null";
        String userText = userInput.getText();
        String kokoText = koko.getResponse(userInput.getText());
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(userText, userImage),
                DialogBox.getKokoDialog(kokoText, kokoImage)
        );
        userInput.clear();
        if (koko.isExit()) {
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // change 2 -> whatever
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
    }

}
