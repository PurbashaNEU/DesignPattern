package edu.neu.csye7374;

import java.text.DecimalFormat;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;





/**
 * class FinalComprehensive:
 * 
 * TOTAL POINTS: 100
 * 
 * Complete the implementation WITH A DETAILED DEVELOPMENT LOG (i.e. LOG[] Strings) showing
 * how YOUR coding progressed in a descriptive set of steps (e.g. "implemented BLAH", "fixed BLAH")
 * 
 * 20 POINT DEDUCTION IF SUBMITTED WITHOUT SUFFICIENT DETAILED Strings in LOG[]
 * 
 * REQUIREMENTS (NOTE: use supplied GIVEN code and data):
 * 
 * 10 POINTS 1. GIVEN API1 & API2, Implement a class Adapter:
 * complete the implementation of a class adapter (class AdapterClass) for API1 to use API2

 * 10 POINTS 2. GIVEN API1 & API2, Implement an object Adapter:
 * complete the implementation of an object adapter (class AdapterObject) for API2 to use an API1 object (class Operation)
 * 
 * 10 POINTS 3. Implement a Facade:
 * Complete the implementation of a Facade (class FacadePOS) to use the AdapterObject to implement FacadeAPI
 * 
 * 70 POINTS 4. Demonstrate use of Decorator design pattern to show a DETAILED bill for NEU students:
 *  (10 points) Sam, MSIS degree with courses CSYE6200, CSYE6202
 *  (10 points) Joe, MSIS degree with courses CSYE6200, CSYE6202, CSYE6205
 *  (10 points) Dan, MSSE degree with courses CSYE6205, CSYE7374
 *  (10 points) Jim, MSSE degree with courses CSYE6200, CSYE6202, CSYE6205, CSYE7374
 *  e.g. Billing for Sam's degree: $ total_dollars MSIS BILL (msis_base_expense) CSYE6200 BILL (csye6200_expense) CSYE6200 BILL (csye6202_expense)
 *  
 *    GIVEN BillAPI, derive (WITH REQUIRED Singleton Factories):  
 *    		(5 points) class NEUBillForIMSISDegree is the total billed expense for an NEU MSIS degree 
 *    		(5 points) class NEUBillForIMSSEDegree is the total billed expense for an NEU MSSE degree
 *     
 *    		(5 points) class CSYE6200 is the billed expense for the CSYE6200 course
 *    		(5 points) class CSYE6202 is the billed expense for the CSYE6202 course
 *    		(5 points) class CSYE6205 is the billed expense for the CSYE6205 course
 *    		(5 points) class CSYE7374 is the billed expense for the CSYE7374 course
 *    
 *    REQUIRED FOR EACH NEU STUDENT:
 *    1. Use COMMAND PATTERN to DECORATE a bill for degree class with the SPECIFIED INDIVIDUAL course expenses;
 *    2. use Eager Singleton Factories to create COMMAND pattern objects 
 *    2. use Lazy Singleton Factories to create billed degree expense and course billed expense objects 
 *    
 *  Command Pattern
 */
public class FinalComprehensive {	
	private static final int MAJOR_REVISION = 3;
	/**
	 * add literal Strings to LOG[] for a detailed development log
	 */
	private final static String LOG[] = {
			"initial revision",
			"1. Implement Class Adapter (AdapterClass) for API1 to use API2",
			"1.a Create a new Java class named AdapterClass.",
			"1.b Implement the API1 interface in the AdapterClass class",
			"1.c Define private fields to store an instance of API2",
			"1.d Implement the operation method using methods from the API2 interface",
			"1.e Test the AdapterClass by creating an instance, calling the operation method, and verifying the results.",
			
			"2.Implement AdapterObject for API2 to use API1 Object ",
			"2.a Implement the API2 interface in the AdapterObject class",
			"2.b Implement the API2 interface in the AdapterObject class",
			"2.c Define private fields to store an instance of API1",
			"2.d Implement the add, sub, mult, and div methods using the operation method of the API1 object",
			"2.f Override the toString method to display the operation and result",
			
			"3. Implement Facade (FacadePOS) Using AdapterObject to Implement FacadeAPI",
			"3.a Define private fields to store instances of AdapterObject, course expense classes, and degree expense classes",
			"3.b Implement methods in the FacadePOS class that provide simplified interfaces for performing operations",
			"3.c Internally used the AdapterObject to perform operations and return results",
			"3.d Test the FacadePOS by creating an instance, calling its methods, and verifying the results",
			
			"4. Demonstrate Use of Decorator Design Pattern for Detailed Billing",
			"4.a Create classes for each individual course expense (e.g., CSYE6200, CSYE6202, etc.).",
			"4.b Create classes for each degree's billed expense (e.g., NEUBillForIMSISDegree, NEUBillForIMSSEDegree).",
			"4.c Implement the Command Pattern by creating command classes for each course expense using the Decorator pattern",
			"4.d For each command class, implement methods that add the specific course expense to the bill.",
			"4.e Implement the billed expense classes by extending the command classes and implementing methods to add degree expenses.",
			"4.f Implement Singleton Factories for both Eager and Lazy initialization to create instances of command and billed expense objects",
			"4.g Display the detailed bill by invoking the toString method on the decorated bill object", 
			"LEAVE THIS AS END OF DEVELOPMENT LOG STRINGS"
			
	};
	public static final int MINOR_REVISION = LOG.length;
	public static final String REVISION = Integer.valueOf(MAJOR_REVISION) + "." + Integer.valueOf(MINOR_REVISION); 
	/**
	 * GIVEN:
	 * supplied data values
	 */
	private static final int ADAPTER_GIVEN_DATA_VALUE_A = 6;
	private static final int ADAPTER_GIVEN_DATA_VALUE_B = 3;
	private static final int ADAPTER_GIVEN_DATA_VALUE_C = 0;
	private static final int FACADE_GIVEN_DATA_VALUE_DOLLARS = 20;
	private static final int[] FACADE_GIVEN_DATA_VALUE_PRICES = {1,2,3,4,5};
	private static final double NEU_MSIS_DEGREE_BASE_BILLED_EXPENSE = 24000;
	private static final double NEU_MSSE_DEGREE_BASE_BILLED_EXPENSE = 40000;
	private static final double NEU_CSYE6200_COURSE_BILLED_EXPENSE = 1000;
	private static final double NEU_CSYE6202_COURSE_BILLED_EXPENSE = 1200;
	private static final double NEU_CSYE6205_COURSE_BILLED_EXPENSE = 1500;
	private static final double NEU_CSYE7374_COURSE_BILLED_EXPENSE = 2000;


	/**
	 * STUDENT TODO:
	 * Initialize all Singleton Factories
	 */
	
	/**
	 * GIVEN:
	 * class E for all adapter and facade formatted output
	 */
	private static class E {
		private final int a;
		private final int b;
		private final int c;
		private final String s;
		
		public E(int a, String s, int b, int c) {
			super();
			this.a = a;
			this.s = s;
			this.b = b;
			this.c = c;
		}

		public int getA() { return a; }
		public int getB() { return b; }
		public int getC() { return c; }
		public String getS() { return s; }
		
		public String drawN(int n, String s) {
		    StringBuilder sb = new StringBuilder();
		    sb.append("[").append(n).append("] ");
		    return sb.toString();
		}
		public String drawN(int n) {
			 StringBuilder sb = new StringBuilder();
		     sb.append("[");
		     for (int i = 0; i < n; i++) {
		         sb.append(s);
		     }
		     sb.append("]");
		     return sb.toString();}
		@Override

		public String toString() {
			StringBuilder sb = new StringBuilder();
		    sb.append(drawN(a, "[" + a + "]")).append(" ");
		    sb.append(drawN(b, "[" + b + "]")).append(" ");
		    sb.append(drawN(c, "[" + c + "]"));
		    return sb.toString();
		}
		
		public static void demoE() {
			System.out.println("\n\t" + FinalComprehensive.class.getName() + ".demoEngine() revision ["+ REVISION +"] ...");
			int a = 9;
			int b = 3;
			int c = 0;
			System.err.println(new E(a, "+", b, a+b));
			System.err.println(new E(a, "-", b, a-b));
			System.err.println(new E(a, "*", b, a*b));
			System.err.println(new E(a, "/", b, a/b));
			System.out.println("\n\t" + FinalComprehensive.class.getName() + ".demoEngine()... done!");
		}
	}
	
	/**
	 * GIVEN:
	 * API1
	 */
	private interface API1 {
		public enum OPERATION_ENUM {
			ADD("+"), SUB("-"), MULT("*"), DIV("/");
			private String op = "+";
			private OPERATION_ENUM(String op) { this.op = op; }
			public String getOp() { return op; }
		}
		int operation(int a, int b, OPERATION_ENUM op);
	}
	/**
	 * GIVEN:
	 * API2
	 */
	private interface API2 {
		int add(int a, int b);
		int sub(int a, int b);
		int mult(int a, int b);
		int div(int a, int b);
	}

	/**
	 * STUDENT TODO:
	 * complete the implementation of API1 (class Operation)
	 * 
	 */
	private static class Operation implements API1{

		/**
		 * GIVEN
		 * toString()
		 */
		private int a;
	    private int b;
	    private OPERATION_ENUM op;
	    private int result;

		    public Operation(int a, int b, API1.OPERATION_ENUM op, int result) {
		        this.a = a;
		        this.b = b;
		        this.op = op;
		        this.result = result;
		    }
		    

		    @Override
		    public int operation(int a, int b, OPERATION_ENUM op) {
		        switch (op) {
		            case ADD:
		                this.a = a;
		                this.b = b;
		                this.op = op;
		                this.result = a + b;
		                break;
		            case SUB:
		                this.a = a;
		                this.b = b;
		                this.op = op;
		                this.result = a - b;
		                break;
		            case MULT:
		                this.a = a;
		                this.b = b;
		                this.op = op;
		                this.result = a * b;
		                break;
		            case DIV:
		                this.a = a;
		                this.b = b;
		                this.op = op;
		                this.result = a / b;
		                break;
		            default:
		                throw new IllegalArgumentException("Unsupported operation");
		        }
		        return result;
		    }
		    @Override
	        public String toString() {
		    	return "[" + a + "] " + op.getOp() + " [" + b + "] = [" + result + "]";
	           
		    	//return new E(a, op.getOp(), b, result).toString();
	        }
		
	}
	
	/**
	 * STUDENT TODO:
	 * complete the implementation of an object adapter AdapterObject for API2 to use an API1 object
	 * 
	 */
	private static class AdapterObject implements API2{

		/**
		 * STUDENT TODO
		 * implement all setter and getter methods
		 */

		/**
		 * GIVEN
		 * toString()
		 */
		private API1 operation;
	    private int a;
	    private int b;
	    private API1.OPERATION_ENUM op;
	    private int result;

	    public AdapterObject(API1 operation) {
	        this.operation = operation;
	    }

	    @Override
	    public int add(int a, int b) {
	        this.a = a;
	        this.b = b;
	        this.op = API1.OPERATION_ENUM.ADD;
	        this.result = operation.operation(a, b, op);
	        return result;
	    }

	    @Override
	    public int sub(int a, int b) {
	        this.a = a;
	        this.b = b;
	        this.op = API1.OPERATION_ENUM.SUB;
	        this.result = operation.operation(a, b, op);
	        return result;
	    }

	    @Override
	    public int mult(int a, int b) {
	        this.a = a;
	        this.b = b;
	        this.op = API1.OPERATION_ENUM.MULT;
	        this.result = operation.operation(a, b, op);
	        return result;
	    }

	    @Override
	    public int div(int a, int b) {
	        this.a = a;
	        this.b = b;
	        this.op = API1.OPERATION_ENUM.DIV;
	        this.result = operation.operation(a, b, op);
	        return result;
	    }
	    
	    @Override
	    public String toString() {
	        if (op != null) {
	            return "[" + a + "] " + op.getOp() + " [" + b + "] = [" + result + "]";
	        }
	        return "";
	    }
		/**
		 * STUDENT TODO:
		 * complete demoAdapterObject() implementation
		 */
		public static void demoAdapterObject() {
			System.out.println("\n\t" + AdapterObject.class.getName() + ".demoAdapterObject()...");

			/**
			 * STUDENT TODO:
			 * create operation (from class Operation)
			 * create adapter (from class AdapterObject)
			 */

			
			/**
			 * GIVEN
			 * validation code
			 */
			int a = ADAPTER_GIVEN_DATA_VALUE_A;
			int b = ADAPTER_GIVEN_DATA_VALUE_B;
			int c = ADAPTER_GIVEN_DATA_VALUE_C;
			API1 operation = new Operation(a, b, API1.OPERATION_ENUM.ADD, a + b);
			AdapterObject adapter = new AdapterObject(operation);
			
			operation.operation(a, b, API1.OPERATION_ENUM.ADD);
			System.out.println(operation);
			adapter.add(a, b);			
			System.out.println(adapter);
			
			operation.operation(a, b, API1.OPERATION_ENUM.SUB);
			System.out.println(operation);
			adapter.sub(a, b);			
			System.out.println(adapter);
			
			operation.operation(a, b, API1.OPERATION_ENUM.MULT);
			System.out.println(operation);
			adapter.mult(a, b);			
			System.out.println(adapter);
			
			operation.operation(a, b, API1.OPERATION_ENUM.DIV);
			System.out.println(operation);			
			adapter.div(a, b);			
			System.out.println(adapter);
			
			
			System.out.println("\n\t" + AdapterObject.class.getName() + ".demoAdapterObject()... done!");
		}
	}
	
	/**
	 * STUDENT TODO:
	 * complete the implementation of a class adapter AdapterClass for API1 to use API2
	 * 
	 */
	
	private static class AdapterClass implements API1 {
		
		/**
		 * STUDENT TODO
		 * implement all setter and getter methods
		 */

		/**
		 * GIVEN
		 * toString()
		 */
		private API2 api2;

	    public AdapterClass(API2 api2) {
	        this.api2 = api2;
	    }

	    @Override
	    public int operation(int a, int b, OPERATION_ENUM op) {
	        switch (op) {
	            case ADD:
	                return api2.add(a, b);
	            case SUB:
	                return api2.sub(a, b);
	            case MULT:
	                return api2.mult(a, b);
	            case DIV:
	                return api2.div(a, b);
	            default:
	                return 0;
	        }
	    }
	    public int add(int a, int b) {
	        return api2.add(a, b);
	    }

	    public int sub(int a, int b) {
	        return api2.sub(a, b);
	    }

	    public int mult(int a, int b) {
	        return api2.mult(a, b);
	    }

	    public int div(int a, int b) {
	        return api2.div(a, b);
	    }
	 
	@Override
	public String toString() {

		 return api2.toString();
		 
	}
		
		/**
		 * STUDENT TODO:
		 * complete demoAdapterClass() implementation
		 */
		public static void demoAdapterClass() {
			System.out.println("\n\t" + AdapterClass.class.getName() + ".demoAdapterClass()...");
			
			/**
			 * STUDENT TODO:
			 * create adapter (from class AdapterClass)
			 */

			
			/**
			 * GIVEN
			 * validation code
			 */
			int a = ADAPTER_GIVEN_DATA_VALUE_A;
			int b = ADAPTER_GIVEN_DATA_VALUE_B;
			int c = ADAPTER_GIVEN_DATA_VALUE_C;
			
			API2Impl api2Impl = new API2Impl();
			AdapterClass adapter = new AdapterClass(api2Impl);

		
			adapter.operation(a, b, OPERATION_ENUM.ADD);
			System.out.println(adapter);
			adapter.add(a, b);
			System.out.println(adapter);
			adapter.operation(a, b, OPERATION_ENUM.SUB);
			System.out.println(adapter);
			adapter.sub(a, b);
			System.out.println(adapter);
			adapter.operation(a, b, OPERATION_ENUM.MULT);
			System.out.println(adapter);
			adapter.mult(a, b);
			System.out.println(adapter);
			adapter.operation(a, b, OPERATION_ENUM.DIV);
			System.out.println(adapter);
			adapter.div(a, b);
			System.out.println(adapter);
			
			
			System.out.println("\n\t" + AdapterClass.class.getName() + ".demoAdapterClass()... done!");
		}
	}
	private static class API2Impl implements API2 {
		   
		 private int a;
		    private int b;
		    private int result;
		    private API1.OPERATION_ENUM op;

		    @Override
		    public int add(int a, int b) {
		        this.a = a;
		        this.b = b;
		        this.result = a + b;
		        this.op = API1.OPERATION_ENUM.ADD;
		        return this.result;
		    }

		    @Override
		    public int sub(int a, int b) {
		        this.a = a;
		        this.b = b;
		        this.result = a - b;
		        this.op = API1.OPERATION_ENUM.SUB;
		        return this.result;
		    }

		    @Override
		    public int mult(int a, int b) {
		        this.a = a;
		        this.b = b;
		        this.result = a * b;
		        this.op = API1.OPERATION_ENUM.MULT;
		        return this.result;
		    }

		    @Override
		    public int div(int a, int b) {
		        this.a = a;
		        this.b = b;
		        this.result = a / b;
		        this.op = API1.OPERATION_ENUM.DIV;
		        return this.result;
		    }

		    @Override
		    public String toString() {
		        return "[" + a + "] " + op.getOp() + " [" + b + "] = [" + result + "]";
		    }
	}

	/**
	 * GIVEN 
	 * FacadeAPI
	 */
	private interface FacadeAPI {
		int sum(List<Integer> prices);
		int change(int dollars); 
	}
	
	/**
	 * STUDENT TODO:
	 * Complete the implementation of a Facade FacadePOS to use the AdapterObject to implement FacadeAPI
	 */
	private static class FacadePOS implements FacadeAPI{
		
		/**
		 * GIVEN
		 * toString()
		 */
		private AdapterObject adapterObject;
	    private int total;
	    private int dollars;
	    private int change;

		

	    public FacadePOS(AdapterObject adapterObject) {
	        this.adapterObject = adapterObject;
	    }
	    @Override
	    public int sum(List<Integer> prices) {
	    	total = prices.stream().mapToInt(Integer::intValue).sum();
	        return total;
	    }

	    
	    @Override
	    public int change(int dollars) {
	        this.dollars = dollars;
	        this.change = dollars - total;
	        return this.change >= 0 ? this.change : 0;
	    }
	        
	      
	    private String drawE(int value, String s) {
	    	   StringBuilder sb = new StringBuilder();
	    	    sb.append("[").append(value).append("]");
	    	    for (int i = 0; i < value; i++) {
	    	        sb.append(s);
	    	    }
	    	    return sb.toString();
	    }
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("TOTAL: [").append(total).append("]\n");
	    sb.append("DOLLARS: [$").append(dollars).append("]\n");
	    sb.append("CHANGE: [$").append(change).append("] ");
	    return sb.toString();
		
	}
		/**
		 * STUDENT TODO:
		 * complete demoFacadePOS() implementation
		 */
		public static void demoFacadePOS() {
			System.out.println("\n\t" + FacadePOS.class.getName() +
					".demoPOSFacade()...");

					int dollars = FACADE_GIVEN_DATA_VALUE_DOLLARS;

					int a = ADAPTER_GIVEN_DATA_VALUE_A; 
					int b = ADAPTER_GIVEN_DATA_VALUE_B;

					API1 operation = new API1() {
					    @Override
					    public int operation(int a, int b, API1.OPERATION_ENUM op) {
					        switch (op) {
					            case ADD:
					                return a + b;
					            case SUB:
					                return a - b;
					            case MULT:
					                return a * b;
					            case DIV:
					                return a / b;
					            default:
					                throw new IllegalArgumentException("Unsupported operation");
					        }
					    }
					};

					AdapterObject adapterObject = new AdapterObject(operation);

					FacadePOS facade = new FacadePOS(adapterObject);

					List<Integer> prices = new ArrayList<>();
					for (int price : FACADE_GIVEN_DATA_VALUE_PRICES) {
					    prices.add(price);
					}

					/**
					* STUDENT TODO:
					* create facade (from class FacadePOS)
					*/
					/**
					* GIVEN
					* validation code
					*/
					facade.sum(prices);
					facade.change(dollars);
					System.out.println(facade);
					System.out.println("\n\t" + FacadePOS.class.getName() +
					".demoPOSFacade()... done!");
					}
	}

	/**
	 * STUDENT TODO:
	 * demonstrate use of the Decorator pattern as controlled by the Command pattern
	 */
	public static class DemoDecoratorPattern {
		/**
		 * GIVEN:
		 * BillAPI which all Bill subclasses implement
		 * 
		 * @author dpeters
		 *
		 */
		private static abstract class BillAPI {
			/**
			 * use to provide a format for price output to stdout limiting digits and
			 * inserting commas as specified in the supplied format String
			 */
			private final static DecimalFormat priceFormat = new DecimalFormat("##,###.##");
			/**
			 * get a String description of the Bill
			 * 
			 * @return String description of the billed expense
			 */
			public abstract String getDesc();

			/**
			 * get the amount of the Bill
			 * 
			 * @return amount of billed expense
			 */
			public abstract double getPrice();
			@Override
			public String toString() {
				return "$ " + priceFormat.format(this.getPrice()) + " " + this.getDesc();
			}
		}

		/**
		 * STUDENT TODO:
		 * Command Pattern
		 */
		public static class NEUBillForIMSISDegree extends BillAPI {
		    private double baseExpense = NEU_MSIS_DEGREE_BASE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "MSIS Degree";
		    }

		    @Override
		    public double getPrice() {
		        return baseExpense;
		    }
		}

		public static class NEUBillForIMSSEDegree extends BillAPI {
		    private double baseExpense = NEU_MSSE_DEGREE_BASE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "MSSE Degree";
		    }

		    @Override
		    public double getPrice() {
		        return baseExpense;
		    }
		}

		public static class CSYE6200 extends BillAPI {
		    private double expense = NEU_CSYE6200_COURSE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "CSYE6200 Course";
		    }

		    @Override
		    public double getPrice() {
		        return expense;
		    }
		}
		public static class CSYE6202 extends BillAPI {
		    private double expense = NEU_CSYE6202_COURSE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "CSYE6202 Course";
		    }

		    @Override
		    public double getPrice() {
		        return expense;
		    }
		}
		public static class CSYE6205 extends BillAPI {
		    private double expense = NEU_CSYE6205_COURSE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "CSYE6205 Course";
		    }

		    @Override
		    public double getPrice() {
		        return expense;
		    }
		}
		public static class CSYE7374 extends BillAPI {
		    private double expense = NEU_CSYE7374_COURSE_BILLED_EXPENSE;

		    @Override
		    public String getDesc() {
		        return "CSYE7374 Course";
		    }

		    @Override
		    public double getPrice() {
		        return expense;
		    }
		}
		//BillDecorator abstract class
		public abstract class BillDecorator extends BillAPI {
			 protected BillAPI decoratedBill;

			    public BillDecorator(BillAPI decoratedBill) {
			        this.decoratedBill = decoratedBill;
			    }

			    @Override
			    public abstract double getPrice();

			    @Override
			    public abstract String getDesc();
		}

		public class CourseDecorator extends BillDecorator {
		    private BillAPI courseBill;

		    public CourseDecorator(BillAPI decoratedBill, BillAPI courseBill) {
		        super(decoratedBill);
		        this.courseBill = courseBill;
		    }

		    @Override
		    public double getPrice() {
		        return decoratedBill.getPrice() + courseBill.getPrice();
		    }

		    @Override
		    public String getDesc() {
		        return decoratedBill.getDesc() + ", " + courseBill.getDesc();
		    }
		}




		

		//Command interface
		public interface Command {
		 void execute();
		 double getTotalBill();
		}

		//StudentCommand class implementing the Command interface
		public static class StudentCommand implements Command {
			private BillAPI degreeBill;
		    private List<BillAPI> courseBills;

		    public StudentCommand(BillAPI degreeBill, List<BillAPI> courseBills) {
		        this.degreeBill = degreeBill;
		        this.courseBills = courseBills;
		    }

		    @Override
		    public void execute() {
		      
		   	 double totalCost = degreeBill.getPrice();
		        System.out.println("Degree Base Price: " + degreeBill.getPrice());

		        for (BillAPI courseBill : courseBills) {
		            totalCost += courseBill.getPrice();
		            System.out.println(courseBill.getClass().getSimpleName() + " Bill Price: " + courseBill.getPrice());
		        }

		        System.out.println("Total Calculated Bill: " + totalCost);
		        
		      
		    }

		    @Override
		    public double getTotalBill() {
		   	 double totalCost = degreeBill.getPrice();

		        for (BillAPI courseBill : courseBills) {
		            totalCost += courseBill.getPrice();
		        }

		        return totalCost;
		    }
		   }






		private static class BilledExpenseFactory {
		    private static NEUBillForIMSISDegree neubillForIMSISDegree = null;
		    private static NEUBillForIMSSEDegree neubillForIMSSEDegree = null;
		    private static CSYE6200 csye6200 = null;
		    private static CSYE6202 csye6202 = null;
		    private static CSYE6205 csye6205 = null;
		    private static CSYE7374 csye7374 = null;

		    public static NEUBillForIMSISDegree getNEUBillForIMSISDegree() {
		        if (neubillForIMSISDegree == null) {
		            neubillForIMSISDegree = new NEUBillForIMSISDegree();
		        }
		        return neubillForIMSISDegree;
		    }

		    public static NEUBillForIMSSEDegree getNEUBillForIMSSEDegree() {
		        if (neubillForIMSSEDegree == null) {
		            neubillForIMSSEDegree = new NEUBillForIMSSEDegree();
		        }
		        return neubillForIMSSEDegree;
		    }

		    public static CSYE6200 getCSYE6200() {
		        if (csye6200 == null) {
		            csye6200 = new CSYE6200();
		        }
		        return csye6200;
		    }

		    public static CSYE6202 getCSYE6202() {
		        if (csye6202 == null) {
		            csye6202 = new CSYE6202();
		        }
		        return csye6202;
		    }

		    public static CSYE6205 getCSYE6205() {
		        if (csye6205 == null) {
		            csye6205 = new CSYE6205();
		        }
		        return csye6205;
		    }

		    public static CSYE7374 getCSYE7374() {
		        if (csye7374 == null) {
		            csye7374 = new CSYE7374();
		        }
		        return csye7374;
		    }
		}

		private static class CommandFactory {
		    private static Command SAM_COMMAND = null;
		    private static Command JOE_COMMAND = null;
		    private static Command DAN_COMMAND = null;
		    private static Command JIM_COMMAND = null;

		    public static Command getSamCommand() {
		        if (SAM_COMMAND == null) {
		            List<BillAPI> courseBills = new ArrayList<>();
		            courseBills.add(BilledExpenseFactory.getCSYE6200());
		            courseBills.add(BilledExpenseFactory.getCSYE6202());

		            SAM_COMMAND = new StudentCommand(
		                BilledExpenseFactory.getNEUBillForIMSISDegree(),
		                courseBills
		            );
		        }
		        return SAM_COMMAND;
		    }

		    public static Command getJoeCommand() {
		        if (JOE_COMMAND == null) {
		            List<BillAPI> courseBills = new ArrayList<>();
		            courseBills.add(BilledExpenseFactory.getCSYE6200());
		            courseBills.add(BilledExpenseFactory.getCSYE6202());
		            courseBills.add(BilledExpenseFactory.getCSYE6205());

		            JOE_COMMAND = new StudentCommand(
		                BilledExpenseFactory.getNEUBillForIMSISDegree(),
		                courseBills
		            );
		        }
		        return JOE_COMMAND;
		    }

		    public static Command getDanCommand() {
		        if (DAN_COMMAND == null) {
		            List<BillAPI> courseBills = new ArrayList<>();
		            courseBills.add(BilledExpenseFactory.getCSYE6205());
		            courseBills.add(BilledExpenseFactory.getCSYE7374());

		            DAN_COMMAND = new StudentCommand(
		                BilledExpenseFactory.getNEUBillForIMSSEDegree(),
		                courseBills
		            );
		        }
		        return DAN_COMMAND;
		    }

		    public static Command getJimCommand() {
		        if (JIM_COMMAND == null) {
		            List<BillAPI> courseBills = new ArrayList<>();
		            courseBills.add(BilledExpenseFactory.getCSYE6200());
		            courseBills.add(BilledExpenseFactory.getCSYE6202());
		            courseBills.add(BilledExpenseFactory.getCSYE6205());
		            courseBills.add(BilledExpenseFactory.getCSYE7374());

		            JIM_COMMAND = new StudentCommand(
		                BilledExpenseFactory.getNEUBillForIMSSEDegree(),
		                courseBills
		            );
		        }
		        return JIM_COMMAND;
		    }
		}


		/**
		 * STUDENT TODO:
		 * complete decoratorDemo() implementation
		 */
		public static void decoratorDemo() {
			System.out.println("\n\t" + DemoDecoratorPattern.class.getName() + ".demo()...");
			Command samCommand = CommandFactory.getSamCommand();
		    Command joeCommand = CommandFactory.getJoeCommand();
		    Command danCommand = CommandFactory.getDanCommand();
		    Command jimCommand = CommandFactory.getJimCommand();

		    // Calculate and print decorated bills
		    System.out.println("Decorated Bill for Sam's MSIS degree:\n");
		    samCommand.execute();
		    System.out.println("Total Bill: $" + samCommand.getTotalBill());
		    System.out.println("******************" );
		    
		    System.out.println("Decorated Bill for Joe's MSIS degree:\n");
		    joeCommand.execute();
		    System.out.println("Total Bill: $" + joeCommand.getTotalBill());
		    System.out.println("******************" );
		    
		    System.out.println("Decorated Bill for Dan's MSSE degree:\n");
		    danCommand.execute();
		    System.out.println("Total Bill: $" + danCommand.getTotalBill());
		    System.out.println("******************" );
		    
		    System.out.println("Decorated Bill for Jim's MSSE degree:\n");
		    jimCommand.execute();
		    System.out.println("Total Bill: $" + jimCommand.getTotalBill());

			System.out.println("\n\t" + DemoDecoratorPattern.class.getName() + ".demo()... done!");
		}

	}

	/**
	 * GIVEN:
	 * demonstrate completed implementation solution of this class
	 */
	public static void demo() {
		System.out.println("\n\t" + FinalComprehensive.class.getName() + ".demo() revision [" + REVISION + "] ...");
		
		for (String s : LOG) { System.out.println(s); };
		
		AdapterObject.demoAdapterObject();
		AdapterClass.demoAdapterClass();
		FacadePOS.demoFacadePOS();
		DemoDecoratorPattern.decoratorDemo();
		
		System.out.println("\n\t" + FinalComprehensive.class.getName() + ".demo() revision [" + REVISION + "] ... done!");
	}
}
