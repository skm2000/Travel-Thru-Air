package shubham.flights.model;

public class FlightModel {
	
	int flightId;
	String flightName;
	String arrivalTime;
	String deptTime;
	int totalLegs;
	int isOffer;
	double flightPrice=0.0;
	String deptCity;
	String arrCity;
	double OfferPrice;
	
	
	public FlightModel(String flightName, String arrivalTime, String deptTime, int totalLegs, int isOffer,
			double flightPrice, String deptCity, String arrCity, double offerPrice) {
		super();
		this.flightName = flightName;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.totalLegs = totalLegs;
		this.isOffer = isOffer;
		this.flightPrice = flightPrice;
		this.deptCity = deptCity;
		this.arrCity = arrCity;
		OfferPrice = offerPrice;
	}


	public FlightModel(int flightId, String flightName, String arrivalTime, String deptTime, int totalLegs, int isOffer,
			double flightPrice, String deptCity, String arrCity, double offerPrice) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.totalLegs = totalLegs;
		this.isOffer = isOffer;
		this.flightPrice = flightPrice;
		this.deptCity = deptCity;
		this.arrCity = arrCity;
		OfferPrice = offerPrice;
	}


	public int getFlightId() {
		return flightId;
	}


	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public String getFlightName() {
		return flightName;
	}


	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public String getDeptTime() {
		return deptTime;
	}


	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}


	public int getTotalLegs() {
		return totalLegs;
	}


	public void setTotalLegs(int totalLegs) {
		this.totalLegs = totalLegs;
	}


	public int getIsOffer() {
		return isOffer;
	}


	public void setIsOffer(int isOffer) {
		this.isOffer = isOffer;
	}


	public double getFlightPrice() {
		return flightPrice;
	}


	public void setFlightPrice(double flightPrice) {
		this.flightPrice = flightPrice;
	}


	public String getDeptCity() {
		return deptCity;
	}


	public void setDeptCity(String deptCity) {
		this.deptCity = deptCity;
	}


	public String getArrCity() {
		return arrCity;
	}


	public void setArrCity(String arrCity) {
		this.arrCity = arrCity;
	}


	public double getOfferPrice() {
		return OfferPrice;
	}


	public void setOfferPrice(double offerPrice) {
		OfferPrice = offerPrice;
	}


	@Override
	public String toString() {
		return "FlightModel [flightId=" + flightId + ", flightName=" + flightName + ", arrivalTime=" + arrivalTime
				+ ", deptTime=" + deptTime + ", totalLegs=" + totalLegs + ", isOffer=" + isOffer + ", flightPrice="
				+ flightPrice + ", deptCity=" + deptCity + ", arrCity=" + arrCity + ", OfferPrice=" + OfferPrice + "]";
	}
	
	
	

}
