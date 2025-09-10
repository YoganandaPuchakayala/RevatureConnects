package com.revatureconnects.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "slot_openings")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SlotOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long slotId;

    @ManyToOne
    @JoinColumn(name = "interviewer_id")
    private Employee interviewer;

    private LocalDateTime time;

    private Boolean isBooked;
    
    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL)
    private List<SlotBooking> bookings;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}

	public Employee getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Employee interviewer) {
		this.interviewer = interviewer;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	public List<SlotBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<SlotBooking> bookings) {
		this.bookings = bookings;
	}
    
    
    
    
}
