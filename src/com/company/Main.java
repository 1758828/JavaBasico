package com.company;

import clases.CapacidadEndedudamiento;
import javafx.scene.input.KeyCode;

import java.util.Scanner;

import javax.swing.JOptionPane;
import clases.Constantes;


public class Main {
     
    public static void main(String[] args) {
    	//definición de variables
    	int gasFijos=0;
    	int gasVariables=0;
    	int ingMensuales = 0;
    	String capEndeudamiento;
        
    	CapacidadEndedudamiento endeudamiento = new CapacidadEndedudamiento();
        
        Scanner in = new Scanner(System.in);
        
        String entrada = "SI";
        String valor = "";
        while (entrada.equals("SI")) {
        	
        	//Solicita los ingresos
        	System.out.println(Constantes.TEXTO_INGRESOS);
        	valor = in.nextLine();
            if(evaluaEntrada(valor)) {
            	entrada = "NO";
            
            }
            while (isNumeric(valor)==false) {
        		System.out.println(Constantes.TEXTO_INGRESOS);
        		valor = in.nextLine();
        	}
        	ingMensuales = Integer.parseInt(valor);
        	endeudamiento.setIngresosTotales(ingMensuales);
            
            //Solicita los gastos fijos
            System.out.println(Constantes.TEXTO_GASTOS_FIJOS);
            valor = in.nextLine();
            if(evaluaEntrada(valor)) {
            	entrada = "NO";
            }
            while (isNumeric(valor)==false) {
        		System.out.println(Constantes.TEXTO_GASTOS_FIJOS);
        		valor = in.nextLine();
            }
            gasFijos = Integer.parseInt(valor);
            endeudamiento.setGastosFijos(gasFijos);
            
            
            
            //Solicita los gastos variables
            System.out.println(Constantes.TEXTO_GASTOS_VARIABLES);
            valor = in.nextLine();
            if(evaluaEntrada(valor)) {
            	entrada = "NO";
            }
            while (isNumeric(valor)==false) {
        		System.out.println(Constantes.TEXTO_GASTOS_FIJOS);
        		valor = in.nextLine();
            }
            gasVariables = Integer.parseInt(valor);
            endeudamiento.setGastoVaribales(gasVariables);
         
            
            //Esto te dara la primera entrada al proceso de solicitar los datos para instancir nuestro objeto
             
            capEndeudamiento = endeudamiento.getCapacidadEndeudamiento(endeudamiento.getIngresosTotales(),
            		endeudamiento.getGastosFijos(),
            		endeudamiento.getGastoVaribales());
            System.out.println(Constantes.TEXTO_CAPACIDAD_ENDEUDAMIENTO + capEndeudamiento);
            
        }
        in.close();
    }

    public static boolean isNumeric(String value) {
        
        try {
        	Double.parseDouble(value);
        	return true;
        	
        }
        catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null,Constantes.TEXTO_MENSAJE_ERROR_NUMERICO,
					"Error",
					JOptionPane.ERROR_MESSAGE);
        	
        	return false;
			
		}
        
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
