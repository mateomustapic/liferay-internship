package com.company;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matea Pjanic on 22/02/2017.
 */
public class Info extends HttpServlet
    {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        com.company.Bend azra = new com.company.Bend();
        azra.setBendName("Azra");
        com.company.Album rdd = new com.company.Album();
        rdd.setAlbumName("Ravno do dna");
        com.company.Song a01 = new com.company.Song();
        a01.setSongName("Uradi nesto");
        com.company.Song a02 = new com.company.Song();
        a02.setSongName("Poziv na ples");
        com.company.Song a03 = new com.company.Song();
        a03.setSongName("Tople usne žene");
        rdd.setSongs(new com.company.Song[] {a01, a02, a03});
        azra.setAlbums(new com.company.Album[] {rdd});


        com.company.Bend santana = new com.company.Bend();
        santana.setBendName("Santana");

        com.company.Album spr = new com.company.Album();
        spr.setAlbumName("Supernatural");
        com.company.Album moon = new com.company.Album();
        moon.setAlbumName("Moonflower");

        com.company.Song s01 = new com.company.Song();
        s01.setSongName("Yaleo");
        com.company.Song s02 = new com.company.Song();
        s02.setSongName("Love of my life");
        com.company.Song s03 = new com.company.Song();
        s03.setSongName("Put your lights on");
        spr.setSongs(new com.company.Song[] {s01, s02, s03});

        com.company.Song s11 = new com.company.Song();
        s11.setSongName("Dawn");
        com.company.Song s12 = new com.company.Song();
        s12.setSongName("Carnaval");
        moon.setSongs(new com.company.Song[] {s11, s12});

        santana.setAlbums(new com.company.Album[] {spr, moon});


        ArrayList<Bend> bends = new ArrayList<>();
        bends.add(azra);
        bends.add(santana);

        String input = request.getParameter("yourBend");

        int size = bends.size();
        for(int i=0; i<size; i++) {
            if(input.equalsIgnoreCase(bends.get(i).getBendName())) {
                String json = new Gson().toJson(bends.get(i));
                response.getWriter().write(json);
                break;
            }
            else if(i == size - 1) {
                Map noinfo = new HashMap();
                noinfo.put("no", "yeah right! how about azra or santana??<br>");
                String json = new Gson().toJson(noinfo);
                response.getWriter().write(json);
            }
        }
    }
}