/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.models;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * This is for Irrigation Time Slot model.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

@Data
@Document(collection = "irrigation_time_slot")
public class IrrigationTimeSlot implements Serializable {

	@Id
	@Indexed
	private String irrigationTimeSlotId;

	private String irrigationTimeSlotName;

//	public IrrigationTimeSlot(String irrigationTimeSlotName) {
//		this.irrigationTimeSlotName = irrigationTimeSlotName;
//	}
}
