package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Author;
import service.AuthorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/authors")
public class AuthorController {
    

	private final AuthorService authorService;
    
	public AuthorController(AuthorService authorService) { 
        this.authorService = authorService;
    }
	
    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Author> createAuthor(@RequestBody String nameAuthor) {
        Author author = authorService.createAuthor(nameAuthor);
        return ResponseEntity.ok(author);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthorById(@PathVariable Long id) {
        Optional<Author> optionalAuthor = authorService.findAuthorById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            return ResponseEntity.ok(author);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Author>> findAllAuthors() {
        List<Author> authors = authorService.findAllAuthors();
        return ResponseEntity.ok(authors);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long id) {
        authorService.deleteAuthorById(id);
        return ResponseEntity.noContent().build();
    }
}

