package com.optum.fs.rest.service.util.leetcode;

public class    NumberOfIsland {
    static int count =0;
    public int numIslands(int[][] grid) {
        int result = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){

                if(grid[i][j]==1){
                    count=count+1;
                    dfs(grid,i,j);
                }
                result = Math.max(result,count);
            }
        }
        return count;
    }
    public void dfs(int grid[][],int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]==0){
            return ;
        }
        grid[i][j] = 0;
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j+1);
        dfs(grid,i+1,j-1);
        dfs(grid,i-1,j+1);
        dfs(grid,i-1,j-1);

    }

    public static void main(String[] args) {
        int M[][] = { { 0, 0, 1, 1, 0 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 0, 0, 1 } };
        NumberOfIsland numberOfIsland= new NumberOfIsland();
        System.out.println(numberOfIsland.numIslands(M));
    }
}
