package MonitorData;

public class ActivityDate {
	
	private int day;
	private int month;
	private int year;
	
	private int hour;
	private int minute;
	private int second;
	
	public ActivityDate()
	{
		
	}
	
	public ActivityDate(int day, int month, int year, int hour, int minute, int second)
	{
		
		this.day =day;
		this.month = month;
		this.year = year;
		
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public void setHour(int hour)
	{
		this.hour = hour;
	}
	
	public void setMinute(int minute)
	{
		this.minute = minute;
	}
	
	public void setSecond(int second)
	{
		this.second = second;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute;
	}
	
	public int getSecond()
	{
		return second;
	}
	
	public String print()
	{
		String str = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;
		
		return str;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
