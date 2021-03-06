package es.unileon.prg.tema7;

public class Date {
	private int day;
	private int month;
	private int year;
	
	//Crear Constructor
	
	public Date(){
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	
	public Date(int day, int month, int year) throws Date_Exception{
		StringBuffer message = new StringBuffer();
		
		if(day <= 0){
			message.append("No se permiten dias negativos" +day+ "\n");
		}
		if(month <=0){
			message.append("No se permiten meses negativos" +month+ "\n");
		}else if(month > 12){
			message.append("No se permiten meses mayores que 12" +month+ "\n");
		}
		if (year < 0){
			message.append("No se permiten anyos negativos" +year+ "\n");
		}
		if (message.length() != 0){
			throw new Date_Exception(message.toString());
		}else{
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}
	
	
	public Date(Date another){
		this.day = another.getDay();
		this.month = another.getMonth();
		this.year = another.getYear();
	}
	
	

	
	
	//Getter and Setter
	
	public int getDay(){
		return day;	
	}
	
	public void setDay(int day) throws Date_Exception{
		if(day <=0 ){
			throw new Date_Exception("El nummero de dias no puede ser menor que 0" +month+ "\n");
		}else if (!this.isDayRight(day)){
			throw new Date_Exception("El numero del Mese no es correcto " +month+ "\n");
		}else{
			this.month = month;
		}
	}
	
	
	public int getMonth(){
		return month;
	}
	
	public void setMonth(int month) throws Date_Exception{
		if(month <=0 ){
			throw new Date_Exception("El numero de los Meses no puede ser menor que 0" +month+ "\n");
		}else if (month >12){
			throw new Date_Exception("El numero de los Meses no puede ser mayor que 12" +month+ "\n");
		}else{
			this.month = month;
		}
	}
	

	public int getYear(){
		return year;
	}
	
	
	public void setYear(int year) throws Date_Exception{
		if(year < 0){
			throw new Date_Exception("El anyo no puede ser menor que cero" +year+ "\n");
		}else{
			this.year = year;
		}
	}

	
	
	
	//Crear clase tomorrow
	
	public Date tomorrow(){
		Date tomorrow = null;
		int d, m, y;
				
		d = this.day;
		m = this.month;
		y = this.year;
		
		d++;
		if ( d > this.dayOfMonth(month) ) {
			d = 1;
			m++;
			if ( m > 12 ) {
				m = 1;
				y++;
			}	
		}
		
		try{
			tomorrow = new Date(d, m, y);
		} catch (Date_Exception error){
			System.out.println("ERROR");
		}

		return tomorrow;
	}
	
	
	
	
	// Ejercicio isSame...
	
	//Apartado isSameDay
	
	public boolean isSameDay(Date other){
		if(this.day == other.getDay()){
			return true;
		}else{
			return false;
		}
	}

	
	
	//Apartado isSameMonth
	
	public boolean isSameMonth(Date other){
		if(this.month == other.getMonth()){
			return true;
		}else{
			return false;	
		}
	}
	
	
	
	
	//Apartado isSameYear
	
	public boolean isSameYear(Date other){
		if(this.month == other.getYear()){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}
	
	
	
	//Apartado nameOfMonth
	
	public String nameOfMonth(){
		String name = null;
		switch(month){
		case 1:
			name = "Enero";
			break;
		case 2:
			name = "Febrero";
			break;
		case 3:
			name = "Marzo";
			break;
		case 4:
			name = "Abril";
			break;
		case 5:
			name = "Mayo";
			break;
		case 6:
			name = "Junio";
			break;
		case 7:
			name = "Julio";
			break;
		case 8:
			name = "Agosto";
			break;
		case 9:
			name = "Septiembre";
			break;
		case 10:
			name = "Octubre";
			break;
		case 11: 
			name = "Noviembre";
			break;
		case 12:
			name = "Diciembre";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}
	
	
	
	
	//Apartado checks dayOfMonth
	
	private boolean isDayRight(int day){
		return ((day > 0) && (day <= this.dayOfMonth(this.month)));
	}
	
	
	public int dayOfMonth(){
		return this.dayOfMonth (this.month);
	}
		
	
	
	private int dayOfMonth(int month){
		int n = 0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:	
			case 12:
				n = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				n = 30;
				break;
			case 2:
				n = 28;
				break;
			default:
				n = -1;
			break;	
		}
		return n;	
	}
	
	
	
	
	//Apartado seasonOfMonth
	
	public String nameSeasonMonth(){
		String name = null;
		switch(this.month){
		case 1:
		case 2:
		case 3:
			name = "Invierno";
			break;
		case 4:
		case 5:
		case 6:
			name = "Primavera";
			break;
		case 7:
		case 8:
		case 9:
			name = "Verano";
			break;
		case 10:
		case 11:
		case 12:
			name = "Otonyo";
			break;
		default:
			name = null;
			break;
		}
		return name;
	}
	
	
	
	
	//Apartado monthLeft
	
	public String monthLeft(){
		Date aux = new Date(this);
		StringBuffer monthLeft = new StringBuffer();
		
		try{
			int i = 0;
			for(i = month; i <= 12; i++){
				aux.setMonth(i);
				monthLeft.append(aux.nameOfMonth() + " ");
			}
		}catch (Date_Exception error){
			System.out.println("ERROR");
			
		}
		return monthLeft.toString();
	}
	
	
	
	
	//Apartado days left of the month
	
	public String daysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); isDayRight(i); i++) {
				aux.setDay(i);
				daysLeft.append(aux.toString() + " ");
			}
		} catch (Date_Exception error){
			System.out.println("ERROR");
		}
		return daysLeft.toString();
		
	}
	
	
	
	
	//Apartado month with the same number of days as the month of this date.
	
	public String monthSameDays(){
		Date aux = new Date(this);
		StringBuffer monthSameDays = new StringBuffer();

		try{
			for( int i = 1; i <= 12; i++){
				aux.setMonth(i);
				if ( aux.dayOfMonth() == this.dayOfMonth()){
					 monthSameDays.append(aux.monthSameDays() + " ");
				}
			}
		}catch (Date_Exception error){
			System.out.println("ERROR");
		}
		return monthSameDays.toString();
	}

	

	
	//Apartado  number of days since the first day of the year
	
	public int dayPast(){
		 int resultado = 0;	
		try{
			Date aux = new Date(1,1,this.year);
		
			for(int i = 1; i < this.month; i++){
				resultado += aux.dayOfMonth();
				aux.setMonth(i + 1);
			}
		}catch (Date_Exception error){
			System.out.println("ERROR");
		}
		
		return resultado + this.day - 1;
	}
	
	
	
	//Apartado day of the Week
	
	private String nameOfDay(int day) {
		String nameDay;
		switch (day) {
		case 1: 
			nameDay = "Lunes";
			break;
		case 2: 
			nameDay = "Martes";
			break;
		case 3: 
			nameDay = "Miercoles";
			break;
		case 4: 
			nameDay = "Jueves";
			break;
		case 5: 
			nameDay = "Viernes";
			break;
		case 6: 
			nameDay = "Sabado";
			break;
		case 7: 
			nameDay = "Domingo";
			break;
		default:
			nameDay = "No es un dia";
		}
		return nameDay;
	}
	
	
	public String dayOfTheWeek(int unoEnero){
		int dayNumber;
		
		dayNumber = (dayPast()% 7 + unoEnero)% 7;
		
		return nameOfDay(dayNumber);
	}
	
	
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
	
	
	
	//Apartado randos days
	
	
	public int numRandom(){
        int  d, m, y;
        int contador= 0;
        
        try{
        	do{
        		m = (int) (Math.random()*12) + 1;
        		d = (int) (Math.random()*this.dayOfMonth(m)) + 1;
        		y = this.year;
        		contador++;
        	} while ( !this.isSame(new Date(d,m,y) ) );
		} catch (Date_Exception error){
			System.out.println("ERROR");
		}

        return contador;
    

	}
}
