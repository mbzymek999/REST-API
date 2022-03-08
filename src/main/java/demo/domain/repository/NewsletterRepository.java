package demo.domain.repository;

import demo.domain.entity.Newsletter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {

    Optional<Newsletter> findByIdClient(String idClient);
    Boolean existsByEmail(String email);
}
