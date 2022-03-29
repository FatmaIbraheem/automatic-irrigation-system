/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * This is for Plot model.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@Data
@Document(collection = "plot")
public class Plot {

	@Id
	@Indexed
	private String plotId;

	private String plotName;
	private Configuration plotConfiguration;

	public Plot(String plotName, Configuration plotConfiguration) {
		this.plotName = plotName;
		this.plotConfiguration = plotConfiguration;
	}
}
