/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.services.impl;

import java.io.InputStream;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fi.bm.automaticirrigationsystem.models.Configuration;
import com.fi.bm.automaticirrigationsystem.repository.IConfigurationRepository;
import com.fi.bm.automaticirrigationsystem.services.IConfigurationService;

/**
 * This is for Configuration Service operations.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@Service
public class ConfigurationService implements IConfigurationService {

	@Autowired
	IConfigurationRepository configurationRepository;

	/**
	 * {@inheritDoc}
	 */
	@PostConstruct
	@Override
	public List<Configuration> addConfigurations() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Configuration>> typeReference1 = new TypeReference<List<Configuration>>() {
		};

		InputStream inputStream1 = TypeReference.class.getResourceAsStream("/json/configurationsData.json");
		try {
			List<Configuration> configurationLst = mapper.readValue(inputStream1, typeReference1);
			return configurationRepository.saveAll(configurationLst);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
