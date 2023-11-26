package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;
	
	public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckin() {
		return checkin;
	}

	public LocalDate getCheckout() {
		return checkout;
	}
	
	public int duration() {
		Duration duration = Duration.between(checkin.atStartOfDay(), checkout.atStartOfDay());
		return (int) duration.toDays();
	}
	
	public String updateDates(LocalDate checkin, LocalDate checkout) {
		LocalDate now = LocalDate.parse("06/06/2018", Reservation.fmt1);
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			return "Reservation dates for update must be future dates";
			
		} else if (checkin.isAfter(checkout)) {
			return "Check-out date must be after check-in date";
		}
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	public String toString() {
		return String.format("Room %d, check-in: %s, check-out: %s, %d nights",
				roomNumber,
				fmt1.format(checkin),
				fmt1.format(checkout),
				duration());
	}
}
