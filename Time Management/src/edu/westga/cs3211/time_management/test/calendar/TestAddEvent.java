package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

public class TestAddEvent {

	@Test
	public void testAddNullEvent() {
		Calendar myCalendar = new Calendar();

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			myCalendar.addEvent(null);
		});

	}

	@Test
	public void testAddOnePublicEvent() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);

		myCalendar.addEvent(myEvent);
		assertEquals(1, myCalendar.getEvents().size());

	}

	@Test
	public void testAddTwoPublicEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);

		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "church", "prayer", attendees, Visibility.PUBLIC);

		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		assertEquals(2, myCalendar.getEvents().size());
	}
	@Test
	public void testAddThreePublicEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PUBLIC);
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);
		
		LocalDateTime startThree = LocalDateTime.now().plusDays(3);
		LocalDateTime endThree = start.plusDays(3);

		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "church", "prayer", attendees, Visibility.PUBLIC);
		
		Event myEventThree = new Event("Name Three", startThree, endThree, "gym", "workout", attendees, Visibility.PUBLIC);

		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		myCalendar.addEvent(myEventThree);
		assertEquals(3, myCalendar.getEvents().size());
	}
	@Test
	public void testAddOnePrivateEvent() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PRIVATE);

		myCalendar.addEvent(myEvent);
		assertEquals(1, myCalendar.getEvents().size());

	}
	@Test
	public void testAddTwoPrivateEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PRIVATE);
		
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);
		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "school", "homework", attendees, Visibility.PRIVATE);

		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		assertEquals(2, myCalendar.getEvents().size());
	}
	@Test
	public void testAddThreePrivateEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.PRIVATE);
		
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);
		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "school", "homework", attendees, Visibility.PRIVATE);
		LocalDateTime startThree = LocalDateTime.now().plusDays(3);
		LocalDateTime endThree = start.plusDays(3);
		Event myEventThree = new Event("Name Three", startThree, endThree, "gym", "workout", attendees, Visibility.PRIVATE);

		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		myCalendar.addEvent(myEventThree);
		assertEquals(3, myCalendar.getEvents().size());
	}
	@Test
	public void testAddOneFriendsOnlyEvent() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.FRIENDS_ONLY);

		myCalendar.addEvent(myEvent);
		assertEquals(1, myCalendar.getEvents().size());
	}
	@Test
	public void testAddTwoFriendsOnlyEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees,Visibility.FRIENDS_ONLY );
		
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);
		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "school", "homework", attendees, Visibility.FRIENDS_ONLY);
		
		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		assertEquals(2, myCalendar.getEvents().size());
	}
	@Test
	public void testAddThreeFriendsOnlyEvents() {
		Calendar myCalendar = new Calendar();
		LocalDateTime start = LocalDateTime.now().plusDays(1);
		LocalDateTime end = start.plusDays(1);
		ArrayList<String> attendees = new ArrayList<String>();
		attendees.add("jack");
		Event myEvent = new Event("Name", start, end, "school", "homework", attendees, Visibility.FRIENDS_ONLY);
		
		LocalDateTime startTwo = LocalDateTime.now().plusDays(2);
		LocalDateTime endTwo = start.plusDays(2);
		Event myEventTwo = new Event("Name Two", startTwo, endTwo, "school", "homework", attendees, Visibility.FRIENDS_ONLY);
		LocalDateTime startThree = LocalDateTime.now().plusDays(3);
		LocalDateTime endThree = start.plusDays(3);
		Event myEventThree = new Event("Name Three", startThree, endThree, "gym", "workout", attendees, Visibility.FRIENDS_ONLY);

		myCalendar.addEvent(myEvent);
		myCalendar.addEvent(myEventTwo);
		myCalendar.addEvent(myEventThree);
		assertEquals(3, myCalendar.getEvents().size());
	}
	
	

}
