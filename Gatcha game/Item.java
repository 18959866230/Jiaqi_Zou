package assign08;

/**
 * this is a super class called Item, implements Comparable Class and has
 * several abstract methods that would be override in subclass extends from item
 * class.
 * 
 * @author Jiaqi Zou
 * @version 2023/ Mar 23
 *
 */
public abstract class Item implements Comparable<Item> {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	/**
	 * this method is aim to get the name of type we created.
	 * 
	 * @param none
	 * @return this.name
	 */
	public String getName() {
		return this.name;

	}

	/**
	 * This is an abstract method called getDescription that it would be override in
	 * subclass.
	 * 
	 * @return none
	 */
	public abstract String getDescription();

	/**
	 * This is an abstract method called useUpgrade that it would be override in
	 * subclass.
	 */
	public abstract void useUpgrade();

	/**
	 * This is an abstract method called compareTo that it would be override in
	 * subclass.
	 */
	public abstract int compareTo(Item other);
}
