/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawel.miron.controllers;



import com.pawel.miron.config.DBManager;
import com.pawel.miron.entity.Song;
import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;


/**
 *
 * @author Pawel
 */
public class SongBean implements Serializable {

    private Song song = new Song();

    public void setSong(Song song) {
        this.song = song;
    }

    public SongBean() {
        System.out.println("Stworzono SongBean");
    }

    public Song getSong() {
        return this.song;
    }

    public void setAlbum(Song song) {
        this.song = song;
    }

    public void dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        song.setId(null);
        em.persist(song);
        em.getTransaction().commit();
        em.close();
        this.song = new Song();
    }

    public List<Song> getAllSongs() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Song.findAll").getResultList();
        em.close();
        return list;
    }


    public void zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.song = em.find(Song.class, song.getId());
        em.close();
    }

    public void usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.song = em.find(Song.class, song.getId());
        em.remove(this.song);
        this.song = new Song();
        em.getTransaction().commit();
        em.close();

    }

    

    public void edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(song);
        em.getTransaction().commit();
        em.close();
        this.song = new Song();

    }

    public void songListener() {
        //String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("songID");
        //int id = Integer.parseInt(ids);
        //this.song.setId(id);
    }

}
