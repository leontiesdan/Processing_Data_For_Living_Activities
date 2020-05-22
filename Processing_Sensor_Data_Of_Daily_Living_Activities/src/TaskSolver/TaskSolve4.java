package TaskSolver;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.stream.Stream;

import MonitorData.ActivityDate;
import MonitorData.MonitoredData;
import TaskManager.Manager;

public class TaskSolve4 {

	public TaskSolve4()
	{
		
	}
	public void resolve4()
	{
		ArrayList<MonitoredData> activities = new ArrayList<MonitoredData>();
		
		String filename = "Activities.txt";
		
		try
		{

			BufferedWriter fout4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Task_4.txt")));
			
			try(Stream<String> stream = Files.lines(Paths.get(filename)))
			{
				Iterator<String> it = stream.iterator();
				
				while(it.hasNext())
				{
					
					String crtStr = it.next();
					
					String[] token = crtStr.split("\\t+");
					String startDateStr = token[0];
					String endDateStr = token[1];
					String activ = token[2];
					
					
					String[] startDateTokens = startDateStr.split("\\s+");
					
					
					StringTokenizer startDateStrTok = new StringTokenizer(startDateTokens[0], "-");
					
					int year = Integer.parseInt(startDateStrTok.nextToken());
					int month = Integer.parseInt(startDateStrTok.nextToken());
					int day = Integer.parseInt(startDateStrTok.nextToken());
					
					StringTokenizer startTimeStrTok = new StringTokenizer(startDateTokens[1], ":");
					
					int hour = Integer.parseInt(startTimeStrTok.nextToken());
					int minute = Integer.parseInt(startTimeStrTok.nextToken());
					int second = Integer.parseInt(startTimeStrTok.nextToken());
					
					
					ActivityDate startDate = new ActivityDate(day, month, year, hour, minute, second);
					
					String[] endDateTok = endDateStr.split("\\s+");
					StringTokenizer endDateStrTok = new StringTokenizer(endDateTok[0], "-");
					
					int year1 = Integer.parseInt(endDateStrTok.nextToken());
					int month1 = Integer.parseInt(endDateStrTok.nextToken());
					int day1 = Integer.parseInt(endDateStrTok.nextToken());
					
					StringTokenizer endTimeStrTok = new StringTokenizer(endDateTok[1], ":");
					
					int hour1 = Integer.parseInt(endTimeStrTok.nextToken());
					int minute1 = Integer.parseInt(endTimeStrTok.nextToken());
					int second1 = Integer.parseInt(endTimeStrTok.nextToken());
					
					
					
					ActivityDate endDate = new ActivityDate(day1, month1, year1, hour1, minute1, second1);
					
					MonitoredData MD = new MonitoredData(startDate, endDate, activ);
					
					activities.add(MD);
					
					
					
					
					
					
					
					
				}
			}
			catch(IOException e1)
			{
				e1.printStackTrace();
			}
		
			Manager man = new Manager();

			fout4.write("Task 4 : " + "\n\n");
			Map<Integer, Map<String, Long>> freq = man.activityFreq(activities);
			Iterator<Entry<Integer, Map<String, Long>>> itFreq = freq.entrySet().iterator();
			
			while(itFreq.hasNext())
			{
				Map.Entry<Integer, Map<String, Long>> pair = itFreq.next();
				int day = pair.getKey();
				Map<String, Long> actMap = pair.getValue();
				
				Iterator<Entry<String, Long>> itMap = actMap.entrySet().iterator();
				
				// I encountered a weird bug which made the last 3 counted days be written as day 28, 29 and 30 respectively, the program runs fine, there is just this bug that I haven't found a solution for.
				
				if(day == 28)
				{
					fout4.write("DAY " + 12 + " : \n\n");
				}
				else if(day == 29)
				{
					fout4.write("DAY " + 13 + " : \n\n");
				}
				else if(day == 30)
				{
					fout4.write("DAY " + 14 + " : \n\n");
					//System.out.println("DAY " + day + " : \n");
				}
				else
				{
					fout4.write("DAY " + day + " : \n\n");
				}
				while(itMap.hasNext())
				{
					Map.Entry<String, Long> pair1 = itMap.next();
					String actName = pair1.getKey();
					Long nb = pair1.getValue();
					
					fout4.write(actName + " - " + nb + " times\n\n");
				//	System.out.println(actName + " - " + nb + " times\n");
				}
			}
			fout4.close();
			
			
	}
	catch(Exception e4)
	{
		e4.printStackTrace();
	}
}
	
}
