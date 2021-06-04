package term_project;


class Stock {
	private String stockName;
	private String stockExpire;
	private int stockNumber;
	
	
	public Stock(String stockName, String stockExpire, int stockNumber) {
		this.stockName = stockName;
		this.stockExpire = stockExpire;
		stockNumber = stockNumber;
	}
	
	public void store() {
		//store
	};
}

class stockFood extends Stock{
	private String foodCategory;
		
	public stockFood(String stockName, String stockExpire, int stockNumber, String foodCategory) {
		super(stockName, stockExpire, stockNumber);
		this.foodCategory = foodCategory;
	}
	
	public void store() {
		super.store();
	}
}

class meat extends stockFood{
	private String meatSpecies;
	
	public meat(String stockName, String stockExpire, int stockNumber, String foodCategory, String meatSpecies) {
		super(foodCategory, stockExpire, stockNumber, foodCategory);
		this.meatSpecies = meatSpecies;
	}
	
	public void store() {
		super.store();
	}
}

class fruit extends stockFood{
	private String fruitSeason;
	
	public fruit(String stockName, String stockExpire, int stockNumber, String foodCategory, String fruitSeason) {
		super(foodCategory, stockExpire, stockNumber, foodCategory);
		this.fruitSeason = fruitSeason;
	}
	
	public void store() {
		super.store();
	}
}

class vegetable extends stockFood{
	private String vetStem;
	
	public vegetable(String stockName, String stockExpire, int stockNumber, String foodCategory, String vetStem) {
		super(foodCategory, stockExpire, stockNumber, foodCategory);
		this.vetStem = vetStem;
	}
	
	public void store() {
		super.store();
	}
}