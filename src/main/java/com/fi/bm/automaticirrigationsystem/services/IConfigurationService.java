/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.services;

import java.util.List;

import com.fi.bm.automaticirrigationsystem.models.Configuration;

/**
 * @author fibrahim4
 *
 */

public interface IConfigurationService {
	
	/**
	 * Add Configurations
	 * 
	 * @param 
	 * @return List<Configuration>
	 * @throws
	 */
	List<Configuration> addConfigurations();
}
