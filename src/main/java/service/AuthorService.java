package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.Author;
import repository.AuthorRepository;

@Service
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public Author createAuthor(Author nameAuthor) {
        Author author = new Author(nameAuthor.getName());
        return authorRepository.save(author);
    }

    
    public Optional<Author> findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }
    
    public Optional<Author> findAuthorById(Long id) {
        return authorRepository.findById(id);
    }
    
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    
    public void deleteAuthorById(Long id) {
        authorRepository.deleteById(id);
    }
}
