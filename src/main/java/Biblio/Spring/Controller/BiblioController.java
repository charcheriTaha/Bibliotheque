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

import Biblio.Spring.Repository.BiblioRepository;

@RestController
@RequestMapping("/bibliotheque")
public class BiblioController {

	private final BiblioRepository BR;

	public BiblioController(BiblioRepository bR) {
		super();
		BR = bR;
	}

	@RequestMapping(value = "/addBiblio", method = RequestMethod.POST)
	public Bibliotheque ajouterbiblio(@RequestBody Bibliotheque biblio) {
		return BR.save(biblio);
	}

	@GetMapping
	public String getAll() {
		return BR.findAll().toString();
	}

	@RequestMapping(value = "/updateBiblio/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Bibliotheque> updatebiblio(@PathVariable(value = "id") long biblio_Id,
			@RequestBody Bibliotheque biblio_Details) {
		Optional<Bibliotheque> optionelEntity = BR.findById(biblio_Id);

		Bibliotheque biblio = optionelEntity.get();
		biblio.setNom(biblio_Details.getNom());
		biblio.setAdresse(biblio_Details.getAdresse());
		biblio.setCapacite(biblio_Details.getCapacite());
		final Bibliotheque updatedbiblio = BR.save(biblio);
		return ResponseEntity.ok(updatedbiblio);
	}

}
