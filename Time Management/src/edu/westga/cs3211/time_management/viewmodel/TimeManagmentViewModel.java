/**
 * 
 */
package edu.westga.cs3211.time_management.viewmodel;


import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 * The view model of the time management system.
 * @author Jeremiah Liscum
 *
 */
public class TimeManagmentViewModel {
	private Calendar calendar;
	private ListProperty<Event> eventListProperty;
	/**
	 * Constructor 
	 */
	public TimeManagmentViewModel() {
		this.calendar = new Calendar();
		this.eventListProperty = new SimpleListProperty<Event>(FXCollections.observableArrayList(this.calendar.getEvents()));
		
	}
	
	
}
