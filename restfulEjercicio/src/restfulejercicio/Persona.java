package restfulejercicio;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona {
	
	private int Id;
	private String Nombre;
	private boolean Casado;
	private String Sexo;
	
	public void setId(int id) {
		Id = id;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	public void setCasado(boolean casado) {
		Casado = casado;
	}
	
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	
	public int getId() {
		return Id;
	}
	
	public String getNombre() {
		return Nombre;
	}
	
	public boolean getCasado() {
		return Casado;
	}
	
	public String getSexo() {
		return Sexo;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d Nombre: %s Casado: %s Sexo: %s ", Id,Nombre,Casado,Sexo);
	}
}
