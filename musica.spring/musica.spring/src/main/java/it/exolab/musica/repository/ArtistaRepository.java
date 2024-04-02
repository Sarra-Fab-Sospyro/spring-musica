package it.exolab.musica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.exolab.musica.model.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer>{ 
	
	public List<Artista> findAll();
	
	public Artista findByNomeArtistico(String nomeArtistico);

}
