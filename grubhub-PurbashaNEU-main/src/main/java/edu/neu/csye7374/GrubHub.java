package edu.neu.csye7374;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import edu.neu.csye7374.GrubHub.IndividualOrder.IndividualOrderBuilder;



/**
 * GrubHub model:
 * 
 * 100 TOTAL POINTS
 *  
 * USE AND COMPLETE CODING THIS SINGLE (partially coded) CLASS (add inner classes)
 * to Model Grubhub service demonstrating the correct use of all following design patterns:
 * 
 * Adapter, Builder, Bridge, Composite, Decorator, Singleton, Factory Method, Strategy
 * 
 * Demonstrate Point of Sale (POS) by displaying (on console stdout) 
 * ALL orders, totaled with all discounts as follows:
 * 	
 * 	Show ALL Orders NormalDiscount (0% decrease applied to each item price and Total), 
 * 	Show ALL Orders	MemberDiscount (10% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SpecialDiscount (20% decrease applied to each item price and Total), 
 * 	Show ALL Orders	SuperBowlDiscount (20% increase applied to each item price and Total), 
 * 
 * 
 * 20 POINTS
 * 1. Create following food items using the following design patterns: 
 *    Builder, 
 *    Decorator,
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 * 
 * $ 0.99 French Fries
 * $ 1.29 Medium Drink
 * $ 3.49 Hamburger
 * $ 1.49 Hot Dog
 * $ 3.79 Cheeseburger
 * $ 4.49 Buffalo Wings
 * $ 2.49 Salad
 * $ 5.49 Icecream ($1 OPTIONS: cherry, fudge, chocolatechips, oreo, kitkat, sprinkles)
 * 
 * 
 * 30 POINTS
 * 2. Create the following customer orders using the following design patterns: 
 *    Builder, 
 *    Singleton Factory (Eager, Lazy and Enum implementations)
 *    AND with the following attributes:
 *    
 * 	Dan's Customer Grubhub Order ID #1 Hamburger, Medium Drink
 * 	Pam's Customer Grubhub Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink)
 * 	Jim's Customer Grubhub Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink)
 * 	Jen's Customer Grubhub Order ID #4 Cheeseburger, French Fries
 * 	Len's Customer Grubhub Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad)
 * 	Sam's Customer Grubhub Order ID #6 IcecreamCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Icecream)
 * 
 * 
 * 40 POINTS
 * 3. Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices): 
 * 	NormalDiscount (0% decrease), 
 * 	MemberDiscount (10% decrease), 
 * 	SpecialDiscount (20% decrease), 
 * 	SuperBowlDiscount (20% increase)
 * 
 * MUST DEVELOPE APIs (PosAPI and CalculatorAPI) IN TWO PHASES (NOTE: all names with 1 & 2) 
 * using Bridge design pattern:
 * 
 * PosAPI Point of Sale API (PosAPI1 & PosAPI2)
 * 
 * 	Phase I 	class Pos1 and interface PosAPI1 with methods:
 * 		double sumTotal(List<Double> itemList); // add customer total
 * 		void setStrategy(PriceStrategyAPI s);	// set strategy for price adjustments
 *		double getSum();	// return sum total
 *		String toStringSumTotal();	// return String representation of sum total
 *
 * 	Phase II 	class Pos2 and interface PosAPI2 with methods:
 * 		double getChange(double cash);		// accept cash, return change
 *		String toStringCash();		// return String representation of customer cash submitted
 *		String toStringChange();	// return String representation of customer change received
 *
 * Calculator API (CalculatorAPI1 & CalculatorAPI2)
 * 
 *  PHASE I		class Calculator1 and interface CalculatorAPI1 with method:
 *      double add(double a, double b);
 *  
 *  PHASE II	class Calculator2 and interface CalculatorAPI2 with methods:
 *  	double sub(double a, double b);
 *  	double mult(double a, double b);
 *  	double div(double a, double b);
 *  
 *  
 * 10 POINTS
 *  4. Develop class OrderAdapter using Adapter design pattern, 
 *  to adapt Order to use an ItemAPI object
 *   
 * @author dpeters
 *
 */
public class GrubHub {
	/**
	 * static initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed only once
	 */
	static {
		/**
		 * Set outer class (replace Driver)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(GrubHub.class);
	}
	/**
	 * object initialization block REQUIRED FOR DevelopmentLogEnum
	 * executed with each constructor
	 */
	{
		/**
		 * Set outer class (use DevelopmentLogEnum defined below)
		 */
		DevelopmentLogEnum.LOG.setOuterClass(this.getClass());
	}

	/**
	 * DevelopmentLogEnum manages development log entries for this class
	 *
	 * @author dgpeters
	 *
	 */
	public static enum DevelopmentLogEnum {
		LOG;

		private static final int MAJOR_REVISION;
		private static final int MINOR_REVISION;
		private static final String REVISION;
		private final static List<String> DEVELOPMENT_LOG_ENTRY_LIST;
		private Class outerClass = null;

		/**
		 * static initialization block
		 * executed once for this class
		 */
		static {
			MAJOR_REVISION = 1;
			MINOR_REVISION = 0;
			REVISION = Integer.valueOf(MAJOR_REVISION) + "." + Integer.valueOf(MINOR_REVISION);
			/**
			 * Detailed development log for this class
			 *
			 * NOTE:	Everything here is contained in the specification of this enum
			 * 				DevelopmentLogEnum
			 * 			and is compiled to be initialized BEFORE any code execution
			 * 			EVERYTHING IN THIS LOG IS CODE TO BE COMPILED AND NEVER EXECUTES
			 * 			EXCEPT TO DISPLAY
			 * 				DEVELOPMENT_LOG_ENTRY_LIST
			 * 			Strings AND
			 * 				REVISION
			 * 	 		ON THE CONSOLE (STDOUT) OUTPUT.
			 *
			 *
			 * FOR EACH CHANGE to this class during development
			 * (e.g., bug fixes or new features, inner classes or inner interfaces),
			 * add a detailed descriptive Literal String (with trailing comma) to this list
			 * BEFORE " **End of Log Entry List **" String
			 * e.g.
			 *
			 * "1.2: made changes to blah blah to fix bug blah",
			 * " **End of Log Entry List **"
			 *
			 * OR
			 *
			 * "3.7: created new inner class blah to add new blah blah feature",
			 * " **End of Log Entry List **"
			 *
			 */
			DEVELOPMENT_LOG_ENTRY_LIST = new ArrayList<>(Arrays.asList(
					"1.0: initial version of class created",
					"2.0: Developed adapter patter",
					"3.0: Developed Builder pattern", 
					"3.1: Developed individual and combo builder and composite design pattern",
					"4.0: Developed item classes",
					"4.1: Developed decorators",
					"5.0: Developed item factory",
					"5.1: Developed Strategy pattern for discounts",
					"6.0: Updated Order class",
					"6.1: implemented OrderComponentAPI",
					"6.2: corrected OrderBuilder API",
					"7.0: Updated implementation of Individual Order and ComboOrder builder pattern",
					"8:0: Updated decorator pattern implementation by removing Icecream and individual menu order item classes",
					"9.0: Updated singleton pattern implentations, by adding overriden methods of ItemAPI",
					"10.0: Added implementation pf OrderComponentFactoryAPI by factory design pattern",
					"11.0: Implemented bridge pattern on calculator apis ",
					"12.0: Added demo method to show demo of the implemented patterns and users Dan, Pam, Jim, Jen, Len and Sam",

					"** End of Log Entry List **"
			));
		} // end static block

		public void setOuterClass(Class outerClass) {
			this.outerClass = outerClass;
		}
		public Class getOuterClass() {
			return outerClass;
		}

		public String getRevision() {
			return DevelopmentLogEnum.REVISION + "." + DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.size();
		}
		/**
		 * revisionLog shows all the entries in the development log made during the development of this class
		 * @return
		 */
		public String getDevelopmentLog() {
			StringBuilder sb = new StringBuilder(outerClass.getSimpleName());

			sb.append(" Development Log ").append(this.getRevision()).append("\n");
			DevelopmentLogEnum.DEVELOPMENT_LOG_ENTRY_LIST.forEach((e) -> sb.append(e).append("\n"));

			return sb.toString();
		}
	} // end of enum DevelopmentLogEnum


	/**
	 * ItemAPI implemented by all Item objects for sale
	 *
	 * @author dpeters
	 */
	private interface ItemAPI {
		double getPrice();
		String getName();
	}
	/**
	 * OrderAPI implemented by all Order objects for customer orders
	 *
	 * @author dpeters
	 */
	private interface OrderAPI {
		int getId();
		double getPrice();
		String getName();
		String getDescription();
	}


	/**
	 * Student ToDO:
	 * Adapter Design Pattern:
	 *
	 * 4. Develop inner class OrderAdapter using Adapter design pattern,
	 * to adapt Order to use an ItemAPI object
	 */

	public static class OrderAdaptor extends Order{
		ItemAPI itemapi;
		public OrderAdaptor(){
		}
		public void OrderAdapter(ItemAPI itemapi) {
			this.itemapi = itemapi;
		}

		@Override
		public double getPrice(){
			return itemapi.getPrice();
		}
		@Override
		public String getName() {

			return itemapi.getName();
		}

	}


	/**
	 * Student ToDO:
	 * Builder Design Pattern:
	 *
	 * Using Builder design pattern, develop inner class ItemBuilder
	 * to custom configure an Item object
	 */
	public static class Item implements ItemAPI{
		private String name;
		private double price;
		public Item() {
		}
		private Item(ItemBuilder builder){
			this.name = builder.name;
			this.price = builder.price;
		}
		public String getName(){
			return name;
		}
		public double getPrice(){
			return price;
		}
		@Override
		public String toString() {
			return "Item: " + this.name + ", " + this.price;
		}
		public static class ItemBuilder{
			private String name;
			private double price;

			public ItemBuilder(String name){
				this.name = name;
			}
			public ItemBuilder price(double price) {
				this.price = price;
				return this;
			}
		
			public Item build() {
				Item item = new Item(this);
				return item;
			}
		}
	}



	/**
	 * Student ToDO:
	 * Composite Design Pattern:
	 *
	 * Using Composite and Builder design pattern,
	 * develop inner classes:
	 *
	 *  Order, IndividualOrder, IndividualOrderBuilder,
	 * ComboOrder and ComboOrderBuilder
	 *
	 */
	public interface OrderComponentAPI extends OrderAPI {
	}

	public interface OrderBuilderAPI {
		public OrderComponentAPI build();
	}
	public static class Order implements OrderComponentAPI {

		private int id;
		protected double price;
		private String name;
		private String description;

		public Order() {
		}

		public Order(OrderBuilder orderBuilder) {
			this.id = orderBuilder.id;
			this.name = orderBuilder.name;
			this.price = orderBuilder.price;
			this.description = orderBuilder.description;
		}

		@Override
		public int getId() {
			return id;
		}

		@Override
		public double getPrice() {
			return price;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public String getDescription() {
			return description;
		}

		@Override
		public String toString() {
			return "Order{" +
					"id=" + id +
					", price=" + price +
					", name='" + name + '\'' +
					", description='" + description + '\'' +
					'}';
		}

		public static class OrderBuilder implements OrderBuilderAPI {
			private int id;
			private double price;
			private String name;
			private String description;

			public OrderBuilder(int id) {
				this.id = id;
			}

			public OrderBuilderAPI price(double price) {
				this.price = price;
				return this;
			}

			public OrderBuilder name(String name) {
				this.name = name;
				return this;
			}

			public OrderBuilder description(String description) {
				this.description = description;
				return this;
			}

			//Return the finally constructed Order object
			@Override
			public OrderComponentAPI build() {
				OrderComponentAPI order = new Order(this);
				return order;
			}

		}
	}

	public static class IndividualOrder extends Order{

		private String name;
		private String description;
		private List<ItemAPI> items;
		public IndividualOrder() {
		}
		private IndividualOrder(IndividualOrderBuilder builder){

			super(builder);
			this.name = builder.name;
			this.description = builder.description;
			this.items = builder.items;
			this.price = builder.items.stream()
					.map(item -> item.getPrice())
					.reduce(0.0, (a, b) -> a + b);
		}
		public static class IndividualOrderBuilder extends OrderBuilder {
			//	private int id;
//				private double price;
			private String name;
			private String description;
			private List<ItemAPI> items = new ArrayList<>();

			public IndividualOrderBuilder(int id) {
				super(id);
			}

			public IndividualOrderBuilder item(ItemAPI item) {
				this.items.add(item);
				return this;
			}
			

			
			public IndividualOrderBuilder description(String description) {
				this.description = description;
				return this;
			}

			public OrderComponentAPI build() {
				OrderComponentAPI individualOrder = new IndividualOrder(this);
				return individualOrder;
			}
		}

		@Override
		public String toString() {
			return getName() + "'s GrubHub order ID #" +
					getId() + "\n" +
					items.stream().map(item -> item.toString()).collect(Collectors.joining("\n"))
					+ "\nTotal Amount: $" + getPrice();
		}
	}
	public static class ComboOrder extends Order{

		private List<ItemAPI> items;
		private String comboName;

		public ComboOrder() {
		}

		private ComboOrder(ComboOrderBuilder builder){
			super(builder);
			this.comboName = builder.comboName;
			this.items = builder.items;
			this.price = builder.items.stream()
					.map(item -> item.getPrice())
					.reduce(0.0, (a, b) -> a + b);
		}
		public static class ComboOrderBuilder extends OrderBuilder{
			private String comboName;
			private String description;
			private List<ItemAPI> items = new ArrayList<>();

			public ComboOrderBuilder(int id) {
				super(id);
			}

			public ComboOrderBuilder item(ItemAPI item) {
				this.items.add(item);
				return this;
			}
			public ComboOrderBuilder comboName(String comboName) {
				this.comboName = comboName;
				return this;
			}
			public ComboOrderBuilder description(String description) {
				this.description = description;
				return this;
			}

			public OrderComponentAPI build() {
				OrderComponentAPI comboOrder = new ComboOrder(this);
				return comboOrder;
			}
		}
		@Override
		public String toString() {
			return getName() + "'s GrubHub " + comboName + " order ID #" +
					getId() + "\n" +
					items.stream().map(item -> item.toString()).collect(Collectors.joining("\n"))
					+ "\nTotal Amount: $" + getPrice();
		}
	}



	/**
	 * Student ToDO:
	 * Decorator Design Pattern:
	 *
	 * Using Decorator design pattern,
	 * develop inner classes:
	 *
	 *  ItemDecoratorAPI, and others as needed for all ItemAPI options
	 *
	 */

	public static abstract class ItemDecoratorAPI implements ItemAPI {


		@Override
		public double getPrice() {
//			this.price =  api.getPrice();
			return 0.0;
			//this.price;
		}

		@Override
		public String getName() {

			return "";
			
		}
	}


	public static class CherryDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public CherryDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before adding cherry ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price after adding cherry ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Cherry ";
		}

	}
	public static class FudgeDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public FudgeDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before Adding Fudge ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price After Adding Fudge ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Fudge ";
		}

	}
	public static class ChocolatechipsDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public ChocolatechipsDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before Adding Chocolatechips ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price After Adding Chocolatechips ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Chocolatechips ";
		}

	}
	public static class OreoDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public OreoDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before Adding Oreo ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price After Adding Oreo ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Oreo ";
		}

	}
	public static class KitkatDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public KitkatDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before Adding Kitkat ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price After Adding Kitkat ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Kitkat ";
		}

	}
	public static class SprinklesDecorator extends ItemDecoratorAPI {
		public final ItemAPI itemAPI;
		public SprinklesDecorator(ItemAPI api) {
			this.itemAPI=api;
		}

		public double getPrice(){
			double price = itemAPI.getPrice();
			System.out.println("******** Price before Adding Sprinkles ====> " + price);
			double newPrice =  price + 1.00;
			System.out.println("******** Price After Adding Sprinkles ====> " + newPrice);
			return newPrice;
		}

		public String getName(){
			String name = itemAPI.getName();
			return name + " Added Sprinkles ";
		}

	}


	/**
	 * Student ToDO:
	 * Factory Design Pattern:
	 *
	 * Using Factory design pattern and supplied ItemFactoryAPI,
	 * develop inner classes:
	 *
	 * ItemFactory, ItemFactoryEnumSingleton,
	 * ItemFactoryEagerSingleton and ItemFactoryLazySingleton
	 *
	 * Using Factory design pattern and supplied OrderComponentFactoryAPI,
	 * develop inner classes:
	 *
	 * IndividualOrderComponentFactory, IndividualOrderComponentFactoryEnumSingleton,
	 * IndividualOrderComponentFactoryEagerSingleton and IndividualOrderComponentFactoryLazySingleton
	 *
	 * ComboOrderComponentFactory, ComboOrderComponentFactoryEnumSingleton,
	 * ComboOrderComponentFactoryEagerSingleton and ComboOrderComponentFactoryLazySingleton
	 *
	 * Using Factory design pattern and supplied OrderAdapterFactoryAPI,
	 * develop inner classes:
	 *
	 * OrderAdapterFactory, OrderAdapterFactoryEnumSingleton,
	 * OrderAdapterFactoryEagerSingleton and OrderAdapterFactoryLazySingleton
	 *
	 */


	/**
	 * ItemFactoryAPI for Factory method design pattern
	 * @author dpeters
	 *
	 */
	private interface ItemFactoryAPI {
		ItemAPI getObject();
		ItemAPI getObject(Item.ItemBuilder b);
	}


	public static class ItemFactory implements ItemFactoryAPI {
		@Override
		public ItemAPI getObject() {
			return new Item();
		}

		@Override
		public ItemAPI getObject(Item.ItemBuilder b) {
			return b.build();
		}

	}
	public static class ItemFactoryEagerSingleton {
		private static final ItemFactoryEagerSingleton instance = new ItemFactoryEagerSingleton();
		private ItemFactoryEagerSingleton() {
		}
		public static ItemFactoryEagerSingleton getInstance() {
			return instance;
		}
		//        @Override
		public ItemAPI getObject() {
			return new Item();
		}

		//        @Override
		public ItemAPI getObject(Item.ItemBuilder b) {
			return b.build();
		}
		@Override
		public String toString() {
			return "Item Factory Singleton Eager Object is Created";
		}
	}

	public static class ItemFactoryLazySingleton{
		private static ItemFactoryLazySingleton instance;

		private ItemFactoryLazySingleton() {

		}


		public static ItemFactoryLazySingleton getInstance() {
			if(instance==null)
			{
				synchronized(ItemFactoryLazySingleton.class) {
					if(instance==null) {
						instance = new ItemFactoryLazySingleton();
					}
				}
			}
			return instance;
		}
		
//        @Override
		public ItemAPI getObject() {
			return new Item();
		}

		//        @Override
		public ItemAPI getObject(Item.ItemBuilder b) {
			return b.build();
		}

		@Override
		public String toString() {
			return "Singleton Lazy Object is Created";
		}
	}
	public static class ItemFactoryEnumSingleton{
		private static volatile ItemFactoryEnumSingleton instance;

		private ItemFactoryEnumSingleton() {

		}

		public static ItemFactoryEnumSingleton getInstance() {


			if (instance == null) {

				synchronized (ItemFactoryEnumSingleton.class) {

					if (instance == null) {
						instance = new ItemFactoryEnumSingleton();
					}
				}
			}
			return instance;
		}
		//        @Override
//        @Override
		public ItemAPI getObject() {
			return new Item();
		}

		//        @Override
		public ItemAPI getObject(Item.ItemBuilder b) {
			return b.build();
		}

		@Override
		public String toString() {
			return "SingleTon Enum Object";
		}
	}
	/**
	 * OrderComponentFactoryAPI for Factory method design pattern
	 * @author dpeters
	 *
	 */

	private interface OrderComponentFactoryAPI {
		OrderComponentAPI getObject();
		OrderComponentAPI getObject(OrderBuilderAPI b);
	}

	public class IndividualOrderFactory implements OrderComponentFactoryAPI {

		//        @Override
		public OrderComponentAPI getObject() {
			return new IndividualOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}
	}

	public enum IndividualOrderFactoryEnumSingleton implements OrderComponentFactoryAPI {

		INSTANCE;

		@Override
		public OrderComponentAPI getObject() {
			return new IndividualOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}
	}

	public static class IndividualOrderFactoryEagerSingleton implements OrderComponentFactoryAPI {

		private static IndividualOrderFactoryEagerSingleton instance=new IndividualOrderFactoryEagerSingleton();  // Implementing Eager Singleton

		private IndividualOrderFactoryEagerSingleton() {
		}

		public static IndividualOrderFactoryEagerSingleton getInstance() {
			return instance;
		}

		@Override
		public OrderComponentAPI getObject() {
			return new IndividualOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}

	}

	public static class IndividualOrderFactoryLazySingleton implements OrderComponentFactoryAPI {

		private static IndividualOrderFactoryLazySingleton instance=null;   //Implementing Lazy singleton method

		private IndividualOrderFactoryLazySingleton() {
		}

		public static IndividualOrderFactoryLazySingleton getInstance() {
			if(instance==null)
			{
				synchronized(IndividualOrderFactoryLazySingleton.class) {
					if(instance==null) {
						instance = new IndividualOrderFactoryLazySingleton();
					}
				}
			}
			return instance;
		}

		@Override
		public OrderComponentAPI getObject() {
			return new IndividualOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}

	}

	public static class ComboOrderFactory implements OrderComponentFactoryAPI {

		@Override
		public OrderComponentAPI getObject() {
			return new ComboOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}
	}

	public enum ComboOrderFactoryEnumSingleton implements OrderComponentFactoryAPI {

		INSTANCE;

		public static ComboOrderFactoryEnumSingleton getInstance() {
			return INSTANCE;
		}

		@Override
		public OrderComponentAPI getObject() {
			return new ComboOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}
	}

	public static class ComboOrderFactoryEagerSingleton implements OrderComponentFactoryAPI {

		private static ComboOrderFactoryEagerSingleton instance=new ComboOrderFactoryEagerSingleton();  // Implementing Eager Singleton

		private ComboOrderFactoryEagerSingleton() {
		}

		public static ComboOrderFactoryEagerSingleton getInstance() {
			return instance;
		}

		@Override
		public OrderComponentAPI getObject() {
			return new ComboOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}

	}

	public static class ComboOrderFactoryLazySingleton implements OrderComponentFactoryAPI {

		private static ComboOrderFactoryLazySingleton instance=null;   //Implementing Lazy singleton method

		private ComboOrderFactoryLazySingleton() {
		}

		public static ComboOrderFactoryLazySingleton getInstance() {
			if(instance==null)
			{
				synchronized(ComboOrderFactoryLazySingleton.class) {
					if(instance==null) {
						instance = new ComboOrderFactoryLazySingleton();
					}
				}
			}
			return instance;
		}

		@Override
		public OrderComponentAPI getObject() {
			return new ComboOrder();
		}

		@Override
		public OrderComponentAPI getObject(OrderBuilderAPI b) {
			return b.build();
		}

	}

	private interface OrderAdapterFactoryAPI {
		OrderAdaptor getObject();
	}

	public class OrderAdapterFactory implements OrderAdapterFactoryAPI {

		@Override
		public OrderAdaptor getObject() {
			return new OrderAdaptor();
		}

	}

	public enum OrderAdapterFactoryEnumSingleton implements OrderAdapterFactoryAPI {

		INSTANCE;

		@Override
		public OrderAdaptor getObject() {
			return new OrderAdaptor();
		}
	}

	public static class OrderAdapterFactoryEagerSingleton implements OrderAdapterFactoryAPI {

		private static OrderAdapterFactoryEagerSingleton instance=new OrderAdapterFactoryEagerSingleton();  // Implementing Eager Singleton

		private OrderAdapterFactoryEagerSingleton() {
		}

		public static OrderAdapterFactoryEagerSingleton getInstance() {
			return instance;
		}

		@Override
		public OrderAdaptor getObject() {
			return new OrderAdaptor();
		}

	}

	public static class OrderAdapterFactoryLazySingleton implements OrderAdapterFactoryAPI {

		private static OrderAdapterFactoryLazySingleton instance=null;   //Implementing Lazy singleton method

		private OrderAdapterFactoryLazySingleton() {
		}

		public static OrderAdapterFactoryLazySingleton getInstance() {
			if(instance==null)
			{
				synchronized(OrderAdapterFactoryLazySingleton.class) {
					if(instance==null) {
						instance = new OrderAdapterFactoryLazySingleton();
					}
				}
			}
			return instance;
		}

		@Override
		public OrderAdaptor getObject() {
			return new OrderAdaptor();
		}

	}


	/**
	 * Student ToDO:
	 * Strategy Design Pattern:
	 *
	 * Using Strategy design pattern to change retail prices:
	 * NormalDiscount (0% decrease), MemberDiscount (10% decrease),
	 * SpecialDiscount (20% discount), SuperBowlDiscount (20% increase)
	 */
	private enum DiscountStrategy{
		NORMAL,
		MEMBER,
		SPECIAL,
		SUPERBOWL
	}
	public interface DiscountStrategyAPI{
		public String discount(Item item);
	}

	public static class NormalDiscount implements DiscountStrategyAPI{
		@Override
		public String discount(Item item) {
			double discountedPrice = item.getPrice() - item.getPrice() * 0.0;
			return "Discount of 0% on" + item.getName() + "on Normal Discount. Final price = " + Math.round(discountedPrice * 100.0) / 100.0;
		}
	}

	public static class MemberDiscount implements DiscountStrategyAPI{
		@Override
		public String discount(Item item) {
			double discountedPrice = item.getPrice() - item.getPrice() * 0.10;;
			return "Discount of 10% on" + item.getName() + "on Member Discount. Final price = " + Math.round(discountedPrice * 100.0) / 100.0;
		}
	}

	public static class SpecialDiscount implements DiscountStrategyAPI{
		@Override
		public String discount(Item item) {
			double discountedPrice = item.getPrice() - item.getPrice() * 0.20;;
			return "Discount of 20% on" + item.getName() + "on Special Discount. Final price = " + Math.round(discountedPrice * 100.0) / 100.0;
		}
	}

	public static class SuperBowlDiscount implements DiscountStrategyAPI{
		@Override
		public String discount(Item item) {
			double discountedPrice = item.getPrice() + item.getPrice() * 0.20;;
			return "Discount of 20% (increase) on" + item.getName() + "on SuperBowl MarkUp. Final price = " + Math.round(discountedPrice * 100.0) / 100.0;
		}
	}

	public class StoreDiscountStrategy{
		private DiscountStrategyAPI discountStrategy;

		public StoreDiscountStrategy(DiscountStrategyAPI discountStrategy) {
			super();
			this.discountStrategy = discountStrategy;
		}

		public String discountedPrice(Item item) {
			return discountStrategy.discount(item);
		}
	}


	/**
	 * Student ToDO:
	 * Bridge Design Pattern:
	 *
	 * Develop TWO Point of Sale APIs for Order purchases with DISCOUNTS (to change prices):
	 * Using Bridge design pattern to in TWO design phases
	 * developing inner interfaces PosAPI1, PosAPI2, CalculatorAPI1, CalculatorAPI2 and
	 * developing inner classes Pos1, Pos2, Calculator1 and Calculator2
	 *
	 */
	public interface CalculatorAPI1 {

		double add(double a, double b);
	}

	public interface PosAPI1 {

		double sumTotal(List<Double> itemList);
		void setStrategy(DiscountStrategyAPI discountStrategy);
		double getSum();	// return sum total
		String toStringSumTotal();	// return String representation of sum total
	}

	public static class Calculator1 implements CalculatorAPI1 {

		double result = 0;

		@Override
		public double add(double a, double b) {
			result = a+b;
			return result;
		}

		@Override
		public String toString() {
			return "Calculator1{" +
					"result=" + result +
					'}';
		}
	}

	public static class Pos1 implements PosAPI1{

		double sum = 0;

		private final CalculatorAPI1 calculator1;
		DiscountStrategyAPI discountStrategy;

		public Pos1(CalculatorAPI1 calculator1) {
			this.calculator1 = calculator1;
		}

		@Override
		public double sumTotal(List<Double> asList) {
			for(double d:asList)
				sum += d;
			return sum;
		}

		@Override
		public void setStrategy(DiscountStrategyAPI discountStrategy) {
			this.discountStrategy = discountStrategy;
		}

		@Override
		public double getSum() {
			return sum;
		}

		@Override
		public String toStringSumTotal() {
			return "Sum Total is $" + sum;
		}

		@Override
		public String toString() {
			return "Pos1{" +
					"sum=" + toStringSumTotal() +
					", calculator1=" + calculator1 +
					", discountStrategy=" + discountStrategy +
					'}';
		}
	}

	public interface CalculatorAPI2 extends CalculatorAPI1{

		double sub(double a, double b);

		double mult(double a, double b);

		double div(double a, double b);
	}

	public static class Calculator2 extends Calculator1 implements CalculatorAPI2{

		@Override
		public double sub(double a, double b) {
			result = a-b;
			return result;
		}

		@Override
		public double mult(double a, double b) {
			result = a*b;
			return result;
		}

		@Override
		public double div(double a, double b) {
			result = a/b;
			return result;
		}

		@Override
		public String toString() {
			return "Calculator2{" +
					"result=" + result +
					'}';
		}

	}

	public interface PosAPI2 extends PosAPI1{
		double getChange(double cash);		// accept cash, return change
		String toStringCash();		// return String representation of customer cash submitted
		String toStringChange();	// return String representation of customer change received
	}


	public static class Pos2 extends Pos1 implements PosAPI2{

		double cash;
		double change;

		private final CalculatorAPI2 calculator2;

		public Pos2(CalculatorAPI2 calculator2) {
			super(calculator2);
			this.calculator2 = calculator2;
		}

		@Override
		public double getChange(double cash) {
			this.cash = cash;
			change = calculator2.sub(cash, sum);
			return change;
		}

		@Override
		public String toStringCash() {
			return "Cash submitted: $" + cash;
		}

		@Override
		public String toStringChange() {
			return "Change received: $" + change;
		}

		@Override
		public String toString() {
			return "Pos2{" +
					"sum=" + sum +
					", discountStrategy=" + discountStrategy +
					", cash=" + toStringCash() +
					", change=" + toStringChange() +
					", calculator2=" + calculator2 +
					'}';
		}
	}



	/**
	 * Testing Code for GrubHub class
	 */
	public static void demoGrubHub(){

		System.out.println("\n" + GrubHub.class.getName() + ".demoGrubHub()...");
		System.out.println("=====================================================");

		/** $ 5.49 Icecream ($1 OPTIONS: cherry, fudge, chocolatechips, oreo, kitkat, sprinkles) */
		Item.ItemBuilder icecreamBuilder = new Item.ItemBuilder("Icecream").price(5.49);
		ItemAPI icecream = new ItemFactory().getObject(icecreamBuilder);

		ItemAPI icecreamWithOptions = new SprinklesDecorator(new KitkatDecorator(new CherryDecorator(icecream)));

		/** $ 0.99 French Fries */
		Item.ItemBuilder frenchFriesBuilder = new Item.ItemBuilder("French Fries").price(0.99);
		ItemAPI frenchFries = ItemFactoryLazySingleton.getInstance().getObject(frenchFriesBuilder);

		/** $ 1.29 Medium Drink */
		Item.ItemBuilder mediumDrinkBuilder = new Item.ItemBuilder("Medium Drink").price(1.29);
		ItemAPI mediumDrink = ItemFactoryEagerSingleton.getInstance().getObject(mediumDrinkBuilder);

		/** $ 2.49 Salad */
		Item.ItemBuilder saladBuilder = new Item.ItemBuilder("Salad").price(2.49);
		ItemAPI salad = ItemFactoryEnumSingleton.getInstance().getObject(saladBuilder);

		/** $ 3.49 Hamburger */
		Item.ItemBuilder hamburgerBuilder = new Item.ItemBuilder("Hamburger").price(3.49);
		ItemAPI hamburger = ItemFactoryEnumSingleton.getInstance().getObject(hamburgerBuilder);

		/** $ 4.49 Buffalo Wings */
		Item.ItemBuilder buffaloWingsBuilder = new Item.ItemBuilder("Buffalo Wings").price(4.49);
		ItemAPI buffaloWings = ItemFactoryEagerSingleton.getInstance().getObject(buffaloWingsBuilder);

		/** $ 1.49 Hot Dog */
		Item.ItemBuilder hotDogBuilder = new Item.ItemBuilder("Hot Dog").price(1.49);
		ItemAPI hotDog = new ItemFactory().getObject(hotDogBuilder);

		/** $ 3.79 Cheeseburger */
		Item.ItemBuilder cheeseburgerBuilder = new Item.ItemBuilder("Cheeseburger").price(3.79);
		ItemAPI cheeseburger = ItemFactoryLazySingleton.getInstance().getObject(cheeseburgerBuilder);


		/** 	Dan's Customer Door Dash Order ID #1 Hamburger, Medium Drink */

		System.out.println("=====================================================");
		IndividualOrder.IndividualOrderBuilder individualOrder1 = (IndividualOrderBuilder) new IndividualOrder.IndividualOrderBuilder(1).item(hamburger).item(mediumDrink).description("dan").name("Dan");
		OrderComponentAPI dansOrder = IndividualOrderFactoryLazySingleton.getInstance().getObject((OrderBuilderAPI) individualOrder1);
		System.out.println(dansOrder);
		System.out.println("=====================================================");

		/** 	Pam's Customer Door Dash Order ID #2 HotDogCombo (HotDog, French Fries, Medium Drink) */

		ComboOrder.OrderBuilder hotdogCombo = new ComboOrder.ComboOrderBuilder(2).comboName("HotDogCombo")
				.item(hotDog).item(frenchFries).item(mediumDrink).name("Pam");
		OrderComponentAPI pamsOrder = ComboOrderFactoryLazySingleton.getInstance().getObject(hotdogCombo);
		System.out.println("=====================================================");
		System.out.println(pamsOrder);
		System.out.println("=====================================================");

		/** 	Jim's Customer Door Dash Order ID #3 BurgerCombo (Hamburger, French Fries, Medium Drink) */

		ComboOrder.OrderBuilder burgerCombo = new ComboOrder.ComboOrderBuilder(3).comboName("BurgerCombo")
				.item(hamburger).item(frenchFries).item(mediumDrink).name("Jim");
		OrderComponentAPI jimsOrder = ComboOrderFactoryEagerSingleton.getInstance().getObject(burgerCombo);
		System.out.println("=====================================================");
		System.out.println(jimsOrder);
		System.out.println("=====================================================");

		/** 	Jen's Customer Door Dash Order ID #4 Cheeseburger, French Fries */

		System.out.println("=====================================================");
		IndividualOrder.IndividualOrderBuilder individualOrder4 = (IndividualOrderBuilder) new IndividualOrder.IndividualOrderBuilder(4).item(cheeseburger).item(frenchFries).description("dan").name("Jen");
		OrderComponentAPI jensOrder = IndividualOrderFactoryEagerSingleton.getInstance().getObject((OrderBuilderAPI) individualOrder4);
		System.out.println(jensOrder);
		System.out.println("=====================================================");

		/** 	Len's Customer Door Dash Order ID #5 WingCombo (Buffalo Wings, Medium Drink, Salad) */

		ComboOrder.OrderBuilder wingCombo = new ComboOrder.ComboOrderBuilder(5).comboName("WingCombo")
				.item(buffaloWings).item(mediumDrink).item(salad).name("Len");
		OrderComponentAPI lensOrder = ComboOrderFactoryEnumSingleton.getInstance().getObject(wingCombo);
		System.out.println("=====================================================");
		System.out.println(lensOrder);
		System.out.println("=====================================================");

		/** 	Sam's Customer Door Dash Order ID #6 IcecreamCombo (Buffalo Wings, French Fries, Salad, Medium Drink, Icecream) */

		ComboOrder.OrderBuilder icecreamCombo = new ComboOrder.ComboOrderBuilder(6).comboName("IcecreamCombo")
				.item(buffaloWings).item(frenchFries).item(salad)
				.item(mediumDrink).item(icecreamWithOptions).name("Sam");
		OrderComponentAPI samsOrder = new ComboOrderFactory().getObject(icecreamCombo);
		System.out.println("=====================================================");
		System.out.println(samsOrder);
		System.out.println("=====================================================");


		System.out.println("=====================================================");
		System.out.println("\n" + GrubHub.class.getName() + ".demoPos()... done!");
	}



	/**
	 * test Point of Sale (POS) Bridge Abstraction Phase I Pos1 (Calculator1) and Phase II Pos2 (Calculator2)
	 */
	public static void demoPos(Double... a ) {
		System.out.println("\n\t" + GrubHub.class.getName() + ".demoPos()...");
		{
			System.out.println("TESTING Pos1 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");

			Pos1 obj = new Pos1(new Calculator1());

			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 0% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);

			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Pos2 (sumTotal(" + a[0] + ", " + a[1] + ", " + a[2] + "):...");

			Pos2 obj = new Pos2(new Calculator2());

			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 10% Normal Discount");
			obj.setStrategy(new NormalDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 10% Member Discount");
			obj.setStrategy(new MemberDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 20% Special Discount");
			obj.setStrategy(new SpecialDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);

			System.out.println("applying 20% SuperBowl MarkUp");
			obj.setStrategy(new SuperBowlDiscount());
			obj.sumTotal(Arrays.asList(a));
			obj.getChange(20.0d);
			System.out.println(obj);
		}
		System.out.println("\n\t" + GrubHub.class.getName() + ".demoPos()... done!");
	}

	/**
	 * test the Point of Sale (POS) Bridge Abstraction
	 */
	public static void testPos() {
		System.out.println("\n\t" + GrubHub.class.getName() + ".testPos()...");

		/*
		 * Using:	1.1,2.2,3.1
		 * Test Pos1: sumTotal
		 * Test Pos2: getChange
		 */
		Double array[] = { 1.1, 2.2, 3.3 };

		GrubHub.demoPos(array);

		System.out.println("\n\t" + GrubHub.class.getName() + ".testPos()... done!");
	}

	/**
	 * test Point of Sale (POS) Bridge Implementor
	 */
	public static void testCalculator() {
		System.out.println("\n\t" + GrubHub.class.getName() + ".testCalculator()...");

		/*
		 * Using:	a = 4.2, b = 2.1
		 * Test Calculator1: add
		 * Test Calculator2: sub, mult, div
		 */
		double a = 4.2;
		double b = 2.1;
		GrubHub.demoCalculator(a, b);

		System.out.println("\n\t" + GrubHub.class.getName() + ".testCalculator()... done!");
	}

	/**
	 * test Point of Sale Bridge (POS) Implementor Phase I Calculator1 and Phase II Calculator2
	 */
	public static void demoCalculator(double a, double b) {
		System.out.println("\n\t" + GrubHub.class.getName() + ".demoCalculator()...");
		{
			System.out.println("TESTING Calculator1 (add " + a + "," + b + "):...");
			Calculator1 obj = new Calculator1();
			obj.add(a, b);
			System.out.println(obj);
		}
		{
			System.out.println("TESTING Calculator2 (add,sub,mult,div " + a + "," + b + "):...");
			Calculator2 obj = new Calculator2();
			obj.add(a, b);
			System.out.println(obj);
			obj.sub(a, b);
			System.out.println(obj);
			obj.mult(a, b);
			System.out.println(obj);
			obj.div(a, b);
			System.out.println(obj);
		}
		System.out.println("\n\t" + GrubHub.class.getName() + ".demoCalculator()... done!");
	}

	/**
	 * demonstrate the use of class GrubHub
	 */
	public static void demo() {
		System.out.println("\n\t" + GrubHub.class.getName() + "demo()...");
		System.out.println(DevelopmentLogEnum.LOG.getDevelopmentLog()); // REMOVE MY SOLUTION

		/**
		 * test Calculator
		 */
		GrubHub.testCalculator();

		/**
		 * test Point of Sale (PoS)
		 */
		GrubHub.testPos();

		/**
		 * Student ToDO:
		 * use Point of Sale (PoS) to total all orders with all discounts
		 */
		GrubHub.demoGrubHub();
		System.out.println("\n\t" + GrubHub.class.getName() + "demo()... done!");
	}
}

// Output:
/*
============Main Execution Start===================



	edu.neu.csye7374.GrubHubdemo()...
GrubHub Development Log 1.0.18
1.0: initial version of class created
2.0: Developed adapter patter
3.0: Developed Builder pattern
3.1: Developed individual and combo builder and composite design pattern
4.0: Developed item classes
4.1: Developed decorators
5.0: Developed item factory
5.1: Developed Strategy pattern for discounts
6.0: Updated Order class
6.1: implemented OrderComponentAPI
6.2: corrected OrderBuilder API
7.0: Updated implementation of Individual Order and ComboOrder builder pattern
8:0: Updated decorator pattern implementation by removing Icecream and individual menu order item classes
9.0: Updated singleton pattern implentations, by adding overriden methods of ItemAPI
10.0: Added implementation pf OrderComponentFactoryAPI by factory design pattern
11.0: Implemented bridge pattern on calculator apis 
12.0: Added demo method to show demo of the implemented patterns and users Dan, Pam, Jim, Jen, Len and Sam
** End of Log Entry List **


	edu.neu.csye7374.GrubHub.testCalculator()...

	edu.neu.csye7374.GrubHub.demoCalculator()...
TESTING Calculator1 (add 4.2,2.1):...
Calculator1{result=6.300000000000001}
TESTING Calculator2 (add,sub,mult,div 4.2,2.1):...
Calculator2{result=6.300000000000001}
Calculator2{result=2.1}
Calculator2{result=8.82}
Calculator2{result=2.0}

	edu.neu.csye7374.GrubHub.demoCalculator()... done!

	edu.neu.csye7374.GrubHub.testCalculator()... done!

	edu.neu.csye7374.GrubHub.testPos()...

	edu.neu.csye7374.GrubHub.demoPos()...
TESTING Pos1 (sumTotal(1.1, 2.2, 3.3):...
Pos1{sum=Sum Total is $6.6, calculator1=Calculator1{result=0.0}, discountStrategy=null}
applying 0% Normal Discount
Pos1{sum=Sum Total is $13.2, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$NormalDiscount@30f39991}
applying 10% Member Discount
Pos1{sum=Sum Total is $19.8, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$MemberDiscount@4a574795}
applying 20% Special Discount
Pos1{sum=Sum Total is $26.400000000000002, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$SpecialDiscount@23fc625e}
applying 20% SuperBowl MarkUp
Pos1{sum=Sum Total is $33.0, calculator1=Calculator1{result=0.0}, discountStrategy=edu.neu.csye7374.GrubHub$SuperBowlDiscount@4f023edb}
TESTING Pos2 (sumTotal(1.1, 2.2, 3.3):...
Pos2{sum=6.6, discountStrategy=null, cash=Cash submitted: $20.0, change=Change received: $13.4, calculator2=Calculator2{result=13.4}}
applying 10% Normal Discount
Pos2{sum=13.2, discountStrategy=edu.neu.csye7374.GrubHub$NormalDiscount@85ede7b, cash=Cash submitted: $20.0, change=Change received: $6.800000000000001, calculator2=Calculator2{result=6.800000000000001}}
applying 10% Member Discount
Pos2{sum=19.8, discountStrategy=edu.neu.csye7374.GrubHub$MemberDiscount@5674cd4d, cash=Cash submitted: $20.0, change=Change received: $0.1999999999999993, calculator2=Calculator2{result=0.1999999999999993}}
applying 20% Special Discount
Pos2{sum=26.400000000000002, discountStrategy=edu.neu.csye7374.GrubHub$SpecialDiscount@63961c42, cash=Cash submitted: $20.0, change=Change received: $-6.400000000000002, calculator2=Calculator2{result=-6.400000000000002}}
applying 20% SuperBowl MarkUp
Pos2{sum=33.0, discountStrategy=edu.neu.csye7374.GrubHub$SuperBowlDiscount@65b54208, cash=Cash submitted: $20.0, change=Change received: $-13.0, calculator2=Calculator2{result=-13.0}}

	edu.neu.csye7374.GrubHub.demoPos()... done!

	edu.neu.csye7374.GrubHub.testPos()... done!

edu.neu.csye7374.GrubHub.demoGrubHub()...
=====================================================
=====================================================
Dan's GrubHub order ID #1
Item: Hamburger, 3.49
Item: Medium Drink, 1.29
Total Amount: $4.78
=====================================================
=====================================================
Pam's GrubHub HotDogCombo order ID #2
Item: Hot Dog, 1.49
Item: French Fries, 0.99
Item: Medium Drink, 1.29
Total Amount: $3.77
=====================================================
=====================================================
Jim's GrubHub BurgerCombo order ID #3
Item: Hamburger, 3.49
Item: French Fries, 0.99
Item: Medium Drink, 1.29
Total Amount: $5.7700000000000005
=====================================================
=====================================================
Jen's GrubHub order ID #4
Item: Cheeseburger, 3.79
Item: French Fries, 0.99
Total Amount: $4.78
=====================================================
=====================================================
Len's GrubHub WingCombo order ID #5
Item: Buffalo Wings, 4.49
Item: Medium Drink, 1.29
Item: Salad, 2.49
Total Amount: $8.27
=====================================================
******** Price before adding cherry ====> 5.49
******** Price after adding cherry ====> 6.49
******** Price before Adding Kitkat ====> 6.49
******** Price After Adding Kitkat ====> 7.49
******** Price before Adding Sprinkles ====> 7.49
******** Price After Adding Sprinkles ====> 8.49
=====================================================
Sam's GrubHub IcecreamCombo order ID #6
Item: Buffalo Wings, 4.49
Item: French Fries, 0.99
Item: Salad, 2.49
Item: Medium Drink, 1.29
edu.neu.csye7374.GrubHub$SprinklesDecorator@723279cf
Total Amount: $17.75
=====================================================
=====================================================

edu.neu.csye7374.GrubHub.demoPos()... done!

	edu.neu.csye7374.GrubHubdemo()... done!


============Main Execution End===================



*/


