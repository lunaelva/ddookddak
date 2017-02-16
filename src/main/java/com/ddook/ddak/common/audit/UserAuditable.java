package com.ddook.ddak.common.audit;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserAuditable implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Column(name="REG_DATE",nullable=false)
	protected LocalDateTime regDate;
	
	@Column(name="UPD_DATE",nullable=true)
	protected LocalDateTime updDate;

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getUpdDate() {
		return updDate;
	}

	public void setUpdDate(LocalDateTime updDate) {
		this.updDate = updDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}