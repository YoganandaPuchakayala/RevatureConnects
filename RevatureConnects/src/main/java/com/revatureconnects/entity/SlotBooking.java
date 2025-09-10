package com.revatureconnects.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "slot_bookings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SlotBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "slot_id", nullable = false)
    private SlotOpening slot;

    @ManyToOne
    @JoinColumn(name = "empId", nullable = false)
    private Employee candidate;
    
    private LocalDateTime bookedAt;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public SlotOpening getSlot() {
		return slot;
	}

	public void setSlot(SlotOpening slot) {
		this.slot = slot;
	}

	public Employee getCandidate() {
		return candidate;
	}

	public void setCandidate(Employee candidate) {
		this.candidate = candidate;
	}

	public LocalDateTime getBookedAt() {
		return bookedAt;
	}

	public void setBookedAt(LocalDateTime bookedAt) {
		this.bookedAt = bookedAt;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}
    
    
}

