package it.exolab.musica.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.exolab.musica.model.Artista;
import it.exolab.musica.service.ArtistaService;

@RestController
@RequestMapping(path = "/artista")
@CrossOrigin
public class ArtistaRest {

	@Autowired
	private ArtistaService artistaService;

	@GetMapping(path = "/findAllArtisti", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Artista>> findAll() {

		try {
			List<Artista> listaArtisti = artistaService.findAll();

			return ResponseEntity.ok(listaArtisti);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping(path = "/findArtista/{nomeArtistico}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> findArtistaByNomeArtistico(@PathVariable("nomeArtistico") String nomeArtistico) {

		try {
			Artista artistaTrovato = artistaService.findByNomeArtistico(nomeArtistico);

			return ResponseEntity.ok(artistaTrovato);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping(path = "/findArtistaById/{idArtista}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> findArtistaById(@PathVariable("idArtista") Integer idArtista) {

		try {
			Artista artistaTrovatoById = artistaService.findById(idArtista);

			return ResponseEntity.ok(artistaTrovatoById);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}

	}

	@PostMapping(path = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> insert(@RequestBody Artista artista) {

		try {
			Artista artistaInserito = artistaService.insert(artista);
			return ResponseEntity.ok(artistaInserito);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();

		}
	}
	
	@PutMapping(path = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Artista> update(@RequestBody Artista artista) {

		try {
			Artista artistaInserito = artistaService.update(artista);
			return ResponseEntity.ok(artistaInserito);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.internalServerError().build();

		}
	}
	
	@DeleteMapping(path="/delete",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Artista> delete(@RequestBody Artista artista){
		
		try {
			artistaService.delete(artista);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}
}
