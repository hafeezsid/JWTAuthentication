package com.ecommerce.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name = "tutor_slot_detail")
@EntityListeners(AuditingEntityListener.class)
public class TutorSlotDetail {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_slot_id")
	private long tutorSlotId;
	
	@Column(name = "slot_start_time", columnDefinition = "TIME")
	private java.util.Date slotStartTime; 
	
	@Column(name = "slot_end_time", columnDefinition = "TIME")
	private java.util.Date slotEndTime; 
	
	@ManyToOne
	@JoinColumn(name = "tutor_schedule_id", referencedColumnName = "tutor_schedule_id")
	private TutorSchedule tutorSchedule;
	
	@Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
    
    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String modifiedBy;

	public long getTutorSlotId() {
		return tutorSlotId;
	}

	public void setTutorSlotId(long tutorSlotId) {
		this.tutorSlotId = tutorSlotId;
	}

	public java.util.Date getSlotStartTime() {
		return slotStartTime;
	}

	public void setSlotStartTime(java.util.Date slotStartTime) {
		this.slotStartTime = slotStartTime;
	}

	public java.util.Date getSlotEndTime() {
		return slotEndTime;
	}

	public void setSlotEndTime(java.util.Date slotEndTime) {
		this.slotEndTime = slotEndTime;
	}

	public TutorSchedule getTutorSchedule() {
		return tutorSchedule;
	}

	public void setTutorSchedule(TutorSchedule tutorSchedule) {
		this.tutorSchedule = tutorSchedule;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

    
    
}
