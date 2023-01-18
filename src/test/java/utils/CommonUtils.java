
package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtils {

	public static String QTYPE_TEXTAREA = "Short Answer";
	public static String QTYPE_DRAG_AND_DROP = "Ordering Type";
	public static String QTYPE_CHKBOX_MCQ = "MCQ (Multiple Correct)";
	public static String QTYPE_RADIO_MCQ = "MCQ (Single Correct)";
	public static String QTYPE_RADIO_TF = "True / False";
	
	public static String TIME_PFIX = "00:";
	
	/*
	1. class="question-type"   Short Answer   ==>> Textarea
	2. class="question-type"   Ordering Type  ==>> Drag and drop
	3. class="question-type"   True / False     ==>> Radio button
	4. class="question-type"   MCQ (Multiple Correct) ==> Checkbox
	5. class="question-type"   MCQ (Single Correct)    ==> Radio button
	*/

	
	public static String sumOfTimes(ArrayList<String> timestampsList) throws ParseException {

   	 String pt = "1970-01-01-";
        String sumOfTimes="";
        final DateFormat dt = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        final Calendar sum = Calendar.getInstance();
        sum.setTimeInMillis(0);

        long tm0 = new SimpleDateFormat("yyyy-MM-dd").parse(pt).getTime();

        for (final String t : timestampsList) {
            Date x = dt.parse(pt + t);
            sum.add(Calendar.MILLISECOND, (int)x.getTime());
            sum.add(Calendar.MILLISECOND, (int)-tm0);
        }

        long tm = sum.getTime().getTime();

        tm = tm / 1000;


        long hh = tm / 3600;
        tm %= 3600;
        long mm = tm / 60;
        tm %= 60;
        long ss = tm;
        sumOfTimes = format(hh) + ":" + format(mm) + ":" + format(ss);
        return sumOfTimes;
   }
   
   
   private static String format(long s){
       if (s < 10) return "0" + s;
       else return "" + s;
   }
	

   public static String marksScored(List<String> marks) throws ParseException {
	   String finalOutputStr;
   	
   	//marks.forEach(mark -> System.out.println(mark.split(" ")[0]) );
   	//marks.forEach(mark -> System.out.println(mark.split(" ")[1]));
   	
   	int scoredMarks = 0,totalMarks = 0;

   	
   	for(int i = 0; i < marks.size(); i++)
   	{
   	    scoredMarks = scoredMarks + Integer.parseInt(marks.get(i).split(" ")[1].split("/")[0]);
   	    totalMarks = totalMarks + Integer.parseInt(marks.get(i).split(" ")[1].split("/")[1]);
   	}
   	finalOutputStr = "Scored Marks ==>> "+ scoredMarks + ", out of Total Marks ==>> "+totalMarks;
	return finalOutputStr;
   }

}
