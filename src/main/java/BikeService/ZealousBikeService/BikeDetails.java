package BikeService.ZealousBikeService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class BikeDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cusId;
	private String cusName;
	private long cusContactno;
	private String cusEmailid;
	private String cusBikeno;
	@JsonFormat(pattern = ("yyyy-mm-dd"))
	private Date cusDateofpurchase; // dd-mm-yyyy

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Nullable
	@JsonBackReference
	@JoinTable(name="Allrecords", joinColumns = @JoinColumn(name="cusId"),inverseJoinColumns = @JoinColumn(name="jobcardno"))
	private Collection<ServiceDetails> serviceDetails = new ArrayList<>();

	@Override
	public String toString() {
		return "BikeDetails [cusId=" + cusId + ", cusName=" + cusName + ", cusContactno=" + cusContactno
				+ ", cusEmailid=" + cusEmailid + ", cusBikeno=" + cusBikeno + ", cusDateofpurchase=" + cusDateofpurchase
				+ ", serviceDetails=" + serviceDetails + "]";
	}

	public BikeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BikeDetails(int cusId, String cusName, long cusContactno, String cusEmailid, String cusBikeno,
			Date cusDateofpurchase, Collection<ServiceDetails> serviceDetails) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContactno = cusContactno;
		this.cusEmailid = cusEmailid;
		this.cusBikeno = cusBikeno;
		this.cusDateofpurchase = cusDateofpurchase;
		this.serviceDetails = serviceDetails;
	}

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public long getCusContactno() {
		return cusContactno;
	}

	public void setCusContactno(long cusContactno) {
		this.cusContactno = cusContactno;
	}

	public String getCusEmailid() {
		return cusEmailid;
	}

	public void setCusEmailid(String cusEmailid) {
		this.cusEmailid = cusEmailid;
	}

	public String getCusBikeno() {
		return cusBikeno;
	}

	public void setCusBikeno(String cusBikeno) {
		this.cusBikeno = cusBikeno;
	}

	public Date getCusDateofpurchase() {
		return cusDateofpurchase;
	}

	public void setCusDateofpurchase(Date cusDateofpurchase) {
		this.cusDateofpurchase = cusDateofpurchase;
	}

	public Collection<ServiceDetails> getServiceDetails() {
		return serviceDetails;
	}

	public void setServiceDetails(Collection<ServiceDetails> serviceDetails) {
		this.serviceDetails = serviceDetails;
	}



}
