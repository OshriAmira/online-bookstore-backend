package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ContactMessage;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
}
