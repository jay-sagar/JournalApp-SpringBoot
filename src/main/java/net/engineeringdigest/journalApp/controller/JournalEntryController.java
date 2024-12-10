//package net.engineeringdigest.journalApp.controller;
//
//import net.engineeringdigest.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal") // maps the whole class, end point will be journal/xxx
//public class JournalEntryController {
//
//    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping // localhost:8080/journal GET
//    public List<JournalEntry> getAll() {
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping // localhost:8080/journal POST
//    public boolean createEntry(@RequestBody JournalEntry myEntry) {
//        // @RequestBody it's say hey spring, please take the data from the request and turn into a java object
//        //              that I can use
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId) {
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteJournalEntryById(@PathVariable Long myId) {
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{id}")
//    public JournalEntry updateJournalById(@PathVariable long id, @RequestBody JournalEntry myEntry) {
//        return journalEntries.put(id, myEntry);
//    }
//}
