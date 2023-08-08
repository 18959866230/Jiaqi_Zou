package assign08;

/**
 * this is a subclass called Upgrade extends from Item class and it has methods
 * override
 * 
 * @author Jiaqi Zou
 * @version 2023/ Mar 23
 *
 */
public class Upgrade extends Item {
	private boolean used;

	public Upgrade() {
		super("Upgrade");
		this.used = false;
	}

	/**
	 * this is the method to get Upgrade's boolean value.
	 * 
	 * @param none
	 * @return used
	 */
	public boolean isUsed() {
		return used;
	}

	/**
	 * this is the method extends and override from superclass Item class, to get
	 * the description of Upgrade.
	 * 
	 * @param none
	 * @return "Upgrade: used" & "Upgrade; ready"
	 */
	public String getDescription() {
		if (used) {
			return "Upgrade: used";

		} else {
			return "Upgrade; ready";
		}

	}

	/**
	 * this is the method extends and override from superclass Item class, to use
	 * upgrade on boolean type Upgrade.
	 * 
	 * @param none
	 * @return none
	 */
	public void useUpgrade() {
		used = true;
	}

	/**
	 * this is the method extends and override from superclass Item class, to
	 * compare Upgrade with other types Tool, Armor, Magic follow the rule: For two
	 * Upgrade objects: unused > used, otherwise they are equal When comparing Item
	 * objects of different types: Tool > Armor > Magic > Upgrade
	 * 
	 * @param Item type other
	 * @return int type value.
	 */
	public int compareTo(Item other) {
		if (other instanceof Tool) {
			return -1;
		} else if (other instanceof Armor) {
			return -1; // Add this line
		} else if (other instanceof Magic) {
			return -1;
		} else {
			if (this.used == ((Upgrade) other).used) {
				return 0;
			} else if (this.used) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}
