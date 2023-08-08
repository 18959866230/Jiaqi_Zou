package assign06;

/**
 * This class represents a better dynamic array of strings, doubling the length of
 * the backing array when more space is needed and never shrinking.
 * 
 * @author Prof. Martin and ?
 * @version ?
 */
public class BetterDynamicArray {

	// DO NOT ADD OR REMOVE ANY INSTANCE VARIABLES
	private String[] elements; // the backing array
	private int elementCount; // the number of elements

	/**
	 * Creates a dynamic array with space for ten elements, but zero spaces occupied.
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public BetterDynamicArray() {
		elements = new String[10];
		elementCount = 0;
	}

	/**
	 * Appends the given string to end of this dynamic array.
	 * 
	 * @param str - the string to append
	 */
	public void append(String str) {
		insert(elementCount, str);
		// Fill in by calling insert method.
	}

	/**
	 * Inserts a given string into this dynamic array at a given index.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index at which to insert
	 * @param str - the string to insert
	 */
	public void insert(int index, String str) {	
		if(index < 0 || index > elementCount) {
			throw new IndexOutOfBoundsException("Index " + index + 
					" is invalid for adding to this array with length " + elementCount);
		}
		// Step 1: Add code to ensure the value of index is valid.
		// HINT: The index is valid if it is in the range of indexes currently used by 
		// elements in this dynamic array.  The range is determined by elementCount, 
		// not elements.length.
		
		// Step 2: If there are no free spaces in the backing array, expand -- DONE.
		if(elementCount == elements.length) {
			doubleBackingArray();
			
		}

		// Step 3: Shift the elements at index and up by one to make room for str at index.
		// ADVICE: Try this on paper first since this can be a difficult operation.
		// HINT: It is best to shift the elements if you start at the end because
		// it prevents overwriting values that have not yet been shifted.
		for(int i = elementCount - 1; i >= index; i--) {
			elements[i+1] = elements[i];
			
		}
			
		
		// Step 4: Insert str at index.
		elements[index] = str;
		
		
		// Step 5: Update elementCount.
		elementCount ++;
		
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow to earn full credit.
	}
	
	/**
	 * Creates a new array with twice the length as the backing array.
	 * Copies all elements from the backing array to the new array.
	 * Sets the backing array reference to the new array.
	 */
	private void doubleBackingArray() {
		String[] largerArray = new String[elements.length * 2];
		for(int i = 0; i < elements.length; i++) 
			largerArray[i] = elements[i];			
		elements = largerArray;
	}

	/**
	 * Gets the string stored in this dynamic array at the given index.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to get
	 * @return the element at the given index
	 */
	public String getElement(int index) {
		if(index < 0 || index >= elementCount) {
			throw new IndexOutOfBoundsException(
					"Index " + index + " is invalid for this array with length " + elementCount);
		}
		// Fill in.

		return elements[index];  // Replace null with the appropriate expression.
	}

	/**
	 * Returns the number of elements in this dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		
		// Fill in.
		
		return elementCount;  // Replace 0 with the appropriate expression.
	}

	/**
	 * Sets (i.e., changes) the string stored in this dynamic array at the given index
	 * to the given string.
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to set
	 * @param str - the new string value for setting the element
	 */
	public void setElement(int index, String str) {
		if(index < 0 || index >= elementCount)
			throw new IndexOutOfBoundsException(
					"Index " + index + " is invalid for this array with length " + elementCount);

		elements[index] = str;
		// Fill in.
	}

	/**
	 * Deletes the string at the given index from this dynamic array. 
	 * Throws an exception if the given index is out of bounds.
	 * 
	 * @param index - the index of the element to delete
	 */
	public void delete(int index) {
		// Fill in. Do not shrink the backing array. 
		// Its length should be the same before and after executing this method.
		
		// Step 1: Add code to ensure the value of index is valid.
		if(index < 0 || index >= elementCount)
			throw new IndexOutOfBoundsException(
					"Index " + index + " is invalid for this array with length " + elementCount);

		// Step 2: Shift the elements index + 1 and beyond down by one. 
		// This overwrites the deleted element at index.
		for(int i =index +1; i<elementCount;i++) {
			elements[i-1] = elements[i];
		}
		
		// Step 3: Update elementCount.
		elements[elementCount-1] = null;
		elementCount --;
		
		// DO NOT create a new array each time this method is called. If you create 
		// a new array each time, your program will be too slow to earn full credit.
	}

	/**
	 * Generates a textual representation of this dynamic array.
	 * 
	 * @return the textual representation
	 * 
	 * DO NOT MODIFY THIS METHOD
	 */
	public String toString() {
		String result = "[";
		if(size() > 0) 
			result += getElement(0);
		
		for(int i = 1; i < size(); i++) 
			result += ", " + getElement(i);
		
		return result + "] backing array length: " + elements.length;
	}
}