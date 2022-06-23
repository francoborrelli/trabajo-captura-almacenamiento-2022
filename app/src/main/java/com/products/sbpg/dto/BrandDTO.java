/**
 * Este paquete contiene las clases que se utilizan para transferir información de las 
 * distintas instancias entre capas.
 */
package com.products.sbpg.dto;

import com.products.sbpg.model.Brand;

/**
 * Las instancias de esta clase se utilizan para transferir información de las
 * marcas.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
public class BrandDTO {

	/**
	 * Identificador de cada una de las instancias.
	 */
	private long id;

	/**
	 * Es el nombre de la marca.
	 */
	private String name;

	/**
	 * Es la versión de la marca.
	 */
	// private int version;

	/**
	 * Constructor.
	 * 
	 * @param anId       	es el identificador de la marca.
	 * @param aName 		es el nombre de la marca.
	 */
	public BrandDTO(Brand aBrand) {
		this.setId(aBrand.getId());
		this.setName(aBrand.getName());
	}

	/**
	 * Constructor.
	 * 
	 * @param anId       	es el identificador de la marca.
	 * @param aName 		es el nombre de la marca.
	 */
	public BrandDTO(long anId, String aName) {
		this.setId(anId);
		this.setName(aName);
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
	 * @return el nombre de la marca.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter.
	 * 
	 * @param aName es el nombre de la marca.
	 */
	public void setName(String aName) {
		this.name = aName;
	}

	/**
	 * Getter.
	 * 
	 * @return la versión de la marca.
	 */
	// public int getVersion() {
	// 	return this.version;
	// }

	/**
	 * Setter.
	 * 
	 * @param version es la versión de la marca.
	 */
	// private void setVersion(int version) {
	// 	this.version = version;
	// }

}
