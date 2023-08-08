package assign08;

/**
 * this is a subclass called Tool extends from Item class and it has methods
 * override
 * 
 * @author Jiaqi Zou
 * @version 2023/ Mar 23
 *
 */
public class Tool extends Item {
	private int power;

	public Tool(String name, int power) {
		super(name);
		this.power = power;

	}

	/**
	 * this is the method to get Tool's power value.
	 * 
	 * @param none
	 * @return this.power
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * this is the method to set power value for Tool.
	 * 
	 * @param power
	 * @return none
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * this is the method extends and override from superclass Item class, to get
	 * the description of Tool.
	 * 
	 * @param none
	 * @return "Tool: " + getName() + " - power=" + power.
	 */
	public String getDescription() {
		return "Tool: " + getName() + " - power=" + power;
	}

	/**
	 * this is the method extends and override from superclass Item class, to use
	 * the upgrade for Tool.
	 * 
	 * @param none
	 * @return none
	 */
	public void useUpgrade() {
		this.power += 1;

	}

	/**
	 * this is the method extends and override from superclass Item class, to
	 * compare Tool with other types Armor, Magic, Upgrade follow the rule: For two
	 * Tool objects: compare the power numbers. When comparing Item objects of
	 * different types: Tool > Armor > Magic > Upgrade
	 * 
	 * @param Item type other
	 * @return int type value.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool) {
			return Integer.compare(this.power, ((Tool) other).power);
		} else if (other instanceof Armor) {
			return 1;
		} else if (other instanceof Magic) {
			return 1;
		} else if (other instanceof Upgrade) {
			return 1;
		} else {
			return 1;
		}
	}
}
