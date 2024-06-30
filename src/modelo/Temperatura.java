package modelo;

public class Temperatura {
	
	String temperatura_max;
	String temperatura_min;
		
	String sens_termica_max;
	String sens_termica_min;
	
	public Temperatura(String temperatura_max, String temperatura_min, String sens_termica_max, String sens_termica_min) {
		super();
		this.temperatura_max = temperatura_max;
		this.temperatura_min = temperatura_min;
		this.sens_termica_max = sens_termica_max;
		this.sens_termica_min = sens_termica_min;
	}



	public String getTemperatura_max() {
		return temperatura_max;
	}

	public void setTemperatura_max(String temperatura_max) {
		this.temperatura_max = temperatura_max;
	}

	public String getTemperatura_min() {
		return temperatura_min;
	}

	public void setTemperatura_min(String temperatura_min) {
		this.temperatura_min = temperatura_min;
	}



	public String getSens_termica_max() {
		return sens_termica_max;
	}

	public void setSens_termica_max(String sens_termica_max) {
		this.sens_termica_max = sens_termica_max;
	}

	public String getSens_termica_min() {
		return sens_termica_min;
	}

	public void setSens_termica_min(String sens_termica_min) {
		this.sens_termica_min = sens_termica_min;
	}



	@Override
	public String toString() {
		return "Temperatura [temperatura_max=" + temperatura_max + ", temperatura_min=" + temperatura_min
				+ ", sens_termica_max=" + sens_termica_max + ", sens_termica_min=" + sens_termica_min + "]";
	}
	
	
	
	
}
