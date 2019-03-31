/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easysundaytest;

/**
 *
 * @author abusufian
 */
import java.util.*;
public class EasySundayTest {

    public static Map mappingString(String source) {
        Map<Character,Integer> sourceMap = new HashMap<Character,Integer>();
        for (int i = 0; i < source.length(); i++) {
          char eachChar = source.charAt(i);
          if(Character.isLowerCase(eachChar)){
              if(sourceMap.containsKey(eachChar)){
                  int cnt = sourceMap.get(eachChar);
                  sourceMap.put(eachChar, ++cnt);
              }
              else{
                  sourceMap.put(eachChar, 1);
                  
              }
              
          }
          else{
              char lowerCase = Character.toLowerCase(eachChar);
              if(sourceMap.containsKey(lowerCase)){
                  int cnt = sourceMap.get(lowerCase);
                  sourceMap.put(lowerCase, --cnt);
              }
              else{
                  sourceMap.put(lowerCase, -1);
              }
              
          }
        }
        return sourceMap;
    }
    private static HashMap sortByValues(Map map) { 
           List list = new LinkedList(map.entrySet());
           // Defined Comparator here
           Collections.sort(list, (Object o1, Object o2) -> ((Comparable) ((Map.Entry) (o2)).getValue())
                   .compareTo(((Map.Entry) (o1)).getValue()));

           // copying the sorted list in HashMap
           // LinkedHashMap to preserve the insertion order
           HashMap sortedHashMap = new LinkedHashMap();
           for (Iterator it = list.iterator(); it.hasNext();) {
                  Map.Entry entry = (Map.Entry) it.next();
                  sortedHashMap.put(entry.getKey(), entry.getValue());
           } 
           return sortedHashMap;
      }

    public static void main(String[] args) {
        Scanner abu = new Scanner (System.in);
        System.out.println("Please Enter Your Input");
        String input = abu.nextLine();
        Map<Character,Integer> inputMap = new HashMap<Character,Integer>();
        inputMap = mappingString(input);
        Map<Character,Integer> outputMap = sortByValues(inputMap); 
        Iterator it = outputMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.print(pair.getKey() + ":" + pair.getValue()+",");
                it.remove(); // avoids a ConcurrentModificationException
        }
    }
}
