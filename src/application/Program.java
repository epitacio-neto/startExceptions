package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.Exception.DomainException;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkin = LocalDate.parse(sc.next(), Reservation.fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkout = LocalDate.parse(sc.next(), Reservation.fmt1);

			Reservation reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = LocalDate.parse(sc.next(), Reservation.fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = LocalDate.parse(sc.next(), Reservation.fmt1);

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
			
		}
		catch (DomainException e) {
			System.out.println("Error in reservation:  " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}
		sc.close();
	}

}
