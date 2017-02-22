package com.company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Matea Pjanic on 22/02/2017.
 */
public class Info extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        com.company.Bend azra = new com.company.Bend();
        azra.setBendName("Azra");
        com.company.Album rdd = new com.company.Album();
        rdd.setAlbumName("Ravno do dna");
        com.company.Song s1 = new com.company.Song();
        s1.setSongName("Uradi nesto");
        com.company.Song s2 = new com.company.Song();
        s2.setSongName("Poziv na ples");
        com.company.Song s3 = new com.company.Song();
        s3.setSongName("Tople usne žene");
        rdd.setSongs(new com.company.Song[] {s1, s2, s3});
        azra.setAlbum(rdd);

        response.getWriter().write("bend: " + azra.getBendName() + "<br>");
        response.getWriter().write("album: " + azra.getAlbum().getAlbumName() + "<br>");
        response.getWriter().write("song1: " + azra.getAlbum().getSongs()[0].getSongName() + "<br>");
        response.getWriter().write("song2: " + azra.getAlbum().getSongs()[1].getSongName() + "<br>");
        response.getWriter().write("song3: " + azra.getAlbum().getSongs()[2].getSongName() + "<br>");

    }
}
