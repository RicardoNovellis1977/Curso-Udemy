package com.example.ricardo.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtAlcool;
    private EditText edtGasolina;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtAlcool = findViewById(R.id.txtAlcool);
        edtGasolina = findViewById(R.id.txtGasolina);
        txtResultado = findViewById(R.id.txtResultado);
    }

    public void calcularPreco(View view){

       String precoAlcool =  edtAlcool.getText().toString();
       String precoGasolina = edtGasolina.getText().toString();

       Boolean camposValidados = this.validarCampos(precoAlcool,precoGasolina);
       if(camposValidados){
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
       }else{
           txtResultado.setText(" Preencha os preços primeiro! ");
       }
    }

    public void calcularMelhorPreco(String pAlc, String pGas){

        Double precoAlcool = Double.parseDouble(pAlc);
        Double precoGasolina = Double.parseDouble(pGas);

        Double resultado = precoAlcool/precoGasolina;
        if (resultado >= 0.70){
            txtResultado.setText(" Melhor utilizar Gasolina! ");
        }else {
            txtResultado.setText(" Melhor usar Álcool! ");
        }
    }

     public boolean validarCampos(String pAlc, String pGas){

        Boolean camposValidados = true;

        if (pAlc == null || pAlc.equals("")){
            camposValidados = false;
        }else if(pGas == null || pGas.equals("")){
            camposValidados = false;
        }
        return camposValidados;
     }

}
