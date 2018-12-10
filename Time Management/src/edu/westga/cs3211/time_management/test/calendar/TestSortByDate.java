package edu.westga.cs3211.time_management.test.calendar;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs3211.time_management.model.Calendar;
import edu.westga.cs3211.time_management.model.Event;
import edu.westga.cs3211.time_management.model.Visibility;

class TestSortByDate {
	Calendar testCalendar;
	Event testEvent1;
	Event testEvent2;
	Event testEvent3;
	LocalDateTime startTime1;
	LocalDateTime startTime2;
	LocalDateTime startTime3;
	LocalDateTime endTime1;
	LocalDateTime endTime2;
	LocalDateTime endTime3;

	@BeforeEach
	public void setup() throws Exception {
		this.testCalendar = new Calendar();

		this.startTime1 = LocalDateTime.now().plusDays(1);
		this.startTime2 = LocalDateTime.now().plusDays(2);
		this.startTime3 = LocalDateTime.now().plusDays(3);

		this.endTime1 = startTime1.plusDays(1);
		this.endTime2 = startTime2.plusDays(1);
		this.endTime3 = startTime3.plusDays(1);

		String defaultString = "Default";

		List<String> attendees = new ArrayList<String>();

		this.testEvent1 = new Event(defaultString, this.startTime1, this.endTime1, defaultString, defaultString,
				attendees, Visibility.PUBLIC);
		this.testEvent2 = new Event(defaultString, this.startTime2, this.endTime2, defaultString, defaultString,
				attendees, Visibility.PUBLIC);
		this.testEvent3 = new Event(defaultString, this.startTime3, this.endTime3, defaultString, defaultString,
				attendees, Visibility.PUBLIC);

	}

	@Test
	void testEmptyCollection() {
		this.testCalendar.sortByDate();
		assertTrue(this.testCalendar.getEvents().size() == 0);
	}

	@Test
	void testCollectionWithOneEntry() {
		this.testCalendar.addEvent(this.testEvent1);
		this.testCalendar.sortByDate();
		assertTrue(this.testCalendar.getEvents().get(0).getStartTime().equals(this.startTime1));
	}

	@Test
	void testCollectionWithTwoEntriesEarlierDateInSecondPosition() {
		this.testCalendar.addEvent(this.testEvent2);
		this.testCalendar.addEvent(this.testEvent1);
		this.testCalendar.sortByDate();
		assertTrue(this.testCalendar.getEvents().get(0).getStartTime().equals(this.startTime1));
	}

	@Test
	void testCollectionWithMultipleEntriesErliestInFirstSlot() {
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.sortByDate();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getStartTime().equals(this.startTime1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getStartTime().equals(this.startTime3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}

	@Test
	void testCollectionWithMultipleEntriesErliestInSecondSlot() {
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.sortByDate();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getStartTime().equals(this.startTime1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getStartTime().equals(this.startTime3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}
	
	@Test
	void testCollectionWithMultipleEntriesErliestInThirdSlot() {
		this.testCalendar.addEvent(testEvent2);
		this.testCalendar.addEvent(testEvent3);
		this.testCalendar.addEvent(testEvent1);
		this.testCalendar.sortByDate();
		boolean firstCheck = this.testCalendar.getEvents().get(0).getStartTime().equals(this.startTime1);
		boolean secondCheck = this.testCalendar.getEvents().get(2).getStartTime().equals(this.startTime3);
		assertTrue(firstCheck);
		assertTrue(secondCheck);
	}
}
