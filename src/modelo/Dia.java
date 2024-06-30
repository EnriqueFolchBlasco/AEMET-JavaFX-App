package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Dia {
	
//	String fecha;
	
//	String prob_precipitaciones;
//	String cota_nieve_prob;
//	String estado_cielo;
	
	//Clase Viento
//	String viento_direccion;
//	String viento_velocidad;
	
	//Clase Temperatura
//	String temperatura_max;
//	String temperatura_min;
//	String intervalos_temperatura;
//	String sens_termica_max;
//	String sens_termica_min;
	
	//Clase Humedad
		//	String humedad_max;
		//	String humead_min;
	
	
	
//	String uv;
	
	public ArrayList<String> datos;
	String fecha;
	String uv;
	String prob_pre;
	EstadoCielo estado_cielo_dia;
	Humedad humedad_dia;
	Temperatura temperatura_dia;
	Viento viento_dia;
	Horario horario;
	
	public Dia() {
		super();
		this.datos = new ArrayList<String>();
		this.fecha = fecha;
		this.estado_cielo_dia = estado_cielo_dia;
		this.humedad_dia = humedad_dia;
		this.temperatura_dia = temperatura_dia;
		this.viento_dia = viento_dia;
		this.uv = uv;
		this.prob_pre = prob_pre;
		this.horario = horario;

	}
	

	public ArrayList<String> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<String> datos) {
		datos = datos;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public EstadoCielo getEstado_cielo_dia() {
		return estado_cielo_dia;
	}

	public void setEstado_cielo_dia(EstadoCielo estado_cielo_dia) {
		this.estado_cielo_dia = estado_cielo_dia;
	}

	public Humedad getHumedad_dia() {
		return humedad_dia;
	}

	public void setHumedad_dia(Humedad humedad_dia) {
		this.humedad_dia = humedad_dia;
	}

	public Temperatura getTemperatura_dia() {
		return temperatura_dia;
	}

	public void setTemperatura_dia(Temperatura temperatura_dia) {
		this.temperatura_dia = temperatura_dia;
	}

	public Viento getViento_dia() {
		return viento_dia;
	}

	public void setViento_dia(Viento viento_dia) {
		this.viento_dia = viento_dia;
	}

	public String getUv() {
		return uv;
	}

	public void setUv(String uv) {
		this.uv = uv;
	}

	@Override
	public String toString() {
		return "Dia [datos=" + datos + ", fecha=" + fecha + ", estado_cielo_dia=" + estado_cielo_dia + ", humedad_dia="
				+ humedad_dia + ", temperatura_dia=" + temperatura_dia + ", viento_dia=" + viento_dia + "]" + uv + horario;
	}


	public String getProb_pre() {
		return prob_pre;
	}


	public void setProb_pre(String prob_pre) {
		this.prob_pre = prob_pre;
	}


	public Horario getHorario() {
		return horario;
	}


	public void setHorario(Horario horario) {
		this.horario = horario;
	}






	

	
}
