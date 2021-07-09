package com.optum.fs.rest.service.util.amazon.company.preparation.medium;

import java.util.*;

public class GetMovies {
    private  int[] get2SumClosest(int[] movie_duration, int d) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<movie_duration.length;i++) {
            map.putIfAbsent(movie_duration[i], new ArrayList<>());
            map.get(movie_duration[i]).add(i);
        }
        Arrays.sort(movie_duration);
        int l = 0, r = movie_duration.length - 1;
        int max = 0;
        int[] res = new int[]{-1, -1};
        while(l < r) {
            int sum = movie_duration[l] + movie_duration[r];
            if((sum > max || (sum == max && Math.max(movie_duration[l] , movie_duration[r]) > Math.max(res[0],  res[1]))) && sum <= d) {
                max = sum;
                res[0] = movie_duration[l];
                res[1] = movie_duration[r];
            }
            if(sum > d)
                r--;
            else
                l++;
        }
        if (map.get(res[0]) == map.get(res[1])) {
            res[0] = map.get(res[0]).get(map.get(res[0]).size() - 2);
            res[1] = map.get(res[1]).get(map.get(res[1]).size() - 1);
        } else {
            res[0] = map.get(res[0]).get(map.get(res[0]).size() - 1);
            res[1] = map.get(res[1]).get(map.get(res[1]).size() - 1);
        }

        return res;
    }

    public static void main(String[] args) {
        GetMovies getMovies = new GetMovies();
        int[] duration = {90, 300, 75, 100, 400,110,110, 150, 300};
        int time = 600;
        int[] res = getMovies.get2SumClosest(duration,time);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
}
