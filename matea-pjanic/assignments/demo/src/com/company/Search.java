package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matea Pjanic on 03/03/2017.
 */
public class Search extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        Type list = new TypeToken<ArrayList<Bend>>(){}.getType();
        ArrayList<Bend> bends = gson.fromJson(new FileReader("C:\\Users\\Matea Pjanic\\myJSP&Servlets\\MusicAppDesign\\web\\json\\bends.json"), list);

        String input = request.getParameter("yourInput");

        int size = bends.size();
        for(int i=0; i<size; i++) {
            if(input.equalsIgnoreCase(bends.get(i).getBendName())) {
                String json = new Gson().toJson(bends.get(i));
                response.getWriter().write(json);
                break;
            }
            else if(i == size - 1) {
                Map noinfo = new HashMap();
                noinfo.put("no", "hm... how about azra or santana?? :) <br>");
                String json = new Gson().toJson(noinfo);
                response.getWriter().write(json);
            }
        }
    }
}
