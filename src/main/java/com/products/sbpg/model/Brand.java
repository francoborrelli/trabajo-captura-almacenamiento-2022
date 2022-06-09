/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 */
package com.products.sbpg.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Clase que representa a la entidad del marca.
 * 
 *
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */

@Entity(name = "Brand")
@Table(name = "brands")
public class Brand {

	/**
	 * Es el identificador de cada instancia.
	 */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	/**
	 * Es el nombre de la marca.
	 */
	private String name;

	/**
	 * Es la versión del usuario.
	 * 
	 */
	@Version
	public int version;

    @OneToMany(mappedBy = "brand")
    private List<Product> products;

	/**
	 * Constructor. No utilizar.
	 */
	public Brand() {
	}

	/**
	 * Constructor.
	 * 
	 * @param aName es el nombre de la marca.
	 */
	public Brand(String aName) {
		this.setName(aName);
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
	public int getVersion() {
		return this.version;
	}

	/**
	 * Setter.
	 * 
	 * @param version es la versión de la marca.
	 */
	public void setVersion(int version) {
		this.version = version;
	}

}
