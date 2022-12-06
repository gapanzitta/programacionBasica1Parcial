package ar.edu.unlam.pb1.dominio;


public class MixProductosSaludables {

	private String nombre;
	private IngredientesDesayuno ingredientes[] ;
	private final int TOTAL_MIX_DISPONIBLES =15;
	final int LIMITE_PERMITIDOS_CALORIAS = 2800;
	
	
	public MixProductosSaludables(String nombre) {
		this.nombre = nombre;
		this.ingredientes=new IngredientesDesayuno[TOTAL_MIX_DISPONIBLES];
		
		}
	
	/*
		*Con este metodo se incorporan  ingrediente al desayuno
		*Se necesita incorporar la semilla en base a sus caracter�sticas
		 
	*/
	public boolean agregarIngrediente(IngredientesDesayuno nuevoIngrediente) {
		//IngredientesDesayuno ingredienteExtra = null;
		for(int i=0; i < ingredientes.length ; i++) {
			if(ingredientes[i] == null) {
				ingredientes[i] = nuevoIngrediente;
			}
			return true;
		}
		
		return false;
	}
	

	//Metodo para quitar un ingrediente de la preparaci�n
	
	public boolean eliminarIngrediente(String ingredienteASacar) {
		boolean eliminado= false;
		for(int i = 0; i < ingredientes.length; i++) {
			if(ingredientes[i] == null) {
				if(ingredientes[i].equals(ingredienteASacar)) { 
					ingredientes[i]=null;
					eliminado= true;
			}
			}
		}
		return eliminado;
	}
	// Metodo para calcular si la cantidad de calorias estan en le limite permitido
	
	public boolean caloriasContenidasSonPermitidas(int limiteCalorias) {
		int calorias = 0;
		int caloriasTotales = 0;
		for(int i = 0; i < ingredientes.length ; i++) {
			if(ingredientes[i] != null) {
				caloriasTotales += calorias + ingredientes[i].getCalorias();
			}
		}
		if(caloriasTotales < LIMITE_PERMITIDOS_CALORIAS) {
			return true;
		}
		
		return false;
	}
	//Metodo para calcular el valor total del desayuno seleccionado en la bandeja
	
	public double costoTotalDesayuno () {
		
		double costoProducto = 0.0;
		double costoTotalBandeja = 0.0;
		
		for(int i = 0; i < ingredientes.length ; i++) {
			if(ingredientes[i] != null) {
				//costoProducto = (ingredientes[i].getPrecio());
				costoTotalBandeja = costoTotalBandeja + (ingredientes[i].getPrecio());
			}
		}
		
		return costoTotalBandeja;
	}

	//Metodo toString para ver el listado de ingredientes que componen el desayuno
	public String toString() {
		
		String contiene = " ";
		
		for(int i = 0; i < ingredientes.length; i++) {
			contiene += "\n|";			
				if(ingredientes[i] != null) {
						contiene += ingredientes[i].toString();
				} else {
						contiene += " O |";
					}
				}
		
		return contiene;
	}
	
	public IngredientesDesayuno ordenarPorPrecio() {
		
		IngredientesDesayuno temporal = null;
		for(int i = 1; i < ingredientes.length ; i++) {
			for(int j = 0; j < ingredientes.length ; j++) {
				if(ingredientes[j] != null && ingredientes[i].getPrecio()>ingredientes[j].getPrecio()) {
					temporal = ingredientes[j];
					ingredientes[j] = ingredientes[i];
					ingredientes[i] = temporal;
				}
			}
		}
		return temporal;
	}
			

}
