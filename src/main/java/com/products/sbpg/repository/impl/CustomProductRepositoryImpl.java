/**
 * Este paquete contiene las implementaciones de los repositorios personalizados.
 */
package com.products.sbpg.repository.impl;

import com.products.sbpg.repository.CustomProductRepository;

/**
 * Esta clase implementa los mecanismos personalizados de recuperación de
 * información.
 * 
 * @author Javier Bazzocco
 *
 */
public class CustomProductRepositoryImpl implements CustomProductRepository {

	/**
	 * Obtiene la cantidad de usuarios que tienen la misma clave.
	 * 
	 * @return el número de usuarios.
	 */
	@Override
	public int getNumberOfProductsThatHasTheSameName() {
// 	resultado de ejemplo. Acá va la consulta real
		return 4;
	}

}
