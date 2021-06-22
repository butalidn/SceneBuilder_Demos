package sample;

import javafx.collections.ObservableList;
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
    public ListView listView;
    public Button gearButton;
    public TextArea textArea;

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

        listView.getItems().addAll("Golf Balls", "Wedges", "Irons", "Tees", "Drivers");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void radioButtonSelected() {
        langLabel.setText("You selected: " + ((RadioButton) this.langToggle.getSelectedToggle()).getText());
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

    public void golfButton(ActionEvent actionEvent) {
        String textAreaString = "";
        ObservableList listOfItems = listView.getSelectionModel().getSelectedItems();

        for(Object item: listOfItems) {
            textAreaString += (item.toString() + "\n");
        }
        textArea.setText(textAreaString);
    }
}
