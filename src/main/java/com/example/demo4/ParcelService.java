package com.example.demo4;
import org.springframework.stereotype.Service;  
//use appropriate annotation to configure ParcelService as a Service 
@Service 
public class ParcelService { 
 
 //calculate the totalCost and return the cost 
 public double calculateTotalCost(ParcelBean parcelBean) 
 { 
 String serviceType = parcelBean.getServiceType(); 
 int weight = parcelBean.getWeight(); 
 float cost = 0.0f; 
 
 if(serviceType.equals("SpeedPost")) { 
 if(weight<=100 && weight>=1) 
 cost = 100.0f; 
 else if(weight<=500 && weight>=101) 
 cost = 250.0f; 
 else if(weight>500) { 
 cost = 500.0f;  } 
 } 
 else if(serviceType.equals("RegisteredPost")) { 
 if(weight<=100 && weight>=1) 
 cost = 200.0f; 
 else if(weight<=500 && weight>=101) 
 cost = 400.0f; 
 else if(weight>500) { 
 cost = 800.0f; 
 } 
 } 
 else if(serviceType.equals("ParcelService")) { 
 if(weight<=100 && weight>=1) 
 cost = 1000.0f; 
 else if(weight<=500 && weight>=101) 
 cost = 1500.0f; 
 else if(weight>500) { 
 cost = 2000.0f; 
 } 
 } 
 parcelBean.setServiceCost(cost); 
 return cost+(cost*0.1); 
 } 
} 