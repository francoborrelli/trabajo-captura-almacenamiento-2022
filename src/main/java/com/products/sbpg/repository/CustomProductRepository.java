/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.repository;

/**
 * Esta interface define el comportamiento extra que debe cumplir un repositorio
 * de usuarproductos.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
public interface CustomProductRepository {

	/**
	 * Obtiene la cantidad de productos que tienen el mismo nombre.
	 * 
	 * @return el número de productos.
	 */
	public int getNumberOfProductsThatHasTheSameName();
}
