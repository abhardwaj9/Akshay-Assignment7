package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length) {
			items = biggerBackupArray();
		}
		items[size] = item;
		size++;
		return true;
	}

	private Object[] biggerBackupArray() {
		Object[] bigArray = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			bigArray[i] = items[i];
		}
		return bigArray;
	}

	@Override
	public int getSize() {

		return this.size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException

	{
		if (index >= 0 && index < this.size) {
			return (T) items[index];
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException

	{
		boolean isAdded = false;

		if (index >= 0 && index < this.size) {
			if (this.size + 1 < this.items.length) {
				this.size++;
			} else if (this.size + 1 >= this.items.length) {
				Object[] nextItems = new Object[this.items.length * 2];
				Arrays.fill(nextItems, null);
				System.arraycopy(this.items, 0, nextItems, 0, this.size);
				this.items = nextItems;
				this.size++;
			}

			System.arraycopy(items, index, items, index + 1, this.size - index);
			items[index] = item;
			isAdded = true;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		return isAdded;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException

	{
		T t = null;

		if (index >= 0 && index < this.size) {
			t = (T) items[index];

			if (index < this.size - 1) {
				System.arraycopy(items, index + 1, items, index, this.size - index);
			}

			this.size--;
		} else {
			throw new IndexOutOfBoundsException("Index out of bounds.");
		}

		return t;
	}

}

