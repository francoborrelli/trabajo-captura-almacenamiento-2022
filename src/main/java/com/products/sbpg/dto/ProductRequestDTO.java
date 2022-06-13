/**
 * Este paquete contiene todos los objetos que se utilizan para representar los pedidos enviados
 * como parte del cuerpo (body).
 */
package com.products.sbpg.dto;

/**
 * Las instancias de esta clase se utilizan para representar los datos
 * requeridos para el alta de un producto.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */

public class ProductRequestDTO {

	/**
	 * Es el id del producto.
	 */
	public long id;

	/**
	 * Es el nombre del producto.
	 */
	public String name;

	/**
	 * Es la descripción del nuevo producto.
	 */
	public String description;

	/**
	 * Es la el identificador de la marca del producto.
	 */
	public long brandId;

	/**
	 * Constructor.
	 * 
	 * @param id      		es el identificador del producto.
	 * 
	 * @param name     		es el nombre del producto.
	 * @param description 	es la descripción del nuevo producto.
	 */
	public ProductRequestDTO(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

}
