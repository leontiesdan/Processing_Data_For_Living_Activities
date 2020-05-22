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

public class TaskSolve3 {

	public TaskSolve3()
	{
		
	}
	
	public void resolve3()
	{
		
		
ArrayList<MonitoredData> activities = new ArrayList<MonitoredData>();
		
		String filename = "Activities.txt";
		
		try
		{
			
			BufferedWriter fout3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Task_3.txt")));
			
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
			
			
			
			Map<String, Integer> nbAct = man.NbActivities(activities);
			Iterator<Entry<String, Integer>> itNb = nbAct.entrySet().iterator();
			fout3.write("Task 3 : " + "\n");
			while(itNb.hasNext())
			{
				Map.Entry<String, Integer> pair = itNb.next();
				String actName = pair.getKey();
				int nb = pair.getValue();
				
				fout3.write(actName + " - " + nb + " times\n");
				//System.out.println(actName + " - " + nb + " times\n");
			}
			
			fout3.close();
		
		
		
		
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	
	}
	
	
	
}
