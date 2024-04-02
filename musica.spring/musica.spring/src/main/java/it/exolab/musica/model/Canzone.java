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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "canzone")
public class Canzone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4987609490794960760L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_canzone")
	private Integer idCanzone;

	@Column(name = "titolo")
	private String titoloCanzone;

	@Column(name = "durata_minuti")
	private Float durataMinuti;

//	@Column(name = "id_album")
//	private Integer idAlbum;

	@ManyToOne
	@JoinColumn(name = "id_album", nullable = true, insertable = false, updatable = false)
	@JsonIgnoreProperties(value = { "listCanzoni" })
	private Album album;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.REFRESH })

	@JoinTable(name = "genere_canzone", joinColumns = @JoinColumn(name = "id_canzone", referencedColumnName = "id_canzone"), inverseJoinColumns = @JoinColumn(name = "id_genere", referencedColumnName = "id_genere"))

	private List<Genere> listGeneri;

	public Canzone() {
	}

	public Canzone(Integer idCanzone, String titoloCanzone, Float durataMinuti, Album album) {
		this.idCanzone = idCanzone;
		this.titoloCanzone = titoloCanzone;
		this.durataMinuti = durataMinuti;
		this.album = album;
	}

	public Canzone(String titoloCanzone, Float durataMinuti, Album album) {
		this.titoloCanzone = titoloCanzone;
		this.durataMinuti = durataMinuti;
		this.album = album;
	}

	public Integer getIdCanzone() {
		return idCanzone;
	}

	public void setIdCanzone(Integer idCanzone) {
		this.idCanzone = idCanzone;
	}

	public String getTitoloCanzone() {
		return titoloCanzone;
	}

	public void setTitoloCanzone(String titoloCanzone) {
		this.titoloCanzone = titoloCanzone;
	}

	public Float getDurataMinuti() {
		return durataMinuti;
	}

	public void setDurataMinuti(Float durataMinuti) {
		this.durataMinuti = durataMinuti;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

//	public Integer getIdAlbum() {
//		return idAlbum;
//	}
//
//	public void setIdAlbum(Integer idAlbum) {
//		this.idAlbum = idAlbum;
//	}

	public List<Genere> getListGeneri() {
		return listGeneri;
	}

	public void setListGeneri(List<Genere> listGeneri) {
		this.listGeneri = listGeneri;
	}

	@Override
	public String toString() {
		return "Canzone [idCanzone=" + idCanzone + ", titoloCanzone=" + titoloCanzone + ", durataMinuti=" + durataMinuti
				+ ", album=" + album.getTitoloAlbum() + "]";
	}

}
