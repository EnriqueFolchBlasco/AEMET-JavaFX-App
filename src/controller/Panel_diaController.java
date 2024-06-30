package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.MunicipioNoExiste;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import modelo.Database;
import modelo.Dia;

public class Panel_diaController {

	
    @FXML
    private AnchorPane cielo_;

    @FXML
    private Label cielo_title;

    @FXML
    private Label direccion_v_label;

    @FXML
    private ImageView estado_img;
    
    @FXML
    private ImageView viento_img;

    @FXML
    private Label estado_label;

    @FXML
    private Label fecha_label;

    @FXML
    private Label fecha_title;

    @FXML
    private Label humedad_max_label;

    @FXML
    private Label humedad_min_label;

    @FXML
    private Label precipi_label;

    @FXML
    private Label precipitaciones_label;

    @FXML
    private Label precipitaciones_title;

    @FXML
    private Label senst_max_label;

    @FXML
    private Label senst_min_label;

    @FXML
    private Label temperatura_max_label;

    @FXML
    private Label temperatura_min_label;

    @FXML
    private Label temperatura_title;

    @FXML
    private Label temperatura_title1;

    @FXML
    private Label temperatura_title11;

    @FXML
    private Label temperatura_title1111;

    @FXML
    private Label temperatura_title12;

    @FXML
    private Label temperatura_title121;

    @FXML
    private Label temperatura_title2;

    @FXML
    private Label temperatura_title21;

    @FXML
    private Label temperatura_title3;

    @FXML
    private Label uv_label;

    @FXML
    private Label velocidad_v_label;

	
    public void mostrar(Dia dia){

 
        	temperatura_max_label.setText(dia.getTemperatura_dia().getTemperatura_max());
        	temperatura_min_label.setText(dia.getTemperatura_dia().getTemperatura_min());
        	estado_label.setText(dia.getEstado_cielo_dia().getEstado());
        	fecha_label.setText(dia.getFecha());
        	velocidad_v_label.setText(dia.getViento_dia().getVelocidad());
        	direccion_v_label.setText(dia.getViento_dia().getDireccion());
        	senst_min_label.setText(dia.getTemperatura_dia().getSens_termica_min());
        	senst_max_label.setText(dia.getTemperatura_dia().getSens_termica_max());
        	humedad_max_label.setText(dia.getHumedad_dia().getHumedad_max());
        	humedad_min_label.setText(dia.getHumedad_dia().getHumedad_min());
        	
            File file2 = new File("src/viento/" + dia.getViento_dia().getDireccion() + ".png");
    		Image image2 = new Image(file2.toURI().toString());
    		viento_img.setImage(image2);
        	
            File file = new File("src/iconos/" + dia.getEstado_cielo_dia().getNumero() + ".png");
    		Image image = new Image(file.toURI().toString());
    		estado_img.setImage(image);
    		


    	


        
        
    	try {
    		
    		if (dia.getProb_pre().equals("null")) {
            	//uv_label.setText("  N/A");
			} else {
				precipi_label.setText(dia.getProb_pre() + "%");
			}
    		 
		} catch (NullPointerException e) {
			precipi_label.setText("N/A");
		}
    	
    	try {
    		
    		if (dia.getUv().equals("null")) {
            	//uv_label.setText("  N/A");
			} else {
		    	uv_label.setText("UV: "+ dia.getUv());
			}
    		
		} catch (NullPointerException e) {
        	uv_label.setText("  N/A");

		}
    	

    }
    
    
    
    public void amagar(boolean a) {

    	cielo_.setVisible(a);

    }
	

}
