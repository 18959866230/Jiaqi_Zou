package assign08;

/**
 * this is a subclass called Armor extends from Item class and it has methods
 * override
 * 
 * @author Jiaqi Zou
 * @version 2023/ Mar 23
 *
 */
public class Armor extends Item {
	private int defense;

	public Armor(String name, int defense) {
		super(name);
		this.defense = defense;
	}

	/**
	 * this is the method to get Armor's defense value..
	 * 
	 * @param none
	 * @return this.defense
	 */
	public int getDefense() {
		return this.defense;
	}

	/**
	 * this is the method to set defense value for Armor.
	 * 
	 * @param int defense
	 * @return none
	 */
	public void setDefense(int defense) {
		this.defense = defense;

	}

	/**
	 * this is the method extends and override from superclass Item class, to get
	 * the description of Armor.
	 * 
	 * @param none
	 * @return "Armor: " + getName() + " - defense=" + defense;
	 */
	public String getDescription() {
		return "Armor: " + getName() + " - defense=" + defense;
	}

	/**
	 * this is the method extends and override from superclass Item class, to use
	 * the upgrade for Armor type.
	 * 
	 * @param none
	 * @return none
	 */
	public void useUpgrade() {
		this.defense += 1;

	}

	/**
	 * this is the method extends and override from superclass Item class, to
	 * compare Armor with other types Tool, Magic, Upgrade follow the rule: For two
	 * Armor objects: compare the defense numbers When comparing Item objects of
	 * different types: Tool > Armor > Magic > Upgrade
	 * 
	 * @param Item type other
	 * @return int type value.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool) {
			return 1;
		} else if (other instanceof Armor) {
			return Integer.compare(this.defense, ((Armor) other).defense);
		} else if (other instanceof Magic) {
			return -1;
		} else if (other instanceof Upgrade) {
			return 1;
		} else {
			return -1;
		}
	}
}
