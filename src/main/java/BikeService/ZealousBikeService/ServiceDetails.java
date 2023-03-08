package BikeService.ZealousBikeService;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class ServiceDetails
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private  int jobcardno;
	private String [] issues;
	@JsonFormat(pattern = "yyyy-mm-dd")
	private Date dateofservice;
	private int kilometer;
	private String status;
	private String typeofservice;
	private int estimatecharge;
	private int newproductcost;
	private int labourcharge;
	@Column(name="totalamount")
	private int finalamout;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value={"service_details","hibernateLazyIntializer"})
	@JoinColumn(name = "customerid")
	private BikeDetails bikedetails;



	public int getJobcardno() {
		return jobcardno;
	}



	public void setJobcardno(int jobcardno) {
		this.jobcardno = jobcardno;
	}



	public String[] getIssues() {
		return issues;
	}



	public void setIssues(String[] issues) {
		this.issues = issues;
	}



	public Date getDateofservice() {
		return dateofservice;
	}



	public void setDateofservice(Date dateofservice) {
		this.dateofservice = dateofservice;
	}



	public int getKilometer() {
		return kilometer;
	}



	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getTypeofservice() {
		return typeofservice;
	}



	public void setTypeofservice(String typeofservice) {
		this.typeofservice = typeofservice;
	}



	public int getEstimatecharge() {
		return estimatecharge;
	}



	public void setEstimatecharge(int estimatecharge) {
		this.estimatecharge = estimatecharge;
	}



	public int getNewproductcost() {
		return newproductcost;
	}



	public void setNewproductcost(int newproductcost) {
		this.newproductcost = newproductcost;
	}



	public int getLabourcharge() {
		return labourcharge;
	}



	public void setLabourcharge(int labourcharge) {
		this.labourcharge = labourcharge;
	}



	public int getFinalamout() {
		return finalamout;
	}



	public void setFinalamout(int finalamout) {
		this.finalamout = finalamout;
	}



	public BikeDetails getBikedetails() {
		return bikedetails;
	}



	public void setBikedetails(BikeDetails bikedetails) {
		this.bikedetails = bikedetails;
	}



	@Override
	public String toString() {
		return "ServiceDetails [jobcardno=" + jobcardno + ", issues=" + Arrays.toString(issues) + ", dateofservice="
				+ dateofservice + ", kilometer=" + kilometer + ", status=" + status + ", typeofservice=" + typeofservice
				+ ", estimatecharge=" + estimatecharge + ", newproductcost=" + newproductcost + ", labourcharge="
				+ labourcharge + ", finalamout=" + finalamout + ", bikedetails=" + bikedetails + "]";
	}



	public ServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ServiceDetails(int jobcardno, String[] issues, Date dateofservice, int kilometer, String status,
			String typeofservice, int estimatecharge, int newproductcost, int labourcharge, int finalamout,
			BikeDetails bikedetails) {
		super();
		this.jobcardno = jobcardno;
		this.issues = issues;
		this.dateofservice = dateofservice;
		this.kilometer = kilometer;
		this.status = status;
		this.typeofservice = typeofservice;
		this.estimatecharge = estimatecharge;
		this.newproductcost = newproductcost;
		this.labourcharge = labourcharge;
		this.finalamout = finalamout;
		this.bikedetails = bikedetails;
	}




}
