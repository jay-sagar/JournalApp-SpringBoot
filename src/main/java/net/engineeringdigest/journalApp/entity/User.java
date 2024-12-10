package net.engineeringdigest.journalApp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@Builder
public class User {
    @Id
    private ObjectId id;

    @Indexed(unique = true) // it will make all username unique, but it will not create it automatically
    // to create it you have mention in applications.properties => check over there
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @DBRef // it creates reference for Users to refer for JournalEntries
    private List<JournalEntry> journalEntries = new ArrayList<>();

    private List<String> roles;
}
