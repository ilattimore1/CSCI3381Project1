package project2;

public class Patient {
	private String prediction;
	private String result;
	private String id;
	private String[] values;
	
	public Patient(String i) {
		id = i;
	}	
	
	public Patient(String r, String p, String i, String v) {
		prediction = p;
		result = r;
		id = i;
		values = v.split(",");
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrediction() {
		return prediction;
	}

	public void setPrediction(String prediction) {
		this.prediction = prediction;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public double getValue (int index) {
		return Double.parseDouble(values[index]);
	}
	
	public boolean equals (Object rhs) {
		Patient rhsPat = (Patient)rhs;
		return (rhsPat.getId().equals(id));
	}
	public int getValuesCount () {
		return values.length;
	}
	public String toString () {
		return prediction+","+result+","+id+", [3697] "+values[3697]+", [3258] "+values[3258];
	}
}
