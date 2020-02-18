package project1java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import project1java.Patient;

public class PatientCollection implements PatientCollectionADT{
	private ArrayList<Patient> myPats;
	
	//Collection of Patients 
	public PatientCollection() {
		myPats = new ArrayList<Patient>(); 
		readfile("data.csv");
	}

	// Return the patient with the given id. 
	//Return void if the id does not exist in the collection
	public Patient getPatient(String id) {
		if (!id.contentEquals(id)) {
			String err = "Patient id does not exist in this collection";
			System.out.println(err);
			return null;
		}
		for (Patient patients : myPats) {
			if (patients.getId().equals(id)) {
				System.out.println("\n Patient " + id);
				System.out.println("Result: " + patients.getResult() + "\t" + "Prediction: " + patients.getPred() + "\t" +"Proteins: " + patients.getValues().get(3697) + "    " + patients.getValues().get(3258));
			}
		}
		return null;
	}

	// Remove and return the Patient with the given id. 
	//Return void if the id does not exist.
	public Patient removePatient(String id) {
		if (!id.contentEquals(id)) {
			return null;
		}
		for (Patient patients : myPats) {
			if (patients.getId().equals(id)) {
				myPats.remove(patients);
				return patients;
			}
		}
			return null;
	}

	//Patient Update
	// Set the result field for the patient with given id.
	public void setResultForPatient(String id, String result) {		
		//getPatient(id);
		for (Patient patients : myPats) {
			if (patients.getId().equals(id)) {
				
				patients.setResult(result);
			}
		}
	}


	// Return an ArrayList with all of the collection's patient ids
	public ArrayList<String> getIds() {
		ArrayList<String> ids = new ArrayList<String>();
		System.out.println("\nPatient IDs:");
		for (Patient patients : myPats) {
			System.out.print(patients.getId() + " ");			
		}
		return ids;		
	}
	
	//New Patient Entry 
	// Method reads all lines from comma separated file named fileName.  
	public String addPatientsFromFile(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			e.printStackTrace();
		}
		    String line=" ";
		    int count =1;
				try {
					while ((line = br.readLine()) != null) {
					    String[] tokens = line.split(",");
					    
					    //Error message for invalid criteria
					    if (tokens.length != 4777)
					    {
					    	String err = "Error. The line does not meet criteria. Expected line format:  id,protein1,protein2, ... , protein4776";
			    			System.out.println(err);
					    	return err;
					    }
					    
					    //Adds list of doubles
					    ArrayList<Double> values = new ArrayList<Double>();
					    int k=1;
					    int len = tokens.length-1;
					    while (k < len) {
					    	values.add(Double.parseDouble((tokens[k])));
					    	k++;
					    }
					    
					    //Checks for duplicate id	
					    for (Patient s : myPats) {
				    		if (s.getId().equals(tokens[0])) {
				    			String err = "Error. Duplicate id for patient on line " + count++ + "\nPlease fix line and try again.";
				    			System.out.println(err);
				    			return err;
				    		}
				    	}
					    					    
					    //Adds new patient to collection 
				    	Patient newOne = new Patient("unknown", "pred", tokens[0], values);
				    	if (newOne.getPred().contentEquals("pred")) {
				    		Double p1 = Double.parseDouble(tokens[3697]);
				    		Double p2 = Double.parseDouble(tokens[3258]);
				    		String pred = Predictor.predict(p1, p2);
				    		newOne.setPred(pred);
				    	}
				    	myPats.add(newOne);
				    	count++;
					}

				} catch (IOException e) {
					System.err.println("there was a problem with the file reader, try different read type.");
					e.printStackTrace();
				}
				return null;
	}
	
	
	  public String toString () { 
		  String toReturn = "\n\nPatient Collection:";
		  for (Patient s : myPats) {
			  toReturn += "\nResult: " + s.getResult();
			  toReturn += "\tPrediction: " + s.getPred();
			  toReturn += "\tId: " + s.getId();
			  toReturn += "\tProtein3697: " + s.getValues().get(3697);
			  toReturn += "\tProtein3258: " + s.getValues().get(3258);
		  }
		  return toReturn;
	  }
	 	
	  
	//Read file
	public void readfile(String fileName) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		    String line=" ";
				try {
					while ((line = br.readLine()) != null) {
					    String[] tokens = line.split(",");
					    ArrayList<Double> values = new ArrayList<Double>();
					    int k=3;
					    int len = tokens.length-1;
					    while (k < len) {
					    	values.add(Double.parseDouble((tokens[k])));
					    	k++;
					    }
					   
				    	Patient newOne = new Patient(tokens[0], tokens[1], tokens[2], values);
					    myPats.add(newOne);
					    }

				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}


