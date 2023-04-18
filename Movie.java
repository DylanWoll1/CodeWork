package Final;


	public class Movie {// class deceleration

	// constants 
		
	private static String movieName;
		private int numMinutes;
			private boolean isKidFriendly;
				private int numCastMembers;
					private String [] castMembers;

	// constructor 
	public Movie() {
		movieName = "Flick";	 
			numMinutes = 0 ;
				isKidFriendly = false; 
					numCastMembers = 0;
						castMembers = new String[10];
	 }
	public Movie(String movieName,int numMinutes,boolean isKidFriendly,String [] castMembers){// loaded constructor
	    this();
	    if(movieName != null) {this.movieName = movieName;}
	    if(numMinutes >= 0 ) {this.numMinutes = numMinutes;}
	    this.isKidFriendly = isKidFriendly;
	    this.castMembers = numCastMembers(castMembers);
	}

	public String [] numCastMembers(String[] castMembers) {
	    for(int i=0; i<castMembers.length; i++) {
	    }
	   return castMembers;
	}
	public static String getMovieName() {
		return movieName;
	}
	public int getNumMinutes(){
		return numMinutes;
	}
	public boolean getKidFriendly() {
		return isKidFriendly;
		
	}
	public int getCastMembers() {
		return numCastMembers;
	}

	public boolean replaceCastMember(int index ,String castMembers) {
		if((index < 0) ||(index >= numCastMembers)) {
		return false;	
		}
		else {
			index = numCastMembers;
		}
		return true;
	}
	public boolean doArrysMatch (String[]arr1,String[]arr2) {
		
		if(arr1.equals(null) && arr2.equals(null)){
			return true;
		}
			else if(arr1.equals(null)|| arr2.equals(null)) 
				return false;
			
			else if(arr1.length != arr2.length)
			return false;
			
			for(int i=0;i<arr1.length;i++) 
			{
		if(!arr1[i].equalsIgnoreCase(arr2[i]))		
		   return false;
			}
			return true;
			
			
		}
		
	

	public String getCastMemberNameAsString () {
      String nameCast = "";
		
	for(int i=0;i<numCastMembers;i++) {
		nameCast += castMembers[i]+",";
	}
		nameCast += castMembers[numCastMembers];	   
		
		if(numCastMembers == 0) {
			return  "none";
		}
				return nameCast;
}
	String finalLine = String.format("Movie: [ Minutes %03d | Movie Name: %20s | %13s | Numbers of Cast Members: " + getCastMembers() + " | Cast Members: ", numMinutes, movieName, isKidFriendly);
	}
	