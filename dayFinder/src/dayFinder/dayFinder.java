package dayFinder;

import java.util.Scanner;

public class dayFinder {
	

	public static void main(String[] args) {
		
		int day;
		int month;
		int yearV;
		int yearH;
		boolean schaltjahr = false;
		int a;
		int b;
		int c;
		int d;
		int end;
		String wochentag = "";
		int date;
		String dateS;
		
		

		date = eingabeDate();											//datum eingeben
		
		
		day = date/1000000;												//datum auf Tag, Monat und Jahr einteilen
		month = (date/10000)-(day*100);
		yearV = (date/100)-(day*10000)-(month*100);
		yearH = date-(day*1000000)-(month*10000)-(yearV*100);
		
		
		if(yearH%4==0) {												//schauen ob das jahr ein Schaltjahr ist
			if(month==1 || month==2) {
			schaltjahr = true;
			}
		}

		
		a = day%7;														//den wert für a (Tag) festlegen
		
		if(month==2 || month==3 || month==11) {							//den wert für b (Monat) festlegen
			b = 3;
		}
		else { if(month==1 || month==10) {
			b=0;
		}
				else { if(month==9 || month==12) {
					b=5;
				}
						else {if(month==4 || month==7) {
							b=6;
						}
								else {if(month==5) {
									b=1;
								}
										else {if(month==6) {
											b=4;
										}
												else {b=2;}
		
											}
									}
							}	
	
					}
			}
		
		c = (3-(yearV%4))*2;											//den wert für c (jahrhundertzahl) festlegen
		d = (yearH+(yearH/4))%7;										//den wert für d (jahreszahl) festlegen
		
		end = a+b+c+d;													//a b c und d zusammenrechnen und den endwert bestimmen
		
		if(schaltjahr) {												//wenn das jahr ein schaltjahr ist dann dem endwert 6 addieren
			end = end+6;	
		}
		
		end = end%7;													//den mod 7 vom endwert bestimmen
		
		if(end==0) {wochentag = "Sonntag";}								//jeder mod wird einem wochentag zugeordnet
		if(end==1) {wochentag = "Montag";}
		if(end==2) {wochentag = "Dienstag";}
		if(end==3) {wochentag = "Mittwoch";}
		if(end==4) {wochentag = "Donnerstag";}
		if(end==5) {wochentag = "Freitag";}
		if(end==6) {wochentag = "Samstag";}
		
		String dayS = String.valueOf(day);								//die daten des datums in stringwerte ändern
		String monthS = String.valueOf(month);
		String yearVS = String.valueOf(yearV);
		String yearHS = String.valueOf(yearH);
		
		if(yearHS.length()==1) {										//falls die endjahreszahl nur eine ziffer ist kommt eine 0 davor
			yearHS = "0"+yearHS;
		}
		
		dateS = dayS + "." + monthS + "." + yearVS  + yearHS;			//das datum als string angeben
		
		System.out.println("Der " + dateS + " war ein " + wochentag + ".");		//endergebniss in der konsole anzeigen
		
		
		
	}
	
	
	
	
	public static int eingabeDate() {									//klasse für die datum eingabe
		
		Scanner lesen =new Scanner(System.in);
		System.out.println("Bitte geben sie das Datum im Format TTMMJJJJ an.");
		int date = lesen.nextInt();
		
		return date;
	}
	
	
	
}
