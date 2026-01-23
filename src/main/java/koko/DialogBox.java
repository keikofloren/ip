package koko;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * A custom control representing a dialog box consisting of a text label and an image.
 * This is used to display both the user's messages and Koko's responses in the GUI.
 */
public class DialogBox extends HBox {

    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    /**
     * Constructs a dialog box with the given text and display picture.
     *
     * @param text The message to be displayed in the dialog box.
     * @param img The image to be shown alongside the message.
     */
    public DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
        dialog.getStyleClass().add("reply-label");
    }

    /**
     * Creates a dialog box for the user's message.
     *
     * @param s The user's message.
     * @param i The user's display image.
     * @return A {@code DialogBox} styled as a user dialog.
     */
    public static DialogBox getUserDialog(String s, Image i) {
        return new DialogBox(s, i);
    }

    /**
     * Creates a dialog box for Koko's response.
     * The dialog box will be flipped so that it appears on the opposite side.
     *
     * @param s Koko's response message.
     * @param i Koko's display image.
     * @return A {@code DialogBox} styled as a Koko dialog.
     */
    public static DialogBox getKokoDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.flip();
        return db;
    }

}
