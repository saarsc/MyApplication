package firstapplication.saarsc.myapplication;

/**
 * Created by saarsc on 23/04/2017.
 */

public class TicTacToeManger {
    char[][] board ;
    TicTacToeGame game;
    int turn;
    public TicTacToeManger(TicTacToeGame g){
        this.board =  new char[3][3];
        this.game = g;
    }
    public void setTurn(int turn){
        this.turn = turn;
    }
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
        return this.board[i][j]!=('X') && this.board[i][j]!='O';
    }
    public boolean check(){
        if (turn == 2) {
            for(int i=0; i< this.board.length; i++) {
                if(this.board[i][0]=='X' && this.board[i][1] =='X' && this.board[i][2]=='X'){
                    return true;
                }
            }
            for(int i =0; i< this.board.length; i++){
                if(this.board[0][i]=='X' && this.board[1][i]=='X' && this.board[2][i]=='X'){
                    return true;
                }
            }
            if((this.board[0][0]=='X' && this.board[1][1]=='X' && this.board[2][2]=='X') ||(this.board[0][2]=='X'&& this.board[1][1]=='X' && this.board[2][0]=='X') ){
                return true;
            }

        }else{
            for(int i=0; i< this.board.length; i++) {
                if(this.board[i][0]=='O' && this.board[i][1]=='O' && this.board[i][2]=='O'){
                    return true;
                }
            }
            for(int i =0; i< this.board.length; i++){
                if(this.board[0][i]=='O' && this.board[1][i]=='O' && this.board[2][i]=='O'){
                    return true;
                }
            }
            if((this.board[0][0]=='O' && this.board[1][1]=='O' && this.board[2][2]=='O') ||(this.board[0][2]=='O' && this.board[1][1]=='O' && this.board[2][0]=='O') ){
                return true;
            }
        }
        return false;
    }
    public void place(int i, int j){
        if(turn==2){
            this.board[i][j] ='X';
            turn =2;
        }else{
            this.board[i][j]='O';
            turn =2;
        }
    }
}
