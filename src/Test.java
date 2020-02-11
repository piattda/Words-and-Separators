import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 * 
 * @author P. Bucci
 */
public final class Test {

	/**
	 * Generates the set of characters in the given {@code String} into the
	 * given {@code Set}.
	 * 
	 * @param str
	 *            the given {@code String}
	 * @param strSet
	 *            the {@code Set} to be replaced
	 * @replaces strSet
	 * @ensures strSet = entries(str)
	 */
	private static void generateElements(String str, Set<Character> strSet) {
		
		//osu -> <o,s,u>
		
		for(int i = 0; i < str.length(); i ++){
			//You didn't think to add next line:
			if(!strSet.contains(str.charAt(i))){
			strSet.add(str.charAt(i));
			}
		}
		
	
	}
	
	
	/**
	 * Returns the first "word" (maximal length string of characters not in
	 * {@code separators}) or "separator string" (maximal length string of
	 * characters in {@code separators}) in the given {@code text} starting at
	 * the given {@code position}.
	 * 
	 * @param text
	 *            the {@code String} from which to get the word or separator
	 *            string
	 * @param position
	 *            the starting index
	 * @param separators
	 *            the {@code Set} of separator characters
	 * @return the first word or separator string found in {@code text} starting
	 *         at index {@code position}
	 * @requires 0 <= position < |text|
	 * @ensures <pre>
	 * nextWordOrSeparator =
	 *   text[position, position + |nextWordOrSeparator|)  and
	 * if entries(text[position, position + 1)) intersection separators = {}
	 * then
	 *   entries(nextWordOrSeparator) intersection separators = {}  and
	 *   (position + |nextWordOrSeparator| = |text|  or
	 *    entries(text[position, position + |nextWordOrSeparator| + 1))
	 *      intersection separators /= {})
	 * else
	 *   entries(nextWordOrSeparator) is subset of separators  and
	 *   (position + |nextWordOrSeparator| = |text|  or
	 *    entries(text[position, position + |nextWordOrSeparator| + 1))
	 *      is not subset of separators)
	 * </pre>
	 */
	private static String nextWordOrSeparator(String text, int position, Set<Character> separators) {
		//word is a string of characters not in the set. 
		//Separator string is string of characters in the set
		//We are supposed to return the longest word or separator string that appears 
		//at the given position in the given string. 
		//
		
		//filter through the inputted text and while
		//not at the end
		//if(charAt(i)== anything in a for loop with
		//separators print out 
		//everything from start to that separator. 
		
		char tmp = text.charAt(position);
		String final1 = "";
		if(separators.contains(tmp)&&position < text.length()){
			while(separators.contains(tmp)){
				final1 = final1 + tmp;
				position++;
				if(position < text.length()){
					tmp = text.charAt(position);
				}
			}
		}else{
			while(!separators.contains(tmp)&&position < text.length()){
				final1 = final1 + tmp;
				position ++;
				if(position < text.length()){
					tmp = text.charAt(position);
				}
			}
		}
		
		
		return final1;
	}

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
    	SimpleWriter out = new SimpleWriter1L();
    	
    	
    	Set<Character> strSet = new Set1L<>();
        String str = "OSU";
        generateElements(str, strSet);
        out.println(strSet.toString());
        
    	
    	
       
        out.close();
    }

}
