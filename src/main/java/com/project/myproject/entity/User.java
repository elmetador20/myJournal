package com.project.myproject.entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;




  @Document(collection="users")
  @Data
  public class User{

    @Id
     private ObjectId id;
     @Indexed(unique=true)//indexing de die jisse username unique rhega hmara searching fast ho jaega
     @NonNull//null nhi hone chaiye isliye ye use kr rhe hai lombok ki annotation hai
     private String userName;
     @NonNull
     private String password;
     @DBRef//refrence create kr rhe hai user collections ke andr journalentries ka

     private List<JournalEntry> journalEntries=new ArrayList<>();
  }




