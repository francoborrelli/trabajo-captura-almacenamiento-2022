/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.sbpg.model.Product;

/**
 * Clase que representa el repositorio de productos.
 *
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *  
 */
@Repository
public interface PostgresProductRepository extends JpaRepository<Product, Long> {

	/**
	 * Recupera un producto por su nombre.
	 * 
	 * @param aName es el nombre del producto.
	 * @return el producto con el nombre dado.
	 */
	public Product findByName(String aName);
}