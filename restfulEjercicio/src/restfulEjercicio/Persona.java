package restfulEjercicio;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
	private int id;
	private String nombre;
	private boolean casado;
	private String sexo;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	@XmlAttribute
	public int getId() {
		return this.id;
	}
	
	@XmlAttribute
	public String getNombre() {
		return this.nombre;
	}
	
	@XmlAttribute
	public boolean getCasado() {
		return this.casado;
	}
	
	@XmlAttribute
	public String getSexo() {
		return this.sexo;
	}
}
