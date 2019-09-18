package ianes.br.com.senai.ianes.config;

import java.util.List;

import ianes.br.com.senai.ianes.models.Ambientes;
import ianes.br.com.senai.ianes.models.Itens;
import ianes.br.com.senai.ianes.models.Movimentacao;
import ianes.br.com.senai.ianes.models.Usuario;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by 46923597811 on 14/06/2018.
 */

public interface RestInterface {

    @POST("auth/jwt")
    Call<ResponseBody> realizarLogin(@Body Usuario usuario);

    @GET("ambientes")
    Call<List<Ambientes>> listarAmbientes();

    @GET("itens")
    Call<List<Itens>> listarItens();

    @POST("itens/{id}/movimentacoes")
    Call<ResponseBody> movimentar(@Path("id") Long identificacao, @Body Movimentacao movimentar);

    @GET("itens/{id}/movimentacoes")
    Call<ResponseBody> movimentacoes(@Path("id") Long identificacao, @Body Movimentacao movimentar);

}
