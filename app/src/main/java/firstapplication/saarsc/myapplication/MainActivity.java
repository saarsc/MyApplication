package firstapplication.saarsc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnBack;
    Button btnHangman;
    Button btnXMix;
    Button btnFourInARow;
    Button btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnHangman = (Button)findViewById(R.id.btnHangman);
        btnXMix = (Button)findViewById(R.id.btnXMix);
        btnFourInARow = (Button)findViewById(R.id.btnFourInARow);
        btnExit = (Button)findViewById(R.id.btnExit);
        btnXMix.setOnClickListener(this);
        btnHangman.setOnClickListener(this);
        btnFourInARow.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }
    public void onClick(View view){
        Button btn = (Button) view;
        if (btn.getId() == btnXMix.getId()){
            Intent intent = new Intent(MainActivity.this,Register.class);
            intent.putExtra("game" , "xmixdrix");
            startActivity(intent);
        }else if(btn.getId() == btnHangman.getId()){
            Intent intent = new Intent(MainActivity.this,Register.class);
            intent.putExtra("game" , "hangman");
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(MainActivity.this, SplashScreen.class);
        startActivity(intent);
    }


}
