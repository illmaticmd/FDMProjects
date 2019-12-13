package com.fdmgroup.doa;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fdmgroup.persistence.ItemDao;
import com.fdmgroup.persistence.JpaItemDao;
import com.fdmgroup.products.Item;

public class JpaItemDaoTest {
	private ItemDao classUnderTest = new JpaItemDao();

	@Test
	public void testIfMemberDoesNotExist() {
		// arrange
		Item item = new Item();
		Item itemToAdd = new Item();
		// act
		item = classUnderTest.getItem(itemToAdd.getName());
		// assert
		assertNull(item);
	}

	@Test
	public void test() {
		// arrange

		// act
		// assert
	}

}
