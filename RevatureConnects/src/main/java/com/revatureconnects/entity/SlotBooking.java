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
}
