package Biblio.Spring.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bibliotheque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Biblio_id")
	long id;
	@Column(name="Nom_Biblio")
	private String nom;
	@Column(name="Adress_Biblio")
	private String adresse;
	@Column(name="Capacite_Biblio")
	private int capacite;

	@OneToMany(mappedBy = "biblio", cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Livre> livres = new HashSet<>();

	public long getId() {
		return id;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;

		for (Livre l : livres) {
			l.setBiblio(this);
		}
	}

}
