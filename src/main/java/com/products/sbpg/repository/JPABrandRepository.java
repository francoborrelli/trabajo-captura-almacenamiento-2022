/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.products.sbpg.model.Brand;

/**
 * Clase que representa el repositorio de brand.
 *
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *  
 */
@Repository
public interface JPABrandRepository extends JpaRepository<Brand, Long> {

	/**
	 * Recupera una marca por su nombre.
	 * 
	 * @param aName es el nombre de la marca.
	 * @return la marca con el nombre dado.
	 */
	public Optional<Brand> findOneByName(String aName);

	/**
	 * Recupera o crea una marca por su nombre.
	 * 
	 * @param aName es el nombre de la marca.
	 * @return la marca con el nombre dado.
	 */
    @Transactional
    public default Brand findOrCreate(String aName) {
		return this.findOneByName(aName).orElseGet(() ->this.saveAndFlush(new Brand(aName)));
    }
}

