import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution{

    void isAnagram(String s1, String s2){
    boolean isAnagram =  s1.length()==s2.length() &&  s1.chars().sorted()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.joining())
                .equals(
                  s2.chars().sorted()
                          .mapToObj(c->String.valueOf((char)c))
                                .collect(Collectors.joining())
                );
        System.out.println(isAnagram);
    }
    void partitionOddandEven(List<Integer> list){
        Map<Boolean, List<Integer>> map = list.stream()
                .collect(Collectors.partitioningBy(n->n%2==0));

        System.out.println(map);
    }
    void findLongestString(List<String> list){
        Optional<String> s = list.stream().max(Comparator.comparingInt(String::length));

        System.out.println(s.orElse(null));
    }
    void isAllMatch(List<Integer> list){
        Boolean isallmatch = list.stream()
                .allMatch(n->n%2==0);
        System.out.println(isallmatch);

        Optional<Integer> num = list.stream().sorted(Comparator.reverseOrder()).skip(2)
                .findFirst();
        System.out.println(num);
    }
    void convertStreamToListandSet(Stream<Integer> stream){
       // List<Integer> list = stream.collect(Collectors.toList());
        Set<Integer> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println("set: "+set);
    }
    void stringJoiner(){
        List<String> list = Arrays.asList("apple","orange","mango");
        String s = list.stream().collect(Collectors.joining(",","[{","}]"));
        System.out.println(s);

    }
    void flatMap(){
        List<List<Integer>> listoflist = Arrays.asList(
                Arrays.asList(1,2,3),Arrays.asList(4,5,6)
        );
        List<Integer> ans = listoflist.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(ans);
    }

        }
public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        List<Integer> list = Arrays.asList(1,2,3,3,4,5,5,6);
        List<String> stringList = Arrays.asList("apple","bat","cat");
        List<Integer> listmatch = Arrays.asList(4,6,8,5);
        List<Integer> temp = Arrays.asList(4,5,5,6,6,4,7,1,2,3);
        Stream<Integer> stream = temp.stream();
        obj.stringJoiner();
        obj.flatMap();




    }
}
