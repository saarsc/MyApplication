package firstapplication.saarsc.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class TicTacToeGame extends AppCompatActivity implements View.OnClickListener{;

    TextView tvPlayer1Name;
    TextView tvPlayer2Name;
    static int turn;
    TicTacToeManger manager;
    Button[][] board= new Button[3][3];
    public Random rnd  = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);
        //Gettin every thing form the last activity
        String player1Name = getIntent().getStringExtra("nameOne");
        String player2Name = getIntent().getStringExtra("nameTwo");
        //Sync that shit up
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                String str= "btn"  + i + j;
                int resID = getResources().getIdentifier(str, "id", getPackageName());
                board[i][j] = (Button)findViewById(resID);
                board[i][j].setOnClickListener(TicTacToeGame.this);
                board[i][j].setText("~");
            }
        }
        manager  = new TicTacToeManger(this);
        manager.restart();
        tvPlayer1Name= (TextView)findViewById(R.id.tvPlayer1Name);
        tvPlayer2Name = (TextView) findViewById(R.id.tvPlayer2Name);
        tvPlayer1Name.setText(player1Name + "( X )");
        tvPlayer2Name.setText(player2Name + "( O )");
        turn = rnd.nextInt(2)+1;
        manager.setTurn(turn);
        if(turn == 1){
            tvPlayer2Name.setTextColor(Color.RED);
        }else{
            tvPlayer1Name.setTextColor(Color.RED);
        }
    }


    public void onClick(View view){
        //X turn
        if(turn == 2) {
            tvPlayer1Name.setTextColor(Color.BLACK);
            tvPlayer2Name.setTextColor(Color.RED);
            //Place X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (view.getId() == board[i][j].getId() && manager.occupied(i,j)) {
                        board[i][j].setText("X");
                        manager.place(i,j);
                    }
                }

            }

            //the winner
            if (manager.check()) {
                AlertDialog alertDialog = new AlertDialog.Builder(TicTacToeGame.this).create();
                alertDialog.setTitle("Congrats!");
                alertDialog.setMessage(tvPlayer1Name.getText() + " is the winner");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(TicTacToeGame.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();
            }
            if(manager.full()){
                AlertDialog alertDialog = new AlertDialog.Builder(TicTacToeGame.this).create();
                alertDialog.setTitle("IIts a shame");
                alertDialog.setMessage("There are no winners its a draw");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(TicTacToeGame.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();
            }
            turn =1;

        }
        else{
            tvPlayer2Name.setTextColor(Color.BLACK);
            tvPlayer1Name.setTextColor(Color.RED);
            //Place X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (view.getId() == board[i][j].getId() && manager.occupied(i,j)) {
                        board[i][j].setText("O");
                    }
                }

            }
            //First is the winner
            if (manager.check()) {
                AlertDialog alertDialog = new AlertDialog.Builder(TicTacToeGame.this).create();
                alertDialog.setTitle("Congrats!");
                alertDialog.setMessage(tvPlayer2Name.getText() + " is the winner");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(TicTacToeGame.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();

            }
            if(manager.full()){
                AlertDialog alertDialog = new AlertDialog.Builder(TicTacToeGame.this).create();
                alertDialog.setTitle("IIts a shame");
                alertDialog.setMessage("There are no winners its a draw");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(TicTacToeGame.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                alertDialog.show();
            }
            turn =2;
        }


    }
    @Override
    public void onBackPressed(){
            Intent intent = new Intent(TicTacToeGame.this,Register.class);
            intent.putExtra("game" , "xmixdrix");
            startActivity(intent);

    }
}
