package com.tapmaster;

public class Player {

	private String name;
	private int money;
	
	/**
	 * @param name
	 */
	public Player(String name) {
		this.name = name;
		money = 0;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}
	/**
	 * Increments money by amount
	 * @param amount
	 */
	public void addMoney(int amount)	{
		money += amount;
	}
	
}
