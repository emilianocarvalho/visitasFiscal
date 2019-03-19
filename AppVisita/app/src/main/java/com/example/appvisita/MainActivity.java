package com.example.appvisita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView rc;
    private String HOST = "http://192.168.0.103/VisitasFiscais";
    private VisitasAdapter va;
    private List<visitasListar> lista;

    EditText nome, matriucla;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /*nome = (EditText) findViewById(R.id.edtNome);
        matriucla = (EditText) findViewById(R.id.edtMatricula);
        btn = (Button) findViewById(R.id.btn_teste);*/

        rc = (RecyclerView) findViewById(R.id.rc_lista);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);

        lista = new ArrayList<visitasListar>();
        va = new VisitasAdapter(lista);
        rc.setAdapter(va);

        
        Listar();

          /*  btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fiscal f = new fiscal();
                    f.setMatricula(matriucla.getText().toString());
                    f.setNome(nome.getText().toString());

                    String url =HOST+"/create.php";

                    Ion.with(MainActivity.this)
                            .load(url)
                            .setBodyParameter("matricula",f.getMatricula())
                            .setBodyParameter("nome",f.getNome())
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {

                                    try {
                                        if (result.get("CREATE").getAsString().equals("OK")) {

                                            Toast.makeText(MainActivity.this, "DeuBom Fera", Toast.LENGTH_LONG).show();

                                        } else {
                                            Toast.makeText(MainActivity.this, "DEU RUIM Fera", Toast.LENGTH_LONG).show();
                                        }
                                    }catch (NullPointerException erro){

                                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();


                                    }
                                }
                            });
                }
            });*/




    }
    private void Listar(){
        String url = HOST + "/testeListar.php";

        Ion.with(getBaseContext())
                .load(url)
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {


                        for (int i = 0; i < result.size(); i++) {

                            JsonObject obj = result.get(i).getAsJsonObject();

                            visitasListar v = new visitasListar();

                            v.setCidade(obj.get("cidade").getAsString());
                            v.setCnpj(obj.get("cnpj").getAsString());
                            v.setData(obj.get("dataa").getAsString());
                            v.setRazao(obj.get("estabelecimento").getAsString());
                            v.setEquipe(obj.get("equipe").getAsString());
                            v.setFiscal(obj.get("fiscal").getAsString());
                            v.setIrregularidade(obj.get("irregularidade").getAsString());
                            v.setNumero(obj.get("numero").getAsInt());
                            v.setRecusa_receber(obj.get("recusa_receber").getAsString());
                            v.setTipo_auto(obj.get("tipo_auto").getAsString());
                            v.setObservacao(obj.get("observacao").getAsString());

                            lista.add(v);

                        }
                        va.notifyDataSetChanged();
                    }

                });

    }
}


