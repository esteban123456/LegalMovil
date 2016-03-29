package com.example.esteban.legalmovil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends Activity {
TextView lb_mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        lb_mensaje= (TextView) findViewById(R.id.lbmensaje);
        lb_mensaje.setPaintFlags(lb_mensaje.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
    public void mensaje(View v)
    {
        Intent mainmenu=new Intent(this,MainMenu.class);
        startActivity(mainmenu);
   // Toast.makeText(this,"PRUEBA DE INGRESO",Toast.LENGTH_LONG).show();
    }
}
