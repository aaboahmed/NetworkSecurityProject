package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    public Button decryptButton;
    public Button encryptButton;
    public TextField textField;
    public Label label;
    public ChoiceBox choiceBox;

    private  CaesarCipher caesarCipher ;
    private  PlayFairCipher playFairCipher ;

    public Controller() {
        caesarCipher = new CaesarCipher();
        playFairCipher = new PlayFairCipher();
    }

    @FXML
    private void initialize() {
        encryptButton.setOnMouseClicked(mouseEvent -> handleHashButton());
        decryptButton.setOnMouseClicked(mouseEvent -> handleRetrieveButton());
    }
    
    private void handleHashButton() {
        String algorithmName = choiceBox.getValue().toString();
        String message = textField.getText();
        String encryptedMessage;

        switch (algorithmName) {
            case "Caesar cipher":
                encryptedMessage = caesarCipher.encrypt(message);
                break;
            case "Playfair cipher":
                encryptedMessage = playFairCipher.encrypt(message);
                break;
            default:
                encryptedMessage = "";
        }
        showEncryptedMessage(encryptedMessage);
    }

    private void handleRetrieveButton() {
        String algorithmName = choiceBox.getValue().toString();
        String encryptedMessage = label.getText();
        String decryptedMessage;

        switch (algorithmName) {
            case "Caesar cipher":
                decryptedMessage = caesarCipher.decrypt(encryptedMessage);
                break;
            case "Playfair cipher":
                decryptedMessage = playFairCipher.decrypt(encryptedMessage);
                break;
            default:
                decryptedMessage = "";
        }

        showDecryptedMessage(decryptedMessage);
    }


    private String encryptByPlayFairCipher() {
        String message = choiceBox.getValue().toString();
        label.setText(message);
        textField.clear();

        return "";
    }

    private String decryptByPlayFairCipher() {
        String message = label.getText();
        textField.setText(message);
        label.setText("");
        return "";
    }

    private void showEncryptedMessage(String encryptedMessage) {
        label.setText(encryptedMessage);
        textField.clear();
    }

    private void showDecryptedMessage(String decryptedMessage) {
        textField.setText(decryptedMessage);
        label.setText("");
    }

}