package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="Inquiry")

@NamedQueries({
	@NamedQuery(
			name="getAllInquiry",
			query="select q from Inquiry as q order by q.id desc"
			),
	@NamedQuery(
			name="getMyInquiry",
			query="select q from Inquiry as q where q.name = :name"
			),

})

@Entity()
public class Inquiry {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="name", nullable=false)
	private String name;

	@Column(name="address", nullable=false)
	private String address;

	@Lob
	@Column(name="content", nullable=false, length=512)
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
