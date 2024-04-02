package it.exolab.musica.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genere")
public class Genere {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genere")
	private Integer idGenere;
	
	@Column(name = "genere")
	private String genere;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="listGeneri")
	private List<Canzone> ListCanzoni;
	
	public Integer getIdGenere() {
		return idGenere;
	}
	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	
	

}
