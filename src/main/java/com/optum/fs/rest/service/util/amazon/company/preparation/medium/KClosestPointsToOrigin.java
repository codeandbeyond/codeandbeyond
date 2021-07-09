package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        kClosestPointsToOrigin.kClosest(new int[][]{{1,3},{-2,2}},1);
        kClosestPointsToOrigin.quickselect(new int[][]{{1,3},{-2,2}},1);
    }

    private void quickselect(int[][] points, int k) {
        int l=0;
        int r=points.length;
        while(l<r){
            int pivot = helper(l,r,points);
            if(pivot==k){
                break;
            }else if(pivot<k){
                l = pivot+1;
            }else{
                r=pivot-1;
            }
        }
        for(int i=0;i<k;i++){
            System.out.println(points[i][0]+" "+points[i][1]);
        }
    }

    private int helper(int l, int r, int[][] points) {
        int[] v = points[l];
        int i=l;
        int j = points.length;
        while(true){
            while(isLess(points[++i],v)){
                if(i==r){
                    break;
                }
            }
            while(isLess(v,points[--j])){
                if(j==l){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            exchange(points,i,j);
        }
        exchange(points,l,j);
        return j;
    }

    private void exchange(int[][] points, int l, int r) {
        int[] temp = points[l];
        points[l] = points[r];
        points[r] = temp;

    }

    private boolean isLess(int[] point, int[] v) {
       return (point[0]*point[0]+point[1]*point[1]- v[0]*v[0]+v[1]*v[1])<0;
    }

    public  int[][] kClosest(int[][] points, int K) {
        int[][] results = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            public int compare(int[]p1,int[]p2){
                return (getDistance(p2)-getDistance(p1));
            }
        });

        System.out.println(pq);
        for(int[] point:points){
            pq.offer(point);
            while(pq.size()>K){
                pq.poll();
            }
        }
        while(K-->0){
            results[K] =  pq.poll();
        }
        System.out.println("The end");
        return results;
    }

    private int getDistance(int[] point) {
       return point[0]*point[0]+point[1]*point[1];
    }
}
