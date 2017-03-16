import java.io.*;

class NumberToWords
{
	static String initial_digit[] = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve"};
	static String pre_word[] = {"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	public static void main(String ar[]) throws IOException
	{
		NumberToWords ntw = new NumberToWords();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in,word="";
		int input,first_num,second_num,len,temp;
		
		System.out.println("Enter the number..");
		in = br.readLine();
		input = Integer.parseInt(in);
		
		//String initial_digit[] = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve"};
		len=in.length();
		//String pre_word[] = {"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
		
		if(len==1)
		{
			System.out.println(initial_digit[input]);
		}
		else if(len==2)
		{
			if(input>=10 && input<=12)
			{
				System.out.println(initial_digit[input]);
			}
			else if(input>=13 && input<=19)
			{
				second_num = input%10;
				word = initial_digit[second_num] + "teen";
			}
			else
			{
				word += ntw.two_digits(input);
				/*
				first_num = input/10;
				if(first_num>0)
					word = word + pre_word[first_num-2];
				second_num = input%10;
				if(second_num>0)
					word = word + initial_digit[second_num-1];
				*/
			}
		}
		else if(len==3)
		{
			/*first_num = input / 100;
			word += initial_digit[first_num-1] + " hundred and ";
			*/
			first_num = input / 100;
			word += ntw.three_digits(input);
			input = input-(first_num*100);
			word += ntw.two_digits(input);
		}
		else if(len==4)
		{
			first_num = input/1000;
			word += initial_digit[first_num] + " thousand ";
			input = input - (first_num * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		else if(len==5)
		{
			temp = input/1000;
			word += ntw.two_digits(temp);
			word += " thousand ";
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		else if(len==6)
		{
			first_num = input/100000;
			word += initial_digit[first_num] + " lakh ";
			input = input - (first_num * 100000);
			temp = input/1000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		else if(len == 7)
		{
			temp = input/100000;
			word += ntw.two_digits(temp);
			word += " lakh ";
			input = input - (temp * 100000);
			temp = input/1000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		else if(len == 8)
		{
			first_num = input/10000000;
			word += initial_digit[first_num] + " crore ";
			input = input - (first_num * 10000000);
			temp = input/100000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " lakh ";
			}
			input = input - (temp * 100000);
			temp = input/1000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		else if(len == 9)
		{
			temp = input/10000000;
			word += ntw.two_digits(temp);
			word += " crore ";
			input = input - (temp * 10000000);
			temp = input/100000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " lakh ";
			}
			input = input - (temp * 100000);
			temp = input/1000;
			if(temp > 0)
			{
				word += ntw.two_digits(temp);
				word += " thousand ";
			}
			input = input - (temp * 1000);
			word += ntw.three_digits(input);
			second_num = input/100;
			input = input-(second_num*100);
			word += ntw.two_digits(input);
		}
		System.out.println(word);
	}
	String two_digits(int input)
	{
		int first_num,second_num;
		String word="";
		first_num = input/10;
				if(input>=10 && input<=12)
				{
					word += initial_digit[input];
				}
				else if(input>=13 && input<=19)
				{
					second_num = input%10;
					word = initial_digit[second_num] + "teen";
				}
				else if(input>=20)
				{
					word += pre_word[first_num-2];
					second_num = input%10;
					if(second_num>0)
						word += " " + initial_digit[second_num];
				}	
				return word;
	}
	String three_digits(int input)
	{
		String word="";
		int first_num;
		first_num = input / 100;
		if(first_num>0)
			word += initial_digit[first_num] + " hundred ";
		return word;
	}
}