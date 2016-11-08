/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pawel.miron.controllers;

import com.pawel.miron.config.DBManager;
import com.pawel.miron.entity.Album;
import java.io.Serializable;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import javax.persistence.EntityManager;

/**
 *
 * @author Pawel
 */
public class AlbumBean implements Serializable {

    private Album album = new Album();

    public AlbumBean() {
        System.out.println("Stworzono AlbumBean");
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void dodaj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        album.setId(null);
        em.persist(album);
        em.getTransaction().commit();
        em.close();
        this.album = new Album();

    }

    public void pokazPiosenki() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.album = em.find(Album.class, album.getId());
        em.close();
    }

    public List<Album> getAllAlbums() {
        EntityManager em = DBManager.getManager().createEntityManager();
        List list = em.createNamedQuery("Album.findAll", Album.class).getResultList();
        em.close();
        return list;
    }

    public void zaladujDoEdycji() {
        EntityManager em = DBManager.getManager().createEntityManager();
        this.album = em.find(Album.class, album.getId());
        em.close();

    }

    public void usun() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        this.album = em.find(Album.class, album.getId());
        em.remove(this.album);
        this.album = new Album();
        em.getTransaction().commit();
        em.close();


    }

    public void edytuj() {
        EntityManager em = DBManager.getManager().createEntityManager();
        em.getTransaction().begin();
        em.merge(album);
        em.getTransaction().commit();
        em.close();

        this.album = new Album();

    }

    public void albumListener() {
        //String ids = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("albumID");
        //int id = Integer.parseInt(ids);
        //this.album.setId(id);
    }

    public void findURL() {
        String input = "http://www.last.fm/pl/music/";
        String nazwa = album.getTitle();
        String zespol = album.getArtist();
        String nazwaR = nazwa.replace(' ', '+');
        String zespolR = zespol.replace(' ', '+');
        String url = input.concat(zespolR).concat("/").concat(nazwaR).concat("/+images");

        System.out.println(url);

        try {
            Document document = Jsoup.connect(url).followRedirects(true).get();
            Elements all = document.select("img");
            Element elem = all.get(2);
            String output = elem.attr("src");

            System.out.println(output);

            album.setLogo(output);
        } catch (IOException e) {
            album.setLogo("https://dummyimage.com/100x100/000000/fff");
        }

    }

}
