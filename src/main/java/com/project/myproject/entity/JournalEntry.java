package com.project.myproject.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

//pojo==pre old java object
// @document spring ko ye batega ki  ye jo h wo mongodb ke collection se mapped entity hai
@Document(collection="journal entries")
public class JournalEntry {
  // @ID se hmne map kr di as a primary key jo age use kia hai Repository me
  @Id 
  private ObjectId id;
  private String title;
  private String content;
  private LocalDateTime date;

 public void setDate(LocalDateTime date) {
    this.date = date;
  }

 public LocalDateTime getDate() {
    return date;
  }

 public ObjectId getId() {
    return id;
  }
 
  public void setId(ObjectId id) {
    this.id = id;
  }
  
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public void setContent(String content) {
    this.content = content;
  }
  
  public String getContent() {
    return content;
  }


}
