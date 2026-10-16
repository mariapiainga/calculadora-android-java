package com.example.calculadorabsica;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private TextView result;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir, btnBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);
        result = (TextView) findViewById(R.id.result);
        btnSumar = (Button) findViewById(R.id.btnSumar);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
        btnDividir = (Button) findViewById(R.id.btnDividir);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void Calcular(View view) {

        double numero1 = Double.parseDouble(num1.getText().toString());
        double numero2 = Double.parseDouble(num2.getText().toString());
        double resultado = 0;
        int id = view.getId();

        if (id == R.id.btnSumar) {
            resultado = numero1 + numero2;
        } else if (id == R.id.btnRestar) {
            resultado = numero1 - numero2;
        } else if (id == R.id.btnMultiplicar) {
            resultado = numero1 * numero2;
        } else if (id == R.id.btnDividir) {
            if (numero2 == 0) {

                result.setText("No se puede dividir entre 0");
                return;

            } else {
                resultado = numero1 / numero2;
            }

        }

        result.setText(String.valueOf(resultado));

    }

    public void Borrar (View view){

        num1.setText("");
        num2.setText("");
    }


}