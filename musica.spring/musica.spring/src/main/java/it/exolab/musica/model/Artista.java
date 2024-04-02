package it.exolab.musica.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artista")
public class Artista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2268920016638992102L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_artista")
	private Integer idArtista;

	@Column(name = "nome_artistico")
	private String nomeArtistico;

	@Column(name = "ascoltatori")
	private Integer ascoltatori;

	@Column(name = "immagine")
	private String immagineArtista;

									// di default fetch = FetchType.LAZY
	@OneToMany(mappedBy = "artista", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Album> listAlbum;

	public Artista() {
	}

	public Artista(String nomeArtistico, String immagineArtista) {
		this.nomeArtistico = nomeArtistico;
		this.immagineArtista = immagineArtista;
	}

	public Artista(Integer idArtista, String nomeArtistico, Integer ascoltatori, String immagineArtista) {
		this.idArtista = idArtista;
		this.nomeArtistico = nomeArtistico;
		this.ascoltatori = ascoltatori;
		this.immagineArtista = immagineArtista;
	}

	public Integer getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(Integer idArtista) {
		this.idArtista = idArtista;
	}

	public String getNomeArtistico() {
		return nomeArtistico;
	}

	public void setNomeArtistico(String nomeArtistico) {
		this.nomeArtistico = nomeArtistico;
	}

	public Integer getAscoltatori() {
		return ascoltatori;
	}

	public void setAscoltatori(Integer ascoltatori) {
		this.ascoltatori = ascoltatori;
	}

	public String getImmagineArtista() {
		return immagineArtista;
	}

	public void setImmagineArtista(String immagineArtista) {
		this.immagineArtista = immagineArtista;
	}

	public List<Album> getListAlbum() {
		return listAlbum;
	}

	public void setListAlbum(List<Album> listAlbum) {
		this.listAlbum = listAlbum;
	}

	@Override
	public String toString() {
		return "\n\tArtista [idArtista = " + idArtista + ", nomeArtistico = " + nomeArtistico + ", ascoltatori = " + ascoltatori
				+ ", immagineArtista = " + immagineArtista + "]";
	}

}
