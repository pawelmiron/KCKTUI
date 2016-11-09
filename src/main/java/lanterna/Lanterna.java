/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lanterna;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.Component.Alignment;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.component.Panel.Orientation;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.component.TextBox;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.pawel.miron.controllers.AlbumBean;
import com.pawel.miron.controllers.SongBean;
import com.pawel.miron.entity.Album;
import com.pawel.miron.entity.Song;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pawel
 */
public class Lanterna {//////////////////////////////////////////////////////////////////////////////////////////

    //Controllers Declaraton
    private AlbumBean albumBean;
    private SongBean songBean;
    //List Declaration
    private List songList;
    private List albumList;
    //Windows Declaration 
    private final Window DUWindow;
    private final Window PUWindow;
    private final Window DAWindow;
    private final Window PAWindow;
    private final Window EUWindow;
    private final GUIScreen guiScreen;
    //Tables Declaration
    private Table tableAlbum;
    private Table DUTable;
    private Table PUtable;
    private Table DAtable;
    //Row Declaration
    private Component[] PArow;
    //Statci Buttons Declaration
    private Button GoBackButton;
    private Button DUdodaj;
    private Button dodaj1;
    private Button dodajAlbum;
    private Button dodajUtwor;
    private Button ExitBTN;
    private Button pokazUtwory;
    //Panel Holders
    private final Panel DUpanelHolder;
    private final Panel PUPanelHolder;
    private Panel DApanelHolder;
    private Panel panelHolder1;
    private final Panel EUpanelHolder;
    //Panels
    private final Panel DUmenuGlowne;
    private final Panel PUmenuGlowne;
    private Panel DAmenuGlowne;
    private Panel menuGlowne1;
    private final Panel DUcontent;
    private final Panel PUContent;
    private Panel DAContent;
    private Panel content1;
    //Components
    private Component[] DUrow1;
    private Component[] DUrow2;
    private Component[] PUrow;
    private Component[] DArow1;
    private Component[] DArow2;
    private Component[] DArow3;
    private Component[] DArow4;
    //Labels
    private final Label DULabel;
    private final Label PUlabel;
    private final Label DALabel;
    //Edytuj Utwor
    private Panel EUmenuGlowne;
    private Label EULabel;
    private Panel EUcontent;
    private Table EUTable;
    private Component[] EUrow1;
    private Component[] EUrow2;
    private Button EUButton;
    //Edytuj Album
    private final Window EAWindow;
        private Panel EApanelHolder;
        private Panel EAmenuGlowne;
        private Label EALabel;
        private Panel EAContent;
        private Table EAtable;
        private Component[] EArow1;
        private Component[] EArow2;
        private Component[] EArow3;
        private Component[] EArow4;
        private Button EAButton;
        private Album EdytowanyAlbum;
    
    
    //Constreucting TUI Objects
    public Lanterna() {
        //Controllers
        albumBean = new AlbumBean();
        songBean = new SongBean();
        //GuiScreen
        guiScreen = TerminalFacade.createGUIScreen();
        //Windows
        DUWindow = new Window("GLOWNE OKNO");
        PUWindow = new Window("POKAZ UTWORY");
        DAWindow = new Window("DODAJ ALBUM");
        PAWindow = new Window("GLOWNE OKNO");
        EUWindow = new Window("GLOWNE OKNO");
        //Panel Holders
        DUpanelHolder = new Panel("", Orientation.HORISONTAL);
        DUpanelHolder.setLayoutManager(new VerticalLayout());
        PUPanelHolder = new Panel("", Orientation.HORISONTAL);
        PUPanelHolder.setLayoutManager(new VerticalLayout());
        EUpanelHolder = new Panel("", Orientation.HORISONTAL);
        EUpanelHolder.setLayoutManager(new VerticalLayout());
        //Panels
        DUmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);
        DUcontent = new Panel("Content", Orientation.HORISONTAL);
        DUcontent.setLayoutManager(new VerticalLayout());
        
        PUmenuGlowne = new Panel("Menu", Orientation.HORISONTAL);
        PUContent = new Panel("Content", Orientation.HORISONTAL);
        //Tables
        tableAlbum = new Table(6);
        DUTable = new Table(2);
        PUtable = new Table(2);
        //Labels
        DULabel = new Label("Dodadwanie piosenki");
        DULabel.setAlignment(Alignment.TOP_LEFT);
        PUlabel = new Label("Lista utworow");
        //Components
        DUrow1 = new Component[2];
        DUrow2 = new Component[2];
        
        DApanelHolder = new Panel("", Orientation.HORISONTAL);
        DApanelHolder.setLayoutManager(new VerticalLayout());
        DAmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);

        DALabel = new Label("Dodadwanie piosenki");
        DALabel.setAlignment(Alignment.TOP_LEFT);

        DAContent = new Panel("Content", Orientation.HORISONTAL);
        DAContent.setLayoutManager(new VerticalLayout());

        DAtable = new Table(2);
        DAtable.setColumnPaddingSize(7);

        DArow1 = new Component[2];
        DArow2 = new Component[2];
        DArow3 = new Component[2];
        DArow4 = new Component[2];

        DArow1[0] = new Label("   Artist");
        DArow1[1] = new TextBox("", 69);

        DArow2[0] = new Label("   Title");
        DArow2[1] = new TextBox("", 69);

        DArow3[0] = new Label("   Genre");
        DArow3[1] = new TextBox("", 69);

        DArow4[0] = new Label("   URL");
        DArow4[1] = new TextBox("", 69);
        
        panelHolder1 = new Panel("", Orientation.HORISONTAL);
        panelHolder1.setLayoutManager(new VerticalLayout());
        menuGlowne1 = new Panel("Menu Glowne", Orientation.HORISONTAL);
        content1 = new Panel("Content", Orientation.HORISONTAL);
        
        EUmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);
        EULabel = new Label("Edytowanie utworu");
        EULabel.setAlignment(Alignment.TOP_LEFT);
        EUcontent = new Panel("Content", Orientation.HORISONTAL);
        EUcontent.setLayoutManager(new VerticalLayout());
        EUTable = new Table(2);
        EUTable.setColumnPaddingSize(7);
        EUrow1 = new Component[2];
        EUrow1[0] = new Label("   Album");
        EUrow1[1] = new TextBox("", 69);
        EUrow2 = new Component[2];
        EUrow2[0] = new Label("   Title");
        EUrow2[1] = new TextBox("", 69);
        EUrow2[1].setAlignment(Alignment.FILL);
        EUButton = new Button("Edytuj");
        EUButton.setAlignment(Alignment.RIGHT_CENTER);
        EAWindow = new Window("DODAJ ALBUM");                                    //Tworze pierwsze okienko wyswietlane zaraz po uruchomieniu ekranu
        EAWindow.setWindowSizeOverride(new TerminalSize(100, 50));                            //Ustawiam wielkosc okna 1 na maksymalny rozmiar
        EAWindow.setSoloWindow(true);                                                        //Dzieki wartosci true gdy pokazujemy te okno inne znikaja
        EApanelHolder = new Panel("", Orientation.HORISONTAL);
        EApanelHolder.setLayoutManager(new VerticalLayout());
        EAmenuGlowne = new Panel("Menu Glowne", Orientation.HORISONTAL);
        EALabel = new Label("Edytowanie albumu");
        EALabel.setAlignment(Alignment.TOP_LEFT);
        EAContent = new Panel("Content", Orientation.HORISONTAL);
        EAContent.setLayoutManager(new VerticalLayout());
        EAtable = new Table(2);
        EAtable.setColumnPaddingSize(7);
        EArow1 = new Component[2];
        EArow2 = new Component[2];
        EArow3 = new Component[2];
        EArow4 = new Component[2];
        EArow1[0] = new Label("   Artist");
        EArow1[1] = new TextBox("", 69);
        EArow2[0] = new Label("   Title");
        EArow2[1] = new TextBox("", 69);
        EArow2[1].setAlignment(Alignment.FILL);
        EArow3[0] = new Label("   Genre");
        EArow3[1] = new TextBox("", 69);
        EArow4[0] = new Label("   URL");
        EArow4[1] = new TextBox("", 69);
        EAButton = new Button("Edytuj", new Action(){
        @Override
        public void doAction(){
        
               
                TextBox textbox;
                
                textbox = (TextBox) EArow1[1];
                EdytowanyAlbum.setArtist(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) EArow2[1];
                EdytowanyAlbum.setTitle(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) EArow3[1];
                EdytowanyAlbum.setGenre(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) EArow4[1];
                EdytowanyAlbum.setLogo(textbox.getText());
                textbox.setText("");
                albumBean.setAlbum(EdytowanyAlbum);
                albumBean.edytuj();
                tableAlbum.removeAllRows();
                InitializeListOfAlbums();
                guiScreen.getActiveWindow().close();

        }
        });
        EAButton.setAlignment(Alignment.RIGHT_CENTER);
    }

    public void TableConfiguration() {
        tableAlbum.setColumnPaddingSize(1);
        DUTable.setColumnPaddingSize(7);
        PUtable.setColumnPaddingSize(5);
    }

    public void WindowsConfiguration() {
        DUWindow.setWindowSizeOverride(new TerminalSize(100, 50));
        DUWindow.setSoloWindow(true);

        PUWindow.setWindowSizeOverride(new TerminalSize(100, 500));
        PUWindow.setSoloWindow(true);

        DAWindow.setWindowSizeOverride(new TerminalSize(100, 50));
        DAWindow.setSoloWindow(true);

        PAWindow.setWindowSizeOverride(new TerminalSize(100, 50)); //Ustawiam wielkosc okna 1 na maksymalny rozmiar
        PAWindow.setSoloWindow(true); //Dzieki wartosci true gdy pokazujemy te okno inne znikaja
        
        EUWindow.setWindowSizeOverride(new TerminalSize(100, 50));
        EUWindow.setSoloWindow(true);
    }

    public void ButtonConfiguration() {
        GoBackButton = new Button("Powrót", new Action() {
            @Override
            public void doAction() {
                guiScreen.getActiveWindow().close();
            }
        });
        GoBackButton.setAlignment(Alignment.TOP_RIGHT);
        
        DUdodaj = new Button("Dodaj", new Action(){
        @Override
            public void doAction() {
            TextBox textbox;
         textbox = (TextBox) DUrow1[1];
         songBean.getSong().setAlbumId(albumBean.getAlbumById(Integer.parseInt(textbox.getText())));
         textbox.setText("");
         textbox = (TextBox) DUrow2[1];
         songBean.getSong().setTitle(textbox.getText());
         textbox.setText("");

         songBean.dodaj();
            PUtable.removeAllRows();
            InitializeListOfSongs();
            guiScreen.getActiveWindow().close();
            }
        });
        
        DUdodaj.setAlignment(Alignment.RIGHT_CENTER);
        
        dodaj1 = new Button("Dodaj", new Action() {
            @Override
            public void doAction() {

               
                TextBox textbox;

                textbox = (TextBox) DArow1[1];
                albumBean.getAlbum().setArtist(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) DArow2[1];
                albumBean.getAlbum().setTitle(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) DArow3[1];
                albumBean.getAlbum().setGenre(textbox.getText());
                textbox.setText("");
                textbox = (TextBox) DArow4[1];
                albumBean.getAlbum().setLogo(textbox.getText());
                textbox.setText("");
                albumBean.dodaj();
                tableAlbum.removeAllRows();
                InitializeListOfAlbums();
                guiScreen.getActiveWindow().close();

            }
        });
        
        dodajAlbum = new Button("Dodaj Album", new Action() {
            @Override
            public void doAction() {
                guiScreen.showWindow(DAWindow);
            }
        });
        
         dodajUtwor = new Button("Dodaj Utwor", new Action() {
            @Override
            public void doAction() {
                guiScreen.showWindow(DUWindow);
            }
        });

        ExitBTN = new Button("Exit", new Action() {
            @Override
            public void doAction() {
                PAWindow.close();
            }
        });
        pokazUtwory = new Button("Pokaz Utwory", new Action() {
            @Override
            public void doAction() {
                guiScreen.showWindow(PUWindow);
            }
        });
       
        
        dodaj1.setAlignment(Alignment.RIGHT_CENTER);
    }

    
    public void RowConfigurations() {
        DUrow1[0] = new Label("   Album");
        DUrow1[1] = new TextBox("", 69);

        DUrow2[0] = new Label("   Title");
        DUrow2[1] = new TextBox("", 69);
    }

    public void SettingConnections() {   //Pola dodawania utworu
        DUTable.addRow(DUrow1);
        DUTable.addRow(new EmptySpace());
        DUTable.addRow(DUrow2);
        DUTable.addRow(new EmptySpace());
        DUcontent.addComponent(DUTable);
        DUcontent.addComponent(DUdodaj, LinearLayout.MAXIMIZES_HORIZONTALLY);
        DUmenuGlowne.addComponent(DULabel);
        DUmenuGlowne.addComponent(new EmptySpace(52, 0));
        DUmenuGlowne.addComponent(GoBackButton);
        DUpanelHolder.addComponent(DUmenuGlowne);
        DUpanelHolder.addComponent(DUcontent);
        DUWindow.addComponent(DUpanelHolder);
        PUContent.addComponent(PUtable);
        PUmenuGlowne.addComponent(PUlabel);
        PUmenuGlowne.addComponent(new EmptySpace(58, 0));
        PUmenuGlowne.addComponent(GoBackButton);
        PUPanelHolder.addComponent(PUmenuGlowne);
        PUPanelHolder.addComponent(PUContent);
        PUWindow.addComponent(PUPanelHolder);
        DAtable.addRow(DArow1);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow2);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow3);
        DAtable.addRow(new EmptySpace());
        DAtable.addRow(DArow4);
        DAtable.addRow(new EmptySpace());
        DAContent.addComponent(DAtable);
        DAContent.addComponent(dodaj1, LinearLayout.MAXIMIZES_HORIZONTALLY);
        DAmenuGlowne.addComponent(DALabel);
        DAmenuGlowne.addComponent(new EmptySpace(52, 0));
        DAmenuGlowne.addComponent(GoBackButton);
        DApanelHolder.addComponent(DAmenuGlowne);
        DApanelHolder.addComponent(DAContent);
        DAWindow.addComponent(DApanelHolder);
        content1.addComponent(tableAlbum);
        menuGlowne1.addComponent(dodajAlbum);
        menuGlowne1.addComponent(dodajUtwor);
        menuGlowne1.addComponent(pokazUtwory);
        menuGlowne1.addComponent(new EmptySpace(27, 0));
        menuGlowne1.addComponent(ExitBTN);
        panelHolder1.addComponent(menuGlowne1);
        panelHolder1.addComponent(content1);
        PAWindow.addComponent(panelHolder1);
        EUTable.addRow(EUrow1);
        EUTable.addRow(new EmptySpace());
        EUTable.addRow(EUrow2);
        EUTable.addRow(new EmptySpace());
        EUcontent.addComponent(EUTable);
        EUcontent.addComponent(EUButton, LinearLayout.MAXIMIZES_HORIZONTALLY);
        EUmenuGlowne.addComponent(EULabel);
        EUmenuGlowne.addComponent(new EmptySpace(54, 0));
        EUmenuGlowne.addComponent(GoBackButton);
        EUpanelHolder.addComponent(EUmenuGlowne);
        EUpanelHolder.addComponent(EUcontent);
        EUWindow.addComponent(EUpanelHolder);
        EAtable.addRow(EArow1);
        EAtable.addRow(new EmptySpace());
        EAtable.addRow(EArow2);
        EAtable.addRow(new EmptySpace());
        EAtable.addRow(EArow3);
        EAtable.addRow(new EmptySpace());
        EAtable.addRow(EArow4);
        EAtable.addRow(new EmptySpace());
        EAContent.addComponent(EAtable);
        EAContent.addComponent(EAButton, LinearLayout.MAXIMIZES_HORIZONTALLY);
        EAmenuGlowne.addComponent(EALabel);
        EAmenuGlowne.addComponent(new EmptySpace(52, 0));
        EAmenuGlowne.addComponent(GoBackButton);
        EApanelHolder.addComponent(EAmenuGlowne);
        EApanelHolder.addComponent(EAContent);
        EAWindow.addComponent(EApanelHolder);
    }
    
    public void InitializeListOfSongs()
    {
        songList = songBean.getAllSongs();
     
        for (Iterator it = songList.iterator(); it.hasNext();) {
            Song song = (Song) it.next();
            
            PUrow = new Component[2];
            PUrow[0] = new Label(song.getTitle());
            System.out.println(song.getTitle());
            PUrow[1] = new Label(song.getAlbumId().getArtist());
            System.out.println(song.getAlbumId().getArtist());
            PUtable.addRow(PUrow);
        }
    }
    
    public void InitializeListOfAlbums(){
    albumList = albumBean.getAllAlbums();

        for (Iterator it = albumList.iterator(); it.hasNext();) {
            Album album = (Album) it.next();
            PArow = new Component[6];
            PArow[0] = new Label(album.getId().toString());
            PArow[1] = new Label(album.getArtist());
            PArow[2] = new Label(album.getTitle());
            PArow[3] = new Label(album.getGenre());
            PArow[4] = new Button("Edytuj", new Action(){
            @Override
            public void doAction(){
                EdytowanyAlbum = album;
                TextBox textbox = new TextBox();
                textbox = (TextBox) EArow1[1];
                textbox.setText(album.getArtist());
                textbox = (TextBox) EArow2[1];
                textbox.setText(album.getTitle());
                textbox = (TextBox) EArow3[1];
                textbox.setText(album.getGenre());
                textbox = (TextBox) EArow4[1];
                textbox.setText(album.getLogo());
                guiScreen.showWindow(EAWindow);
            }
            });
            PArow[5] = new Button("Usun", new Action(){
            @Override
            public void doAction(){
            albumBean.usun(album.getId());
            RefreshAlbumList();
            }
            });
            tableAlbum.addRow(PArow);
        }
    }
    
    public void RefreshAlbumList(){
    tableAlbum.removeAllRows();
    InitializeListOfAlbums();
    }

    public void TUI() {

        //Function Inicialisation
        WindowsConfiguration();
        TableConfiguration();
        ButtonConfiguration();
        RowConfigurations();
        SettingConnections();
        InitializeListOfAlbums();
        InitializeListOfSongs();
     
       
        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(PAWindow);
        guiScreen.getScreen().stopScreen();

    }
}
