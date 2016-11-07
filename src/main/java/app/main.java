/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import com.pawel.miron.controllers.AlbumBean;
import com.pawel.miron.controllers.SongBean;
import com.pawel.miron.entity.Album;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pawel
 */
public class main {

    public static void main(String[] args) {
        
        AlbumBean albumBean = new AlbumBean();
        SongBean songBean = new SongBean();
        
        List list = albumBean.getAllAlbums();
        
        for (Iterator it = list.iterator(); it.hasNext();) {
            Album album = (Album) it.next();
            System.out.println(album.toString());
        }
        
        Album album1 = new Album("madonna","madonna","http://t-eska.cdn.smcloud.net/common/U/S/s/US2075738RFth.jpg/ru-0-r-650,0-n-US2075738RFth_nowa_plyta_madonny_rebel_heart.jpg","popp");
        
        albumBean.setAlbum(album1);
        albumBean.dodaj();
        
        list = albumBean.getAllAlbums();
        
        for (Iterator it = list.iterator(); it.hasNext();) {
            Album album = (Album) it.next();
            System.out.println(album.toString());
        }
    }
}
