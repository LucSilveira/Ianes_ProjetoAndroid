package ianes.br.com.senai.ianes.views;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import ianes.br.com.senai.ianes.MainActivity;
import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.config.RetrofitConfig;
import ianes.br.com.senai.ianes.models.Usuario;
import ianes.br.com.senai.ianes.utils.AppUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private EditText setEmailLogin;
    private EditText setSenhaLogin;
    private SharedPreferences sharedPreferences;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setEmailLogin = findViewById(R.id.emailLogin);
        setSenhaLogin = findViewById(R.id.senhaLogin);
        login = findViewById(R.id.btnLogar);

        setEmailLogin.setText("admin@email.com");
        setSenhaLogin.setText("admin");

        final SharedPreferences sharedPreferences = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d("Email: ", setEmailLogin.getEditText().getText().toString());
                Usuario usuario = new Usuario(setEmailLogin.getText().toString(),
                                              setSenhaLogin.getText().toString());

                Call<ResponseBody> chamadaLogin = new RetrofitConfig().getRestInterface().realizarLogin(usuario);
                chamadaLogin.enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            try{
                                JSONObject obj = new JSONObject(response.body().string());
                                String token = obj.getString("token");

                                //salvando o token no sharedPreferences
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("token", "Bearer " + token);
                                editor.apply();

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();

                                Log.d("token", token);
                            }catch (IOException e){
                                e.printStackTrace();
                            }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }

                        final SharedPreferences sharedPreferences = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);
                        String token = sharedPreferences.getString("token", "");
                        Log.d("tokenInvalido", token);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro ao fazer login", Toast.LENGTH_SHORT).show();
                        Log.d("Login Error: ", t.getMessage());
                    }
                });
            }
        });

    }
}
