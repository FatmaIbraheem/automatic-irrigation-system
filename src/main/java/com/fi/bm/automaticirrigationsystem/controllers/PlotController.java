/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fi.bm.automaticirrigationsystem.models.Plot;
import com.fi.bm.automaticirrigationsystem.services.IPlotService;

/**
 * This is for Plot Controller.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@RestController
@RequestMapping("/plot")
public class PlotController {
	@Autowired
	private IPlotService plotService;

	@PostMapping(path = "/addNewPlot")
	public Plot addNewPlot(Plot plot) {
		return plotService.addNewPlot(plot);
	}

	@PostMapping(path = "/configurePlot")
	public Plot configurePlot(Plot plot) {
		return plotService.configurePlot(plot.getPlotId(), plot.getPlotConfiguration());
	}

	@PostMapping(path = "/editPlot")
	public Plot editPlotName(Plot plot) {
		return plotService.editPlotName(plot.getPlotId(), plot.getPlotName());
	}

	@GetMapping(path = "/listAllPlotsWithDetails")
	public List<Plot> listAllPlotsWithDetails() {
		return plotService.listAllPlotsWithDetails();
	}
}
