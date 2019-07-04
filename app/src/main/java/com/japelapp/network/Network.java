package com.japelapp.network;

import android.os.Environment;
import android.util.JsonReader;

import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;
import com.japelapp.entidade.Usuario;

import org.apache.commons.net.ftp.FTPClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Optional;

public class Network {

    private static String CHAVE_API = "";
    //private static String URL_API = "http://10.3.152.7/japel_fundiaria_servidor/public/api";
    private static String URL_API = "http://31.220.56.13/api";

    private static String URL_FTP = "31.220.56.13";
    private static String DIRETORIO_FTP = "";

    private static String USUARIO_FTP = "convidado";
    private static String SENHA_FTP = "12345678";

    public static ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> registros = new ArrayList<>();
        try {
            URL url = new URL(URL_API + "/user");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Accept", "application/json");
            //httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.setRequestMethod("GET");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Charset.forName("UTF-8")));
            String conteudo = bufferedReader.readLine();
            JSONArray jsonArray = new JSONArray(conteudo);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = (JSONObject) jsonArray.get(i);
                Usuario u = new Usuario();
                u.setId(o.getInt("id"));
                u.setLogin(o.getString("login"));
                u.setSenha(o.getString("senha"));
                registros.add(u);
            }

        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return registros;
    }

    public static String enviarPessoa(Pessoa pessoa, String idusuario, String idpessoa) {
        String id = "";
        try {
            URL url = new URL(URL_API + "/pessoa");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Accept", "text/plain");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.setRequestMethod("POST");

            OutputStream os = httpURLConnection.getOutputStream();
            byte[] input = Marshal.marshalPessoa(pessoa, idusuario, idpessoa).toString().getBytes();
            os.write(input, 0, input.length);
            os.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Charset.forName("UTF-8")));

            id = bufferedReader.readLine();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public static String enviarMoradia(Moradia moradia, String idusuario, String idpessoa) {
        String id = "";
        try {
            URL url = new URL(URL_API + "/moradia");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            httpURLConnection.setRequestProperty("Accept", "text/plain");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Authorization", CHAVE_API);
            httpURLConnection.setRequestMethod("POST");

            OutputStream os = httpURLConnection.getOutputStream();
            byte[] input = Marshal.marshalMoradia(moradia, idusuario, idpessoa).toString().getBytes();
            os.write(input, 0, input.length);
            os.close();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Charset.forName("UTF-8")));

            id = bufferedReader.readLine();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public static void enviarFotos(String nomeRemoto, String caminhoLocal) {
        try {
            FTPClient ftpClient = new FTPClient();
            ftpClient.connect(URL_FTP);
            ftpClient.login(USUARIO_FTP, SENHA_FTP);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
            FileInputStream fileInputStream = new FileInputStream(Environment.getExternalStorageDirectory() + "/" + caminhoLocal);
            ftpClient.storeFile(nomeRemoto + "." + getExtensaoArquivo(caminhoLocal), fileInputStream);
            fileInputStream.close();
            //ftpClient.completePendingCommand();
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
        System.out.println("");
    }

    public static String getExtensaoArquivo(String arquivo) {
        String extensao = "";
        if (arquivo.contains(".")) {
            String[] arquivoArray = arquivo.split("\\.");
            extensao = arquivoArray[arquivoArray.length - 1];
        }
        return extensao;
    }

}
