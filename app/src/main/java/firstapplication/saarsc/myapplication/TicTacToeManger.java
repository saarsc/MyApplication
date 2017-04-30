package firstapplication.saarsc.myapplication;

/**
 * Created by saarsc on 23/04/2017.
 */

public class TicTacToeManger {
    char[][] board ;
    TicTacToeGame game;
    int turn;
    //Constructor
    public TicTacToeManger(TicTacToeGame g){
        this.board =  new char[3][3];
        this.game = g;
    }
    //Getting the turn from the game so it could work here
    public void setTurn(int turn){
        this.turn = turn;
    }
    //Restart the all board with ~
    public void restart(){
        for(int i=0; i< this.board.length; i++){
            for(int j=0; j< this.board[i].length; j++){
                this.board[i][j] = '~';
            }
        }
    }

    public boolean full(){
        for(int i=0; i< this.board.length; i++){
            for(int j=0; j< this.board[i].length; j++){
                if(this.board[i][j] != 'X' && this.board[i][j] != 'O'){
                    return false;
                }
            }
        }
        return  true;
    }
    public boolean occupied(int i, int j){
        return this.board[i][j]!='X' && this.board[i][j]!='O';
    }
    //Check if someone won
    public boolean check() {
        for(int i=0; i< this.board.length; i++) {
            if(this.board[i][0]== this.board[i][1] && this.board[i][1] ==this.board[i][2] && (this.board[i][0] =='X' || this.board[i][0] =='O') ){
                return true;
            }
        }
        for(int i =0; i< this.board.length; i++){
            if(this.board[0][i]== this.board[1][i] && this.board[1][i] ==this.board[2][i] && (this.board[0][i] =='X' || this.board[0][i] =='O')){
                return true;
            }
        }
        if((this.board[0][0]==this.board[1][1] && this.board[1][1]== this.board[2][2] && (this.board[0][0]=='X' ||this.board[0][0]=='O')) ||(this.board[0][2]==this.board[1][1]&& this.board[1][1]==this.board[2][0] && (this.board[2][0]=='X' || this.board[2][0]=='O') ) ){
            return true;
        }
        return false;
    }

    public void place(int i, int j){
        if(turn==2){

            this.board[i][j] ='X';
            turn =1;
        }else if (turn ==1){

            this.board[i][j]='O';
            turn =2;
        }
    }
}
