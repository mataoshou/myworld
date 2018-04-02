package mind.recommend;

import java.util.Random;

public class RandomHan
{
	private Random ran = new Random();  
    private final static int delta = 0x9fa5 - 0x4e00 + 1;  
       
    public char getRandomHan() {  
        return (char)(0x4e00 + ran.nextInt(delta));   
    } 
    
    public String getRandName(int length)
    {
    	String name="";
    	for(int i=0;i<length;i++)
    	{
    		name+=String.valueOf(getRandomHan());
    	}
    	return name;
    }
}
