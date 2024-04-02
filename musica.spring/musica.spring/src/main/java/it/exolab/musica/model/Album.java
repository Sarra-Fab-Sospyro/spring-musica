package it.exolab.musica.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "album")
public class Album implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1216560048364936674L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_album")
	private Integer idAlbum;

	@Column(name = "titolo")
	private String titoloAlbum;

	@Column(name = "immagine")
	private String immagineAlbum;

	@Column(name = "data_rilascio")
	private LocalDate dataRilascio;
	
//	@Column(name = "id_artista")
//	private Integer idArtista;
	
	@ManyToOne
	@JoinColumn(name = "id_artista", nullable = true, insertable = false, updatable = false /*foreignKey = @ForeignKey(foreignKeyDefinition = "id_artista")*/)
	@JsonIgnoreProperties(value= {"listAlbum"})
	private Artista artista;

	@OneToMany(mappedBy = "album", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	private List<Canzone> listCanzoni;

	public Album() {
	}

	public Album(String titoloAlbum, String immagineAlbum, Artista artista) {
		this.titoloAlbum = titoloAlbum;
		this.immagineAlbum = immagineAlbum;
		this.artista = artista;
	}

	public Album(Integer idAlbum, String titoloAlbum, String immagineAlbum, LocalDate dataRilascio, Artista artista) {
		this.idAlbum = idAlbum;
		this.titoloAlbum = titoloAlbum;
		this.immagineAlbum = immagineAlbum;
		this.dataRilascio = dataRilascio;
		this.artista = artista;
	}

	public Integer getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Integer idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getTitoloAlbum() {
		return titoloAlbum;
	}

	public void setTitoloAlbum(String titoloAlbum) {
		this.titoloAlbum = titoloAlbum;
	}

	public String getImmagineAlbum() {
		return immagineAlbum;
	}

	public void setImmagineAlbum(String immagineAlbum) {
		this.immagineAlbum = immagineAlbum;
	}

	public LocalDate getDataRilascio() {
		return dataRilascio;
	}

	public void setDataRilascio(LocalDate dataRilascio) {
		this.dataRilascio = dataRilascio;
	}

	public Artista getArtista() {
		
		System.out.println("getArtista di artista");
		if(artista==null)
			artista = new Artista();
		
		return artista;
	}

	public void setArtista(Artista artista) {
		
		this.artista = artista;
	}

	public List<Canzone> getListCanzoni() {
		return listCanzoni;
	}

	public void setListCanzoni(List<Canzone> listCanzoni) {
		this.listCanzoni = listCanzoni;
	}

	
//	public Integer getIdArtista() {
//		return idArtista;
//	}
//
//	public void setIdArtista(Integer idArtista) {
//		this.idArtista = idArtista;
//	}

//	@Override
//	public String toString() {
//		return "\n\tAlbum [idAlbum = " + idAlbum + ", titoloAlbum = " + titoloAlbum + ", immagineAlbum = " + immagineAlbum
//				+ ", dataRilascio = " + dataRilascio + ", artista = " + artista.getNomeArtistico()  +"]";
//	}

}
