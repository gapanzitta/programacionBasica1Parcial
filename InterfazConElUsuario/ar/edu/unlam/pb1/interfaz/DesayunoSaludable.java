package ar.edu.unlam.pb1.interfaz;

import java.util.Scanner;


import ar.edu.unlam.pb1.dominio.*;


public class DesayunoSaludable {

	private static String productos []= { "leche", "cafe", "tea","teConLeche","Chocolatada",
										"CafeConLeche","cereales", "frutosSecos", "lacteos",
										"manzana","JugoNaranja", "banana","colacionSinTacc"};
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcionIngresada =0;
		mostrarMensaje("BIENVENIDOS A COMER SALUDABLE ES LO IMPORTANTE");
		
		MixProductosSaludables actual = new MixProductosSaludables("desayuno");
				do {
					mostrarMenu();
					opcionIngresada = teclado.nextInt();
					actual =determinarAccionARealizar( actual, opcionIngresada, teclado);
					 

}while (opcionIngresada !=9);
	}
private static MixProductosSaludables determinarAccionARealizar(MixProductosSaludables actual, int opcionIngresada, Scanner teclado) {
	switch(opcionIngresada) {
	case 1:	
		agregarIngredienteAlaPreparacion(teclado , actual);
		break;
	case 2:
		verListaDeIngredientes(teclado , actual);
		break;
	case 3:
		listaIngrediestesConTopeDeCalorias(teclado , actual);
		break;
	case 4:
		calcularCostoDelDesayuno(teclado , actual);
		break;
	case 9:
		break;
	default: 
		System.out.println("Opcion no contemplada");
		break;
	}
	return actual;
}
private static void mostrarMenu() {
	
	mostrarMensaje("*******************************************************");
	mostrarMensaje("OPERACIONES QUE SE PUEDEN EFECTUAR");
	mostrarMensaje("1- Incorporar ingredientes a la preparaci�n");
	mostrarMensaje("2 -Ver los ingredientes que contiene la preparacion");
	mostrarMensaje("3- Verificar que el dasayuno no supere X cantidad de calorias");
	mostrarMensaje("4- Determinar el costo de una lista de ingredientes seleccionados ");
	mostrarMensaje("9- Salir ");
	mostrarMensaje("*******************************************************");
	mostrarMensaje("Ingrese la opcion deseada ");
	}

private static String mostrarMensaje(String mensaje) {
	System.out.println(mensaje);
	return mensaje;
}

/*
 * Agrega un nuevo ingrediente a la bandeja del desayuno
 * Para trasformar el numero a String se puede usar Integer.toString(numero)
 */
private static void agregarIngredienteAlaPreparacion(Scanner teclado, MixProductosSaludables actual) {
	IngredientesDesayuno nuevoIngrediente;
	// Creo un objeto de tipo ingrediente
	// Agrego el ingrediente a trav[es del m[etodo agregarIngrediente
	nuevoIngrediente = new IngredientesDesayuno();
	System.out.println("Ingrese el nombre del ingrediente");
	nuevoIngrediente.setIngrediente(teclado.next());
	System.out.println("Ingrese el código del ingrediente");
	nuevoIngrediente.setCodigo(teclado.next());
	System.out.println("Ingrese el precio");
	nuevoIngrediente.setPrecio(teclado.nextDouble());
	System.out.println("Ingrese las calorias del ingrediente");
	nuevoIngrediente.setCalorias(teclado.nextInt());
	//String codigo1 ,codigo2,codigo3;
	
	actual.agregarIngrediente(nuevoIngrediente);
	}
	
/*
 * Mostrar la cantidad de productos que estan contenidos en la bandeja del desayuno
 */
private static void verListaDeIngredientes(Scanner teclado, MixProductosSaludables actual ) {
	
	System.out.println(actual.toString());
	
}

/*
 * Realizar un ordenar por el campo precio que contiene la preparaci�n
 */
private static void listaIngrediestesConTopeDeCalorias(Scanner teclado, MixProductosSaludables actual ) {
	
	actual.ordenarPorPrecio();
	System.out.println(actual);
	
}
/*
 * Calcular el costo de la preparaci�n que hemos agregado segun los ingredientes en uso.
 */
private static void calcularCostoDelDesayuno(Scanner teclado, MixProductosSaludables actual ) {

	actual.costoTotalDesayuno();
}
/*
 * Este m�todo retorna el nombre del producto que se encuentra en la lista de productos
 */
private static String obtenerNombreDelIngrediente(int numeroPosicion) {
	
	
return null;
}

private static int generarNumeroAleatorio() {
	int numerosPosibles = 999;
	int aleatorio = (int)(Math.random()*numerosPosibles);
	
	return aleatorio;
}
private static String armarParteAlfabetica(String productos[], int pos) {
	
	return productos[pos].substring(0, 3);
}


	
}
