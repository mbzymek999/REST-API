package demo.domain.newsletter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface NewsletterRepository extends JpaRepository<Newsletter, Integer> {

    Optional<Newsletter> findByClientId(String clientId);

    Boolean existsByEmail(String email);
}
