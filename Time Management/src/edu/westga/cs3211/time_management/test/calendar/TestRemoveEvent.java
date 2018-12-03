package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestRemoveEvent {

	@Test
	void testRemoveEvent() {
		Calendar myCalendar = new  Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		Event myEventTwo = new Event("Name Two",start, end, "school", "meeting", attendees, Visibility.PUBLIC);
		
		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		myCalendar.removeEvent(myEvent);
		assertEquals(1, myCalendar.getEvents().size());
	}
	@Test
	void testRemoveNullEvent() {
		Calendar myCalendar = new  Calendar();
		assertThrows(
				IllegalArgumentException.class, 
				()->{
					myCalendar.removeEvent(null);
				}
			);
	}

}
