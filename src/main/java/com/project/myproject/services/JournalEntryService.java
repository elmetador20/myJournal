package com.project.myproject.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.project.myproject.entity.JournalEntry;
import com.project.myproject.entity.User;
import com.project.myproject.repository.JournalEntryRepository;

@Component
public class JournalEntryService {

  @Autowired
  private JournalEntryRepository journalEntryRepository;
  @Autowired
  private UserService userService;
 
  @Transactional
   public void saveEntry(JournalEntry journalEntry, String userName) {
    try {  
       User user = userService.findbyUserName(userName);
    journalEntry.setDate(LocalDateTime.now());
    JournalEntry saved = journalEntryRepository.save(journalEntry);
    user.getJournalEntries().add(saved);
    userService.saveUser(user);
  }

        
    catch (Exception e) {
      System.out.println(e);
      throw new RuntimeException("an error occired");
    }
  }
 

  public void saveEntry(JournalEntry journalEntry  ) {
    journalEntryRepository.save(journalEntry);
  }

  public List<JournalEntry> getAll() {
    return journalEntryRepository.findAll();
  }

  public Optional<JournalEntry> findById(ObjectId id) {
    return journalEntryRepository.findById(id);
  }

  public void deleteById(ObjectId id, String userName) {
    User user = userService.findbyUserName(userName);
    user.getJournalEntries().removeIf(x -> x.getId().equals(id));
    userService.saveNewUser(user);
    journalEntryRepository.deleteById(id);
  }
}
// controller call krega service ko sservice call krega repository ko