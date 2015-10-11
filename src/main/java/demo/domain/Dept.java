package demo.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data @EqualsAndHashCode(of="id")
@ToString(exclude="emp")
public class Dept {
	@Id @GeneratedValue
	Long id;
	
	@Column(length=20, nullable=false)
	@NotEmpty
	String name;
	
	@Column
	Integer age;
	
	@Enumerated(EnumType.STRING)
	Level level;
	
//	@OneToMany(mappedBy="dept")
//	List<Emp> emp;
}
