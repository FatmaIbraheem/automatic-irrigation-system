/**
 * 
 */
package com.fi.bm.automaticirrigationsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fi.bm.automaticirrigationsystem.models.Configuration;

/**
 * This is for Configuration Repository.
 * 
 * @author Fatma Ibrahim
 * @since 23-03-2022
 *
 */

public interface IConfigurationRepository extends MongoRepository<Configuration,String> {

}
