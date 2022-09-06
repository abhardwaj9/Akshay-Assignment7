package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CustomArrayListTest {

	@Test
	void should_throw_exception_on_get_if_empty()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(0);
		});

		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1000);
		});

		IndexOutOfBoundsException exception3 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
		
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
		assertEquals("Index out of bounds.", exception3.getMessage());
	}
	
	@Test
	void should_return_zero_size_if_empty()
	
	{
		CustomArrayList<String> list;
		
		list = new CustomArrayList<String>();
		
		assertEquals(list.getSize(), 0);
	}

	@Test
	void should_add_object_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	
		
		assertEquals("a", list.get(0));
		assertEquals(list.getSize(), 1);
		
	}

	@Test
	void should_add_twentyone_objects_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	list.add("b");	list.add("c");	list.add("d");	list.add("e");	list.add("f");	list.add("g");
		list.add("h");	list.add("i");	list.add("j");	list.add("k");	list.add("l");	list.add("m");	list.add("n");
		list.add("o");	list.add("p");	list.add("q");	list.add("r");	list.add("s");	list.add("t");	list.add("u");
		
		assertEquals("a", list.get(0));
		assertEquals("k", list.get(10));
		assertEquals("u", list.get(20));
		assertEquals(list.getSize(), 21);
		
	}

	@Test
	void should_add_a_million_objects_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
			
		for (int count = 0; count < 1000000; count++)
		{
			list.add("Element " + (count + 1));
		}

		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1000000);
		});

		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
		
		assertEquals("Element 1", list.get(0));
		assertEquals("Element 1000000", list.get(999999));
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
		assertEquals(list.getSize(), 1000000);
		
	}

	@Test
	void should_add_object_at_index_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	list.add("b");	list.add("c");	list.add("d");	list.add("e");	list.add("f");	list.add("g");
		list.add("h");	list.add("i");	list.add("j");	list.add("k");	
					
		list.add(4, "l");
		
		assertEquals("l", list.get(4));
		assertEquals("e", list.get(5));
		assertEquals("k", list.get(11));
		assertEquals(list.getSize(), 12);
		
		list.add(11, "m");

		assertEquals("j", list.get(10));
		assertEquals("m", list.get(11));
		assertEquals("k", list.get(12));
		assertEquals(list.getSize(), 13);
	}

	
	@Test
	void should_throw_exception_if_add_index_out_of_bounds()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	list.add("b");	list.add("c");	list.add("d");	list.add("e");	list.add("f");	list.add("g");
		list.add("h");	list.add("i");	list.add("j");	list.add("k");	
				
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(-4, "l");
		});
		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(11, "l");
		});
		
		assertEquals("e", list.get(4));
		assertEquals("k", list.get(10));
		assertEquals(list.getSize(), 11);
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
	}
	
	@Test
	void should_remove_object_from_list()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	list.add("b");	list.add("c");	list.add("d");	list.add("e");	list.add("f");	list.add("g");
		list.add("h");	list.add("i");	list.add("j");	list.add("k");	
		
		list.remove(4);
		
		assertEquals("f", list.get(4));
		assertEquals("k", list.get(9));
		assertEquals(list.getSize(), 10);

		list.remove(9);
		
		assertEquals("f", list.get(4));
		assertEquals("j", list.get(8));
		assertEquals(list.getSize(), 9);
	}
	
	@Test
	void should_throw_exception_if_remove_index_out_of_bounds()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("a");	list.add("b");	list.add("c");	list.add("d");	list.add("e");	list.add("f");	list.add("g");
		list.add("h");	list.add("i");	list.add("j");	list.add("k");	
				
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-4);
		});
		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(11);
		});
		
		assertEquals("e", list.get(4));
		assertEquals("k", list.get(10));
		assertEquals(list.getSize(), 11);
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
	}
}
