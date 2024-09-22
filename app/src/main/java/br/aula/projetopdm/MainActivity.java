package br.aula.projetopdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnFecharApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button buttonimc = findViewById(R.id.btn_IMC);
        buttonimc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,IMCActivity.class);
                startActivity(intent);
            }

        });
        Button buttonCombustivel = findViewById(R.id.btn_combustivel);
        buttonCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CombustivelActivity.class);
                startActivity(intent);
            }

        });

        Button buttonApresentacao = findViewById(R.id.btn_apresentacao);
        buttonApresentacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ApresentacaoActivity.class);
                startActivity(intent);
            }

        });

        // Inicializa o botão
        btnFecharApp = findViewById(R.id.btn_fecharapp);

        // Define a ação do botão para fechar o app
        btnFecharApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fecha o aplicativo
                finishAffinity();  // Finaliza todas as atividades e fecha o app
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}