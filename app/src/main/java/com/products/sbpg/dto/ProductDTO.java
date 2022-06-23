/**
 * Este paquete contiene las clases que se utilizan para transferir información de las 
 * distintas instancias entre capas.
 */
package com.products.sbpg.dto;

import com.products.sbpg.model.Product;

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
	 * Es la marca del producto.
	 */
	private BrandDTO brand;

	/**
	 * Constructor.
	 * 
	 * @param aProduct     es el producto.
	 */
	public ProductDTO(Product aProduct) {
		this.setId(aProduct.getId());
		this.setName(aProduct.getName());
		this.setDescription(aProduct.getDescription());
		this.setBrand(new BrandDTO(aProduct.getBrand()));
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
	 * @return la descripcion de este producto.
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
	 * @return la marca de este producto.
	 */
	public BrandDTO getBrand() {
		return this.brand;
	}

	/**
	 * Setter.
	 * 
	 * @param aBrand es la marca de este producto.
	 */
	public void setBrand(BrandDTO aBrand) {
		this.brand = aBrand;
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
}
