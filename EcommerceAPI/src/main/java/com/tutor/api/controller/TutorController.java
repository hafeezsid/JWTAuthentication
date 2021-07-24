package com.tutor.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tutor.api.dto.TutorListDto;
import com.tutor.api.dto.TutorListViewDto;
import com.tutor.api.dto.TutorPersonalInfoDto;
import com.tutor.api.dto.TutorProfileInfoDto;
import com.tutor.api.entity.ProfileImage;
import com.tutor.api.entity.TutorCertificate;
import com.tutor.api.entity.TutorEducation;
import com.tutor.api.entity.TutorExperience;
import com.tutor.api.entity.TutorPersonalInfo;
import com.tutor.api.entity.TutorProfile;
import com.tutor.api.entity.TutorProfileInfo;
import com.tutor.api.entity.User;
import com.tutor.api.exceptionHandler.ApplicationException;
import com.tutor.api.service.TutorService;
import com.tutor.api.service.UserService;

@RestController
@RequestMapping("/tutor")
public class TutorController {

	Logger logger = LoggerFactory.getLogger(TutorController.class);
	
	@Autowired
	TutorService tutorService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	Gson gson=new Gson();
	
	/**
	 * @param tutorPrsnObj
	 * @return
	 */
	@PostMapping("/savePersonalInfo")
	public ResponseEntity<TutorPersonalInfoDto> savePersonalInfo(@RequestBody TutorPersonalInfoDto
			tutorPrsnObj)
	{
	
		try {
			User user=userService.getLoggedInUserDetails();
			final TutorPersonalInfo infoObj=objectMapper.convertValue(tutorPrsnObj, TutorPersonalInfo.class);
			tutorService.saveTutorPersonalInfo(infoObj,user);
			return new ResponseEntity<TutorPersonalInfoDto>(tutorPrsnObj,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception while :: savePersonalInfo", e);
			throw new ApplicationException("Error occurred while saving personal details",e);
		}
		
	}
	
	@GetMapping("/fetch/{tutorId}")
	public ResponseEntity<TutorListViewDto> fetchTutorbyId(@PathVariable long tutorId){
		try {
			TutorListViewDto dto=new TutorListViewDto();
			dto.setUserId(tutorId);
			dto=tutorService.findByTutorId(dto);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	catch (Exception e) {
		logger.error(e.getMessage(),e);
		throw new ApplicationException("Error occurred while fetching tutors");
	}
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<TutorListDto> fetchAllTutor(@RequestParam Map<String,String> paramMaps)
	{
		try {
		Integer page=Integer.valueOf(paramMaps.get("page"));
		Integer size=Integer.valueOf(paramMaps.get("size"));
		Pageable pageable=PageRequest.of(page, size);
		TutorListDto tutorListDto=new TutorListDto();
		tutorListDto.setPage(page);
		tutorListDto.setSize(size);
		List<TutorListViewDto> tutorList= tutorService.findAllByPageAndSize(pageable,tutorListDto);
		tutorListDto.setTutorList(tutorList);
		return new ResponseEntity<>(tutorListDto,HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ApplicationException("Error occurred while fetching tutors");
		}
	}
	
	
	@PostMapping("/saveTeachingInfo")
	public ResponseEntity<TutorProfileInfoDto> saveTeachingInfo(@RequestBody TutorProfileInfoDto
			tutorProfileObj)
	{

		try {
			User user=userService.getLoggedInUserDetails();
			final TutorProfileInfo infoObj=objectMapper.convertValue(tutorProfileObj, TutorProfileInfo.class);
			tutorService.saveTutorProfileInfo(infoObj,user);
			tutorProfileObj=objectMapper.convertValue(infoObj, TutorProfileInfoDto.class);
			return new ResponseEntity<TutorProfileInfoDto>(tutorProfileObj,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Exception while :: savePersonalInfo", e);
			throw new ApplicationException("Error occurred while saving teaching details",e);
		}
		
	}
	
	@GetMapping("/basicInfo")
	public ResponseEntity<TutorPersonalInfoDto> fetchPersonalInfo(){
		try {
		User user=userService.getLoggedInUserDetails();
		TutorPersonalInfoDto infoObj=new TutorPersonalInfoDto();
	
		TutorProfile tutorP=tutorService.fetchTutorProfileByUser(user);
		if(tutorP!=null) {
			infoObj=objectMapper.convertValue(tutorP.getTutorPersonalInfo(), TutorPersonalInfoDto.class);
			if(infoObj==null) {
				infoObj=new TutorPersonalInfoDto();
			}
			if(tutorP.getProfileImage()!=null) {
				logger.info(tutorP.getProfileImage().getImage().toString());
				infoObj.setProfilePicByte(tutorP.getProfileImage().getImage());
			}
		}
		return new ResponseEntity<>(infoObj,HttpStatus.OK); 
		}catch (Exception e) {
			logger.error("Error ocurred inside method fetchPersonalInfo()", e);
			throw new ApplicationException("Error occurred while fetching tutor Details", e);
		}
	}
	
	@GetMapping("/teachingInfo")
	public ResponseEntity<TutorProfileInfoDto> fetchTeachingInfo(){
		try {
		User user=userService.getLoggedInUserDetails();
		TutorProfile tutorP=tutorService.fetchTutorProfileByUser(user);
		TutorProfileInfoDto infoObj=objectMapper.convertValue(tutorP.getTutorProfileInfo(), TutorProfileInfoDto.class);
		return new ResponseEntity<>(infoObj,HttpStatus.OK); 
		}
		catch (Exception e) {
			logger.error("Error occurred while fetching tutor Details", e);
			throw new ApplicationException("Error occurred while fetching tutor Details", e);
		}
	}
	@PostMapping("/education")
	public ResponseEntity<TutorEducation> saveEducation(
			@RequestParam Map<String,String> map,@RequestParam("attachedFile") MultipartFile file )
	{	
		
			if(file==null) {
				logger.error("Error:: saveEducation():: file cannot be empty.");
				throw new ApplicationException("file cannot be empty.");
			}
			
		try {
			JsonObject convertedObject = gson.fromJson(map.get("education"), JsonObject.class);
			User user=userService.getLoggedInUserDetails();
			TutorProfile tutorP=tutorService.fetchTutorProfileByUser(user);
			
			TutorEducation tutorEducation =new TutorEducation();
			tutorEducation.setFromYear(convertedObject.get("fromYear").getAsInt());
			tutorEducation.setToYear(convertedObject.get("toYear").getAsInt());
			tutorEducation.setInstitutionName(convertedObject.get("institutionName").getAsString());
			tutorEducation.setMajor(convertedObject.get("major").getAsString());
			tutorEducation.setDegree(convertedObject.get("degree").getAsString());
			if(!convertedObject.get("additionalInfo").isJsonNull())
				tutorEducation.setAdditionInfo(convertedObject.get("additionalInfo").getAsString());
			
			tutorEducation.setAttachedDoc(file.getBytes());
			tutorEducation.setDocumentType(file.getContentType());
			tutorEducation.setDocumentName(file.getOriginalFilename());
			tutorEducation.setUploadStatus(true);
			if(tutorP.getTutorProfileInfo()!=null)
			{
				tutorEducation.setTutorProfileInfo(tutorP.getTutorProfileInfo());
				tutorEducation=tutorService.saveEducation(tutorEducation);
			}
			else {
				TutorProfileInfo tpi=new TutorProfileInfo();
				tpi.setTutorProfile(tutorP);
				Set<TutorEducation> eduSet=new HashSet<>();
				eduSet.add(tutorEducation);
				tpi.setEducations(eduSet);
				tutorEducation.setTutorProfileInfo(tpi);
				tutorService.saveTutorProfileInfo(tpi);
				tutorEducation=tpi.getEducations().stream().findFirst().get();
			}
			
			return new ResponseEntity<>(tutorEducation,HttpStatus.OK);
			
			
		} catch (Exception e) {
			logger.error("Error occurred while saving education Details", e);
			throw new ApplicationException("Error occurred while saving education Details", e);
		}
	}
	
	@PostMapping("/experience")
	public ResponseEntity<TutorExperience> saveExperience(
			@RequestParam Map<String,String> map)
	{	
		try {
			JsonObject convertedObject = gson.fromJson(map.get("experience"), JsonObject.class);
			User user=userService.getLoggedInUserDetails();
			TutorProfile tutorP=tutorService.fetchTutorProfileByUser(user);
			TutorExperience tutorExperience =new TutorExperience();
			tutorExperience.setFromYear(convertedObject.get("fromYear").getAsInt());
			tutorExperience.setToYear(convertedObject.get("toYear").getAsInt());
			tutorExperience.setCompany(convertedObject.get("company").getAsString());
			tutorExperience.setDesignation(convertedObject.get("designation").getAsString());
			tutorExperience.setCountry(convertedObject.get("country").getAsString());
			tutorExperience.setState(convertedObject.get("state").getAsString());
			tutorExperience.setCity(convertedObject.get("city").getAsString());
			if(!convertedObject.get("additionalInfo").isJsonNull())
				tutorExperience.setAdditionInfo(convertedObject.get("additionalInfo").getAsString());
			tutorExperience.setDocumentType("Experience");
			tutorExperience.setUploadStatus(true);
			if(tutorP.getTutorProfileInfo()!=null)
			{
				tutorExperience.setTutorProfileInfo(tutorP.getTutorProfileInfo());
				tutorExperience=tutorService.saveExperience(tutorExperience);
			}
			else {
				TutorProfileInfo tpi=new TutorProfileInfo();
				tpi.setTutorProfile(tutorP);
				Set<TutorExperience> expSet=new HashSet<TutorExperience>();
				expSet.add(tutorExperience);
				tpi.setExperiences(expSet);
				tutorExperience.setTutorProfileInfo(tpi);
				tutorService.saveTutorProfileInfo(tpi);
			}
			
				return new ResponseEntity<>(tutorExperience,HttpStatus.OK);
			
		} catch (Exception e) {
			logger.error("Error occurred while saving experience Details", e);
			throw new ApplicationException("Error occurred while saving experience Details", e);
		}
	}
	
	@PostMapping("/certificate")
	public ResponseEntity<TutorCertificate> saveCertificate(
			@RequestParam Map<String,String> map,@RequestParam("attachedFile") MultipartFile file )
	{	

		if(file==null) {
			logger.error("Error:: saveEducation():: file cannot be empty.");
			throw new ApplicationException("file cannot be empty.");
		}
		try {
			JsonObject convertedObject = gson.fromJson(map.get("certificate"), JsonObject.class);
			User user=userService.getLoggedInUserDetails();
			TutorProfile tutorP=tutorService.fetchTutorProfileByUser(user);
			TutorCertificate tutorCertificate =new TutorCertificate();
			tutorCertificate.setAcquiredYear(convertedObject.get("acquiredYear").getAsInt());
			tutorCertificate.setCertificateName(convertedObject.get("certificateName").getAsString());
			tutorCertificate.setProvider(convertedObject.get("provider").getAsString());
			if(!convertedObject.get("certificateLink").isJsonNull())
			tutorCertificate.setCertificateLink(convertedObject.get("certificateLink").getAsString());
			tutorCertificate.setAttachedDoc(file.getBytes());
			tutorCertificate.setUploadStatus(true);
			if(tutorP.getTutorProfileInfo()!=null)
			{
				tutorCertificate.setTutorProfileInfo(tutorP.getTutorProfileInfo());
				tutorCertificate=tutorService.saveCertificate(tutorCertificate);
			}
			else {
				TutorProfileInfo tpi=new TutorProfileInfo();
				tpi.setTutorProfile(tutorP);
				Set<TutorCertificate> certSet=new HashSet<>();
				certSet.add(tutorCertificate);
				tpi.setCertificates(certSet);
				tutorCertificate.setTutorProfileInfo(tpi);
				tutorService.saveTutorProfileInfo(tpi);
			}
			return new ResponseEntity<>(tutorCertificate,HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error occurred while saving certificate Details", e);
			throw new ApplicationException("Error occurred while saving certificate Details", e);
		}
	}
	
	
	
	@DeleteMapping("/education/{id}")
	public ResponseEntity<Long> deleteEducation(
			@PathVariable("id") long tutorEducatioId )
	{
			try{
			tutorService.deleleTutorEducationById(tutorEducatioId);
			return new ResponseEntity<>(tutorEducatioId,HttpStatus.OK);
			}catch (Exception e) {
				logger.error(e.getMessage(),e);
				throw new ApplicationException("Cannot delete education.", e);
			}
	}
	
	@DeleteMapping("/experience/{id}")
	public ResponseEntity<Long> deleteExperience(
			@PathVariable("id") long  tutorExperienceId )
	{
			try{
			tutorService.deleleTutorExperienceById(tutorExperienceId);
			return new ResponseEntity<Long>(tutorExperienceId,HttpStatus.OK);
			}catch (Exception e) {
				logger.error(e.getMessage(),e);
				throw new ApplicationException("Cannot delete education.", e);
			}
	}
	
	@DeleteMapping("/certificate/{id}")
	public ResponseEntity<Long> deleteCetificate(
			@PathVariable("id") long tutorCertificateId )
	{
			try{
			tutorService.deleleTutorCertificateById(tutorCertificateId);
			return new ResponseEntity<>(tutorCertificateId,HttpStatus.OK);
			}catch (Exception e) {
				logger.error(e.getMessage(),e);
				throw new ApplicationException("Cannot delete education.", e);
			}
	}
	

	
	@PostMapping("/uploadImage")
	public ResponseEntity<String> uploadProfileImage(@RequestParam("image") MultipartFile file)
	{	
		TutorProfile tutorP=null;
		User user=userService.getLoggedInUserDetails();
		byte image[];
		try {
			image = file.getBytes();
			ProfileImage photoObj = new ProfileImage();
			photoObj.setImage(image);
			
			tutorP=tutorService.fetchTutorProfileByUser(user);
					
			if(tutorP==null) {
				tutorP=new TutorProfile();
			}
				
				tutorP.setProfileImage(photoObj);
				tutorP.setUser(user);
				tutorService.saveTutorProfileWithImage(tutorP);
			return new ResponseEntity<String>("true",HttpStatus.OK);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new ApplicationException("Error while uploading image");
		}
	}
	
	
}
