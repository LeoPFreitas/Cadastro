package com.example.cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.vo.Formulario;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEt;
    private EditText phoneEt;
    private EditText emailEt;
    private CheckBox emailListCb;
    private EditText cityEt;
    private RadioButton maleRb;
    private Spinner stateS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEt = findViewById(R.id.nameEt);
        phoneEt = findViewById(R.id.phoneEt);
        emailEt = findViewById(R.id.emailEt);
        emailListCb = findViewById(R.id.emailListCb);
        cityEt = findViewById(R.id.cityEt);
        maleRb = findViewById(R.id.maleRb);
        stateS = findViewById(R.id.statesS);
        Button clearBt = findViewById(R.id.clearBt);
        Button saveBt = findViewById(R.id.saveBt);

        clearBt.setOnClickListener(this);
        saveBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Formulario formulario = setFormulario();
        String message = formulario.toString();
        if (view.getId() == R.id.saveBt && isAllFieldsFiled()) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        } else if(view.getId() == R.id.clearBt) {
            clearAllFields();
        }
    }

    private boolean isAllFieldsFiled() {
        return !nameEt.getText().toString().equals("") &&
                !phoneEt.getText().toString().equals("") &&
                !emailEt.getText().toString().equals("") &&
                !cityEt.getText().toString().equals("");
    }

    private void clearAllFields() {
        nameEt.setText("");
        phoneEt.setText("");
        emailEt.setText("");
        cityEt.setText("");
        emailListCb.setChecked(false);
        maleRb.setChecked(true);
        stateS.setSelection(0);
    }

    private Formulario setFormulario() {
        String name = nameEt.getText().toString();
        String phone = phoneEt.getText().toString();
        String email = emailEt.getText().toString();
        String gender = maleRb.isChecked() ? "Masculino":"Feminino";
        boolean isList = emailListCb.isChecked();
        String city = cityEt.getText().toString();
        String state = ((TextView)stateS.getSelectedView()).getText().toString();

        return new Formulario(name, phone, email, gender, isList, city, state);
    }
}