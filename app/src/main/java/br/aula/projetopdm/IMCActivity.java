package br.aula.projetopdm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    private EditText editTextPeso, editTextAltura;
    private Button buttonCalcular, buttonLimpar;
    private TextView textViewResultado;
    private ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        // Inicializa os componentes do layout
        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        textViewResultado = findViewById(R.id.textViewResultado);
        btnClose = findViewById(R.id.btnClose);

        // Define a ação do botão Calcular
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        // Define a ação do botão Limpar
        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparCampos();
            }
        });

        // Define a ação do botão de fechar (X)
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Fecha a activity atual
            }
        });
    }

    // Método para calcular o IMC
    private void calcularIMC() {
        String pesoStr = editTextPeso.getText().toString();
        String alturaStr = editTextAltura.getText().toString();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, insira o peso e a altura", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converte os valores para double
        double peso = Double.parseDouble(pesoStr);
        double altura = Double.parseDouble(alturaStr);

        if (altura <= 0 || peso <= 0) {
            Toast.makeText(this, "Peso e altura devem ser maiores que zero", Toast.LENGTH_SHORT).show();
            return;
        }

        // Calcula o IMC
        double imc = peso / (altura * altura);
        String classificacao = classificarIMC(imc);

        // Exibe o resultado
        textViewResultado.setText(String.format("IMC: %.2f\nClassificação: %s", imc, classificacao));
    }

    // Método para classificar o IMC
    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade Grau I";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III (Obesidade Mórbida)";
        }
    }

    // Método para limpar os campos de texto
    private void limparCampos() {
        editTextPeso.setText("");
        editTextAltura.setText("");
        textViewResultado.setText("");
    }
}
