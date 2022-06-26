/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.products.sbpg.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.products.sbpg.dto.DTOFactory;
import com.products.sbpg.model.Product;
import com.products.sbpg.search.ElasticProductRepository;
import com.products.sbpg.service.IProductService;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * productos.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@Service
@Transactional
@Qualifier("elastic")
public class ElasticProductServiceImpl implements IProductService {

	/**
	 * Es el repositorio ligado a los productos.
	 */
	@Inject
	private ElasticProductRepository productRepository;

	/**
	 * Es el objeto encargado de crear los DTOs.
	 */
	@Inject
	private DTOFactory dtoFactory;


	/**
	 * Recupera los productos que matcheen con full text search
	 * 
	 * @return Lista de Product.
	 */
	public List<Product> search(String aTerm) {
		return	StreamSupport
			.stream(this.getProductRepository().findByNameOrDescriptionOrBrandName(aTerm, aTerm, aTerm, PageRequest.of(0, 100)).getContent().spliterator(), false)
			.collect(Collectors.toList());
	}


	public Optional<Product> findById(long anId) {
		return this.getProductRepository().findById(anId);
	}

	/**
	 * Getter.
	 * 
	 * @return el repositorio de productos.
	 */
	public ElasticProductRepository getProductRepository() {
		return this.productRepository;
	}

	/**
	 * Getter.
	 * 
	 * @return el objeto que debe utilizarse para crear los DTOs.
	 */
	public DTOFactory getDtoFactory() {
		return this.dtoFactory;
	}
}
