package es.unileon.prg1.date;

/////////////////////////////
// JAVADOC IS MISSING!!!!  //
// PLEASE, COMPLETE IT     //
/////////////////////////////

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 2016;
	}
	
	public Date(int day, int month, int year) throws DateException{
		StringBuffer message = new StringBuffer();

		if ( day <= 0){
			message.append("Negative days are not allowed - wrong value for day: " + day + "\n");
		}
		if ( month <= 0 ){
			message.append("Negative months are not allowed - wrong value for month: " + month + "\n");			
		} else {
			if ( month > 12 ){
				message.append("There are only 12 months - wrong value for month: " + month + "\n");							
			} else {
				if ( day > this.daysOfMonth(month) ){
					message.append("Day/Month wrong combination: " + day + "/" + month + "\n");						
				}				
			}
		}
		if ( year < 0 ){
			message.append("Negative years are not allowed - wrong value for year: " + year + "\n");			
		}
		
		if ( message.length() != 0){
			throw new DateException(message.toString());
		} else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	///////////////////////
	// CLONE CONSTRUCTOR //
	///////////////////////
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) throws DateException{
		if ( day <= 0) {
			throw new DateException("Negative days are not allowed - wrong value for day: " + day + "\n");			
		} else {
			if ( !this.isDayRight(day) ){
				throw new DateException("Day/Month wrong combination: " + day + "/" + this.month + "\n");
			} else {
				this.day = day;
			}
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws DateException{
		if ( month <= 0) {
			throw new DateException("Negative months are not allowed - wrong value for month: " + month + "\n");			
		} else {
			if ( month > 12 ){
				throw new DateException("There are only 12 months - wrong value for month: " + month + "\n");
			} else {
				this.month = month;
			}
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws DateException{
		if ( year < 0) {
			throw new DateException("Negative years are not allowed - wrong value for year: " + year + "\n");			
		} else {
			this.year = year;
		}
	}
	
	public Date tomorrow(){
		Date tomorrow = null;
		int d, m, y;
				
		d = this.day;
		m = this.month;
		y = this.year;
		
		d++;
		if ( d > this.daysOfMonth(month) ) {
			d = 1;
			m++;
			if ( m > 12 ) {
				m = 1;
				y++;
			}	
		}
		
		try{
			tomorrow = new Date(d, m, y);
		} catch (DateException e){
			System.err.println("Date.tomorrow: " + e.getMessage());
		}

		return tomorrow;
	}

	//////////////////////////////////////
	// CONDITIONAL STATEMENTS EXERCISES //
	//         if-then-else             //
	//////////////////////////////////////
	
	public boolean isSameDay(Date other){
		// WRONG SINTAX OF THE IF-STATEMENT
		if ( this.day == other.getDay() )
			return true;
		else
			return false;
	}
	
	public boolean isSameMonth(Date other){
		// RIGHT SINTAX OF THE IF-STATEMENT
		if ( this.month == other.getMonth() ) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isSameYear(Date other){
		// SOLUTION WITHOUT IF-STATEMENT
		return this.year == other.getYear();
	}

	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}
	
	//////////////////////////////////////
	// CONDITIONAL STATEMENTS EXERCISES //
	//            switch                //
	//////////////////////////////////////

	public String getMonthName(){
		String name = null;
		switch (this.month){
		case 1:
			name = "January";
			break;
		case 2:
			name = "February";
			break;
		case 3:
			name = "March";
			break;
		case 4:
			name = "April";
			break;
		case 5:
			name = "May";
			break;
		case 6:
			name = "June";
			break;
		case 7:
			name = "July";
			break;
		case 8:
			name = "August";
			break;
		case 9:
			name = "September";
			break;
		case 10:
			name = "October";
			break;
		case 11:
			name = "November";
			break;
		case 12:
			name = "December";
			break;
		}
		return name;
	}
		
	private boolean isDayRight(int day){
		return ( ( day > 0 ) && (day <= this.daysOfMonth(this.month) ) );
	}
	
	public int daysOfMonth(){
		return this.daysOfMonth(this.month);
	}
	
	private int daysOfMonth(int month){
		int number = 0;
		switch (month){
		case 1: // next
		case 3: // next
		case 5: // next
		case 7: // next
		case 8: // next
		case 10: // next
		case 12:
			number = 31;
			break;
		case 4: // next
		case 6: // next
		case 9: // next
		case 11: 
			number = 30;
			break;
		case 2:
			// we do not consider leap years
			number = 28;
			break;
		default:
			number = -1;
		}
		return number;
	}

	public String getSeasonName(){
		String name = null;
		switch (this.month){
		case 1: // next
		case 2: // next
		case 3: 
			name = "Winter";
			break;
		case 4: // next
		case 5: // next
		case 6:
			name = "Spring";
			break;
		case 7: // next
		case 8: // next
		case 9:
			name = "Summer";
			break;
		case 10: // next
		case 11: // next
		case 12:
			name = "Autumn";
			break;
		}
		
		return name;
	}
	
	//////////////////////////////////
	// LOOPING STATEMENTS EXERCISES //
	//              for             //
	//////////////////////////////////
	
	public String getMonthsLeft(){
		Date aux = new Date(this);
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for (int i = this.month + 1; i <= 12; i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getMonthsLeft: " + e.getMessage());
		}
		return monthsLeft.toString();
	}
	
	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); isDayRight(i); i++) {
				aux.setDay(i);
				daysLeft.append(aux.toString() + " ");
			}
		} catch (DateException e){
			System.err.println("Date.getDaysLeftOfMonth: " + e.getMessage());
		}
		return daysLeft.toString();
	}
	
	public String getMonthsSameDays(){
		Date aux = new Date(this);
		StringBuffer months = new StringBuffer();

		try{
			for ( int i = 1; i <= 12; i++) {
				aux.setMonth(i);
				if ( aux.daysOfMonth() == this.daysOfMonth() ) {
					months.append(aux.getMonthName() + " ");
				}
			}
		} catch (DateException e){
			System.err.println("Date.getMonthsSameDays: " + e.getMessage());
		}
		return months.toString();
	}

	public int daysPast(){
		int result;
		result = 0;
		
		try{
			Date aux = new Date(1,1,this.year);
		
			for ( int i = 1; i < this.month; i++ ) {
				result += aux.daysOfMonth();
				aux.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println("Date.daysPast: " + e.getMessage());
		}
		
		return result + this.day - 1;
	}

	//////////////////////////////////
	// LOOPING STATEMENTS EXERCISES //
	//      while / do-while        //
	//////////////////////////////////
	
	public int numRandomTriesEqualDate(){
        int tries, d, m, y;
        tries = 0;
        
        try{
        	do{
        		m = (int) (Math.random()*12) + 1;
        		d = (int) (Math.random()*this.daysOfMonth(m) ) + 1;
        		y = this.year;
        		tries++;
        	} while ( !this.isSame(new Date(d,m,y) ) );
		} catch (DateException e){
			System.err.println("Date.numRandomTriesEqualsDate: " + e.getMessage());
		}

        return tries;
    }
	
	private String nameOfDay(int day) {
		String dayName;
		switch (day) {
		case 1: 
			dayName = "Monday";
			break;
		case 2: 
			dayName = "Tuesday";
			break;
		case 3: 
			dayName = "Wednesday";
			break;
		case 4: 
			dayName = "Thursday";
			break;
		case 5: 
			dayName = "Friday";
			break;
		case 6: 
			dayName = "Saturday";
			break;
		case 7: 
			dayName = "Sunday";
			break;
		default:
			dayName = "Wrong day";
		}
		return dayName;
	}
	
	public String dayOfWeek(int firstOfJanuary){
		int dayNumber;
		
		dayNumber = ( daysPast() % 7 + firstOfJanuary ) % 7;
		
		return nameOfDay(dayNumber);
	}
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	
}
