package dannypht.springframework.spring_7_webapp.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String publisherName;

  private String address;

  private String city;

  private String state;

  private String zip;

  @ToString.Exclude
  @OneToMany(mappedBy = "publisher")
  private Set<Book> books = new HashSet<>();

    @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass())
      return false;

    Publisher publisher = (Publisher) o;
    return Objects.equals(id, publisher.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
