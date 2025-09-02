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

    
    
}
