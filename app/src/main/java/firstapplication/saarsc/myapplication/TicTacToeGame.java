package firstapplication.saarsc.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeGame extends AppCompatActivity implements View.OnClickListener{
        Button btnBack;
    Button btn00;
    Button btn01;
    Button btn02;
    Button btn10;
    Button btn11;
    Button btn12;
    Button btn20;
    Button btn21;
    Button btn22;
    TextView tvPlayer1Name;
    TextView tvPlayer2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);
        String player1Name = getIntent().getStringExtra("nameOne");
        String player2Name = getIntent().getStringExtra("nameTwo");

        btnBack = (Button)findViewById(R.id.btnBack);
        btn00 = (Button)findViewById(R.id.btn00);
        btn01 = (Button)findViewById(R.id.btn01);
        btn01 = (Button)findViewById(R.id.btn02);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn20 = (Button)findViewById(R.id.btn20);
        btn21 = (Button)findViewById(R.id.btn21);
        btn22 = (Button)findViewById(R.id.btn22);
        tvPlayer1Name= (TextView)findViewById(R.id.tvPlayer1Name);
        tvPlayer2Name = (TextView) findViewById(R.id.tvPlayer2Name);
        tvPlayer1Name.setText(player1Name);
        tvPlayer2Name.setText(player2Name);

        btnBack.setOnClickListener(this);
        btn00 .setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn20 .setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
    }
    public void onClick(View view){
        if(btnBack.getId() == view.getId()){
            Intent intent = new Intent(TicTacToeGame.this,Register.class);
            intent.putExtra("game" , "xmixdrix");
            startActivity(intent);
        }
    }
}
