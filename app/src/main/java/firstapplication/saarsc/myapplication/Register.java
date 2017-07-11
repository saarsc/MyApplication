package firstapplication.saarsc.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{
    Button btnBack;
    EditText etPlayer1;
    EditText etPlayer2;
    Button btnConfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe);
        btnConfirm = (Button) findViewById(R.id.btnConfirm);
        btnConfirm.setOnClickListener(this);
        etPlayer1 = (EditText)findViewById(R.id.etPlayer1);
        etPlayer2=(EditText) findViewById(R.id.etPlayer2);
    }
    public void onClick(View view){
        String game = getIntent().getStringExtra("game");
        AlertDialog alertDialog = new AlertDialog.Builder(Register.this).create();

    if(etPlayer1.getText().toString().isEmpty()){
            alertDialog.setTitle("Empty box!");
            alertDialog.setMessage("First player please enter a name");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
    }else
        if(etPlayer2.getText().toString().isEmpty()){
            alertDialog.setTitle("Empty box!");
            alertDialog.setMessage("Second player please enter a name");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }

       else
        if(btnConfirm.getId() == view.getId()){

        if(game.equals("xmixdrix")) {

            Intent intent = new Intent(Register.this, TicTacToeGame.class);
            intent.putExtra("nameOne",etPlayer1.getText().toString());
            intent.putExtra("nameTwo",etPlayer2.getText().toString());
            startActivity(intent);
        }
            if(game.equals("hangman")) {

                Intent intent = new Intent(Register.this, Hangman.class);
                intent.putExtra("nameOne",etPlayer1.getText().toString());
                intent.putExtra("nameTwo",etPlayer2.getText().toString());
                startActivity(intent);
            }
    }
    }
    @Override
    public void onBackPressed(){

            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);


    }

}
