package com.project.myproject.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
//entity me hm db ka data model(schema store krte hai)
//pojo==plain old java object
// @document spring ko ye batega ki  ye jo h wo mongodb ke collection se mapped entity hai
@Document(collection="journal entries")
@Getter
@Setter
public class JournalEntry {
  // @ID se hmne map kr di as a primary key jo age use kia hai Repository me
  @Id
  private ObjectId id;
  private String title;
  private String content;
  private LocalDateTime date;


}
