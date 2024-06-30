package controller;

import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.TreeSet;
import exceptions.MunicipioNoExiste;
import org.controlsfx.control.textfield.TextFields;

import exceptions.MunicipioNoExiste;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Database;
import modelo.Dia;
import utilidades.FuncionesG;

public class AEMETController implements Initializable{
	
	//int codigo = 46035;
	
    @FXML
    private ComboBox<String> comunidades_box;
    
    @FXML
    private ComboBox<String> provincies_box;
    
    @FXML
    private TextField textField_1;
    
    @FXML
    private Button search_b;
	
    @FXML
    private Panel_diaController panelDia_1Controller;
    
    @FXML
    private Panel_diaController panelDia_2Controller;
    
    @FXML
    private Panel_diaController panelDia_3Controller;
    
    @FXML
    private Panel_diaController panelDia_4Controller;
    
    @FXML
    private Panel_diaController panelDia_5Controller;
    
    @FXML
    private Panel_diaController panelDia_6Controller;
    
    @FXML
    private Panel_diaController panelDia_7Controller;
    
    @FXML
    private Label hora1;
    
    @FXML
    private Label hora2;
    
    @FXML
    private Label hora3;
    
    @FXML
    private Label hora4;
    
    @FXML
    private Label hora5;
    
    @FXML
    private Label hora6;
    
    @FXML
    private Label hora7;


	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
		System.out.println("Inicia");
		FuncionesG.cargarCodigosFichero();
//		cargarAutocompletado();
		FuncionesG.cargarCodigosFicheroComunidades();
		provincies_box.setDisable(true);
		textField_1.setDisable(true);
		
		//Engastuos
		panelDia_1Controller.amagar(false);
    	panelDia_2Controller.amagar(false);
    	panelDia_3Controller.amagar(false);
    	panelDia_4Controller.amagar(false);
    	panelDia_5Controller.amagar(false);
    	panelDia_6Controller.amagar(false);
    	panelDia_7Controller.amagar(false);
		
		comunidades_box.setItems(añadirComunidades());


		comunidades_box.getSelectionModel().selectedItemProperty().addListener((comboBox, valorAnterior, valorActual) -> {
			provincies_box.getItems().clear();
			textField_1.clear();
			textField_1.setDisable(true);

			provincies_box.setDisable(false);
			String codigo_com = "";
			
			try {
				codigo_com = comunidadToCodigo(valorActual);
			} catch (MunicipioNoExiste e) {
				System.err.println("NO EXISTE ESE MUNICIPIO");
			}
			//System.out.println(codigo_com);
			
			if (!(codigo_com.equals("NO"))) {
				
				FuncionesG.sacarProvinciasMedianteCodigo(codigo_com);
				provincies_box.setItems(añadirProvincias());
				
			}
			
			FuncionesG.ListaMunicipios.clear();
			
			
		});
		
		provincies_box.getSelectionModel().selectedItemProperty().addListener((comboBox, valorAnterior, valorActual) -> {
			System.out.println(valorActual);

			textField_1.setDisable(false);
			
			String codigo_prov = provinciaToCodigo(valorActual);
//			System.out.println("El codigo es "+ codigo_prov);
			FuncionesG.sacarMunicipiosMedianteCodigo(codigo_prov);
			cargarAutocompletado();

		});
		
		search_b.setOnMouseClicked((event) -> creacionBD());
		

	}
	

	public ObservableList<String> añadirComunidades() {
		
		
        TreeSet<String> nomsComunitats = new TreeSet<String>();
        
		for (Map.Entry<String, String> entry : FuncionesG.getListaCodigosComunidades().entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    
			nomsComunitats.add(entry.getKey());
		    
		}
		
		ObservableList<String> LlistaComunitats = FXCollections.observableArrayList(nomsComunitats);
		return LlistaComunitats;

	}
	
	public ObservableList<String> añadirProvincias() {
		
		
        TreeSet<String> nomsProvincies = new TreeSet<String>();

        for (Map.Entry<String, String> entry : FuncionesG.getListaProvincias().entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    
			nomsProvincies.add(entry.getKey());
		    
		}
		
		ObservableList<String> LlistaProvinciess = FXCollections.observableArrayList(nomsProvincies);

//		for (String string : LlistaProvinciess) {
//			System.out.println(string);
//		}
		
		return LlistaProvinciess;

	}
	
	public String comunidadToCodigo(String comunidad) throws MunicipioNoExiste {
		
		String x = "NO";
		
		for (Map.Entry<String, String> entry : FuncionesG.getListaCodigosComunidades().entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    
			if (entry.getKey().equals(comunidad)) {
				x = entry.getValue();
			}
		    
		}
		
		if (x.equals("NO")) {
			throw new MunicipioNoExiste();
		}
		
		return x;
	}

	public String provinciaToCodigo(String provincia) {
		
		String x = "NO";
		
		for (Map.Entry<String, String> entry : FuncionesG.getListaProvincias().entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
			if (entry.getKey().equals(provincia)) {
				x = entry.getValue();
			}
		    
		}
		
		return x;
	}
	
	public void creacionBD() {
		String poblacio = textField_1.getText();
		System.out.println("La poblacion es: "+poblacio);
		Database database = new Database(poblacio);
		//database.pasarMunicipioACodigo();
		database.descargar_crear_XML();
		database.informacionXML();
		
		
		//Engastuos
		panelDia_1Controller.amagar(true);
    	panelDia_2Controller.amagar(true);
    	panelDia_3Controller.amagar(true);
    	panelDia_4Controller.amagar(true);
    	panelDia_5Controller.amagar(true);
    	panelDia_6Controller.amagar(true);
    	panelDia_7Controller.amagar(true);
    		
    	panelDia_1Controller.mostrar(Database.listaDias.get(0));
    	panelDia_2Controller.mostrar(Database.listaDias.get(1));
    	panelDia_3Controller.mostrar(Database.listaDias.get(2));
    	panelDia_4Controller.mostrar(Database.listaDias.get(3));
    	panelDia_5Controller.mostrar(Database.listaDias.get(4));
    	panelDia_6Controller.mostrar(Database.listaDias.get(5));
    	panelDia_7Controller.mostrar(Database.listaDias.get(6));


    	
    	
	}
	
	public void cargarAutocompletado() {
		
        TreeSet<String> nomsLocalitats = new TreeSet<String>();
        
        //System.out.println("Nom lcoalitats size " +  nomsLocalitats.size());
        for (Map.Entry<String, String> entry : FuncionesG.getListaMunicipios().entrySet()) {
		    //System.out.println("clave=" + entry.getKey() + ", valor=" + entry.getValue());
		    
			nomsLocalitats.add(entry.getKey());
		    
		}
        
		TextFields.bindAutoCompletion(textField_1, nomsLocalitats);	
		
        //System.out.println("Nom lcoalitats 2 size " +  nomsLocalitats.size());

	}
	
}


