package assign08;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * this is the J-unit test for testing the accuracy of method override in
 * subclass (extends from Item class).
 * 
 * @author Jiaqi Zou
 * @version 2023/ mar 23
 *
 */
public class ItemTest {

	private Tool tool1, tool2;
	private Armor armor1, armor2;
	private Magic magic1, magic2;
	private Upgrade upgrade1, upgrade2;

	@BeforeEach
	/**
	 * These are setups value used in all tests below.
	 */
	void setUp() {
		tool1 = new Tool("Hammer", 5);
		tool2 = new Tool("Wrench", 10);

		armor1 = new Armor("Helmet", 15);
		armor2 = new Armor("Boots", 10);

		magic1 = new Magic("Fireball", 20, 5);
		magic2 = new Magic("Ice Shard", 15, 3);

		upgrade1 = new Upgrade();
		upgrade2 = new Upgrade();
	}

	@Test
	void testToolCompareTo() {
		assertTrue(tool1.compareTo(tool2) < 0);
		assertTrue(tool2.compareTo(tool1) > 0);
		assertTrue(tool1.compareTo(armor1) > 0);
		assertTrue(tool1.compareTo(magic1) > 0);
		assertTrue(tool1.compareTo(upgrade1) > 0);
	}

	@Test
	void testArmorCompareTo() {
		assertTrue(armor1.compareTo(armor2) > 0);
		assertTrue(armor2.compareTo(armor1) < 0);
		assertTrue(armor1.compareTo(tool1) > 0);
		assertTrue(armor1.compareTo(magic1) < 0);
		assertTrue(armor1.compareTo(upgrade1) > 0);
	}

	@Test
	void testMagicCompareTo() {
		assertTrue(magic1.compareTo(magic2) < 0);
		assertTrue(magic2.compareTo(magic1) > 0);
		assertTrue(magic1.compareTo(tool1) < 0);
		assertTrue(magic1.compareTo(armor1) > 0);
		assertTrue(magic1.compareTo(upgrade1) > 0);
	}

	@Test
	void testUpgradeCompareTo() {
		assertTrue(upgrade1.compareTo(upgrade2) == 0);
		assertTrue(upgrade1.compareTo(tool1) < 0);
		assertTrue(upgrade1.compareTo(armor1) < 0);
		assertTrue(upgrade1.compareTo(magic1) < 0);
	}

	@Test
	void testToolGetDescription() {
		assertEquals("Tool: Hammer - power=5", tool1.getDescription());
	}

	@Test
	void testArmorGetDescription() {
		assertEquals("Armor: Helmet - defense=15", armor1.getDescription());
	}

	@Test
	void testMagicGetDescription() {
		assertEquals("Magic: Fireball - power=20, cost=5", magic1.getDescription());
	}

	@Test
	void testUpgradeGetDescription() {
		assertEquals("Upgrade; ready", upgrade1.getDescription());
	}

	@Test
	void testToolUseUpgrade() {
		tool1.useUpgrade();
		assertEquals(6, tool1.getPower());
	}

	@Test
	void testArmorUseUpgrade() {
		armor1.useUpgrade();
		assertEquals(16, armor1.getDefense());
	}

	@Test
	void testMagicUseUpgrade() {
		magic1.useUpgrade();
		assertEquals(21, magic1.getPower());
		assertEquals(6, magic1.getCost());
	}

	@Test
	void testUpgradeUseUpgrade() {
		assertFalse(upgrade1.isUsed());
		upgrade1.useUpgrade();
		assertTrue(upgrade1.isUsed());
	}

	@Test
	void testToolPower() {
		assertEquals(5, tool1.getPower());
		assertEquals(10, tool2.getPower());
	}

	@Test
	void testArmorDefense() {
		assertEquals(15, armor1.getDefense());
		assertEquals(10, armor2.getDefense());
	}

	@Test
	void testMagicPowerCost() {
		assertEquals(20, magic1.getPower());
		assertEquals(5, magic1.getCost());
		assertEquals(15, magic2.getPower());
		assertEquals(3, magic2.getCost());
	}

	@Test
	void testUpgradeUsed() {
		assertFalse(upgrade1.isUsed());
		assertFalse(upgrade2.isUsed());
	}
}
