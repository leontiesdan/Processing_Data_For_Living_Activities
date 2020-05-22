package MonitorData;

public class MonitoredData {
	
	private ActivityDate start;
	private ActivityDate end;
	private String activity;
	
	public MonitoredData()
	{
		
	}
	
	public MonitoredData(ActivityDate start, ActivityDate end, String activity)
	{
		
		
		this.start = start;
		this.end = end;
		this.activity = activity;
		
		
	}
	
	public void setStart(ActivityDate start) 
	{
		this.start = start;
	}
	
	public void setEnd(ActivityDate end)
	{
		this.end = end;
	}
	
	public void setActivity(String activity)
	{
		this.activity = activity;
	}
	
	public ActivityDate getStart()
	{
		return start;
	}
	
	public ActivityDate getEnd()
	{
		return end;
	}
	
	public String getActivity()
	{
		return activity;
	}
	
	public String getStartString()
	{
		String startString = "";
		
		startString = getStart().getYear() + "-" + getStart().getMonth() + "-" + getStart().getDay() + " " + getStart().getHour() + ":" + getStart().getMinute() + ":" + getStart().getSecond();
		
		return startString;
	}
	
	public String getEndString()
	{
		String endString = "";
		
		endString = getStart().getYear() + "-" + getStart().getMonth() + "-" + getStart().getDay() + " " + getStart().getHour() + ":" + getStart().getMinute() + ":" + getStart().getSecond();
		
		return endString;
	}
	
	
	
	

}
