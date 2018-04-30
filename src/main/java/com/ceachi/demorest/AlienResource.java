package com.ceachi.demorest;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	AlienRepository repo = new AlienRepository();
	
	@GET //http://localhost:8080/demorest/webapi/aliens
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // allow to get bouth XML and JSON files
	public List<Alien> getAliens()  {
		return repo.getAliens();
	}
	
	@GET //http://localhost:8080/demorest/webapi/aliens/alien/1 
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) 
	public Alien getAlienById(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
	
	@POST
	@Path("alien")  //aliens/alien
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // send data in bouth XML or JSON format
	public Alien createAlien(Alien a1) {
		System.out.println("am primit : " + a1);
		
		repo.create(a1);
		
		return a1;
	}
	
	
//updating	
	@PUT
	@Path("alien")  //aliens/alien
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON}) // send data in bouth XML or JSON format
	public Alien updateAlien(Alien a1) {
		System.out.println("am primit : " + a1);
		repo.create(a1);
		
		return a1;
	}

	//delete
	@DELETE 
	@Path("alien/{id}") //http://localhost:8080/demorest/webapi/aliens/alien/101
	public Alien deleteAlien(@PathParam("id") int id) {
		Alien a = repo.getAlien(id);
		if(a.getId() != 0) {
			
		}
		
		repo.delete(id);
		return a;
	}

}
