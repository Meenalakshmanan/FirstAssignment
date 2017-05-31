package com.stockoverflow.user.model;

public class User {

	private int id;
	private String name; 
    private String reputation;  
    private String goldBadges;
    private String silverBadges;
    private String bronzeBadges;
 
    public User(){
       
    }
    
    public User(int id,String name,String reputation,String goldBadges,String silverBadges,String bronzeBadges){
    	this.id =id;
    	this.name = name;
    	this.reputation = reputation;
    	this.goldBadges = goldBadges;
    	this.silverBadges = silverBadges;
    	this.bronzeBadges = bronzeBadges;
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReputation() {
		return reputation;
	}

	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	public String getGoldBadges() {
		return goldBadges;
	}

	public void setGoldBadges(String goldBadges) {
		this.goldBadges = goldBadges;
	}

	public String getSilverBadges() {
		return silverBadges;
	}

	public void setSilverBadges(String silverBadges) {
		this.silverBadges = silverBadges;
	}

	public String getBronzeBadges() {
		return bronzeBadges;
	}

	public void setBronzeBadges(String bronzeBadges) {
		this.bronzeBadges = bronzeBadges;
	}

	@Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", reputation=" + reputation + ", " +
        		"goldBadges=" + goldBadges + ", silverBadges= "+ silverBadges +",bronzeBadges="+bronzeBadges+"]";
    }
	
	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        User other = (User) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
 
}
