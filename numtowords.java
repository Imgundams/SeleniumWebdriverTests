package testings;

public class numtowords {

	String numToWords(int numb){
		String words;
	switch(numb){
	 case 1:  words = "\"I don’t want to earn my living; I want to live.\" - Oscar Wilde ";
     break;
	 case 2:  words = "\"Life shrinks or expands in proportion to one’s courage.\" - Anais Nin";
     break;
	 case 3:  words = "\"Life must be lived forwards, but can only be understood backwards. \" - Kierkegaard";
     break;
	 case 4:  words = "\"The trouble is you think you have time.\" - Buddha";
     break;
	 case 5:  words = "\"Do not dwell in the past, do not dream of the future, concentrate the mind on the present moment.\"- Buddha";
     break;
	 case 6:  words = "\"Love the life you live, and live the life you love.\" - Bob Marly";
     break;
	 case 7:  words = "\"It has been my philosophy of life that difficulties vanish when faced boldly.\" - Isaac Asimov";
     break;
	 case 8:  words = "\"Try and fail, but never fail to try.\" - Jared Leto";
     break;
	 case 9:  words = "\"Life is a mirror and will reflect back to the thinker what he thinks into it.\" - Ernest Holmes";
     break;
	 case 10: words = "\"Life is wasted on the living.\" - Douglas Adams";
     break;
	 case 11: words = "\"Life is like riding a bicycle. To keep your balance you must keep moving.\" - Albert Einstein";
     break;
	 case 12: words = "\"The key to immortality is first living a life worth remembering.\" - Bruce Lee";
     break;
	 default: words = "Not a Number";
     break;
	}
	

	return words;
}}
