package cl.santotomas.prueban2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nombre, apellido, tarjeta, mes, año, codigo, calle, cuidad, estado, codigop;
    Button bton2, bton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = (EditText)findViewById(R.id.nombre);
        apellido    = (EditText)findViewById(R.id.apellido);
        tarjeta     = (EditText)findViewById(R.id.tarjeta);
        mes         = (EditText)findViewById(R.id.mes);
        año         = (EditText)findViewById(R.id.año);
        calle       = (EditText)findViewById(R.id.calle);
        cuidad      = (EditText)findViewById(R.id.ciudad);
        estado      = (EditText)findViewById(R.id.estado);
        codigop     = (EditText)findViewById(R.id.codigop);
        codigo      = (EditText)findViewById(R.id.codigo);
        bton2        = (Button)findViewById(R.id.bton2);
        bton3        = (Button)findViewById(R.id.bton3);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "registro", null, 1);
        SQLiteDatabase registros = admin.getWritableDatabase();

        String name = nombre.getText().toString();
        String m = mes.getText().toString();
        String a = año.getText().toString();
        String card = tarjeta.getText().toString();

        if (nombre.getText().toString().isEmpty() && mes.getText().toString().isEmpty() && año.getText().toString().isEmpty() && tarjeta.getText().toString().isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("name", name);
            registro.put("m", m);
            registro.put("a", a);
            registro.put("card", card);

            registros.insert("registros", null, registro);

            registros.close();
            nombre.setText("");
            mes.setText("");
            año.setText("");
            tarjeta.setText("");


        } else{
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }

        bton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nombre.getText().toString();
                String m = mes.getText().toString();
                String a = año.getText().toString();
                String card = tarjeta.getText().toString();

                Intent bton2 = new Intent(MainActivity.this, DetailActivity.class);

                bton2.putExtra("name", name);
                bton2.putExtra("m", m);
                bton2.putExtra("a", a);
                bton2.putExtra("card", card);

                startActivity(bton2);
            }
        });
        
    }
}