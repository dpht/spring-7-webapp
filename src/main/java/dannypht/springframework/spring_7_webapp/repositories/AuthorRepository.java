package dannypht.springframework.spring_7_webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import dannypht.springframework.spring_7_webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
