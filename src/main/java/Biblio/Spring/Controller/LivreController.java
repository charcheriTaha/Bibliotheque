package Biblio.Spring.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Biblio.Spring.Entity.Bibliotheque;
import Biblio.Spring.Entity.Livre;
import Biblio.Spring.Repository.BiblioRepository;
import Biblio.Spring.Repository.LivreRepository;

@RestController
@RequestMapping("/livres")
public class LivreController {

	private final BiblioRepository BR;
	private final LivreRepository LR;

	public LivreController(BiblioRepository bR, LivreRepository lR) {
		super();
		BR = bR;
		LR = lR;
	}

	@RequestMapping(value = "/addLivre", method = RequestMethod.POST)
	public Livre ajouterlivre(@RequestBody Livre livre) {
		return LR.save(livre);
	}

	@GetMapping
	public String getAll() {
		return LR.findAll().toString();
	}


	@RequestMapping(value = "/updateLivre/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Livre> updateLivre(@PathVariable(value = "id") long livre_Id,
			@RequestBody Livre livre_Details) {
		Optional<Livre> optionelEntity = LR.findById(livre_Id);

		Livre livre = optionelEntity.get();

		livre.setTitre(livre_Details.getTitre());
		livre.setAuteur(livre_Details.getAuteur());
		livre.setPrix(livre_Details.getPrix());
		final Livre updatedlivre = LR.save(livre);
		return ResponseEntity.ok(updatedlivre);
	}

	@GetMapping("/getLivre/{id}")
	public Optional<Livre> getLivreById(@PathVariable(value = "id") long livre_id) {
		return LR.findById(livre_id);
	}

}
