/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fi.bm.automaticirrigationsystem.models.Configuration;
import com.fi.bm.automaticirrigationsystem.models.Plot;
import com.fi.bm.automaticirrigationsystem.repository.IPlotRepository;
import com.fi.bm.automaticirrigationsystem.services.IPlotService;

/**
 * This is for Plot Service operations.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@Service
public class PlotService implements IPlotService {

	@Autowired
	private IPlotRepository plotRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Plot addNewPlot(Plot plot) {
		return plotRepository.save(new Plot(plot.getPlotName(), plot.getPlotConfiguration()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Plot configurePlot(String plotId, Configuration conf) {
		Optional<Plot> plotOpt = plotRepository.findById(plotId);

		if (plotOpt.isPresent()) {
			plotOpt.get().setPlotConfiguration(conf);
		}

		return plotRepository.save(plotOpt.get());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Plot editPlotName(String plotId, String plotNewName) {
		Optional<Plot> plotOpt = plotRepository.findById(plotId);

		if (plotOpt.isPresent()) {
			plotOpt.get().setPlotName(plotNewName);
		}

		return plotRepository.save(plotOpt.get());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Plot> listAllPlotsWithDetails() {//ofset
		return plotRepository.findAll();
	}
}
