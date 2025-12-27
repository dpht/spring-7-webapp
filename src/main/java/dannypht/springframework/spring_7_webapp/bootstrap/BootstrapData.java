package dannypht.springframework.spring_7_webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dannypht.springframework.spring_7_webapp.domain.Author;
import dannypht.springframework.spring_7_webapp.domain.Book;
import dannypht.springframework.spring_7_webapp.domain.Publisher;
import dannypht.springframework.spring_7_webapp.repositories.AuthorRepository;
import dannypht.springframework.spring_7_webapp.repositories.BookRepository;
import dannypht.springframework.spring_7_webapp.repositories.PublisherRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  @Override
  public void run(String... args) throws Exception {

    Publisher publisher1 = new Publisher();
    publisher1.setPublisherName("Pearson");
    publisher1.setAddress("123 Main Street");

    Publisher savedPublisher1 = publisherRepository.save(publisher1);

    Author author1 = new Author();
    author1.setFirstName("John");
    author1.setLastName("Lennon");

    Book book1 = new Book();
    book1.setTitle("Domain Driven Design");
    book1.setIsbn("123456");
    book1.setPublisher(savedPublisher1);

    Author author2 = new Author();
    author2.setFirstName("George");
    author2.setLastName("Harrison");

    Book book2 = new Book();
    book2.setTitle("Spring in Action");
    book2.setIsbn("654321");
    book2.setPublisher(savedPublisher1);

    Author savedAuthor1 = authorRepository.save(author1);
    Book savedBook1 = bookRepository.save(book1);

    Author savedAuthor2 = authorRepository.save(author2);
    Book savedBook2 = bookRepository.save(book2);

    savedAuthor1.getBooks().add(savedBook1);
    savedAuthor2.getBooks().add(savedBook2);

    authorRepository.save(savedAuthor1);
    authorRepository.save(savedAuthor2);

    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());
    System.out.println("Publisher Count: " + publisherRepository.count());
    System.out.println("Bootstrap data loaded successfully");
  }
}
