/**
 * Este paquete contiene las clases que definen la api rest de la aplicación.
 */
package com.products.sbpg.controller.impl;

import org.slf4j.*;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.sbpg.SbpgApplication;
import com.products.sbpg.controller.IProductController;
import com.products.sbpg.dto.ProductSearchDTO;
import com.products.sbpg.exception.ResourceNotFoundException;
import com.products.sbpg.model.Product;
import com.products.sbpg.service.IProductService;

import java.util.List;
import java.util.Optional;

/**
 * Esta clase presenta los diferentes "endpoints" de la api rest para gestionar productos.
 * 
 * @author Borrelli Franco Martín
 * @author Carbone José Ignacio
 *
 */
@RestController
@RequestMapping("/api/postgres")
public class PostgresProductController implements IProductController {
    // for logging
	private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);
	
	/**
	 * Es el servicio relacionado con los productos.
	 */
	@Inject
	@Qualifier("postgres")
	private IProductService productsService;

	@GetMapping("/products/search/{term}")
	public ProductSearchDTO searchProducts(@PathVariable(value = "term") String aTerm) {
		StopWatch watch = new StopWatch();
		watch.start();
		List<Product> products =this.productsService.search(aTerm);
		watch.stop();
		return new ProductSearchDTO(products, watch.getLastTaskTimeMillis());
	}

	@GetMapping("/products/search-only-by-product/{term}")
	public ProductSearchDTO searchProductsOnlyByProducts(@PathVariable(value = "term") String aTerm) {
		StopWatch watch = new StopWatch();
		watch.start();
		List<Product> products = this.productsService.searchByProductOnly(aTerm);
		watch.stop();
		return new ProductSearchDTO(products, watch.getLastTaskTimeMillis());
	}
	
  @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable(value = "id") long productId) throws ResourceNotFoundException {
        logger.info("getting product with id: {}", productId);
        return this.productsService.findById(productId);
    }

	// private IProductService getProductsService() {
	// 	return this.productsService;
	// }

}
