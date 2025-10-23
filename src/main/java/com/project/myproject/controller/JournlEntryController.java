package com.project.myproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@RestController 
@RequestMapping("/journal")
public class JournlEntryController {


  private Map<Long, JournalEntry> journalEntries =new HashMap<>();

  @GetMapping//http://localhost:8080/journal
   public List<JournalEntry> getAll() {
          return new ArrayList<>(journalEntries.values());
   }


   @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
    
    //http://localhost:8080/journal
    journalEntries.put(myEntry.getId(), myEntry);
         return true;

   }
   @GetMapping("id/{myId}")
   //@pathVariable <datatype> <variable name given in getmapping>
   public JournalEntry getJournalEntryByIdEntry(@PathVariable long myId){
   return  journalEntries.get(myId);
   }
  @DeleteMapping("id/{myId}")
   public JournalEntry deleteJournalEntryById(@PathVariable long myId){
    return journalEntries.remove(myId);

   }
   
 @PutMapping
 //yaha pe hamne reqparams use kra hai jiske wjh se putmapping pe hme endpoint define krne k zroort n pdi
   public JournalEntry updateJournalEntryById(@RequestParam long id,@RequestBody JournalEntry myEntry){
    return  journalEntries.put(id ,myEntry);

   }
   
}
