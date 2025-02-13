import java.util.*;

class Board{
    int size;
    Character[][] grid;

    public Board(int s){
        this.size = s;
        this.grid = new Character[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.grid[i][j]=' ';
            }
        }
    }

    public String display() {
        String s = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-1; j++) {
                s+=grid[i][j] + "  ";
            }
            s+=grid[i][size-1];
            System.out.println();
        }
        return s;
    }
    public boolean isValidMove(int row,int col){
        if(row>=this.size || col>=this.size||row<0||col<0){
            return false;
        }
        return true;
        // return ((row<size && col < size)&&(!(row<0 && col<0)))&&(grid[row][col]==' ');
    }
    public boolean placeMove(int row,int col,Character symbol){
        if(isValidMove(row, col)&&(grid[row][col]==' ')){
            grid[row][col]=symbol;
            return true;
        }
        return false;
    }
    public boolean checkWin(Character symbol){
        int count = 4;
        for(int i=0;i<1;i++){
            for(int j=0;j<grid.length;j++){
                if(!(grid[i][j]==symbol)){
                    count--;
                    break;
                }
            }
        }
        if(count==4){
            return true;
        }
        for(int i=0;i<1;i++){
            for(int j=0;j<grid.length;j++){
                if((grid[j][i]!=symbol)){
                    count--;
                    break;
                }
            }
        }
        if(count==3){
            return true;
        }
        for(int i=0;i<grid.length;i++){
                if(!(grid[i][i]==symbol)){
                    count--;
                    break;
                }
        }
        if(count==2){
            return true;
        }
        for(int i=0;i<grid.length;i++){
            if(!(grid[i][grid.length-i-1]==symbol)){
                count--;
                break;
            }
        }
        if(count==1){
            return true;
        }
        return false;
        
    }
    public boolean checkDraw(){
        for(int i=0;i<this.size;i++){
            for(int j=0;j<this.size;j++){
                if((grid[i][j]==' ')){
                    return false;
                }
            }
        } 
        if(!(checkWin('X')&&checkWin('O'))){
            return true;
        }
        return false;
    }
}
// class Player{
//     Character symbol;
//     String name;
//     Scanner sc;

//     public Player(Character s,String Identifier,Scanner n){
//         this.symbol=s;
//         this.name=Identifier;
//         this.sc = n;
//     }

//     public List<Integer> get_move(Board b){
//         List<Integer> l = new ArrayList<>();
//         int row = sc.nextInt();
//         int col = sc.nextInt();
//         l.addAll(List.of(row,col));
//         return l; 
//     }
// }
// class Game{
//     Board board;
//     Player[] players;
//     int current_player_index;
//     Scanner sc;

//     public Game(int size,Player[] players,Scanner s){
//         this.board.size = size;
//         this.players = players;
//         this.sc = s;
//     }
//     public void start(){

//     }
// }