/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.products.sbpg.search;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
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
public interface ElasticProductRepository extends ElasticsearchRepository<Product, Long> {

	/**
	 * Recupera un producto por su nombre.
	 * 
	 * @param aName es el nombre del producto.
	 * @return el producto con el nombre dado.
	 */
	public Product findByName(String aName);

	@Override
	public Page<Product> findAll(Pageable pageable);
}
