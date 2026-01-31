package koko;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Koko koko;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.jpg"));
    private Image kokoImage = new Image(this.getClass().getResourceAsStream("/images/DaKoko.jpg"));

    @FXML
    public void initialize() {
        assert scrollPane != null : "scrollPane should not be null";
        assert dialogContainer != null : "dialogContainer should not be null";
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /** Injects the Koko instance */
    public void setKoko(Koko k) {
        assert k != null : "Koko should not be null";
        assert dialogContainer != null : "dialogContainer should not be null";
        assert kokoImage != null : "kokoImage should not be null";
        koko = k;
        dialogContainer.getChildren().add(
                DialogBox.getKokoDialog(koko.showWelcome(), kokoImage)
        );
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        assert userInput != null : "userInput should not be null";
        assert dialogContainer != null : "dialogContainer should not be null";
        assert kokoImage != null : "kokoImage should not be null";
        String input = userInput.getText();
        String response = koko.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getKokoDialog(response, kokoImage)
        );
        userInput.clear();
        if (koko.isExit()) {
            PauseTransition delay = new PauseTransition(Duration.seconds(2)); // change 2 -> whatever
            delay.setOnFinished(event -> Platform.exit());
            delay.play();
        }
    }
}
