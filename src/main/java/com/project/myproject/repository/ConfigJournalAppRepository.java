package com.project.myproject.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.myproject.entity.ConfigJournalApp;


public interface ConfigJournalAppRepository  extends MongoRepository<ConfigJournalApp,ObjectId> {

}
