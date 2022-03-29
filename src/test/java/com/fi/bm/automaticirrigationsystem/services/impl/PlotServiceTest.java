/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.services.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fi.bm.automaticirrigationsystem.models.Configuration;
import com.fi.bm.automaticirrigationsystem.models.IrrigationTimeSlot;
import com.fi.bm.automaticirrigationsystem.models.Plot;
import com.fi.bm.automaticirrigationsystem.repository.IPlotRepository;
import com.fi.bm.automaticirrigationsystem.services.IPlotService;

/**
 * @author fatma Ibrahim
 *
 */
@SpringBootTest
public class PlotServiceTest {
	@Autowired
	IPlotService iPlotService;

	@MockBean
	IPlotRepository plotRepository;

	List<Plot> plotLst = new ArrayList<Plot>();
	Plot plot;
	Configuration plotConfiguration = new Configuration();
	Optional<Plot> plotOpt;

	List<Plot> plotLstRs = new ArrayList<Plot>();
	Plot plotRs;
	Configuration plotConfigurationRs = new Configuration();

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IrrigationTimeSlot a_irrigationTimeSlot = new IrrigationTimeSlot();
		a_irrigationTimeSlot.setIrrigationTimeSlotId("11");
		a_irrigationTimeSlot.setIrrigationTimeSlotName("a_irrigationTimeSlot");

		IrrigationTimeSlot b_irrigationTimeSlot = new IrrigationTimeSlot();
		b_irrigationTimeSlot.setIrrigationTimeSlotId("12");
		b_irrigationTimeSlot.setIrrigationTimeSlotName("b_irrigationTimeSlot");

		List<IrrigationTimeSlot> irrigationTimeSlotLst = new ArrayList<IrrigationTimeSlot>();
		irrigationTimeSlotLst.add(a_irrigationTimeSlot);
		irrigationTimeSlotLst.add(b_irrigationTimeSlot);

		plotConfiguration.setAmountOfWater(5.50);
		plotConfiguration.setConfId("1");
		plotConfiguration.setIrrigationTimeSlotLst(irrigationTimeSlotLst);

		plot = new Plot("plotName", plotConfiguration);

		plotOpt.get().setPlotConfiguration(plotConfiguration);
		plotOpt.get().setPlotId(plot.getPlotId());
		plotOpt.get().setPlotName(plot.getPlotName());

		IrrigationTimeSlot a_irrigationTimeSlotRs = new IrrigationTimeSlot();
		a_irrigationTimeSlotRs.setIrrigationTimeSlotId("11");
		a_irrigationTimeSlotRs.setIrrigationTimeSlotName("a_irrigationTimeSlot");

		IrrigationTimeSlot b_irrigationTimeSlotRs = new IrrigationTimeSlot();
		b_irrigationTimeSlotRs.setIrrigationTimeSlotId("12");
		b_irrigationTimeSlotRs.setIrrigationTimeSlotName("b_irrigationTimeSlot");

		List<IrrigationTimeSlot> irrigationTimeSlotLstRs = new ArrayList<IrrigationTimeSlot>();
		irrigationTimeSlotLstRs.add(a_irrigationTimeSlotRs);
		irrigationTimeSlotLstRs.add(b_irrigationTimeSlotRs);

		plotConfigurationRs.setAmountOfWater(5.50);
		plotConfigurationRs.setConfId("1");
		plotConfigurationRs.setIrrigationTimeSlotLst(irrigationTimeSlotLst);

		plotRs = new Plot("plotName", plotConfigurationRs);
	}

	/**
	 * Test method for
	 * {@link com.fi.bm.automaticirrigationsystem.services.impl.PlotService#addNewPlot(com.fi.bm.automaticirrigationsystem.models.Plot)}.
	 */
	@Test
	public void testAddNewPlot() {
		given(plotRepository.save(plot)).willReturn(plot);

		plotRs = iPlotService.addNewPlot(plot);
		assertNotNull(plotRs);
	}

	/**
	 * Test method for
	 * {@link com.fi.bm.automaticirrigationsystem.services.impl.PlotService#configurePlot(java.lang.String, com.fi.bm.automaticirrigationsystem.models.Configuration)}.
	 */
	@Test
	public void testConfigurePlot() {
		given(plotRepository.findById(plot.getPlotId())).willReturn(plotOpt);

		Optional<Plot> plotOpt = plotRepository.findById(plot.getPlotId());

		if (plotOpt.isPresent()) {
			plotOpt.get().setPlotConfiguration(plotConfiguration);
		}

		given(plotRepository.save(plotOpt.get())).willReturn(plot);

		plotRs = iPlotService.configurePlot(plot.getPlotId(), plotConfiguration);
		assertNotNull(plotRs);
	}

	/**
	 * Test method for
	 * {@link com.fi.bm.automaticirrigationsystem.services.impl.PlotService#editPlotName(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testEditPlotName() {
		given(plotRepository.findById(plot.getPlotId())).willReturn(plotOpt);

		if (plotOpt.isPresent()) {
			plotOpt.get().setPlotName("plotNewName");
		}

		given(plotRepository.save(plotOpt.get())).willReturn(plot);

		plotRs = iPlotService.editPlotName(plot.getPlotId(), "plotNewName");
		assertNotNull(plotRs);
	}

	/**
	 * Test method for
	 * {@link com.fi.bm.automaticirrigationsystem.services.impl.PlotService#listAllPlotsWithDetails()}.
	 */
	@Test
	public void testListAllPlotsWithDetails() {
		given(plotRepository.findAll()).willReturn(plotLst);

		plotLstRs = iPlotService.listAllPlotsWithDetails();
		assertNotNull(plotLstRs);
	}

}
