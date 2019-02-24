package restfulEjercicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/personas/")
public class Personas {
	public static ArrayList<Persona> personas = new ArrayList<>();

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response guardar(Persona p) {
		this.personas.add(p);
		return Response.ok(p).build();
	}

	@GET
	@Path("person")
	@Produces(MediaType.TEXT_PLAIN)
	public String ver(@QueryParam("persona") String nombre) {
		String coinciden = "Viendo personas que coincidan con " + nombre;
		for (Persona p : personas) {
			if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
				coinciden += System.getProperty("line.separator") + p.toString();
			}
		}
		return coinciden;
	}

	@GET
	@Path("buscar/{query}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Persona> verQ(@DefaultValue("Juan") @QueryParam("query") String query) {
		ArrayList<Persona> coinciden = new ArrayList<>();
		for (Persona p : personas) {
			if (p.getNombre().equals(query)) {
				coinciden.add(p);
			}
		}
		return coinciden;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Persona> listar() {
		return personas;
	}

	@POST
	@Path("add")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadePersonas(ArrayList<Persona> nuevasPersonas) {
		for (Persona p : nuevasPersonas) {
			personas.add(p);
		}
		return Response.ok("Añadidas personas a la lista").build();
	}

	/*
	 * FORMULARIO UTILIZADO <html> <body> <form method="POST"
	 * action="http://127.0.0.1:8080/restfulEjercicios/rest/personas"> <h2>Introduce
	 * persona</h2> <label>Id: </label> <input type="number" name="id" /> <br/>
	 * <br/> <label>Nombre: </label> <input type="text" name="nombre" /> <br/> <br/>
	 * <label>Casado: </label> Si<input type="radio" name="casado"
	 * value="true"/>No<input type="radio" name="casado" value="false"/> <br/> <br/>
	 * <label>Sexo: </label> <input type="text" name="sexo"/> <br/> <br/> <input
	 * type="submit" value="Enviar consulta" /> </form> </body> </html>
	 */

	@POST
	@Path("form")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadePersonas(@FormParam("id") int id, @FormParam("nombre") String nombre,
			@FormParam("casado") boolean casado, @FormParam("sexo") String sexo) {
		Persona p = new Persona();
		p.setId(id);
		p.setNombre(nombre);
		p.setCasado(casado);
		p.setSexo(sexo);
		personas.add(p);
		return Response.ok("Añadida persona").build();
	}

	@GET
	@Path("id/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String borraPersona(@PathParam("id") String id) {
		int cont = 0;
		try {
			int idInt = Integer.parseInt(id);
			for (Persona p : personas) {
				if (p.getId() == idInt) {
					personas.remove(p);
					cont++;
				}
			}
		} catch (NumberFormatException e) {
			return "Esto no es una id, y no se ha podido encontrar la persona";
		}
		return "Se han borrado " + cont + " personas";
	}

	@GET
	@Path("XML/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response personaXML(@PathParam("id") String id) {
		Persona coincide = null;
		try {
			int idInt = Integer.parseInt(id);
			for (Persona p : personas) {
				if (p.getId() == idInt) {
					coincide = p;
				}
			}
		} catch (NumberFormatException e) {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		if(coincide == null) {
			return Response.noContent().build();
		}
		return Response.ok(coincide).build();
	}
	
	

}
