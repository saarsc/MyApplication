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

public class TicTacToeGame extends AppCompatActivity implements View.OnClickListener{Button btnBack;
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
    static int turn;
    Button[][] board= new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);
        String player1Name = getIntent().getStringExtra("nameOne");
        String player2Name = getIntent().getStringExtra("nameTwo");
        //Sync that shit up

        btn00 = (Button)findViewById(R.id.btn00);
        btn01 = (Button)findViewById(R.id.btn01);
        btn02 = (Button)findViewById(R.id.btn02);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn20 = (Button)findViewById(R.id.btn20);
        btn21 = (Button)findViewById(R.id.btn21);
        btn22 = (Button)findViewById(R.id.btn22);
        tvPlayer1Name= (TextView)findViewById(R.id.tvPlayer1Name);
        tvPlayer2Name = (TextView) findViewById(R.id.tvPlayer2Name);
        tvPlayer1Name.setText(player1Name + "( X )");
        tvPlayer2Name.setText(player2Name + "( O )");
        //Click listner

        btn00 .setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn20 .setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        //Board
        board[0][0] = btn00;
        board[0][1] = btn01;
        board[0][2] = btn02;

        board[1][0] = btn10;
        board[1][1] = btn11;
        board[1][2] = btn12;

        board[2][0] = btn20;
        board[2][1] = btn21;
        board[2][2] = btn22;
        turn =1;
        for(int i =0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
                board[i][j].setText("~");
            }
        }
        tvPlayer1Name.setTextColor(Color.RED);
    }
    public boolean occupied(Button btn){
        return !btn.getText().equals("X") && !btn.getText().equals("O");

    }
    public boolean check(){
          if (turn == 1) {
                    for(int i=0; i< board.length; i++) {
                        if(board[i][0].getText().equals("X") && board[i][1].getText().equals("X") && board[i][2].getText().equals("X")){
                            return true;
                        }
                }
                    for(int i =0; i< board.length; i++){
                        if(board[0][i].getText().equals("X") && board[1][i].getText().equals("X") && board[2][i].getText().equals("X")){
                            return true;
                        }
                    }
                 if((board[0][0].getText().equals("X") && board[1][1].getText().equals("X") && board[2][2].getText().equals("X")) ||(board[0][2].getText().equals("X") && board[1][1].getText().equals("X") && board[2][0].getText().equals("X")) ){
                    return true;
                 }

            }else{
              for(int i=0; i< board.length; i++) {
                  if(board[i][0].getText().equals("O") && board[i][1].getText().equals("O") && board[i][2].getText().equals("O")){
                      return true;
                  }
              }
              for(int i =0; i< board.length; i++){
                  if(board[0][i].getText().equals("O") && board[1][i].getText().equals("O") && board[2][i].getText().equals("O")){
                      return true;
                  }
              }
              if((board[0][0].getText().equals("O") && board[1][1].getText().equals("O") && board[2][2].getText().equals("O")) ||(board[0][2].getText().equals("O") && board[1][1].getText().equals("O") && board[2][0].getText().equals("O")) ){
                  return true;
              }
          }


        return false;
    }
    public boolean full(){
        for(int i=0; i< board.length; i++){
            for(int j=0; j< board[i].length; j++){
             if(board[i][j].getText() != "X" && board[i][j].getText() != "O"){
                 return false;
             }
            }
        }
        return  true;
    }
    public void onClick(View view){
        //X turn

        if(turn == 1) {
            tvPlayer2Name.setTextColor(Color.BLACK);
            tvPlayer1Name.setTextColor(Color.RED);
            //Place X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (view.getId() == board[i][j].getId() && occupied(board[i][j])) {
                        board[i][j].setText("X");
                    }
                }

            }

            //First is the winner
            if (check()) {
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
            if(full()){
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
        else{
            tvPlayer1Name.setTextColor(Color.BLACK);
            tvPlayer2Name.setTextColor(Color.RED);
            //Place X
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (view.getId() == board[i][j].getId() && occupied(board[i][j])) {
                        board[i][j].setText("O");
                    }
                }

            }
            //First is the winner
            if (check()) {
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
            if(full()){
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

   /*         if(view.getId() == btn00.getId()){

            }else  if(view.getId() == btn01.getId()){

            }else if(view.getId() == btn02.getId()){

            }else  if(view.getId() == btn10.getId()){

            }else  if(view.getId() == btn11.getId()){

            }else  if(view.getId() == btn12.getId()){

            }else if(view.getId() == btn20.getId()){

            }else  if(view.getId() == btn21.getId()){

            }else if(view.getId() == btn22.getId()){

            }*/
           // turn =2;
        /*} else {
            tvPlayer1Name.setTextColor(Color.BLACK);
            if(view.getId() == btn00.getId()){

            }else  if(view.getId() == btn01.getId()){

            }else if(view.getId() == btn02.getId()){

            }else  if(view.getId() == btn10.getId()){

            }else  if(view.getId() == btn11.getId()){

            }else  if(view.getId() == btn12.getId()){

            }else if(view.getId() == btn20.getId()){

            }else  if(view.getId() == btn21.getId()){

            }else if(view.getId() == btn22.getId()){

            }
            turn =1;
        }*/

    }
    @Override
    public void onBackPressed(){
            Intent intent = new Intent(TicTacToeGame.this,Register.class);
            intent.putExtra("game" , "xmixdrix");
            startActivity(intent);

    }
}
