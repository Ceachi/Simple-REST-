package com.ceachi.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	List<Alien> aliens;
	Connection con = null;
	
	public AlienRepository() {
		aliens = new ArrayList<>();
		/*
		
		aliens.add(new Alien(1,"Al", 123));
		aliens.add(new Alien(2, "B", 321));
		aliens.add(new Alien(3, "C", 321));
		System.out.println("In constructor aliens = " );
		*/
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);

		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<>();
		String sql = "select * from alien";
		
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
				aliens.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aliens;
	}
	
	public Alien getAlien(int id) {
		String sql = "select * from alien where id=" + id;
		Alien a = new Alien();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPoints(rs.getInt(3));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
		/*
		for(Alien alien : aliens) {
			if(alien.getId() == id) {
				return alien;
			}
		}
		return null;
		*/
	}
	
	public void create(Alien a1) {
		
		String sql = "insert into alien values(?,?,?)";	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2,a1.getName());
			st.setInt(3,  a1.getPoints());
			
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	

	public void update(Alien a1) {
		
		String sql = "update alien set name=?, points=? where id = ?";	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,a1.getName());
			st.setInt(2,  a1.getPoints());
			st.setInt(3, a1.getId());
			
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql = "delete from alien where id=?";	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, id);
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
