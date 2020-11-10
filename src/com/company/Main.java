package com.company;


import clases.CapacidadEndedudamiento;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

import javax.swing.JOptionPane;
import clases.Constant;


public class Main {
    
	
	
    public static void main(String[] args) {
    	//definición de variables
    	int gasFijos=0;
    	int gasVariables=0;
    	int ingMensuales = 0;
    	String capEndeudamiento;
        
    	CapacidadEndedudamiento endeudamiento = new CapacidadEndedudamiento();
        
    	String entrada = "SI";
        String valor = "";
        String tipo = "N";
        while (entrada.equals("SI")) {
        	
        	tipo = "N";
        	//Solicita los ingresos
        	valor = imprimir(Constant.TEXTO_INGRESOS, tipo);
        	ingMensuales = Integer.parseInt(valor);
        	endeudamiento.setIngresosTotales(ingMensuales);
            
            //Solicita los gastos fijos
        	valor = imprimir(Constant.TEXTO_GASTOS_FIJOS, tipo);
            gasFijos = Integer.parseInt(valor);
            endeudamiento.setGastosFijos(gasFijos);
            
            //Solicita los gastos variables
            valor = imprimir(Constant.TEXTO_GASTOS_VARIABLES, tipo);
            gasVariables = Integer.parseInt(valor);
            endeudamiento.setGastoVaribales(gasVariables);
            
            //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto 
            capEndeudamiento = endeudamiento.getCapacidadEndeudamiento(endeudamiento.getIngresosTotales(),
            		endeudamiento.getGastosFijos(),
            		endeudamiento.getGastoVaribales());
            System.out.println(Constant.TEXTO_CAPACIDAD_ENDEUDAMIENTO + capEndeudamiento);
            
            tipo = "A";
            entrada = imprimir(Constant.TEXTO_CONTINUAR, tipo);
            while ( !entrada.equals("SI") && !entrada.equals("NO")) {
            	entrada = imprimir(Constant.TEXTO_CONTINUAR, tipo);
            }
            
        }
        
    }

    public static boolean isNumeric(String value) {
        
        try {
        	Double.parseDouble(value);
        	return true;
        	
        }
        catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,Constant.TEXTO_MENSAJE_ERROR_NUMERICO,
					"Error",
					JOptionPane.ERROR_MESSAGE);
        	
        	return false;
			
		}
        
    }
    
    public static String imprimir(String message, String tipo) {
    	String value;
    	
    	Scanner in = new Scanner(System.in);
    	
    	System.out.println(message);
    	value = in.nextLine();
        
    	if (tipo == "N") {
			while (isNumeric(value)==false) {
				System.out.println(message);
				value = in.nextLine();
		    }
    	}
		
		return value;
        
    }
    
    public static boolean evaluaEntrada(String val) {
            	
        if (val.equals("NO")) { 
        	return true;
        }
        else {
        	return false;
        }
    }
}
