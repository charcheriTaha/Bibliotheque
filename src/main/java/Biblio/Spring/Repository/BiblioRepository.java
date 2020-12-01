package Biblio.Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Biblio.Spring.Entity.Bibliotheque;

@Repository("BiblioRepository")
public interface BiblioRepository extends JpaRepository <Bibliotheque, Long>{

}
