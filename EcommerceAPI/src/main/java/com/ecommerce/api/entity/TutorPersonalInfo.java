package com.ecommerce.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class TutorPersonalInfo implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2879029461800942007L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tutor_personal_info_id")
	private long tutorPersonalInfoId;
	@Column
	private String displayName;
	@Column
	private String preferredChat;
	@Column
	private String skypeId;
	@Column
	private String zoomMeetingLink;
	@Column
	private String zoomMeetingId;
	@Column
	private String zoomPassCode;
	@Column
	private String fromCountry;
	@Column
	private String fromState;
	@Column
	private String fromCity;
	@Column
	private String livingInCountry;
	@Column
	private String livingInState;
	@Column
	private String livingInCity;
	@Column
	private String birthYear;
	@Column
	private String birthMonth;
	@Column
	private String birthDay;
	@Column
	private String gender;
	@Column
	private String currentAddress;
	@Column
	private String permAddress;
	@Column
	private String defLangaugeName;
	
	@OneToOne
	@JoinColumn(name = "user_id",referencedColumnName = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "tutorPersonalInfo", fetch = FetchType.EAGER)
	private List<UserLanguage> languageList;
	
	
	public TutorPersonalInfo() {
	}
}
