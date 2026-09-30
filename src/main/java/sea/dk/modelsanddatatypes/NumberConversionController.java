package sea.dk.modelsanddatatypes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class NumberConversionController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TextInputDialog dialog = new TextInputDialog("");

        dialog.setTitle("Text Input Dialog");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            String message = ncModel.getGreetingsMessage(result.get());
            lblWelcomeText.setText(message);
        }


        System.out.println("");
    }

    @FXML
    private Label lblResult;

    @FXML
    private TextField txtNumberInput;

    @FXML
    private Label lblWelcomeText;

    private NumberConversionModel ncModel = new NumberConversionModel();

    @FXML
    protected void onHelloButtonClick() {
        System.out.println(ncModel.getGreetingsMessage("kjhgkjhgjkh"));
        lblWelcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void onClick(ActionEvent event)
    {
        double txtFieldValue = Double.parseDouble(txtNumberInput.getText());
        double result = ncModel.getMilesFromKilometers(txtFieldValue);
        String resultAsString = String.valueOf(result);
        lblResult.setText(resultAsString);
    }
}
