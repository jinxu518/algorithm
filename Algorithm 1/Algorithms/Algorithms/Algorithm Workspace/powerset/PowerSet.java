package powerset;

import java.util.*;

public class PowerSet {
    public static void main(String [] args) {
        List<Integer> list=new ArrayList<>();
        list.addAll(Arrays.asList(2,7,4,8,12));
        PowerSet pr=new PowerSet();
        System.out.println(pr.powerSet(list));
    }
    public List<Set<Integer>> powerSet(List<Integer> x) {
        List<Set<Integer>> p=new ArrayList<>();
        Set<Integer> s=new TreeSet<>();
        p.add(s);
        Set<Integer> t;
        while(!x.isEmpty()) {
            Integer f=x.remove(0);
            List<Set<Integer>> p1=new ArrayList<>();
            for(Set i:p) {
                t=new TreeSet<>();
                p1.add(i);
                t.add(f);
                t.addAll(i);
                p1.add(t);

            }
            p=p1;
        }

     return p;
    }
}
