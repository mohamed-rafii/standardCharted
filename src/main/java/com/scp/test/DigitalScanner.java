package com.scp.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class scans the digits in the digital format and converts to numbers
 * @author Rafi
 *
 */
public class DigitalScanner {
    Map<String, Integer> reference= new HashMap<String, Integer>();

    public static void main(String args[]) throws IOException {
    }

    /**
     *This method accepts the string and converts to digits
     * @param input
     * @return String
     */
    public String getNumber(String input) {
        StringBuilder results = new StringBuilder();
        if(input !=null && input.trim().length() > 0){

            List<String> list = new ArrayList<String>(Arrays.asList(input.split("\n")));
            list.removeAll(Arrays.asList("".trim(), null));//removes all the empty lines

            if(list.size() %3 == 0){ // if the number of lines is not mod 3, then it is invalid and exit
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < list.size(); i += 3){//jumps 3 lines after the iteration
                    for (int n = 0; n < 27; n += 3) //lines are max 27 characters
                    {
                        if(list.get(i).substring(n, n+3) != null){//top portion
                            sb.append(list.get(i).substring(n, n+3));
                        }
                        if(list.get(i+1).substring(n, n+3) != null){ //middle portion
                            sb.append(list.get(i+1).substring(n, n+3));
                        }
                        if(list.get(i+2).substring(n, n+3) != null){ //bottom portion
                            sb.append(list.get(i+2).substring(n, n+3));
                        }

                        if(sb.toString() !=null && sb.toString().length() > 0){//if the digit is valid
                            if(reference.containsKey(sb.toString())){// if the representation appears in the reference data
                                results.append(reference.get(sb.toString()));
                            }else{ // invalid character
                                results.append("-1");
                            }
                        }
                        sb.setLength(0); // set length of buffer to 0
                        sb.trimToSize(); // trim the underlying buffer
                    }
                }
            }
        }
        return results.toString().replaceAll("-1","ILL"); //replace the invalid character with ILL
    }

    /**
     *
     * @return Map<String, Integer>
     */
    public Map<String, Integer> populateData(){
        reference.put(" _ | ||_|",0);
        reference.put("     |  |",1);
        reference.put(" _  _||_ ",2);
        reference.put(" _  _| _|",3);
        reference.put("   |_|  |",4);
        reference.put(" _ |_  _|",5);
        reference.put(" _ |_ |_|",6);
        reference.put(" _   |  |",7);
        reference.put(" _ |_||_|",8);
        reference.put(" _ |_| _|",9);
        reference.put(" _ |_|  |",9);
        return reference;
    }
}
