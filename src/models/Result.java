package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "cost")
@NamedQueries({ @NamedQuery(name = "getAllResult", query = "select c from cost as order by c.id desc"),
		@NamedQuery(name = "getResultCounts", query = "select count(c) from cost as c") })

@Entity
public class Result {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "進捗")
	private double parcent;

	@Column(name = "使用人件費")
	private double result;

	@Column(name = "差し引き予算")
	private double remaining;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getParcent() {
		return parcent;
	}

	public void setParcent(double parcent) {
		this.parcent = parcent;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getRemaining() {
		return remaining;
	}

	public void setRemaining(double remaining) {
		this.remaining = remaining;
	}
}
