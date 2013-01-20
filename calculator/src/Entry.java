/*
 * 08-600
 * Pinjing Zhao
 * ID:pinjingz
 * Oct 24，2012
 * HW Contest
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Entry{
	static Map<String, Integer> map = new HashMap<String, Integer>();
    static List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>> (map.entrySet());
    
    public static void insert( String word ) {
 		if (map.containsKey( word ) ) { 
 			int currentCount = map.get(word);
 			map.put (word,currentCount + 1);
 		} else {
 			map.put (word,1);
 		}

 	}

    public static String[] displayMap() {
    	String[] strId = new String[10];
    	for (int i =0; i< 10; i++) {
    		strId[i]= infoIds.get(i).getKey();
    	
 		}
    	return strId;
 	}
     public static void sortMap() {
    	 Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {   
    	     public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {      
    	         return (o2.getValue() - o1.getValue()); 
    	    }
   		}); 
     }
	
   public static String[] mostFrequent (String filename) {
	   BufferedReader br = null;
	   try {
		   br = new BufferedReader(new FileReader(filename));
		   String line = br.readLine();
	    	while(line != null) {
				//split a string into words
	    		line = line.toLowerCase();
	    		String[] words = line.split( "\\W" );
			    for ( String word : words ) {
				   //insert word into map
				    if ( word.length() != 0 ) {
					    insert( word );
				    }
			    }
				line = br.readLine();
			}  	   
	    	br.close();
		} catch (Exception e) {
		}
		//print out the first 10 frequent words and numbers
	   for(Map.Entry<String, Integer> entry : map.entrySet()) 
			infoIds.add(entry);
		sortMap();

	   return displayMap();
  }
}



