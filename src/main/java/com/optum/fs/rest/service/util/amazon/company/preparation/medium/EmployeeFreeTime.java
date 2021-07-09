package com.optum.fs.rest.service.util.amazon.company.preparation.medium;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> avail = new ArrayList<>();
        List<Interval> result = new ArrayList();
        for(int i=0;i<schedule.size();i++){
            avail.addAll(schedule.get(i));
        }
        Collections.sort(avail,(a, b)->(a.start-b.start));

        Interval curr = avail.get(0);
        for(int i=1;i<avail.size();i++){
            Interval each = avail.get(i);
            if(curr.end < each.start){
                result.add(new Interval(curr.end,each.start));
                curr = each;
            }else{
                curr = curr.end < each.end ?each:curr;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();
        Interval interval = new Interval(1,3);
        Interval interval2 = new Interval(1,2);
        Interval interval3 = new Interval(5,6);
        List<Interval> list = new ArrayList<>();
        list.add(interval2);
        list.add(interval3);
        Interval interval4 = new Interval(4,10);
        Interval interval5 = new Interval(1,3);
    }
}
class Interval{
    int start;
    int end;
    Interval(int start,int end){
        this.start = start;
        this.end = end;
    }

}
