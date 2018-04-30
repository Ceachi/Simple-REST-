package com.ceachi.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	int id;
	String name;
	int points;
	
	public Alien() {
		
	}
	public Alien(int id, String name, int points) {
		this.id = id;
		this.name = name;
		this.points = points;
	}
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", points=" + points + "]";
	}

	

}
