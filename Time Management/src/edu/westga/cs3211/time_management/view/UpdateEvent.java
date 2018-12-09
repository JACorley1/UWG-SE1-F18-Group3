/**
 * 
 */
package edu.westga.cs3211.time_management.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * @author Jeremiah Liscum
 *
 */
public class UpdateEvent {
	@FXML
    private TextField nameTextFlied;

    @FXML
    private DatePicker startTimeDate;

    @FXML
    private DatePicker endTimeDate;

    @FXML
    private Label nameLabel;

    @FXML
    private Label startTimeLabel;

    @FXML
    private Label endTimeLabel;

    @FXML
    private Label locationLabel;

    @FXML
    private TextField locationTextField;

    @FXML
    private Label descriptionLabel;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private Label attendesLabel;

    @FXML
    private TextField attendeesTextFlied;

    @FXML
    private ComboBox<?> attendeesList;

    @FXML
    private Button attendeesAddButton;

    @FXML
    private Button removeButton;

    @FXML
    private Label visibilityLabel;

    @FXML
    private ComboBox<?> visibilityList;

    @FXML
    private Button updateButton;

    @FXML
    private Button cancelButton;

    @FXML
    void visibilityList(ActionEvent event) {

    }
	   
}
