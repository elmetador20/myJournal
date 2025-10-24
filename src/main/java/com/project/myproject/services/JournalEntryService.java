package com.project.myproject.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.myproject.entity.JournalEntry;
import com.project.myproject.repository.JournalEntryRepository;
@Component
public class JournalEntryService {

  @Autowired
  private JournalEntryRepository journalEntryRepository;
   
  public void saveEntry(JournalEntry journalEntry){
    journalEntryRepository.save(journalEntry);
  }
  public List<JournalEntry>getAll(){
    return journalEntryRepository.findAll();
  }
  public Optional<JournalEntry> findById(ObjectId id){
    return journalEntryRepository.findById(id);
  }
  public void deleteById(ObjectId id){
    journalEntryRepository.deleteById(id);
  }
}
// controller call krega service ko sservice call krega repository ko 