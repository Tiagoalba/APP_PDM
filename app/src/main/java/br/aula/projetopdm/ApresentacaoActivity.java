package br.aula.projetopdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ApresentacaoActivity extends AppCompatActivity {

    private TextView textViewNomeAluno, textViewCurso, textViewMatricula, textViewSemestre, textViewDisciplina;
    private ImageButton btnClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentacao);

        // Inicializa os TextViews do layout
        textViewNomeAluno = findViewById(R.id.textViewNomeAluno);
        textViewCurso = findViewById(R.id.textViewCurso);
        textViewMatricula = findViewById(R.id.textViewMatricula);
        textViewSemestre = findViewById(R.id.textViewSemestre);
        textViewDisciplina = findViewById(R.id.textViewDisciplina);

        // Dados fictícios do aluno
        String nomeAluno = "Tiago Albano";
        String curso = "ADS";
        String matricula = "33880930";
        String semestre = "4º Semestre";
        String disciplina = "Programação para Dispositivos Móveis";

        // Define os textos para os TextViews
        textViewNomeAluno.setText("Nome do Aluno: " + nomeAluno);
        textViewCurso.setText("Curso: " + curso);
        textViewMatricula.setText("Número de Matrícula: " + matricula);
        textViewSemestre.setText("Semestre: " + semestre);
        textViewDisciplina.setText("Disciplina: " + disciplina);

        // Inicializa o botão de fechar (X)
        btnClose = findViewById(R.id.btn_close);

        // Define a ação de voltar para a MainActivity ao clicar no botão X
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Voltar para a MainActivity
                Intent intent = new Intent(ApresentacaoActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finaliza a activity atual
            }
        });
    }
}
