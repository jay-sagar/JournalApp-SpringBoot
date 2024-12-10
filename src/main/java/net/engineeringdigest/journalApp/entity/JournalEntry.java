package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

// lombok:
/*
    It aims to reduce the boilerplate code that developers have to write, such as getter, setters,
    constructors, and more.
    Lombok achieves this by generating this code automatically during compilation, based on annotations you add to your
    java classes
    It generates bytecode for methods like getters, setters, constructors, equals(), hashcode(), and toString(), as specified
    by the annotations used in your code. This generated code is added to the compiled class files (.class files)
    The java compiler compiles your classes, including the generated code. this means that the generated methods become part of your
    compile class files.
    when you run your applications, the generated methods are available for use, just like any other methods in your classes
 */

@Document(collection = "journal_entries") // create collection in mongodb
@NoArgsConstructor
@Data // it generates all Annotation below
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@EqualsAndHashCode
public class JournalEntry {
    @Id // gives unique key
    private ObjectId id; // mongodb datatype

    @NonNull
    private String title;

    private String content;

    private LocalDateTime date;

//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}
