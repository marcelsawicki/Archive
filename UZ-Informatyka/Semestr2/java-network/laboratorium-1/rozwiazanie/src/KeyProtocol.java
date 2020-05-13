import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyProtocol 
{
    private static final int WAITING = 0;
    private static final int SENTKNOCKKNOCK = 1;
    List<String> list = new ArrayList<String>();

    private int state = WAITING;
    
    KeyProtocol()
    {
		list.add("abc");
		list.add("haslo");
		list.add("jeden");
    }
	public  String processInput(String theInput)
	{
        String theOutput = "key_out-{error}";

        if (state == WAITING) {
        	theOutput = "Listening...";
        	
        	if(theInput!=null)
        	{
        		// String request = "key_in-get{haslo}";
        		// String request = "key_in-set{abcd:3}";
        		String request = theInput;
        		
        		if(request.startsWith("key_in-get"))
        		{
            		String requestPattern = "key_in-get\\{([^}]*?)\\}";
            		boolean retval = request.matches(requestPattern);
            		Pattern r = Pattern.compile(requestPattern);
            		Matcher m = r.matcher(request);
            		if(m.find())
            		{
            			System.out.println("Found value: " + m.group(1));
            			String customKey = m.group(1);
            			boolean containsKey = list.contains(customKey);
            			if(containsKey)
            			{
            				theOutput = "key_out-{"+customKey+":yes}";
            			}
            			else
            			{
            				theOutput = "key_out-{"+customKey+":no}";
            			}
            		}
        		}
        		
        		if(request.startsWith("key_in-set"))
        		{
            		String requestPattern = "key_in-set\\{\\w*:([^}]*?)\\}";
            		Pattern r = Pattern.compile(requestPattern);
            		Matcher m = r.matcher(request);
            		
            		String requestPatternF = "key_in-set\\{([^}]*?)\\}";
            		Pattern rF = Pattern.compile(requestPatternF);
            		Matcher mF = rF.matcher(request);
            		
            		int customIndexInt=0;
            		if(m.find())
            		{
            			System.out.println("Found value1: " + m.group(1));

            			String customKey = m.group(1);
            			if(mF.find())
            			{
                			String customPassword1 = mF.group(1);
                			String[] customPassword2 = customPassword1.split(":");
                			String customPassword3 = customPassword2[0];
                			if(customPassword3.equals("password"))
                			{
                    			list.add(customKey);
                    			theOutput = "key_out-{"+customKey+":yes}";
                			}
                			else
                			{
                				theOutput = "key_out-{"+customKey+":no}";
                			}
            			}

            			//customIndexInt = Integer.parseInt(customIndex);
            			//System.out.println(list.get(customIndexInt));
//            			list.add(customKey);
//            			theOutput = "key_out-{"+customKey+":yes}";
            			
            		}
            		
        		}
        	}
   
            state = WAITING;
        } 
           
        return theOutput;
	}

}
