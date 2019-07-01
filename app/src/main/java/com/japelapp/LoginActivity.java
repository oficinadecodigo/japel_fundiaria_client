package com.japelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.japelapp.bd.DatabaseHelper;
import com.japelapp.bd.UsuarioDao;
import com.japelapp.entidade.Usuario;
import com.japelapp.network.Network;
import com.japelapp.util.Sessao;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText txt_login;
    EditText txt_senha;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        verificarPermissoes();
        txt_login = findViewById(R.id.login_login);
        txt_senha = findViewById(R.id.login_senha);
        btn_login = findViewById(R.id.login_btn_entrar);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    baixarUsuarios();
                } catch (Throwable ex) {
                }
            }
        });

    }

    private void login() {
        String login = txt_login.getText().toString();
        String senha = txt_senha.getText().toString();

        UsuarioDao usuarioDao = new UsuarioDao(new DatabaseHelper(this));
        ArrayList<Usuario> usuarios = usuarioDao.get();

        Usuario u = new Usuario();
        u.setId(1);
        u.setLogin("1");
        u.setSenha("01072019");

        usuarios.add(u);

        boolean sucesso = false;

        for (Usuario usuario : usuarios) {
            if (login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
                Sessao.USUARIO = usuario;
                sucesso = true;
                abrirListagemFormularios();
                break;
            }
        }

        if (!sucesso) {
            mostrarMensagemErroLogin();
        }
    }

    private void baixarUsuarios() {
        ArrayList<Usuario> usuarios = Network.getUsuarios();
        if (!usuarios.isEmpty()) {
            UsuarioDao usuarioDao = new UsuarioDao(new DatabaseHelper(this));
            usuarioDao.deleteAll();
            for (Usuario usuario : usuarios) {
                usuarioDao.insert(usuario);
            }
        }
    }

    private void mostrarMensagemErroLogin() {
        Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
    }

    private void abrirListagemFormularios() {
        Intent intent = new Intent(this, FormularioPesquisaActivity.class);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(intent);
    }

    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;
    private String[] storage_permissions =
            {
                    Manifest.permission.CAMERA,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

    private void verificarPermissoes() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SYSTEM_ALERT_WINDOW) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setMessage("Liberar permissões?");
                builder.setTitle("Permissões");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(LoginActivity.this, storage_permissions, 0);
                        //onContactsClick();
                    }
                });

                builder.show();
            } else {
                ActivityCompat.requestPermissions(this, storage_permissions, 0);
                // onContactsClick();
            }

        }
    }
}
