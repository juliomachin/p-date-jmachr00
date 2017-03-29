package es.unileon.prg.tema7

public class Date {
	private int day;
	private int month;
	private int year;

	public int getDay(){
		return day;	
	}
	
	public void setDay(int day) throws Date_Exception{
		if(day <=0 ){
			throw new Date_Exception("El número de dias no puede ser menor que 0" +month+ "\n");
		}else if (!this.isDayRigth(day)){
			throw new Date_Exception("El número del Mese no es correcto " +month+ "\n");
		}else{
			this.month = month;
		}
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setMonth(int month) throws Date_Exception{
		if(month <=0 ){
			throw new Date_Exception("El número de los Meses no puede ser menor que 0" +month+ "\n");
		}else if (month >12){
			throw new Date_Exception("El número de los Meses no puede ser mayor que 12" +month+ "\n");
		}else{
			this.month = month;
		}
	}

	public int getYear(int year) throws dateException{
		if(year < 0){
			throw new Date_Exception("Un año no puede ser menor que cero" +year+ "\n");
		}else if (year)
		return year;
	}
	
	public void setYear()

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
