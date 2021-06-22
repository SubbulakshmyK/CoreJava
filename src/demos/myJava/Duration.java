package demos.myJava;

public class Duration {
	
	public static void main(String srg[]) {
		System.out.println("(89,78)==> "+getDurationString(89, 78));
		System.out.println("(89,58)==> "+getDurationString(89, 58));
		System.out.println("(8978)==> "+getDurationString(8978));
		System.out.println("(0,48)==> "+getDurationString(0, 48));
		
	}
	
	public static String getDurationString(long munites, long seconds) {
		String durationString;
		if(munites<0 || (seconds <0 || seconds > 59))
			durationString="Invalid value";
		else {
			long hrs = munites / 60;
			munites = munites % 60;
			durationString = hrs+"h "+munites+"m "+seconds+"s";
		}
		return durationString;
	}
	
	public static String getDurationString(long seconds) {
		String durationString;
		if(seconds<0)
			durationString = "Invalid value";
		else {
			long munites = seconds / 60;
			seconds = seconds % 60;
			durationString = getDurationString(munites, seconds);
		}
		return durationString;
	}
	

}
