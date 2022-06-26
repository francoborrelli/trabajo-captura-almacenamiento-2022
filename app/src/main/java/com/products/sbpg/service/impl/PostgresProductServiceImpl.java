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
import com.products.sbpg.dto.ProductDTO;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.PostgresProductRepository;
import com.products.sbpg.repository.PostgresBrandRepository;
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
@Qualifier("postgres")
public class PostgresProductServiceImpl implements IProductService {

	/**
	 * Es el repositorio ligado a los productos.
	 */
	@Inject
	private PostgresProductRepository productRepository;

	/**
	 * Es el repositorio ligado a las marcas.
	 */
	@Inject
	private PostgresBrandRepository brandRepository;

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
		return StreamSupport
		.stream(this.getProductRepository().search(aTerm, PageRequest.of(0, 100)).getContent().spliterator(), false)
		.collect(Collectors.toList());
	}

	/**
	 * Recupera los productos que matcheen con full text search solo en los campos de producto
	 * 
	 * @return Lista de Product.
	 */
	public List<Product> searchByProductOnly(String aTerm) {
		return StreamSupport
		.stream(this.getProductRepository().search(aTerm, PageRequest.of(0, 100)).getContent().spliterator(), false)
		.collect(Collectors.toList());
	}

	public Optional<Product> findById(long anId) {
		return this.getProductRepository().findById(anId);
	}

	/**
	 * Agrega un nuevo producto.
	 * 
	 * @param aName      	es el nombre del producto.
	 * @param aDescription 	es el nombre de producto del nuevo producto.
	 * @param brandId 	    es el identificador de la marca del producto.
	 * @return un DTO que representa al producto recientemente creado.
	 */
	public ProductDTO addProduct(String aName, String aDescription, long brandId) {

		Product newProduct = new Product(aName, aDescription, brandRepository.findById(brandId).get());

		this.getProductRepository().save(newProduct);

		return this.getDtoFactory().createProductDTO(newProduct);
	}

	/**
	 * Getter.
	 * 
	 * @return el repositorio de productos.
	 */
	public PostgresProductRepository getProductRepository() {
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

	/**
	 * Edita el nombre de un producto.
	 * 
	 * @param id   es el identificador del producto.
	 * @param name es el nuevo nombre.
	 */
	public void editProduct(long id, String name) {
		try {
			Product product = this.getProductRepository().findById(id).get();
			System.out.println("version actual " + product.version);
			System.out.println("sleeping");
			Thread.sleep(30000);
			System.out.println("waking up");
			product.setName(name);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
