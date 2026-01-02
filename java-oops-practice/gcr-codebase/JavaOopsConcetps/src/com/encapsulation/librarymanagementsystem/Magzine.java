	package com.encapsulation.librarymanagementsystem;

	class Magazine extends LibraryItem implements Reservable {

	    public Magazine(int id, String title, String author) {
	        super(id, title, author);
	    }

	    @Override
	    public int getLoanDuration() {
	        return 7; 		
	    }

	    @Override
	    public void reserveItem() {
	        System.out.println("Magazine reserved successfully");
	    }

	    @Override
	    public boolean checkAvailability() {
	        return isAvailable();
	    }
	}
