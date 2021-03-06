package restfulEjercicios;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/persona")
public class GestionaPersona {
	
	public static Persona persona;
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Persona leer() {
		if(persona==null) {
			persona = new Persona();
			persona.setNombre("Fulano");
			persona.setCasado(true);
			persona.setId(2);
			persona.setSexo("M");
		}
		return persona;
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Response guardar(Persona p) {
		persona = p;
		return Response.ok(p).build();
	}
}
