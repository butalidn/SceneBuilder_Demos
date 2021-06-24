package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {
    @FXML private TableColumn<Person, String> firstNameCol;
    @FXML private TableColumn<Person, String> lastNameCol;
    @FXML private TableColumn<Person, LocalDate> birthdayCol;
    @FXML private TableView<Person> tableViewObj;

    public void goToMainView(ActionEvent actionEvent) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) (((Node)actionEvent.getSource()).getScene().getWindow());
        window.setScene(tableViewScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        birthdayCol.setCellValueFactory(new PropertyValueFactory<Person, LocalDate>("birthday"));

        tableViewObj.setItems(getPeople());
        tableViewObj.setEditable(true);
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public ObservableList<Person> getPeople(){
        ObservableList<Person> people = FXCollections.observableArrayList();
        people.add(new Person("Frank", "Sinatra", LocalDate.of(1915, Month.DECEMBER,12)));
        people.add(new Person("Nik", "Butalid", LocalDate.of(1996, Month.SEPTEMBER,10)));
        people.add(new Person("Katie", "Wynn", LocalDate.of(1997, Month.JUNE,1)));

        return people;
    }

    public void changeFirstName(TableColumn.CellEditEvent editEvent) {
        Person selectedPerson = tableViewObj.getSelectionModel().getSelectedItem();
        selectedPerson.setFirstName(editEvent.getNewValue().toString());
    }

    public void changeLastName(TableColumn.CellEditEvent editEvent) {
        Person selectedPerson = tableViewObj.getSelectionModel().getSelectedItem();
        selectedPerson.setLastName(editEvent.getNewValue().toString());
    }
}
