import java.io.*;

class WordsToNum
{
	static String one_word[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen",
	"fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
	static String word_pool[]={"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String big_pool[]={"hundred", "thousand"};
	
	public static void main(String ar[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WordsToNum wtn = new WordsToNum();
		
		int num_word=0,i=0,output=0,j=i;
		String word,ch_word;
		
		
		System.out.println("Enter the word..");
		word = br.readLine();
		String word_ar[] = word.split(" ");
		
		for(i=0; i<word_ar.length; i++)
		{
			if(word_ar[i].equalsIgnoreCase("thousand"))
			{
				String part_word[] = new String[(i-j)+1];
				System.arraycopy(word_ar,j,part_word,0,(i-j)+1);
				output += thousand(part_word);
				j=i;
			}
			if(word_ar[i].equalsIgnoreCase("hundred"))
			{
				String part_word[] = new String[(i-j)+1];
				System.arraycopy(word_ar,j,part_word,0,(i-j)+1);
				output += hundred(part_word);
				j=i;
			}
		}
		
		if((j+1) < word_ar.length)
		{
			String ten_part[] = new String[word_ar.length - j];
			System.arraycopy(word_ar,j,ten_part,0,word_ar.length - j);
				
			output += ten(ten_part);
		}
		System.out.println(output);
	}
	
	public static int thousand(String part_word[])
	{
		int output=0;
		if(part_word.length > 1)
		{
			String part_w[] = new String [part_word.length-1];
			System.arraycopy(part_word,0,part_w,0,part_word.length-1);
			output += ten(part_w);
		}
		if(output>0)
			output *= 1000;
		else
			output = 1*1000;
		return output;
	}
	public static int hundred(String part_word[])
	{
		int output=0;
		if(part_word.length > 1)
		{
			String part_w[] = new String [part_word.length-1];
			System.arraycopy(part_word,0,part_w,0,part_word.length-1);
			output += ten(part_w);
		}
		if(output>0)
			output *= 100;
		else
			output = 1*100;
		return output;
	}
	public static int ten(String part_word[])
	{
		int output=0,i,w;
		for(i=0; i<part_word.length; i++)
		{
			for(w=0; w<9; w++)
			{
				if(part_word[i].equalsIgnoreCase(one_word[w]))
				{
					output += w+1;
				}
			}
			for(w=0; w<word_pool.length; w++)
			{
				if(part_word[i].equalsIgnoreCase(word_pool[w]))
				{
					output += (w+2)*10;
				}
			}
		}
		return output;
	}
}