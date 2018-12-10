package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestSortByLocation {
	Calendar testCalendar;
	Event testEvent1;
	Event testEvent2;
	Event testEvent3;
	LocalDateTime startTime1;
	LocalDateTime endTime1;
	String testString1;
	String testString2;
	String testString3;


	@BeforeEach
	public void setup() throws Exception {
		this.testCalendar = new Calendar();

		this.startTime1 = LocalDateTime.now().plusDays(1);
		this.endTime1 = startTime1.plusDays(1);

		String defaultString = "Default";
		
		this.testString1 = "A";
		this.testString2 = "B";
		this.testString3 = "C";
		

		List<String> attendees = new ArrayList<String>();

		this.testEvent1 = new Event(defaultString, this.startTime1, this.endTime1, testString1, defaultString,
				attendees, Visibility.PUBLIC);
		this.testEvent2 = new Event(defaultString, this.startTime1, this.endTime1, testString2, defaultString,
				attendees, Visibility.PUBLIC);
		this.testEvent3 = new Event(defaultString, this.startTime1, this.endTime1, testString3, defaultString,
				attendees, Visibility.PUBLIC);

	}

	@Test
	void testEmptyCollection() {
		this.testCalendar.sortByLocation();
		assertTrue(this.testCalendar.getEvents().size() == 0);
	}

	@Test
	void testCollectionWithOneEntry() {
		this.testCalendar.addEvent(this.testEvent1);
		this.testCalendar.sortByLocation();
		assertTrue(this.testCalendar.getEvents().get(0).getLocation().equals(this.testString1));
	}

	@Test
	void testCollectionWithTwoEntriesEarlierDateInSecondPosition() {
		this.testCalendar.addEvent(this.testEvent2);
		this.testCalendar.addEvent(this.testEvent1);
		this.testCalendar.sortByLocation();
		assertTrue(this.testCalendar.getEvents().get(0).getLocation().equals(this.testString1));
	}

	@Test
	void testCollectionWithMultipleEntriesErliestInFirstSlot() {
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.sortByLocation();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getLocation().equals(this.testString1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getLocation().equals(this.testString3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}

	@Test
	void testCollectionWithMultipleEntriesErliestInSecondSlot() {
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.sortByLocation();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getLocation().equals(this.testString1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getLocation().equals(this.testString3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}
	
	@Test
	void testCollectionWithMultipleEntriesErliestInThirdSlot() {
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.sortByLocation();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getLocation().equals(this.testString1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getLocation().equals(this.testString3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}
}
