/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.services;

import java.util.List;

import com.fi.bm.automaticirrigationsystem.models.Configuration;
import com.fi.bm.automaticirrigationsystem.models.Plot;

/**
 * This is for Plot Service operations.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

public interface IPlotService {

	/**
	 * Add New Plot
	 * 
	 * @param plot
	 * @return Plot
	 * @throws
	 */
	public Plot addNewPlot(Plot plot);

	/**
	 * Configure Plot
	 * 
	 * @param plotId, conf
	 * @return Plot
	 * @throws
	 */
	public Plot configurePlot(String plotId, Configuration conf);

	/**
	 * Edit Plot
	 * 
	 * @param plotId, plotNewName
	 * @return Plot 
	 * @throws
	 */
	public Plot editPlotName(String plotId, String plotNewName);

	/**
	 * List All Plots With Details
	 * 
	 * @param plot
	 * @return List<Plot>
	 * @throws
	 */
	public List<Plot> listAllPlotsWithDetails();
}
