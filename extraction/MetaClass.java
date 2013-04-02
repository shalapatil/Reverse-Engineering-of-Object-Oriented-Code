package extraction;

import java.util.Vector;
import Database_handling.*;

public class MetaClass {

	public String classname;
	public boolean static_class;
	public boolean final_class;
	public boolean abstract_class;
	public String access_class;
	public String parent_class;
	public Vector<String> interfac = new Vector<String>();
	public Vector<Variable> variable = new Vector<Variable>();
	public Vector<Function> function = new Vector<Function>();
	public static Vector<Mapping> mapping = new Vector<Mapping>();

	public MetaClass() {

	}

	public void print_class_details() {

		StoreToDatabase s = new StoreToDatabase();
		try {
			s.store(this);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*** Class Details ******");

		System.out.println("\nClass name :: " + classname);
		System.out.println("Static class :: " + static_class);
		System.out.println("Final class :: " + final_class);
		System.out.println("Abstract class :: " + abstract_class);
		System.out.println("Access specifier of class :: " + access_class);
		System.out.println("Parent class : " + parent_class);
		System.out.print("Interfaces implemented : ");
		for (int i = 0; i < interfac.size(); i++) {
			System.out.print(interfac.get(i) + " , ");

		}

		System.out.println("\n\n**** Instance variable Details ****** ");

		Variable v;
		for (int i = 0; i < variable.size(); i++) {
			v = variable.get(i);
			v.print_variable_details();
		}

		Function f;
		for (int i = 0; i < function.size(); i++) {
			f = function.get(i);
			f.print_function_details();
		}

	}

	public static void print_all_mapping() {
		Mapping f;
		for (int i = 0; i < mapping.size(); i++) {
			f = mapping.get(i);
			f.print_mapping();
		}

	}

}