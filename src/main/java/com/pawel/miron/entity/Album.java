/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawel.miron.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pawel
 */
@Entity
@Table(name = "album")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Album.findAll", query = "SELECT a FROM Album a")
    , @NamedQuery(name = "Album.findById", query = "SELECT a FROM Album a WHERE a.id = :id")
    , @NamedQuery(name = "Album.findByTitle", query = "SELECT a FROM Album a WHERE a.title = :title")
    , @NamedQuery(name = "Album.findByArtist", query = "SELECT a FROM Album a WHERE a.artist = :artist")
    , @NamedQuery(name = "Album.findByLogo", query = "SELECT a FROM Album a WHERE a.logo = :logo")
    , @NamedQuery(name = "Album.findByGenre", query = "SELECT a FROM Album a WHERE a.genre = :genre")})
public class Album implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "artist", length = 255)
    private String artist;
    @Column(name = "logo", length = 255)
    private String logo;
    @Column(name = "genre", length = 255)
    private String genre;
    @OneToMany(mappedBy = "albumId", fetch = FetchType.EAGER)
    private Collection<Song> songCollection;

    public Album() {
    }

    public Album(String title, String artist, String logo, String genre) {
        this.title = title;
        this.artist = artist;
        this.logo = logo;
        this.genre = genre;
    }
    
    

    public Album(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @XmlTransient
    public Collection<Song> getSongCollection() {
        return songCollection;
    }

    public void setSongCollection(Collection<Song> songCollection) {
        this.songCollection = songCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id= " + id + " title= " + title + " artist= " + artist + " genre= " + genre + " logo= " + logo ;
    }
    
}
