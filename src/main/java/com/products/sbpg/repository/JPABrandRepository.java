/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.sbpg.model.Brand;

/**
 * Clase que representa el repositorio de brand.
 *
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *  
 */
@Repository
public interface JPABrandRepository extends JpaRepository<Brand, Long>, CustomProductRepository {

	/**
	 * Recupera una marca por su nombre.
	 * 
	 * @param aName es el nombre de la marca.
	 * @return la marca con el nombre dado.
	 */
	public Brand findByName(String aName);

}
