//India Lattimore
//O-O Software Development Java


package project1java;

import java.util.ArrayList;

import project1java.PatientCollectionADT;
import project1java.Patient;
import project1java.PatientCollection;


@SuppressWarnings("unused")
public class Main {

	public static void main (String[] args) {
		PatientCollection al = new PatientCollection();
		
		//test new patient entry
		al.addPatientsFromFile("newdata.csv");
		
		//tests get Patient
		String id = "1";
		String result = "CR";
		al.getPatient(id);
		
		//tests set patient result 
		al.setResultForPatient(id, result);
		al.getPatient(id);
		
		//tests remove patient
		al.removePatient(id);
		
		//tests get Ids
		al.getIds();
		
		//tests toString
		System.out.println(al.toString());

	}

}
