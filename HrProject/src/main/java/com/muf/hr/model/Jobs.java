package com.muf.hr.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Jobs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jobId;
	private String jobTitle;
	private BigDecimal minSalary;
	private BigDecimal maxSalary;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public BigDecimal getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(BigDecimal minSalary) {
		this.minSalary = minSalary;
	}

	public BigDecimal getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(BigDecimal maxSalary) {
		this.maxSalary = maxSalary;
	}

}
