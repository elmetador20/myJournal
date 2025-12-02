package com.project.myproject.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection="confog_journal_app")
@Data
@NoArgsConstructor
public class ConfigJournalApp {

  @NonNull
  private String key;
  private String value;



}
