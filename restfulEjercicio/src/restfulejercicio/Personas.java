package restfulejercicio;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personas")
public class Personas {
	public static ArrayList<Persona> personas = new ArrayList<>();
	
	@POST
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response guardar(Persona p) {
		this.personas.add(p);
		return Response.ok(p).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Persona> listar(){
		return personas;
	}
	
	@GET
	@Path("personas/{persona}")
	@Produces(MediaType.TEXT_PLAIN)
	public String ver(@PathParam("persona") String nombre) {
		String coinciden = "Viendo personas que coincidan con "+nombre;
		for(Persona p:personas) {
			if(p.getNombre().contains(nombre)) {
				coinciden += System.getProperty("line.separator")+p.toString();
			}
		}
		return coinciden;
	}
}
