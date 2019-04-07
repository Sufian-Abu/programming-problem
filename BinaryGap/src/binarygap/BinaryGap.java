/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarygap;

/**
 *
 * @author abusufian
 */
import java.util.*;
public class BinaryGap {

    /**
     * @param args the command line arguments
     */
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String binary = Integer.toBinaryString(n);
        List<Integer> gaps = new ArrayList<>();
        int result = binaryGaps(binary, gaps);
        System.out.println(result);

        scanner.close();
    }
    
    static int binaryGaps(String binary, List<Integer> gaps){     
        int firstOne = binary.indexOf("1");
        if(firstOne > -1){
            String newBinaryString = binary.substring(firstOne + 1, binary.length());
            int secondOne = newBinaryString.indexOf("1");
            if(secondOne > 0){
                gaps.add(secondOne);
            }
            return binaryGaps(binary.substring(firstOne + 1, binary.length()), gaps);
        }
        return (gaps.size() > 0) ? Collections.max(gaps) : 0;
    }
    
}
