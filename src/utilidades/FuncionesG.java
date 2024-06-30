package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class FuncionesG {
	
	
	public static HashMap<String, String> ListaCodigos = new HashMap<>();
	public static HashMap<String, String> ListaCodigosComunidades = new HashMap<>();
	public static HashMap<String, String> ListaProvincias = new HashMap<>();
	public static HashMap<String, String> ListaMunicipios = new HashMap<>();

	public static void cargarCodigosFichero() {
		
		String linea;
		ListaCodigos.clear();
		try {
			
			Scanner scanner = new Scanner(new File("diccionario.txt"));

			scanner.nextLine();
			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				
				linea = scanner.nextLine();
				String v [] = linea.split("	");
				//ListaCodigos.put(v[4], v[0] + v[1] + v[2] + v[3]);
				ListaCodigos.put(v[4], v[1] + v[2] );
				//ListaCodigos = codigo aemet

			}
			
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No esta el fichero de listas");
		}
		
		
	}
	
	public static void cargarCodigosFicheroComunidades() {
		
		String linea;
		try {
			
			Scanner scanner = new Scanner(new File("comunitats.txt"));

//			scanner.nextLine();
//			scanner.nextLine();
			
			while (scanner.hasNextLine()) {
				
				linea = scanner.nextLine();
				String v [] = linea.split("	");
				ListaCodigosComunidades.put(v[1], v[0] );
				//05 	Canarias
				
				
			}
			
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No esta el fichero de listas");
		}
		
		
	}

	public static void sacarProvinciasMedianteCodigo(String codigo) {
		//El codigo es la comunidad aut
		String linea;
		

		try {
			
			Scanner scanner = new Scanner(new File("provincies.txt"));

//			scanner.nextLine();
//			scanner.nextLine();
			ListaProvincias.clear();

			while (scanner.hasNextLine()) {
				
				linea = scanner.nextLine();
				String v [] = linea.split("	");
				
				if (v[0].equals(codigo)) {
					ListaProvincias.put(v[3], v[2] );

					
					//01	Andalucía	29	Málaga

				}
				
				
				
			}
			
//			for (Entry<String, String> entry : ListaProvincias.entrySet()) {
//				System.out.println(entry.getKey() + " "+entry.getValue());
//			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No esta el fichero de provincies.txt");
		}
		
		
	}

	public static void sacarMunicipiosMedianteCodigo(String codigo) {
		//El codigo es la provincia ej Alicant
		String linea;
		ListaMunicipios.clear();
		System.out.println("ListaMunicipios es:" + ListaMunicipios.size());
		try {
			
			Scanner scanner = new Scanner(new File("diccionario.txt"));

			scanner.nextLine();
			scanner.nextLine();
			
			System.out.println("El codigo 2 es:"+ codigo);
			while (scanner.hasNextLine()) {
				
				linea = scanner.nextLine();
				String v [] = linea.split("	");
				
				if (v[1].equals(codigo)) {
					ListaMunicipios.put(v[4], v[2] );

					//CODAUTO	CPRO	CMUN	DC	NOMBRE
					//16	      01	037  	6	Arraia-Maeztu
					// 0           1     2       3     4 				 posc.vector

				}
				
				
				
			}
			System.out.println("ListaMunicipios2 es:" + ListaMunicipios.size());

			
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("No esta el fichero de provincies.txt");
		}
		
		
	}
	
	public static HashMap<String, String> getListaCodigos() {
		return ListaCodigos;
	}


	public static void setListaCodigos(HashMap<String, String> listaCodigos) {
		ListaCodigos = listaCodigos;
	}


	public static HashMap<String, String> getListaCodigosComunidades() {
		return ListaCodigosComunidades;
	}


	public static void setListaCodigosComunidades(HashMap<String, String> listaCodigosComunidades) {
		ListaCodigosComunidades = listaCodigosComunidades;
	}


	public static HashMap<String, String> getListaProvincias() {
		return ListaProvincias;
	}


	public static void setListaProvincias(HashMap<String, String> listaProvincias) {
		ListaProvincias = listaProvincias;
	}


	public static HashMap<String, String> getListaMunicipios() {
		return ListaMunicipios;
	}


	public static void setListaMunicipios(HashMap<String, String> listaMunicipios) {
		ListaMunicipios = listaMunicipios;
	}


	

	
	
}
