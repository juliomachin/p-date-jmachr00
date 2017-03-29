package es.unileon.prg.tema7

public class Date {
	private int day;
	private int month;
	private int year;

	public int getday(){
		return day;	
	}
	
	public void setday(int day) throws date_Exception{
		if(day <=0 ){
			throw new date_Exception("El número de dias no puede ser menor que 0" +month+ "\n");
		}else if (day >31){
			throw new date_Exception("El número de los Meses no puede ser mayor que 12" +month+ "\n");
		}else{
			this.month = month;
		}
	}
	
	public int getmonth(){
		return month;
	}
	
	public void setmont(int month) throws date_Exception{
		if(month <=0 ){
			throw new date_Exception("El número de los Meses no puede ser menor que 0" +month+ "\n");
		}else if (month >12){
			throw new date_Exception("El número de los Meses no puede ser mayor que 12" +month+ "\n");
		}else{
			this.month = month;
		}
	}

	/*public Date (int day , int month, int year){
			this.day = day;
			this.month = month;
			this.year = year;
			today = new Date("Fecha");
	
			Date(int day, int month, int year){
				if(day ==)
			}
	}*/
		
}
