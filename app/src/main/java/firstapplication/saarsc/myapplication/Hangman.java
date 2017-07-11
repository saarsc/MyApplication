package firstapplication.saarsc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Hangman extends AppCompatActivity {
    String[] words = {"elephant", "test", "idk", "ffs","I want to listen to music"};
    //Image
    ImageView img;
    int[] images = {R.mipmap.hangman0,R.mipmap.hangman1,R.mipmap.hangman2,R.mipmap.hangman3,R.mipmap.hangman4,R.mipmap.hangman5,R.mipmap.hangman6};
    //Bullshit
    TextView tv1Player;
    TextView tv2Player;
    player[] players;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangman);
        tv1Player = (TextView)findViewById(R.id.tvPlayer1Name);
        tv2Player = (TextView)findViewById(R.id.tvPlayer2Name);
        players[0] = new player('X',getIntent().getStringExtra("nameOne"));
        players[1]= new player('O',getIntent().getStringExtra("nameTwo"));


    }
}
