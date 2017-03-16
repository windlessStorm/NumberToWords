import java.io.*;
class WordsToNumber
{
	static String one_word[]={"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen",
	"fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};
	static String word_pool[]={"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String big_pool[]={"hundred", "thousand"};
	
	public static void main(String ar[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WordsToNumber wtn = new WordsToNumber();
		
		int num_word=0,i,output=0;
		String word,ch_word;
		
		System.out.println("Enter the word..");
		word = br.readLine();
		String word_ar[] = word.split(" ");
		
		for(i=0; i<word.length(); i++)
		{
			if(word.charAt(i) == ' ')
			{
				num_word++;
			}
		}
		num_word += 1;
		if(num_word == 0)
		{
			for(i=0; i<one_word.length; i++)
			{
				if(word.equalsIgnoreCase(one_word[i]))
					output = i+1;
			}
			for(i=0; i<word_pool.length; i++)
			{
				if(word.equalsIgnoreCase(word_pool[i]))
					output = (i+2)*10;
			}
		}
		else if(num_word==1)
		{
			for(i=0; i<word_pool.length; i++)
			{
				if(word_ar[0].equalsIgnoreCase(word_pool[i]))
					output=(i+2)*10;
			}
			for(i=0; i<one_word.length; i++)
			{
				if(word_ar[1].equalsIgnoreCase(one_word[i]))
					output+=i+1;
			}
		}
		else if(num_word==3)
		{
			if(word_ar[1].equalsIgnoreCase("hundred"))
			{
				output += wtn.hundred(word_ar[0]);
				output += wtn.last_digit(word_ar);
				/*
				for(i=0; i<one_word.length; i++)
				{
					if(word_ar[word_ar.length-1].equalsIgnoreCase(one_word[i]))
						output+=(i+1);
				}
				*/
				/*
				for(i=0; i<one_word.length; i++)
				{
					if(word_ar[0].equalsIgnoreCase(one_word[i]))
						output=(i+1)*100;
				}
				for(i=0; i<one_word.length; i++)
				{
					if(word_ar[2].equalsIgnoreCase(one_word[i]))
						output+=(i+1);
				}
				*/
			}
		}
		else if(num_word==4)
		{
			if(word_ar[1].equalsIgnoreCase("hundred"))
			{
				output += wtn.hundred(word_ar[0]);
				for(i=0; i<word_pool.length; i++)
				{
					if(word_ar[2].equalsIgnoreCase(word_pool[i]))
					{
						output += (i+2)*10;
					}
				}					
				output += wtn.last_digit(word_ar);
				/*
				for(i=0; i<one_word.length; i++)
				{
					if(word_ar[word_ar.length-1].equalsIgnoreCase(one_word[i]))
						output+=(i+1);
				}
				*/
			}
		}
		System.out.println(output);
	}
	public int hundred(String word)
	{
		int output=0,i;
		for(i=0; i<one_word.length; i++)
				{
					if(word.equalsIgnoreCase(one_word[i]))
						output=(i+1)*100;
				}
				return output;
	}
	public int last_digit(String word_ar[])
	{
		int output=0,i;
		for(i=0; i<one_word.length; i++)
		{
			if(word_ar[word_ar.length-1].equalsIgnoreCase(one_word[i]))
				output=(i+1);
		}
		return output;
	}
}