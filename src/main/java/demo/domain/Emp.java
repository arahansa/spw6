package demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data @EqualsAndHashCode(of="id")
public class Emp {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(length=20, nullable=false)
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	Dept dept;	// 1 <-- SELECT
	
	// FORMATTER
	
	
	
	

}
