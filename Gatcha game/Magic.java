package assign08;

/**
 * this is a subclass called Magic extends from Item class and it has methods
 * override
 * 
 * @author Jiaqi Zou
 * @version 2023/ Mar 23
 *
 */
public class Magic extends Item {
	private int power;
	private int cost;

	public Magic(String name, int power, int cost) {
		super(name);
		this.power = power;
		this.cost = cost;
	}

	/**
	 * this is the method to get Magic's power value.
	 * 
	 * @param none
	 * @return this.power
	 */
	public int getPower() {
		return this.power;
	}

	/**
	 * this is the method to get Magic's cost value.
	 * 
	 * @param none
	 * @return this.cost
	 */
	public int getCost() {
		return this.cost;

	}

	/**
	 * this is the method to set cost value for Magic.
	 * 
	 * @param cost
	 * @return none
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * this is the method to set power value for Magic.
	 * 
	 * @param power
	 * @return none
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * this is the method extends and override from superclass Item class, to get
	 * the description of Magic.
	 * 
	 * @param none
	 * @return "Magic: " + getName() + " - power=" + power + ", cost=" + cost
	 */
	public String getDescription() {
		return "Magic: " + getName() + " - power=" + power + ", cost=" + cost;

	}

	/**
	 * this is the method extends and override from superclass Item class, to use
	 * the upgrade for Magic type.
	 * 
	 * @param none
	 * @return none
	 */
	public void useUpgrade() {
		this.power += 1;
		this.cost += 1;

	}

	/**
	 * this is the method extends and override from superclass Item class, to
	 * compare Magic with other types Tool, Armor, Upgrade follow the rule: For two
	 * Magic objects: compare the fraction power/cost and use caution when dividing
	 * integers When comparing Item objects of different types: Tool > Armor > Magic
	 * > Upgrade
	 * 
	 * @param Item type other
	 * @return int type value.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool) {
			return -1;
		} else if (other instanceof Armor) {
			return 1;
		} else if (other instanceof Magic) {
			double thisRatio = (double) this.power / this.cost;
			double otherRatio = (double) ((Magic) other).power / ((Magic) other).cost;
			return Double.compare(thisRatio, otherRatio);
		} else if (other instanceof Upgrade) {
			return 1;
		} else {
			return -1;
		}
	}
}