package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        Map<List<Integer>,String> map = new LinkedHashMap<>(a);
        for (int i = 0; i<a; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(in.nextInt());
            in.skip(" ");
            String n2 = in.nextLine();
            map.put(list,n2);
        }
        Map<String, List<Integer>> sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors
                        .toMap(Map.Entry::getValue,
                                Map.Entry::getKey,
                                (e1, e2) -> {e1.add(e2.get(0));return e1;},
                                LinkedHashMap::new));
        sortedMap.forEach((k,v)-> {
            System.out.print(k);
            System.out.print(" ");
            v.sort(Comparator.naturalOrder());
            v.forEach(list->{
                System.out.print(list);
                if(v.indexOf(list)==v.size()-1)System.out.println();
                else System.out.print(" ");});
        });
    }
}