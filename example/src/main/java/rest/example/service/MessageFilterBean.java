package rest.example.service;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	
	private @QueryParam("year") long year;
	private  @QueryParam("start") int start;
	private  @QueryParam("size") int size;
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	
	
}
