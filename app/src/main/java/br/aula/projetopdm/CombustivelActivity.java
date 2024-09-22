package br.aula.projetopdm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

public class CombustivelActivity extends AppCompatActivity {

    private EditText editTextGasolina, editTextAlcool;
    private RadioGroup radioGroupCombustivel;
    private RadioButton radioButtonGasolina, radioButtonAlcool;
    private TextView textViewResultado;
    private Button buttonLimpar;
    private ImageButton btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combustivel);

        // Inicializa os componentes do layout
        editTextGasolina = findViewById(R.id.editTextGasolina);
        editTextAlcool = findViewById(R.id.editTextAlcool);
        radioGroupCombustivel = findViewById(R.id.radioGroupCombustivel);
        radioButtonGasolina = findViewById(R.id.radioButtonGasolina);
        radioButtonAlcool = findViewById(R.id.radioButtonAlcool);
        textViewResultado = findViewById(R.id.textViewResultado);
        buttonLimpar = findViewById(R.id.buttonLimpar);
        btnClose = findViewById(R.id.btnClose);

        // Define o ouvinte para o RadioGroup
        radioGroupCombustivel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calcularRelacao();
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

    // Método para calcular a relação e mostrar o resultado
    private void calcularRelacao() {
        String gasolinaStr = editTextGasolina.getText().toString();
        String alcoolStr = editTextAlcool.getText().toString();

        // Verifica se os campos estão preenchidos
        if (TextUtils.isEmpty(gasolinaStr) || TextUtils.isEmpty(alcoolStr)) {
            Toast.makeText(this, "Por favor, insira o valor da gasolina e do álcool", Toast.LENGTH_SHORT).show();
            return;
        }

        // Converte os valores para double
        double precoGasolina = Double.parseDouble(gasolinaStr);
        double precoAlcool = Double.parseDouble(alcoolStr);

        if (precoGasolina <= 0 || precoAlcool <= 0) {
            Toast.makeText(this, "Os valores devem ser maiores que zero", Toast.LENGTH_SHORT).show();
            return;
        }

        // Verifica qual combustível foi selecionado
        int checkedId = radioGroupCombustivel.getCheckedRadioButtonId();
        if (checkedId == R.id.radioButtonGasolina) {
            calcularDiferenca(precoGasolina, precoAlcool, "Gasolina");
        } else if (checkedId == R.id.radioButtonAlcool) {
            calcularDiferenca(precoAlcool, precoGasolina, "Álcool");
        }
    }

    // Método para calcular a diferença em relação aos 70% e exibir o resultado
    private void calcularDiferenca(double valor1, double valor2, String combustivelSelecionado) {
        double relacao = valor1 / valor2;
        double diferenca = (relacao - 0.7) * 100; // Diferença em relação aos 70%

        if (relacao <= 0.7) {
            textViewResultado.setText(String.format("%s é mais vantajoso!\nRelação: %.2f\nDiferença: %.2f%% abaixo dos 70%%", combustivelSelecionado, relacao, Math.abs(diferenca)));
        } else {
            textViewResultado.setText(String.format("%s é menos vantajoso.\nRelação: %.2f\nDiferença: %.2f%% acima dos 70%%", combustivelSelecionado, relacao, diferenca));
        }
    }

    // Método para limpar os campos de texto
    private void limparCampos() {
        editTextGasolina.setText("");
        editTextAlcool.setText("");
        textViewResultado.setText("");
        radioGroupCombustivel.clearCheck();
    }
}
