package com.project.myproject.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.myproject.entity.JournalEntry;
import com.project.myproject.services.JournalEntryService;

@RestController 
@RequestMapping("/journal")
public class JournlEntryControllerV2 {
  //jounralentryservice ko call krwana hai controller me to hm autowire use krenge autowire object bana deta hai aur dependency ko inject kr deta in springboot 
  @Autowired
  private JournalEntryService journalEntryService;

//http://localhost:8080/journal
  @GetMapping 
   public List<JournalEntry> getAll() {
       return journalEntryService.getAll();
   }


   @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
      try {
         myEntry.setDate(LocalDateTime.now());
      journalEntryService.saveEntry(myEntry);
      return new ResponseEntity<>(HttpStatus.CREATED);
      } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
     
   }
   @GetMapping("id/{myId}")
   //@pathVariable <datatype> <variable name given in getmapping>
   public ResponseEntity<JournalEntry>  getJournalEntryByIdEntry(@PathVariable ObjectId myId){
      Optional<JournalEntry>journalEntry=journalEntryService.findById(myId);
      if(journalEntry.isPresent()){
         return new ResponseEntity<>(journalEntry.get(),HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
  @DeleteMapping("id/{myId}")
   public ResponseEntity<?>deleteJournalEntryById(@PathVariable ObjectId myId){
    journalEntryService.deleteById(myId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);


   }
   
 @PutMapping
 //yaha pe hamne reqparams use kra hai jiske wjh se putmapping pe hme endpoint define krne k zroort n pdi
   public JournalEntry updateJournalEntryById(@RequestParam ObjectId id,@RequestBody JournalEntry newEntry){
     JournalEntry old=journalEntryService.findById(id).orElse(null);
     if(old !=null){
        old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
        old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
     }
      journalEntryService.saveEntry(old);
      
    
      return old;
   
   }
   
}
