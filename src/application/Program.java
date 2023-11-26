package application;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: "); int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): "); LocalDate checkin = LocalDate.parse(sc.next(), Reservation.fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): "); LocalDate checkout = LocalDate.parse(sc.next(), Reservation.fmt1);

		
		if (checkin.isAfter(checkout)) { 
			System.out.println("Error in reservation:  Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): "); checkin = LocalDate.parse(sc.next(), Reservation.fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): "); checkout = LocalDate.parse(sc.next(), Reservation.fmt1);
		
			String msg = reservation.updateDates(checkin, checkout);
			if (msg != null) {
				
			System.out.print("Error in reservation: " + msg);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}
		
		
		
		sc.close();
	}

}
