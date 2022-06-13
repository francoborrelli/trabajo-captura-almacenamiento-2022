/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.products.sbpg.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.products.sbpg.dto.DTOFactory;
import com.products.sbpg.dto.ProductDTO;
import com.products.sbpg.model.Product;
import com.products.sbpg.repository.JPAProductRepository;
import com.products.sbpg.repository.JPABrandRepository;
import com.products.sbpg.service.IProductService;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * productos.
 * 
 * @author Javier Bazzocco
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

	/**
	 * Es el repositorio ligado a los productos.
	 */
	@Inject
	private JPAProductRepository productRepository;

	/**
	 * Es el repositorio ligado a las marcas.
	 */
	@Inject
	private JPABrandRepository brandRepository;

	/**
	 * Es el objeto encargado de crear los DTOs.
	 */
	@Inject
	private DTOFactory dtoFactory;

	/**
	 * Recupera todos los productos
	 * 
	 * @return Lista de Product.
	 */
	public List<Product> findAll() {
		return this.getProductRepository().findAll();
	}


	public Optional<Product> findById(long anId) {
		return this.getProductRepository().findById(anId);
	}

	/**
	 * Agrega un nuevo producto.
	 * 
	 * @param aName      	es el nombre del producto.
	 * @param aDescription 	es la descripción del nuevo producto.
	 * @return un DTO que representa al producto recientemente creado.
	 */
	@Override
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
	public JPAProductRepository getProductRepository() {
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
	@Override
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
