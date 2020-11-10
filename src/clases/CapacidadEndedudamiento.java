package clases;

public class CapacidadEndedudamiento {
    Integer ingresosTotales;
    Integer gastosFijos;
    Integer gastoVariables;
    final double POR_FIJO = 0.35;

    //Metodos getter and setter para la clase
    
	/**
	 * @return the ingresosTotales
	 */
	public Integer getIngresosTotales() {
		return ingresosTotales;
	}

	/**
	 * @param ingresosTotales the ingresosTotales to set
	 */
	public void setIngresosTotales(Integer ingresosTotales) {
		this.ingresosTotales = ingresosTotales;
	}

	/**
	 * @return the gastosFijos
	 */
	public Integer getGastosFijos() {
		return gastosFijos;
	}

	/**
	 * @param gastosFijos the gastosFijos to set
	 */
	public void setGastosFijos(Integer gastosFijos) {
		this.gastosFijos = gastosFijos;
	}

	/**
	 * @return the gastoVaribales
	 */
	public Integer getGastoVaribales() {
		return gastoVariables;
	}

	/**
	 * @param gastoVaribales the gastoVaribales to set
	 */
	public void setGastoVaribales(Integer gastoVariables) {
		this.gastoVariables = gastoVariables;
	}

    //Construye un metodo que retorne una cadena con las propiedades de la clase

    public String getCapacidadEndeudamiento(int ingresos, int gasFijos, int gasVariables) {
        // retornar la capacidad de endeudamiento puede ser una cadena con el valor
    	
    	int endeudamiento = (int) ((ingresos - (gasFijos + gasVariables)) * POR_FIJO);
        String capacidadEndeudamiento = Integer.toString(endeudamiento);
      	return capacidadEndeudamiento;
    }
 
}
