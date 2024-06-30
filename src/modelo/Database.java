package modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import utilidades.FuncionesG;

public class Database {
	
	private String poblacion;
	private String codigo;
	public HashMap<String, String> ListaCodigos;
	//public HashMap<Integer, Dia> listaDias;
	public static ArrayList<Dia> listaDias;

	public Database(String poblacion) {
		//this.ListaCodigos = new HashMap<>();
		this.listaDias = new ArrayList<Dia>();

		this.poblacion = poblacion;
		this.codigo = "";
		
		listaDias.clear();
		for (int i = 1; i < 8; i++) {
			Dia dia = new Dia();
			listaDias.add(dia);
		}
		
		pasarMunicipioACodigo();
	}

	public void informacionXML() {
			
		
		
			try {
				//File fxmlFile = new File("localidad_46035.xml");

				File fxmlFile = new File("localidad_" + this.codigo + ".xml");
				
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				
				Document doc = dBuilder.parse(fxmlFile);
				
				doc.getDocumentElement().normalize();
				NodeList listaDias = doc.getElementsByTagName("dia");
				
				for (int i = 0; i < listaDias.getLength(); i++) {
					
					
					Node elementoDia = listaDias.item(i);
					Element diaElement = (Element) elementoDia;
					
					//System.out.println(diaElement.getAttribute("fecha") + "----------------------------");
					
					
					//this.listaDias.get(i).

					
					//Sacar la temperatura
					NodeList nTemp = diaElement.getElementsByTagName("temperatura");
					Node temperatura = nTemp.item(0);
					Element eTemp = (Element) temperatura;
//					System.out.println("Temperatura Maxima:" + eTemp.getElementsByTagName("maxima").item(0).getTextContent());
//					System.out.println("Temperatura Minima:" + eTemp.getElementsByTagName("minima").item(0).getTextContent());
//					System.out.println();
					
					//Sacar la sens_temperatura
					NodeList nSensT = diaElement.getElementsByTagName("sens_termica");
					Node sensTermica = nSensT.item(0);
					Element eSens = (Element) sensTermica;
//					System.out.println("Sensibilidad Temperatura Maxima:" + eSens.getElementsByTagName("maxima").item(0).getTextContent());
//					System.out.println("Sensibilidad Minima:" + eSens.getElementsByTagName("minima").item(0).getTextContent());
//					System.out.println();
					
					
					//Sacar la humedad_termica
					NodeList nhumedadT = diaElement.getElementsByTagName("humedad_relativa");

					Node humedadTermica = nhumedadT.item(0);
					
					Element eHumedad = (Element) humedadTermica;
//					System.out.println("Humedad Maxima:" + eHumedad.getElementsByTagName("maxima").item(0).getTextContent());
//					System.out.println("Humedad Minima:" + eHumedad.getElementsByTagName("minima").item(0).getTextContent());
//					System.out.println();
					
					
					NodeList dato = eHumedad.getElementsByTagName("dato");

					for (int j = 0; j < dato.getLength(); j++) {
						Node hora = dato.item(j);
						Element horaS = (Element) hora;
							//System.out.println(horaS.getAttribute("hora") + "-"+ dato.item(j).getTextContent());
					}
					
					//Estado cielo
					//System.out.println("\n ESTADO CIELO \n");
						
					String[] vec = new String[7];
					
					NodeList listaCielos = diaElement.getElementsByTagName("estado_cielo");
					for (int j = 0; j < listaCielos.getLength(); j++) {
						Node eCielo = listaCielos.item(j);
						Element elementCielo = (Element) eCielo;
						//System.out.println(elementCielo.getAttribute("periodo") + " - " + elementCielo.getAttribute("descripcion")+ " - " + elementCielo.getTextContent());
						
						if (i == 0) {
							vec[j] = elementCielo.getAttribute("descripcion");
						}

					}
					
					
					Horario hor = new Horario(vec[0],vec[1],vec[2],vec[3],vec[4],vec[5],vec[6]);
					this.listaDias.get(0).setHorario(hor);
					
					//While true ASQUEROSOOOO, para sacar el primer dato del estado de cielo
					int j2 = 0;
					while (true) {
					    if (j2 >= listaCielos.getLength()) {
					        break;
					    }
					    
					    Node eCielo = listaCielos.item(j2);
					    Element elementCielo = (Element) eCielo;
					    
					    if (!(elementCielo.getAttribute("descripcion").isEmpty())) {
					    	EstadoCielo c = new EstadoCielo(elementCielo.getAttribute("descripcion"), elementCielo.getTextContent());
							this.listaDias.get(i).setEstado_cielo_dia(c);
							break;
						}
						
					    j2++;

					}
					
					
					//While true ASQUEROSOOOO, para sacar el primer dato de la prob lluvia
					NodeList listaProb = diaElement.getElementsByTagName("prob_precipitacion");
					
					int j4 = 0;
					while (true) {
					    if (j2 >= listaProb.getLength()) {
					        break;
					    }
					    
					    Node ePro = listaProb.item(j4);
					    Element elementPro = (Element) ePro;
					    
					    if (!(elementPro.getTextContent().isEmpty())) {
					    	this.listaDias.get(i).setProb_pre(elementPro.getTextContent());
							break;
						}
						
					    j4++;

					}
					
					//Viento
					//System.out.println("\n VIENTO");
					NodeList listaVientos = diaElement.getElementsByTagName("viento");
					for (int j = 0; j < listaVientos.getLength(); j++) {
						Node nodoViento = listaVientos.item(j);
						Element elementViento = (Element) nodoViento;
//						System.out.println(elementViento.getAttribute("periodo"));
//						System.out.println("Direccion: "+elementViento.getElementsByTagName("direccion").item(0).getTextContent());
//						System.out.println("Velocidad: "+elementViento.getElementsByTagName("velocidad").item(0).getTextContent());
//						System.out.println();
					}
					
					
					//While true ASQUEROSOOOO, para sacar el primer dato del viento
					int j3 = 0;
					while (true) {
					    if (j3 >= listaCielos.getLength()) {
					        break;
					    }
					    
					    Node nodoViento = listaVientos.item(j3);
						Element elementViento = (Element) nodoViento;
					    
					    if (!(elementViento.getElementsByTagName("direccion").item(0).getTextContent().isEmpty())) {
					    	Viento v = new Viento(elementViento.getElementsByTagName("direccion").item(0).getTextContent(),elementViento.getElementsByTagName("velocidad").item(0).getTextContent());
					    	this.listaDias.get(i).setViento_dia(v);
							break;
						}
						
					    j3++;

					}
					
					
					
					
					
					NodeList nmax = doc.getElementsByTagName("uv_max");
					Node elementoUv = nmax.item(i);
					Element uvEl = (Element) elementoUv;

					//DATOS TO LABEL
					this.listaDias.get(i).setFecha(diaElement.getAttribute("fecha"));
					
					//HUMEAD
					Humedad h = new Humedad(eHumedad.getElementsByTagName("maxima").item(0).getTextContent(),eHumedad.getElementsByTagName("minima").item(0).getTextContent());
					this.listaDias.get(i).setHumedad_dia(h);
					
					//int temperatura_max, int temperatura_min, int sens_termica_max, int sens_termica_min
					Temperatura temp = new Temperatura(eTemp.getElementsByTagName("maxima").item(0).getTextContent(),eTemp.getElementsByTagName("minima").item(0).getTextContent(),eSens.getElementsByTagName("maxima").item(0).getTextContent(),eSens.getElementsByTagName("minima").item(0).getTextContent());
					this.listaDias.get(i).setTemperatura_dia(temp);
					//eTemp.getElementsByTagName("maxima").item(0).getTextContent(),eTemp.getElementsByTagName("minima").item(0).getTextContent(),eSens.getElementsByTagName("maxima").item(0).getTextContent(),eSens.getElementsByTagName("minima").item(0).getTextContent()));

					Humedad hum = new Humedad(eHumedad.getElementsByTagName("maxima").item(0).getTextContent(),eHumedad.getElementsByTagName("minima").item(0).getTextContent());
					this.listaDias.get(i).setHumedad_dia(hum);

					// uv = uvEl.getTextContent();
					if (!(uvEl == null)) {
						this.listaDias.get(i).setUv(uvEl.getTextContent());
					}
					
					

					
				}
				
			
//				for (Dia dia : this.listaDias) {
//					System.out.println(dia);
//				}
				
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
	
		public void descargar_crear_XML() {
		System.out.println("Link: https://www.aemet.es/xml/municipios/localidad_" + this.codigo + ".xml");
		try {
							//https://www.aemet.es/xml/municipios/localidad_46035.xml
			URL url = new URL("https://www.aemet.es/xml/municipios/localidad_" + this.codigo + ".xml");
			Scanner s = new Scanner( url.openStream() );
			
			String fichero = "localidad_" + this.codigo + ".xml";
			PrintWriter pw = new PrintWriter(new File(fichero));
			
			String linea;
			
			
			while (s.hasNext()) {
				
				linea = s.nextLine();
				
				pw.println(linea);
				
				
			}
			
			pw.close();
			
		} catch (IOException e) {
			System.out.println("Ha aparecido un problema en la obtencion de datos del XML");
		}
		
	}

	
	public void pasarMunicipioACodigo() {
		this.codigo = FuncionesG.ListaCodigos.get(poblacion);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public HashMap<String, String> getListaCodigos() {
		return ListaCodigos;
	}

	public void setListaCodigos(HashMap<String, String> listaCodigos) {
		ListaCodigos = listaCodigos;
	}

	public ArrayList<Dia> getListaDias() {
		return listaDias;
	}

	public void setListaDias(ArrayList<Dia> listaDias) {
		this.listaDias = listaDias;
	}



	
	
	
	
	
}


