package pe.edu.hr.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "job_history", 
		indexes = { @Index( name = "job_history_indx_0", columnList = "employee_id" ) } )
@IdClass(JobHistoryId.class)
public class JobHistory {	
	@Id
	@ManyToOne	
	@JoinColumn( name = "employee_id", columnDefinition = "INTEGER(6)" ) 
	@JsonIgnoreProperties("jobHistories")
	private Employee employee;
	
	@Id
	@Column( name = "start_date", nullable = false )
	@Temporal( TemporalType.DATE )
	private Date startDate;
	
	@Column( name = "end_date", nullable = false )
	@Temporal( TemporalType.DATE )
	private Date endDate;
	
	@ManyToOne
	@JoinColumn( name = "job_id", nullable = false )
	@JsonIgnoreProperties("jobHistories")
	private Job job;
	
	@ManyToOne
	@JoinColumn( name = "department_id" )
	@JsonIgnoreProperties("jobHistories")
	private Department department;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
