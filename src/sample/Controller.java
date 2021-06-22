package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    public ComboBox comboBox;
    public Label comboBoxLabel;
    public RadioButton jsRadio;
    public RadioButton cppRadio;
    public RadioButton sasRadio;
    public RadioButton pyRadio;
    public Label langLabel;
    public ToggleGroup langToggle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        pizzaOrderLabel.setText("");
        choiceBoxLabel.setText("");
        choiceBox.getItems().addAll("Apples", "Bananas", "Peaches", "Strawberries", "Mango");
        choiceBox.setValue("Apples");

        comboBox.getItems().addAll("COMP1030", "AET3500", "ENG2010", "MAT3025");
        comboBoxLabel.setText("");
        comboBox.setEditable(true);

        langLabel.setText("");
        langToggle = new ToggleGroup();
        this.cppRadio.setToggleGroup(langToggle);
        this.pyRadio.setToggleGroup(langToggle);
        this.sasRadio.setToggleGroup(langToggle);
        this.jsRadio.setToggleGroup(langToggle);
    }

    public void radioButtonSelected() {
        langLabel.setText("You selected: \n" + ((RadioButton) this.langToggle.getSelectedToggle()).getText());
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
        System.out.println("Choice box clicked!");
    }

    public void courseSelected(ActionEvent actionEvent) {
        comboBoxLabel.setText("Course selected: \n" + comboBox.getValue().toString());
    }
}
