package it.exolab.musica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.exolab.musica.model.Artista;
import it.exolab.musica.repository.ArtistaRepository;

@Service
public class ArtistaService {

	@Autowired
	private ArtistaRepository artistaRepository;
	
	public List<Artista> findAll(){
		
		return artistaRepository.findAll();
	}
	
	public Artista insert(Artista artista) {
		
		return artistaRepository.save(artista);
	}
	
	public Artista update(Artista artista) {
		
		return artistaRepository.save(artista);
	}
	
	public Artista findById(Integer idArtista) {
		
		return artistaRepository.findById(idArtista).orElse(null);
	}
	
	public Artista findByNomeArtistico(String nomeArtistico) {
		
		return artistaRepository.findByNomeArtistico(nomeArtistico);
	}
	
	public void delete(Artista artista) {
		
		artistaRepository.delete(artista);
	}
	
}
