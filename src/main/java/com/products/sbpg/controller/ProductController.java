/**
 * Este paquete contiene las clases que definen la api rest de la aplicación.
 */
package com.products.sbpg.controller;

import org.slf4j.*;
import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.sbpg.SbpgApplication;
import com.products.sbpg.dto.ProductRequestDTO;
import com.products.sbpg.model.Product;
import com.products.sbpg.service.IProductService;

import java.util.List;

/**
 * Esta clase presenta los diferentes "endpoints" de la api rest.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    // for logging
	private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);
	
	/**
	 * Es el servicio relacionado con los productos.
	 */
	@Inject
	private IProductService productsService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        logger.info("listing all products...");
        return this.productsService.getAllProducts();
    }

	/**
	 * Endpoint para crear productos.
	 * 
	 * @param anProductRequestDTO dto que contiene la información del producto a crear.
	 * 
	 */
	@PostMapping("/products")
	public void createProduct(@RequestBody ProductRequestDTO anProductRequestDTO) {

		this.getProductsService().addProduct(anProductRequestDTO.name, anProductRequestDTO.description);
	}

	/**
	 * Endpoint para crear productos.
	 * 
	 * @param anProductRequestDTO dto que contiene la información del producto a crear.
	 * 
	 */
	@PutMapping("/products")
	public void editProduct(@RequestBody ProductRequestDTO anProductRequestDTO) {

		this.getProductsService().editProduct(anProductRequestDTO.id, anProductRequestDTO.name);
	}

	/**
	 * Getter.
	 * 
	 * @return el servicio relacionado con los productos.
	 */
	public IProductService getProductsService() {
		return this.productsService;
	}

}
