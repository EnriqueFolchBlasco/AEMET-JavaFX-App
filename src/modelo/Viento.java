package modelo;

public class Viento {

	String direccion;
	String velocidad;
	
	public Viento(String direccion, String velocidad) {
		super();
		this.direccion = direccion;
		this.velocidad = velocidad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	
}
