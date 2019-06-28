package com.japelapp.network;

import com.japelapp.entidade.Usuario;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Network {

    String CHAVE_API = "";
    String URL_API = "";

    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> registros = new ArrayList<>();
        try {
            URL url = new URL(URL_API + "/usuarios");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.getContent().toString();
        } catch (Throwable ex) {
        }
        return registros;
    }

}
