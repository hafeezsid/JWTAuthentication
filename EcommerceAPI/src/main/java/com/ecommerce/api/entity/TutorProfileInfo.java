package com.ecommerce.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class TutorProfileInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6159024498620645188L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_profile_info_id")
	private long tutorProfileInfoId;
	
	@OneToMany(mappedBy = "tutorProfileInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<TutorSubject> tutorSubjects;
	
	@Column(name = "about_me", length = 1000)
	private String aboutMe;
	@Column(name = "about_teaching_exp",length = 1000)
	private String aboutTeachingExp;
	@Column(name = "other_info",length = 1000)
	private String otherInfo;
	@Column(name = "hourly_rate")
	private int hourlyRate;
	
	@Column(name = "currency", length=10)
	private String currency;
	
	
	@OneToOne
	@JoinColumn(name = "tutor_profile_mast_id",referencedColumnName = "tutor_profile_mast_id")
	@JsonIgnore
	private TutorProfile tutorProfile;

	@OneToMany(mappedBy = "tutorProfileInfo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TutorEducation> educations;
	
	@OneToMany(mappedBy = "tutorProfileInfo",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TutorExperience> experiences;
	
	@OneToMany(mappedBy = "tutorProfileInfo",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<TutorCertificate> certificates;

	public long getTutorProfileInfoId() {
		return tutorProfileInfoId;
	}

	public void setTutorProfileInfoId(long tutorProfileInfoId) {
		this.tutorProfileInfoId = tutorProfileInfoId;
	}

	
	public TutorProfile getTutorProfile() {
		return tutorProfile;
	}

	public void setTutorProfile(TutorProfile tutorProfile) {
		this.tutorProfile = tutorProfile;
	}

	public Set<TutorEducation> getEducations() {
		return educations;
	}

	public void setEducations(Set<TutorEducation> educations) {
		this.educations = educations;
	}

	public Set<TutorExperience> getExperiences() {
		return experiences;
	}

	public void setExperiences(Set<TutorExperience> experiences) {
		this.experiences = experiences;
	}

	public Set<TutorCertificate> getCertificates() {
		return certificates;
	}

	public void setCertificates(Set<TutorCertificate> certificates) {
		this.certificates = certificates;
	}

	public Set<TutorSubject> getTutorSubjects() {
		return tutorSubjects;
	}

	public void setTutorSubjects(Set<TutorSubject> tutorSubjects) {
		this.tutorSubjects = tutorSubjects;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getAboutTeachingExp() {
		return aboutTeachingExp;
	}

	public void setAboutTeachingExp(String aboutTeachingExp) {
		this.aboutTeachingExp = aboutTeachingExp;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public int getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(int hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	

}
