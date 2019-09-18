package ianes.br.com.senai.ianes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;

import ianes.br.com.senai.ianes.config.RetrofitConfig;
import ianes.br.com.senai.ianes.models.Ambientes;
import ianes.br.com.senai.ianes.models.Itens;
import ianes.br.com.senai.ianes.models.Movimentacao;
import ianes.br.com.senai.ianes.utils.AppUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /******************************************/
    private List<Ambientes> listAmbientes;
    private Spinner ambientesSelect;
    private Ambientes ambientes;
    /********************************************/
    private List<Itens> listItens;
    private Spinner itensSelect;
    private Itens itens;
    /*******************************************/
    private String token = null;
    private Button movimentar;
    private Movimentacao movimenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        itensSelect = findViewById(R.id.selectItens);
        ambientesSelect = findViewById(R.id.selectAmbientes);
        movimentar = findViewById(R.id.btnMovimentar);

        final SharedPreferences sharedPreferences = getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);
            token = sharedPreferences.getString("token","");

            chamarItens();
        chamarAmbientes();


        itensSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long i) {
                itens = (Itens) itensSelect.getItemAtPosition(itensSelect.getSelectedItemPosition());
                Log.d("id", String.valueOf(itens.getId()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ambientesSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ambientes = (Ambientes) ambientesSelect.getItemAtPosition(ambientesSelect.getSelectedItemPosition());
                Log.d("destino", String.valueOf(ambientes.getId()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        movimentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movimenta = new Movimentacao(ambientes, itens);

                Call<ResponseBody> calz = new RetrofitConfig(token).getRestInterface().movimentar(itens.getId(), movimenta);
                calz.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            /* Já movimentou bb*/
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Não foi bb", Toast.LENGTH_LONG).show();

                    }
                });
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

            Intent intent = new Intent(MainActivity.this, ListsActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void chamarAmbientes(){
        Call<List<Ambientes>> call = new RetrofitConfig(token).getRestInterface().listarAmbientes();
        call.enqueue(new Callback<List<Ambientes>>() {
            @Override
            public void onResponse(Call<List<Ambientes>> call, Response<List<Ambientes>> response) {
                if(response.isSuccessful()){
                    listAmbientes = response.body();
                    if(listAmbientes != null){
                        ArrayAdapter<Ambientes> adapter = new ArrayAdapter<Ambientes>(getApplicationContext(), android.R.layout.simple_list_item_1, listAmbientes);
                        ambientesSelect.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Ambientes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                Log.d("Erro", t.getMessage());
            }
        });
    }

    private void chamarItens() {
        Call<List<Itens>> call = new RetrofitConfig(token).getRestInterface().listarItens();
        call.enqueue(new Callback<List<Itens>>() {
            @Override
            public void onResponse(Call<List<Itens>> call, Response<List<Itens>> response) {
                if(response.isSuccessful()){
                    listItens = response.body();
                    if(listItens != null){
                        ArrayAdapter<Itens> adapt = new ArrayAdapter<Itens>(getApplicationContext(), android.R.layout.simple_list_item_1, listItens);
                        itensSelect.setAdapter(adapt);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Itens>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage().toString(), Toast.LENGTH_LONG).show();
                Log.d("Erro", t.getMessage());

            }
        });

    }
}
