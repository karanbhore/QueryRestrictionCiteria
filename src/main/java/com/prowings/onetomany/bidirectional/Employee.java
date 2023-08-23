package com.prowings.onetomany.bidirectional;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@NamedQuery(name = "QUERY_GET_ALL_EMP", query = "from Employee")
@NamedQuery(name = "QUERY_GET_ALL_EMP_FIL_SALARY", query = "from Employee e where e.salary > 9000 ORDER BY e.name ASC")

@Entity
@Table(name = "EMPLOYEES")
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7656573976941956916L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID", unique = true, nullable = false)
	private Long empId;

	private String name;

	private String department;

	private Long salary;

	@Column(name = "JOINED_ON")
	private Date joinedOn;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private List<AssetMgnt> assetMgnt;

	public List<AssetMgnt> getAssetMgnt() {
		return assetMgnt;
	}

	public void setAssetMgnt(List<AssetMgnt> assetMgnt) {
		this.assetMgnt = assetMgnt;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Date getJoinedOn() {
		return joinedOn;
	}

	public void setJoinedOn(Date joinedOn) {
		this.joinedOn = joinedOn;
	}

	@Override
	public String toString() {

		String resp = this.empId + " | " + this.name + " | " + this.department + " | " + this.salary + " | "
				+ this.joinedOn;

		return resp;
	}
}