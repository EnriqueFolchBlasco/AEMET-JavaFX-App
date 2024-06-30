package modelo;

public class Humedad {

	String humedad_max;
	String humedad_min;
	


	public Humedad(String humedad_max, String humedad_min) {
		super();
		this.humedad_max = humedad_max;
		this.humedad_min = humedad_min;

	}


	public String getHumedad_max() {
		return humedad_max;
	}


	public void setHumedad_max(String humedad_max) {
		this.humedad_max = humedad_max;
	}


	public String getHumedad_min() {
		return humedad_min;
	}


	public void setHumedad_min(String humedad_min) {
		this.humedad_min = humedad_min;
	}
	
	
}
