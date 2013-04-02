package extraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application_GUI.DemoJFileChooser;

/**
 * @author shala
 * 
 */
public class extractDetails extends JavaGrammer {

	static MetaClass output[] = new MetaClass[5];

	static Boolean d = false, co = false;
	static int ch = 1;
	static int var_start = 0;
	static Boolean constructor_flag = false;
	static int temp = 0;
	static int bl_start = 0, bl_end = 0;

	JavaGrammer j;

	private static String class1;
	private static String class_name;
	private static String datatype;
	private static String extra;
	private static String extend;
	private static String implement;
	private static String any;
	private static String name;
	private static String is_fun;
	private static String end_fun;
	private static String fun_call;
	private static String block_start;
	private static String block_end;
	private static String INPUT;
	private static String keyword;
	private static String template;
	private static String new_statment;

	static int pos = 0;
	static int end = 0;;

	static int bl_st = 0;

	static int bl_en = 0;

	static int nxt_class = 0;

	static {
		System.out.println("\nEnter first your choice :: ");

		class1 = JavaGrammer.class1;
		class_name = JavaGrammer.class_name;
		datatype = JavaGrammer.datatype;
		extra = JavaGrammer.extra;
		extend = JavaGrammer.extend;
		implement = JavaGrammer.implement;
		any = JavaGrammer.any;
		name = JavaGrammer.name;
		is_fun = JavaGrammer.is_fun;
		end_fun = JavaGrammer.end_fun;
		fun_call = JavaGrammer.fun_call;
		block_start = JavaGrammer.block_start;
		block_end = JavaGrammer.block_end;
		keyword = JavaGrammer.keyword;
		template = JavaGrammer.template;
		new_statment = JavaGrammer.new_statment;
	}

	static Pattern p_class = Pattern.compile(class1);
	static Pattern p_class_name = Pattern.compile(class_name);
	static Pattern p_class_obj = Pattern.compile(class_name);
	static Pattern p_classobj = Pattern.compile(class_name);

	static Pattern p_extra = Pattern.compile(extra);
	static Pattern p_datatype = Pattern.compile(datatype);
	static Pattern p_is_fun = Pattern.compile(is_fun);
	static Pattern p_end_fun = Pattern.compile(end_fun);
	static Pattern p_fun_call = Pattern.compile(fun_call);

	static Pattern p_name = Pattern.compile(name);
	static Pattern p_extend = Pattern.compile(extend);
	static Pattern p_implement = Pattern.compile(implement);
	static Pattern p_any = Pattern.compile(any);
	static Pattern p_block_start = Pattern.compile(block_start);
	static Pattern p_block_end = Pattern.compile(block_end);
	static Pattern p_keyword = Pattern.compile(keyword);
	static Pattern p_mem_allocation = Pattern.compile(mem_allocation);
	static Pattern p_template = Pattern.compile(template);
	static Pattern p_new_statment = Pattern.compile(new_statment);

	static Matcher m_class;
	static Matcher m_class_name;
	static Matcher m_class_obj;
	static Matcher m_extra;

	static Matcher m_extra1;
	static Matcher m_datatype;
	static Matcher m_datatype1;
	static Matcher m_fun_call;

	static Matcher m_is_fun;
	static Matcher m_end_fun;
	static Matcher m_name;
	static Matcher m_any;

	static Matcher m_any1;
	static Matcher m_classobj;
	static Matcher m_block_start;
	static Matcher m_block_end;

	static Matcher m_search_next_class;
	static Matcher m_keyword;
	static Matcher m_mem_allocation;
	static Matcher m_template;
	static Matcher m_new_statment;

	static {

		try {

			BufferedReader br = null;

			try {
				String args = DemoJFileChooser.s;
				List<String> nextDir = new ArrayList<String>();
				nextDir.add(args);
				while (nextDir.size() > 0) {
					File pathName = new File(nextDir.get(0)); // gets the
																// element at
																// the index of
																// the List
					String[] fileNames = pathName.list(); // lists all files in
															// the directory
					for (int i1 = 0; i1 < fileNames.length; i1++) {
						File f = new File(pathName.getPath(), fileNames[i1]); // getPath
																				// //
																				// converts
																				// //
																				// abstract
																				// //
																				// path
																				// to
																				// path
																				// in
																				// String,
						// constructor creates new File object with fileName
						// name

						System.out.println("Extracting " + f.getName());

						if (f.isDirectory()) {
							nextDir.add(f.getPath());
						} else {
							if (f.getName().toLowerCase().endsWith(".java")) {
								br = new BufferedReader(new FileReader(f));// I
								String line = br.readLine();
								String data = "";
								while (line != null) {
									data = data + "\n" + line;
									line = br.readLine();

								}

								br.close();
								INPUT = data;
								m_class = p_class.matcher(INPUT);
								m_class_name = p_class_name.matcher(INPUT);
								m_class_obj = p_class_obj.matcher(INPUT);
								m_extra = p_extra.matcher(INPUT);
								m_extra1 = p_extra.matcher(INPUT);
								m_datatype = p_datatype.matcher(INPUT);
								m_datatype1 = p_datatype.matcher(INPUT);
								m_fun_call = p_fun_call.matcher(INPUT);
								m_is_fun = p_is_fun.matcher(INPUT);
								m_end_fun = p_end_fun.matcher(INPUT);
								m_name = p_name.matcher(INPUT);
								m_any = p_any.matcher(INPUT);
								m_block_start = p_block_start.matcher(INPUT);
								m_block_end = p_block_end.matcher(INPUT);
								m_search_next_class = p_class.matcher(INPUT);
								m_keyword = p_keyword.matcher(INPUT);
								m_mem_allocation = p_mem_allocation
										.matcher(INPUT);
								m_template = p_template.matcher(INPUT);
								m_new_statment = p_new_statment.matcher(INPUT);
								extract_details();

							}

						}
					}
					nextDir.remove(0);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	static {

	}

	// get a matcher object

	static int counter = 0;
	static int pointer = 0;

	private static boolean template_flag;

	public static void main(String[] args) {

		MetaClass.print_all_mapping();

	}

	private static void extract_details() {
		int class_start = 0;
		int k = -1;

		if (m_class.find()) {
			k++;

			output[k] = new MetaClass();

			// to find the name of the class,starts seraching with the next
			// index found by index of m1

			m_extra = processExtraClassParamter(m_class, m_extra, class_start,
					k);

			class_start = processClassNameAndExtend(p_name, p_extend,
					p_implement, m_class, m_class_name, m_any, class_start, k);

			findBlockBoundries(m_block_start, m_block_end);

			findNextClassIndex(m_search_next_class);

	
			do {
				Variable v = new Variable();

				d = m_datatype.find(pos);

				co = m_class_obj.find(pos);

				int g = pos, flag = 0;

				flag = findClassObjectDeclaration(g, flag);

				if (flag == 1)
					break;

				processDataType_ClassObject(v);
			

				if ((d || co) && var_start >= nxt_class && nxt_class != -1)
					break;

				bl_start = pos;

				if (var_start < pos)
					continue;

				if ((d | co) && var_start >= bl_st && var_start < bl_en) {
					pos = bl_en;
					if (m_block_start.find(pos)) {
						if (m_block_start.find(m_block_start.end())) {
							bl_st = m_block_start.start();
							if (m_block_end.find(bl_st))
								bl_en = m_block_end.start();
						}
						continue;
					}
					continue;
				}

				try {
					processVariableName(k, v);
				} catch (Exception e) {
				}

			} while (d | co);

			output[k].print_class_details();

		}
	}

	private static void processVariableName(int k, Variable v) {
		try {
			m_extra = m_extra.region(pos, var_start);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}

		while (m_extra.find()) {
			if (m_extra.group(0).matches("static"))
				v.static1 = true;
			else if (m_extra.group(0).matches("final"))
				v.final1 = true;
			else if (m_extra.group(0).matches("abstract"))
				v.abstract1 = true;
			else if (m_extra.group(0).matches("const"))
				v.const1 = true;
			else
				v.access = m_extra.group(0);

		}

		if (ch == 1)
			pos = m_datatype.end() + 1;
		else {
			pos = m_class_obj.end() + 1;
		}

		/* checking whether it is constructor */

		try {
			m_is_fun = m_is_fun.region(pos - 1, pos + 5);
		} catch (Exception e) {
		}

		if (m_is_fun.find()) {
			if (ch != 1 && output[k].classname.equals(m_class_obj.group(0))) {
				constructor_flag = true;
				processFunction(k, v);

			}

		}

		/*
		 * checking for function call
		 */
		if (!constructor_flag) {
			m_any = p_any.matcher(INPUT);

			if (m_any.find(pos)) {
				try {
					m_is_fun = m_is_fun.region(m_any.end(), m_any.end() + 5);
				} catch (Exception e) {
				}

				if (m_is_fun.find()) {
					processFunction(k, v);
				} else {

					processVariable(k, v);
				}

			}
		}
		constructor_flag = false;

	}

	private static void processVariable(int k, Variable v) {
		m_name = p_name.matcher(m_any.group(0));
		pos = m_any.end();

		try {
			while (m_name.find()) {

				if (m_name.group(0).equals(""))
					continue;

				Variable v1 = new Variable();
				v1.abstract1 = v.abstract1;
				v1.access = v.access;
				v1.const1 = v.const1;
				v1.final1 = v.final1;
				v1.static1 = v.static1;
				v1.type = v.type;

				v1.name = m_name.group(0);
				output[k].variable.add(v1);

				if (template_flag) {
					if (m_new_statment.find(pos)) {
						pos = m_new_statment.end();

					}

				}

			}
		} catch (IndexOutOfBoundsException i) {
			System.out.println(" " + i);
		}
	}

	private static void processFunction(int k, Variable v) {

		Function f = new Function();

		if (m_end_fun.find(m_is_fun.end())) {

			f.access = v.access;
			f.const1 = v.const1;
			f.final1 = v.final1;
			f.static1 = v.static1;

			if (constructor_flag) {
				f.name = output[k].classname;
				f.type = "-";
			} else {
				f.name = m_any.group(0);
				f.type = v.type;
			}

			m_fun_call = m_fun_call.region(m_any.start(), m_any.end());
			if (m_fun_call.find())
				return;


			m_keyword = m_keyword.region(m_any.start(), m_any.end() + 1);
			if (m_keyword.find() && !m_keyword.group(0).equals("")) {

				return;
			}

			try {
				m_name = p_name.matcher(INPUT);
				m_name = m_name.region(m_is_fun.end(), m_end_fun.start());

				int t = 0;
				Parameter1 p = new Parameter1();
				while (m_name.find()) {
					pos = m_name.end();
					if (m_name.group(0).equals(""))
						continue;
					if (t == 0) {
						p = new Parameter1();
						p.type = m_name.group(0);
						t++;
					} else if (t == 1) {
						t--;
						p.name = m_name.group(0);
						f.parameter.add(p);

					}

				}
				output[k].function.add(f);

				bl_start = m_end_fun.end();

				findBoundries(); // gives in bl_start and bl_end
				pos = bl_end;

				m_classobj = p_classobj.matcher(INPUT);
				m_any1 = p_any.matcher(INPUT);
				m_classobj = m_classobj.region(bl_start, bl_end);
				int t1 = bl_start;
				Vector<Parameter1> localVar = new Vector<Parameter1>();
				while (m_classobj.find(t1) && m_classobj.end() < bl_end) {
					m_fun_call = m_fun_call.region(m_classobj.end(),
							m_classobj.end() + 1);

					t1 = m_classobj.end();
					if (m_fun_call.find()) {
						Mapping m = new Mapping();
						m.s_class = output[k].classname;
						m.s_fun = f.name;

						m_keyword = m_keyword.region(m_classobj.start(),
								m_classobj.end() + 1);
						if (m_keyword.find() && !m_keyword.group(0).equals("")) {
							continue;
						}

						if (m_end_fun.find(m_fun_call.end())) {

							if (m_any1.find(m_fun_call.end())) {
								boolean local_flag = false;
								for (int i = 0; i < localVar.size(); i++) {
									Parameter1 pr1 = new Parameter1();
									pr1 = localVar.get(i);
									if (pr1.name.equals(m_classobj.group(0))) {
										m.d_class = pr1.type;
										m.d_fun = m_any1.group(0);
										MetaClass.mapping.add(m);
										Parameter1 p11 = new Parameter1();
										p11.type = pr1.type;
										p11.name = pr1.name;
										f.localVar.add(p11);
										local_flag = true;
										break;
									}
								}
								if (!local_flag) {
									for (int i = 0; i < output[k].variable
											.size(); i++) {
										Variable vr = new Variable();
										vr = output[k].variable.get(i);
										if (vr.name.equals(m_classobj.group(0))) {
											m.d_class = vr.type;
											m.d_fun = m_any1.group(0);
											MetaClass.mapping.add(m);
										}
									}
								}
							}

						}

					} else {
						m_any = p_any.matcher(INPUT);
						if (m_any.find(t1)) {

							// for identifying construdtor call
							m_is_fun = m_is_fun.region(m_any.end(),
									m_any.end() + 1);

							if (m_is_fun.find() && !m_any.group(0).equals("")) {

								Mapping m = new Mapping();
								m.s_class = output[k].classname;
								m.s_fun = f.name;
								String n = m_any.group(0);

								n = n.replaceAll(" ", "");

								m.d_class = n;
								m.d_fun = n;
								MetaClass.mapping.add(m);

							}
							t1 = m_any.end();
							try {
								m_keyword = m_keyword.region(
										m_classobj.start(), m_classobj.end());
							} catch (Exception e) {
							}

							while (m_keyword.find()) {

								if (!m_keyword.group(0).equals("")) {
									break;
								}

							}
							try {
								m_datatype1 = m_datatype1.region(
										m_classobj.start(), m_classobj.end());
							} catch (Exception e) {
							}

							if (m_datatype1.find()) {
								break;
							}

							m_name = p_name.matcher(m_any.group(0));
							pos = m_any.end();
							try {
								while (m_name.find()) {

									Parameter1 pr = new Parameter1();
									pr.type = m_classobj.group(0);
									pr.name = m_name.group(0);
									localVar.add(pr);

								}
							} catch (IndexOutOfBoundsException i) {
							}

						}

					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}

	private static void findBoundries() {

		
		if (m_block_start.find(bl_start)) {
			bl_start = m_block_start.end();
			counter++;
			pointer = bl_start;
		}

		if (bl_start > bl_end)
			bl_end = bl_start;

		if (m_block_end.find(pointer) && counter > 0) {
			counter--;
			bl_end = m_block_end.end();

		}

	
		do {

			m_block_start = m_block_start.region(pointer, bl_end);

			if (m_block_start.find()) {
				counter++;
				pointer = m_block_start.end();
			}

			if (counter == 0)
				break;

			if (m_block_end.find(bl_end) && counter > 0) {
				counter--;
				bl_end = m_block_end.end();
			}

		} while (true);
	
	}

	private static void processDataType_ClassObject(Variable v) {
		if (d && co) {
			if (m_datatype.start() <= m_class_obj.start())
				ch = 1;
			else
				ch = 2;
		} else if (d && !co) {
			ch = 1;

		} else
			ch = 2;

		int pos1 = 0;
		if (d && ch == 1) {
			var_start = m_datatype.start();
			v.type = m_datatype.group(0);
			pos1 = m_datatype.end() + 1;
		}

		if (co && ch == 2) {
			var_start = m_class_obj.start();
			v.type = m_class_obj.group(0);
			pos1 = m_class_obj.end() + 1;
		}

		/* checking whether it is constructor */

		try {
			m_template = m_template.region(pos1 - 1, pos1 + 5);
		} catch (Exception e) {
		}

		if (m_template.find()) {
			if (m_new_statment.find(m_template.start())) {
				template_flag = true;
			}
		}

	}

	private static int findClassObjectDeclaration(int g, int flag) {
		do {
			while (co && m_class_obj.group(0).equals("")) {
				try {
					co = m_class_obj.find(g++);
				} catch (Exception e) {
					flag = 1;
					break;
				}

			}

			if (flag == 1)
				break;

			try {
				m_extra1 = m_extra1.region(m_class_obj.start(),
						m_class_obj.end());
			} catch (Exception e) {
			}

			if (m_extra1.find()) {
				g = m_extra1.end();
				co = m_class_obj.find(g);
				if (co && m_class_obj.group(0).equals(""))
					continue;
			}

			try {
				m_mem_allocation = m_mem_allocation.region(m_class_obj.start(),
						m_class_obj.end());
			} catch (Exception e) {
				System.out.println(e);
			}

			if (m_mem_allocation.find()) {
				g = m_mem_allocation.end();
				co = m_class_obj.find(g);
				if (co && m_class_obj.group(0).equals(""))
					continue;
			}

			try {
				m_keyword = m_keyword.region(m_class_obj.start(),
						m_class_obj.end());
			} catch (Exception e) {
			}

			if (m_keyword.find()) {
				g = m_keyword.end();
				co = m_class_obj.find(g);
				if (co && m_class_obj.group(0).equals(""))
					continue;
			}

			try {
				m_datatype1 = m_datatype1.region(m_class_obj.start(),
						m_class_obj.end());
			} catch (Exception e) {
			}

			if (m_datatype1.find()) {
				g = m_datatype1.end();
				co = m_class_obj.find(g);

				if (co && m_class_obj.group(0).equals(""))
					continue;
				else
					break;
			}
			break;
		} while (1 < 2);

		return flag;
	}

	private static void findNextClassIndex(Matcher m_search_next_class) {
		if (m_search_next_class.find(pos))
			nxt_class = m_search_next_class.start();
		else
			nxt_class = -1;
	}

	private static void findBlockBoundries(Matcher m_block_start,
			Matcher m_block_end) {
		if (m_block_start.find(pos)) {
			if (m_block_start.find(m_block_start.end())) {
				bl_st = m_block_start.start();
				if (m_block_end.find(bl_st))
					bl_en = m_block_end.start();
			}
		}
	}

	private static int processClassNameAndExtend(Pattern p_name,
			Pattern p_extend, Pattern p_implement, Matcher m_class,
			Matcher m_class_name, Matcher m_any, int class_start, int k) {
		Matcher m_name;
		if (m_class_name.find(m_class.end() + 1)) {
			pos = m_class_name.end() + 1;

			while (m_class_name.group(0).equals("")) {
				if (m_class_name.find(pos))
					pos = m_class_name.end() + 1;
			}

			class_start = pos;
			output[k].classname = m_class_name.group(0);

			if (m_any.find(pos)) {
				pos = m_any.end();

				Matcher m_extend = p_extend.matcher(m_any.group(0));
				Matcher m_implement = p_implement.matcher(m_any.group(0));
				m_name = p_name.matcher(m_any.group(0));

				if (m_extend.find()) {
					if (m_name.find(m_extend.end() + 1)) {

						output[k].parent_class = m_name.group(0);
					}

				}

				if (m_implement.find()) {
					int t = m_implement.end() + 1;
					try {
						while (m_name.find(t)) {
							t = m_name.end() + 1;
							output[k].interfac.add(m_name.group(0));
						}
					} catch (IndexOutOfBoundsException i) {
					}
				}
			}
		}
		return class_start;
	}

	private static Matcher processExtraClassParamter(Matcher m_class,
			Matcher m_extra, int class_start, int k) {
		m_extra = m_extra.region(class_start, m_class.start());

		while (m_extra.find()) {
			if (m_extra.group(0).matches("static"))
				output[k].static_class = true;
			else if (m_extra.group(0).matches("final"))
				output[k].final_class = true;
			else if (m_extra.group(0).matches("abstract"))
				output[k].abstract_class = true;
			else
				output[k].access_class = m_extra.group(0);

		}
		return m_extra;
	}

}
