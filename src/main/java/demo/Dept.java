package demo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data @EqualsAndHashCode(of="id")
public class Dept {
	@Id @GeneratedValue
	Long id;
	
	@Column(length=20, nullable=false)
	@NotEmpty
	String name;
	

}
