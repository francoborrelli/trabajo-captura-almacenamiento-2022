/**
 * Este paquete contiene las clases que se utilizan para transferir información de las 
 * distintas instancias entre capas.
 */
package com.products.sbpg.dto;

/**
 * Las instancias de esta clase se utilizan para transferir información de los
 * productos.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
public class ProductDTO {

	/**
	 * Identificador de cada una de las instancias.
	 */
	private long id;

	/**
	 * Es el nombre del producto.
	 */
	private String name;

	/**
	 * Es la descripción del producto.
	 */
	private String description;

	/**
	 * Es la versión del producto.
	 */
	private int version;

	/**
	 * Es la marca del producto.
	 */
	private BrandDTO brand;

	/**
	 * Constructor.
	 * 
	 * @param anId       	es el identificador del producto.
	 * @param aName 		es el nombre del producto.
	 * @param aDescription  es la descripción del producto.
	 * @param aVersion   	es la versión del producto.
	 * @param brand   		es la marca del producto.
	 */
	public ProductDTO(long anId, String aName, String aDescription, int aVersion) {
		this.setId(anId);
		this.setName(aName);
		this.setDescription(aDescription);
		this.setVersion(aVersion);
	}

	/**
	 * Getter.
	 * 
	 * @return el identificador de esta instancia.
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter.
	 * 
	 * @param anId es el identificador de esta instancia.
	 */
	public void setId(long anId) {
		this.id = anId;
	}

	/**
	 * Getter.
	 * 
	 * @return el username de este producto.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter.
	 * 
	 * @param aDescription es la descripcion de este producto.
	 */
	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	/**
	 * Getter.
	 * 
	 * @return el nombre del producto.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter.
	 * 
	 * @param aName es el nombre del producto.
	 */
	public void setName(String aName) {
		this.name = aName;
	}

	/**
	 * Getter.
	 * 
	 * @return la versión del producto.
	 */
	public int getVersion() {
		return this.version;
	}

	/**
	 * Setter.
	 * 
	 * @param version es la versión del producto.
	 */
	private void setVersion(int version) {
		this.version = version;
	}

}
