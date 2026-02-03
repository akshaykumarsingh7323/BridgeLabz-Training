package com.collectors.librarybookstatics;

public class Book {
	String title;
	String genre;
	int page;
	
	public Book(String title, String genre, int page) {
		this.title = title;
		this.genre = genre;
		this.page = page;
	}
	
	public String getTitle() {
		return title;	
	}
	
	public String getGenre() {
		return genre;
	}
	
	public int getPage() {
		return page;
	}
}
