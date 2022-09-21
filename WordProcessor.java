//import classes for file input - scanner etc.
import java.io.*;
import java.util.Set;
import java.util.Iterator;

//import implementing set (eg. TreeSet)
import java.util.TreeSet;



public class WordProcessor {
	private static <E> String displaySet(Set<E> inputSet){
		
		String output = "";
		Iterator<E> it = inputSet.iterator();
		
		int count = 0;
		
		//printing out the first subset of elements
		while(count < 5) { // limiting the iterator to print in 5 element increments
				output+= it.next().toString();
				count++;
			}
		// placing a new line between each subset of printed elements;
		output += "\n";
		
		//printing out the second subset of elements
		while(count < 10) { 
			output+= it.next().toString();
			count++;
		}
		
		output += "\n";
		
		//printing out the third subset of elements
		while(count < 15) {
			output+= it.next().toString();
			count++;
		}
		
		output += "\n";
		
		//printing out the last subset of elements
		while(count < 20) {
			output+= it.next().toString();
			count++;
		}
		return output;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {	
		Set <String> wordSet = new TreeSet<>();
		Set <CountedElement<String>> countedWordSet = new TreeSet<>();
		
		for(int i = 0; i < args.length; i++) {
			addWord(args[i], wordSet, countedWordSet); // helper method to keep code clean
		}
		
		System.out.println(displaySet(countedWordSet));
	}
	
	public static void addWord(String file, Set<String> wordSet, Set<CountedElement<String>> countedWordSet) throws IOException {
		// to read the elements from a given file
		FileReader reader = new FileReader(file);
		
		// to process the information provided by the FileReader into distinct words
		BufferedReader input = new BufferedReader(reader);
		
		String line = "";
		
		for(int i = 0; i < 20; i ++) { // choosing a large number for the stopping condition so there will be enough space for all words
			line = input.readLine();
			
			if(line == null) break;
			
			// if wordSet does not already contain the word in question, add the word to both wordSet and countedWordSet
			if(!wordSet.contains(line)){
				wordSet.add(line);
				countedWordSet.add(new CountedElement<String>(line));
			}
			
			// if wordSet already contains the word in question, find that word in countedWordSet and increment the value of its count;
			else {
				for(CountedElement<String> a : countedWordSet) {
					if(a.getElement().equals(line)) {
						int count = a.getCount();
						a.setCount(++count);
					}
				}
			}
		}
		input.close(); // closing the BufferedReader
	}
}


	
	