package project1java;
import java.util.ArrayList;

public class Patient{
	//each patient needs a result, prediction, id, and protein values
	private String result;
	private String id;
	private String pred;
	private ArrayList<Double> values;

	public Patient(String r, String p, String d, ArrayList<Double> v) {
			this.setResult(r);
			this.setPred(p);
			this.setId(d);
			this.setValues(v);
		}

	//Getters and setters for private data members
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPred() {
		return pred;
	}

	public void setPred(String pred) {
		this.pred = pred;
	}

	public ArrayList<Double> getValues() {
		return values;
	}

	public void setValues(ArrayList<Double> values) {
		this.values = values;
	}
	
}


