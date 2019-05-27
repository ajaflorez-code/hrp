package pe.edu.hr.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "locations", 
		indexes = { @Index( name = "locations_indx_0", columnList = "city" ),
					@Index( name = "locations_indx_1", columnList = "state_province" ) } )
@SequenceGenerator( name = "seqLocation", initialValue = 3300 )
public class Location {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seqLocation" )
	@Column( name = "location_id", columnDefinition = "INTEGER(4)" )	
	private Integer id;

	@Column( name = "street_address", length = 40 )
	private String streetAddress;
	
	@Column( name = "postal_code", length = 12 )
	private String postalCode;
	
	@NotEmpty(message = "Enter the city")
	@Column( name = "city", length = 30, nullable = false )
	private String city;
	
	@Column( name = "state_province", length = 25 )
	private String stateProvince;
	
	@NotNull(message = "Debe tener un pais asociado")
	@ManyToOne
	@JoinColumn( name = "country_id", nullable = false )
	private Country country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	
}
