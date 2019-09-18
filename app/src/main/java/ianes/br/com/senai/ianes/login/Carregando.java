package ianes.br.com.senai.ianes.login;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.views.LoginActivity;

public class Carregando extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carregando);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent  = new Intent(Carregando.this, LoginActivity.class);
                startActivity(intent);
            }
        }, 5000);

    }
}