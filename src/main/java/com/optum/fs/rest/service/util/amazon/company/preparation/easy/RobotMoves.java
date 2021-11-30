package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

public class RobotMoves {
    public static void main(String[] args) {
        RobotMoves robotMoves = new RobotMoves();
        String moves = "GGLLGG";
        System.out.println(robotMoves.isCircular(moves));
    }

    public boolean isCircular(String moves) {
        int dir = 0;
        int x=0;
        int y=0;
        int[][]dist = {{0,1},{1,0},{0,-1},{-1,0}};
        if(moves.length()==0) return false;
        for(int i=0;i<moves.length();i++){
            int ch = moves.charAt(i);
            if(ch=='R'){
                dir = (dir+1)%4;
            }else if(ch=='L'){
                dir = (dir+3)%4;
            }else{
                x+=dist[dir][0];
                y+=dist[dir][1];
            }
        }
        return (x==0 && y==0) || dir >0;
    }
}
