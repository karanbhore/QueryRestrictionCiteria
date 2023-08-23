package com.prowings.onetomany.bidirectional;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedNativeQuery;

@NamedNativeQuery(name = "nativeSql", query = "select ASSET_NAME, VENDOR from ASSET_MNGT")

@Entity
@Table(name = "ASSET_MNGT")
public class AssetMgnt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7879793708555124965L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AM_ID", unique = true, nullable = false)
	private Long amId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	@Column(name = "ASSET_NAME")
	private String assetName;

	private String vendor;

	public Long getAmId() {
		return amId;
	}

	public void setAmId(Long amId) {
		this.amId = amId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String toString() {

		return this.assetName + " | " + this.vendor;
	}
}