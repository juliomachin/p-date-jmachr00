package es.unileon.prg.tema7

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
	
	public Date(int dya, int month, int year) throws Date_Exception{
		StringBuffer mensaje = new StringBuffer();
		
		if(day <= 0){
			mensaje.append("No se permiten dias negativos" +day+ "\n");
		}
		if(month <=0){
			mensaje.append("No se permiten meses negativos" +month+ "\n");
		}else if(month > 12){
			mensaje.append("No se permiten meses mayores que 12" +month+ "\n");
		}
		if (year < 0){
			mensaje.append("No se permiten anyos negativos" +year+ "\n");
		}
		if (mensaje.length() != 0){
			throw new Date_Exception(mensaje.toString());
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
		}else if (!this.isDayRigth(day)){
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

	public int getYear(int year) throws Date_Exception{
		return year;
	}
	
	public void setYear(int year) throws Date_Exception{
		if(year < 0){
			throw new Date_Exception("El anyo no puede ser menor que cero" +year+ "\n");
		}else{
			this.year = year;
		}
	}

	//Sacar que dia pertenece a cada mes
	
	public int dayOfMonth(){
		return this.dayOfMonth (this.month);
	}

	private int dayOfMonth(int month){
		int m = 0;
		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:	
			case 12:
				m = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				m = 30;
				break;
			case 2:
				m = 28;
				break;
			default:
				m = -1;
			break;	
		}
		return m;	
	}
		
	private boolean isDayRight(int day){
		return ((day >0) && (day <= this.dayOfMonth(this.month)));
	}
	

		
}
