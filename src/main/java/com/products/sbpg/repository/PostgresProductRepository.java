/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


	/**
	 * Recupera todos los producto que matchean con aTerm usando full-text search
	 * 
	 * @param aTerm es el termino a utilizar en la búsqueda
	 * @return una lista de productos
	 */
	@Query(nativeQuery = true, value="SELECT * FROM products p WHERE tsvector_search @@ tsquery(:aTerm)") 
	List<Product> search(@Param("aTerm") String aTerm);

}
