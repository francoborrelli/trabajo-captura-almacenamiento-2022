/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 */
package com.products.sbpg.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Clase que representa a la entidad del producto.
 * 
 *
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */

@Entity(name = "Product")
@Table(name = "products")
public class Product {

	/**
	 * Es el identificador de cada instancia.
	 */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	 * Un producto tiene una marca
	 */
   	@ManyToOne
    @JoinColumn(name="brand_id", nullable=false)
    private Brand brand;

	/**
	 * Es la versión del usuario.
	 * 
	 */
	@Version
	public int version;

	/**
	 * Constructor. No utilizar.
	 */
	public Product() {
	}

	/**
	 * Constructor.
	 * 
	 * @param aName 		es el nombre del producto.
	 * @param aDescription  es la descripción del producto.
	 * @param aBrand		es la marca del producto.
	 */
	public Product(String aName, String aDescription, Brand aBrand) {
		this.setName(aName);
		this.setBrand(aBrand);
		this.setDescription(aDescription);
	}

	/**
	 * Getter.
	 * 
	 * @return el identificador de esta instancia.
	 */
    public long getId() {
        return id;
    }

	/**
	 * Setter.
	 * 
	 * @param anId es el identificador de esta instancia.
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return la descripción del producto.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Setter.
	 * 
	 * @param aDescription es la descripción del producto.
	 */
	public void setDescription(String aDescription) {
		this.description = aDescription;
	}

	/**
	 * Getter.
	 * 
	 * @return la marca del producto.
	 */
	public Brand getBrand() {
		return this.brand;
	}

	/**
	 * Setter.
	 * 
	 * @param aBrand es la marca del producto.
	 */
	public void setBrand(Brand aBrand) {
		this.brand = aBrand;
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
	public void setVersion(int version) {
		this.version = version;
	}

}
