package com.luisfernandomgrs.learning.listview02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listLocales;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe",
            "Ilhés", "Porto Seguro", "Tiradentes",
            "Praga", "Santiago", "Zurique", "Caribe",
            "Buenos Aires", "Budapeste", "Cancún", "Aruba"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Lista de Itens");
        listLocales = findViewById(R.id.ListLocales);

        // Criar adaptador para a lista
        ArrayAdapter<String> adapterListLocales = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        // Adiciona o Adaptador para a lista...
        listLocales.setAdapter(adapterListLocales);

        // adiciona evento de click...
        listLocales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String valorSelecionado = listLocales.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(),
                        valorSelecionado,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}