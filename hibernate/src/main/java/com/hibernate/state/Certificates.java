package com.hibernate.state;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state_certificate_table")
public class Certificates {
	@Id
	private int certificateId;
	private String certificateName;
	private int duration;
	
	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	
	
	
	
	public Certificates(int certificateId, String certificateName, int duration) {
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.duration = duration;
	}
	public Certificates() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
