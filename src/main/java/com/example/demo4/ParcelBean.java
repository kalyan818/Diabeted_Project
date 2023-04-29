package com.example.demo4;
import org.springframework.stereotype.Component; 
//pojo class with required attributes,getters and setters 
@Component 
public class ParcelBean { 
private String serviceType; 
private double serviceCost; 
private int weight; 

public String getServiceType() { 
return serviceType; 
} 
public void setServiceType(String serviceType) { 
this.serviceType = serviceType; 
} 
public double getServiceCost() { 
return serviceCost; 
} 
public void setServiceCost(double serviceCost) { 
this.serviceCost = serviceCost; 
} 
public int getWeight() { 
return weight; 
} 
public void setWeight(int weight) { 
this.weight = weight; 
} 

} 
