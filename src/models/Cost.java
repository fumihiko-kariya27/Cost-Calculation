package models;

public class Cost {

	private Integer budget;

	private Integer hourly_wage;

	private Double time;

	private Integer number_of_people;

	// コンストラクタの生成
	public Cost() {
	}

	// 引数ありのコンストラクタ
	public Cost(int budget, int hourly_wage, double time, int number_of_people) {
		this.budget = budget;
		this.hourly_wage = hourly_wage;
		this.time = time;
		this.number_of_people = number_of_people;
	}

	public double Result() {
		double total_cost = hourly_wage * time * number_of_people;
		return total_cost;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Integer getHourly_wage() {
		return hourly_wage;
	}

	public void setHourly_wage(Integer hourly_wage) {
		this.hourly_wage = hourly_wage;
	}

	public Double getTime() {
		return time;
	}

	public void setTime(double time2) {
		this.time = time2;
	}

	public Integer getNumber_of_people() {
		return number_of_people;
	}

	public void setNumber_of_people(Integer number_of_people) {
		this.number_of_people = number_of_people;
	}

}
