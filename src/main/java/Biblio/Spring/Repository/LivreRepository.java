package Biblio.Spring.Repository;

import Biblio.Spring.Entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("livreRepository")
public interface LivreRepository extends JpaRepository<Livre, Long>{

}
