package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    public Button decryptButton;
    public Button encryptButton;
    public TextField textField;
    public Label encryptedLabel;
    public ChoiceBox choiceBox;
    public Label headerLabel;

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
        String encryptedMessage = encryptedLabel.getText();
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

    private void showEncryptedMessage(String encryptedMessage) {
        headerLabel.setVisible(true);
        encryptedLabel.setText(encryptedMessage);
        textField.clear();
    }

    private void showDecryptedMessage(String decryptedMessage) {
        headerLabel.setVisible(false);
        textField.setText(decryptedMessage);
        encryptedLabel.setText("");
    }

}