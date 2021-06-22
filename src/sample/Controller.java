package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label pizzaOrderLabel;
    public CheckBox pepCheckBox;
    public Button orderButton;
    public CheckBox baconCheckBox;
    public CheckBox pineappleCheckBox;
    public ChoiceBox choiceBox;
    public Button choiceBoxButton;
    public Label choiceBoxLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaOrderLabel.setText("");
        choiceBoxLabel.setText("");
        choiceBox.getItems().addAll("Apples", "Bananas", "Peaches", "Strawberries", "Mango");
        choiceBox.setValue("Apples");
    }


    public void orderButtonClicked(ActionEvent actionEvent) {
        String order = "Toppings are: ";

        if (pepCheckBox.isSelected()) {
            order += "\npepperoni";
        }
        if (baconCheckBox.isSelected()) {
            order += "\nbacon";
        }
        if (pineappleCheckBox.isSelected()) {
            order += "\npineapple";
        }

        this.pizzaOrderLabel.setText(order);
    }

    public void choiceBoxButtonPushed(ActionEvent actionEvent) {
        choiceBoxLabel.setText("My favorite fruit is: " + choiceBox.getValue().toString());
    }
}
