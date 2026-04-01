package it.scuola.demo_post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MessageRepository
extends JpaRepository<Message, Long> {
}