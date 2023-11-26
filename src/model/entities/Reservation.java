package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.Exception.DomainException;

public class Reservation {
	private Integer roomNumber;
	private LocalDate checkin;
	private LocalDate checkout;

	public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, LocalDate checkin, LocalDate checkout) throws DomainException {
		if (checkin.isAfter(checkout)) {
			throw new DomainException("Check-out date must be after check-in date");
		}

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

	public void updateDates(LocalDate checkin, LocalDate checkout) throws DomainException {
		LocalDate now = LocalDate.parse("06/06/2018", fmt1);
		if (checkin.isBefore(now) || checkout.isBefore(now)) {
			throw new DomainException("Reservation dates for update must be future dates");

		} else if (checkin.isAfter(checkout)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String toString() {
		return String.format("Room %d, check-in: %s, check-out: %s, %d nights", roomNumber, fmt1.format(checkin),
				fmt1.format(checkout), duration());
	}
}
