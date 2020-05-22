package TaskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import MonitorData.ActivityDate;
import MonitorData.MonitoredData;

public class Manager {
	
	public ArrayList<Integer> dayCount(ArrayList<MonitoredData> activities)
	{
		
		TASK_2 obj = (activity) -> 
		{
			ArrayList<Integer> days = new ArrayList<Integer>();
			
			Iterator<MonitoredData> it = activity.iterator();
			
			while(it.hasNext())
			{
				MonitoredData crtAct = it.next();
				
				ActivityDate startDate = crtAct.getStart();
				ActivityDate endDate = crtAct.getEnd();
				
				int startDay = startDate.getDay();
				int endDay = endDate.getDay();
				
				if(days.contains(startDay) == false)
				{
					days.add(startDay);
				}
				
				if(days.contains(endDay) == false)
				{
					days.add(endDay);
				}
				
			}
			
			return days;
			
	
		};
		
		return obj.dayCount(activities);
		
		
		
	}
	
	public Map<String, Integer> NbActivities(ArrayList<MonitoredData> activities)
	{
		
		TASK_3 obj = (activity) -> 
		{
			ArrayList<String> actNames = new ArrayList<String>();
			
			Map<String, Integer> mapAct = new HashMap<String, Integer>();
			
			int nb = 0;
			
			
			Iterator<MonitoredData> it = activity.iterator();
			
			while(it.hasNext())
			{
				MonitoredData crtAct = it.next();
				String crtActStr = crtAct.getActivity();
				
				Iterator<MonitoredData> itM = activity.iterator();
				
				nb = 0;
				while(itM.hasNext())
				{
					MonitoredData current = itM.next();
					if(current.getActivity().compareTo(crtActStr) == 0)
					{
						nb++;
					}
					
				}
				
				

				if(actNames.contains(crtActStr) == false)
				{
					actNames.add(crtActStr);
					mapAct.put(crtActStr, nb);
				}
																
			}
			
			return mapAct;
			
		};
		
		return obj.NbActivities(activities);
		
	}
	
	
	public Map<Integer, Map<String, Long>> activityFreq(ArrayList<MonitoredData> activities)
	{
		Map<Integer, Map<String, Long>> freq = activities.stream().collect(Collectors.groupingBy(element ->
		{
			int day = element.getStart().getDay();
			return day;
		}, Collectors.groupingBy(element ->
		{
			return element.getActivity();
		}, Collectors.counting())));
		
		
		return freq;
		
	}
	
	
	public Map<String, String> duration(ArrayList<MonitoredData> activities)
	{
		TASK_5 obj = (activity) ->
		{
			Map<String, Integer> actDur = new HashMap<String, Integer>();
			ArrayList<String> actNames = new ArrayList<String>();
			
			Iterator<MonitoredData> it = activity.iterator();
			
			int sum = 0;
			
			while(it.hasNext())
			{
				MonitoredData crtMD = it.next();
				String singleActName = crtMD.getActivity();
				
				sum = 0;
				
				Iterator<MonitoredData> it1 = activity.iterator();
				while(it1.hasNext())
				{
					MonitoredData crtAct = it1.next();
					String crtActName = crtAct.getActivity();
					
					if(singleActName.compareTo(crtActName) == 0)
					{
						long startConvTime = (crtAct.getStart().getYear() - 2010) * 365 * 24 * 3600 
										   + (crtAct.getStart().getMonth() - 1) * 30 * 24 * 3600
										   + (crtAct.getStart().getDay() - 1) * 24 * 3600
										   + (crtAct.getStart().getHour()) * 3600
										   + (crtAct.getStart().getMinute()) * 60
										   + (crtAct.getStart().getSecond());
						
						long endConvTime = (crtAct.getEnd().getYear() - 2010) * 365 * 24 * 3600 
										 + (crtAct.getEnd().getMonth() - 1) * 30 * 24 * 3600
										 + (crtAct.getEnd().getDay() - 1) * 24 * 3600
										 + (crtAct.getEnd().getHour()) * 3600
										 + (crtAct.getEnd().getMinute()) * 60
										 + (crtAct.getEnd().getSecond());
				
						long duration = endConvTime - startConvTime;
						
						sum += duration;
						
					}
				}
				
				if(actNames.contains(singleActName) == false)
				{
					actNames.add(singleActName);
					actDur.put(singleActName, sum);
				}
				
			}
			
			
			Map<String, String> actDurStr = new HashMap<String, String>();
			Iterator<Entry<String, Integer>> it2 = actDur.entrySet().iterator();
			
			while(it2.hasNext())
			{
				
				Map.Entry<String, Integer> pair = it2.next();
				
				String name = pair.getKey();
				int dur = pair.getValue();
				
				int days = dur / 3600 / 24;
				int hours = (dur - (days * 24 * 3600)) / 3600;
				int minutes = (dur - (days * 24 * 3600) - hours * 3600) / 60;
				int seconds = (dur - (days * 24 * 3600) - hours * 3600 - minutes * 60);
				
				String str = days + "-" + hours + ":" + minutes + ":" + seconds;
				
				actDurStr.put(name, str);
				
				
				
			}
			
			
			return actDurStr;
			
			
			
			
			
			
			
		};

		return obj.duration(activities);
		
	}
	
	
	
	public List<String> filter(ArrayList<MonitoredData> activities)
	{
		
		Map<String, Integer> freq = NbActivities(activities);
		Map<String, Long> less5 = activities.stream().filter(element ->
		{
			long startConvTime = (element.getStart().getYear() - 2010) * 365 * 24 * 3600
							   + (element.getStart().getMonth() - 1) * 30 * 24 * 3600
							   + (element.getStart().getDay() - 1) * 24 * 3600
							   + (element.getStart().getHour()) * 3600
							   + (element.getStart().getMinute()) * 60
							   + (element.getStart().getSecond());
			
			long endConvTime = (element.getEnd().getYear() - 2010) * 365 * 24 * 3600
							 + (element.getEnd().getMonth() - 1) * 30 * 24 * 3600
							 + (element.getEnd().getDay() - 1) * 24 * 3600
							 + (element.getEnd().getHour()) * 3600
							 + (element.getEnd().getMinute()) * 60
							 + (element.getEnd().getSecond());
			
			long duration = endConvTime - startConvTime;
			
			if(duration < 5 * 60)
			{
				return true;
			}
			else
			{
				return false;
			}
		}).collect(Collectors.groupingBy(element -> element.getActivity(), Collectors.counting()));
		
		List<String> res = activities.stream().filter(element ->
		{
			if(less5.get(element.getActivity()) == null)
			{
				return false;
			}
			else if(less5.get(element.getActivity()) >= 0.9 * freq.get(element.getActivity()))
			{
				return true;
			}
			else
			{
				return false;
			}
		}).map(element -> element.getActivity()).distinct().collect(Collectors.toList());
		
		return res;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
