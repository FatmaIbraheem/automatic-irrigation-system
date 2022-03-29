/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fi.bm.automaticirrigationsystem.models.Plot;

/**
 * This is for Plot Repository.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

public interface IPlotRepository extends MongoRepository<Plot, String> {
}
