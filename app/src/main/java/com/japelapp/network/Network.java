package com.japelapp.network;

import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;
import com.japelapp.entidade.Usuario;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Network {

    private static String CHAVE_API = "";
    private static String URL_API = "";

    public static ArrayList<Usuario> getUsuarios() {
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

    public static String enviarPessoa(Pessoa pessoa, String idusuario, String idpessoa) {
        String id = "";
        ArrayList<Usuario> registros = new ArrayList<>();
        try {
            URL url = new URL(URL_API + "/pessoa");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.getOutputStream().write(Marshal.marshalPessoa(pessoa, idusuario, idpessoa).toString().getBytes());
            httpURLConnection.getOutputStream().close();
            id = httpURLConnection.getContent().toString();
        } catch (Throwable ex) {
        }
        return id;
    }

    public static String enviarMoradia(Moradia moradia, String idusuario, String idpessoa) {
        String id = "";
        ArrayList<Usuario> registros = new ArrayList<>();
        try {
            URL url = new URL(URL_API + "/pessoa");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.getOutputStream().write(Marshal.marshalMoradia(moradia, idusuario, idpessoa).toString().getBytes());
            httpURLConnection.getOutputStream().close();
            id = httpURLConnection.getContent().toString();
        } catch (Throwable ex) {
        }
        return id;
    }

}
