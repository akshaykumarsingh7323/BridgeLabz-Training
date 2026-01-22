package com.sorting.tailorshop;

import java.time.LocalTime;

public class Tailor {
	int clothId;
	LocalTime deadline;
	
	public Tailor(int clothId, LocalTime deadline) {
		this.clothId = clothId;
		this.deadline = deadline;
	}
	
	
	public LocalTime getTime() {
		return deadline;
	}
	public String toString() {
		return "Cloth Id : " + clothId + " | DeadLine : " + deadline;
	}
}
