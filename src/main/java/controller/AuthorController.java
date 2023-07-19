package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
import repository.AuthorRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/authors")
public class AuthorController {
    
	private final AuthorRepository authorRepository;
	private final AuthorService authorService;
    
	public AuthorController(AuthorService authorService, AuthorRepository authorRepository) { // Modify the constructor
        this.authorService = authorService;
        this.authorRepository = authorRepository; 
    }
    
//    public AuthorController(AuthorService authorService) {
//        this.authorService = authorService;
//    }
    
//    @PostMapping("/authors")
//    public ResponseEntity<Author> createAuthor(@RequestBody Author nameAuthor) {
//        Author author = authorService.createAuthor(nameAuthor);
//        return ResponseEntity.ok(author);
//    }
    @PostMapping("/authors")
    public Author createAuthor(@RequestBody Author nameAuthor) {
        Author author = new Author(nameAuthor.getName());
        return authorRepository.save(author);
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

