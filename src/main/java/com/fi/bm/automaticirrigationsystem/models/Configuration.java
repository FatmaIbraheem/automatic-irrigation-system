/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.models;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * This is for Configuration model.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@Data
@Document(collection = "configurations")
public class Configuration implements Serializable {

	@Id
	@Indexed
	private String confId;

	private Double amountOfWater;
	private List<IrrigationTimeSlot> irrigationTimeSlotLst;

//	public Configuration(Double amountOfWater, List<IrrigationTimeSlot> irrigationTimeSlotLst) {
//		this.amountOfWater = amountOfWater;
//		this.irrigationTimeSlotLst = irrigationTimeSlotLst;
//	}
}
