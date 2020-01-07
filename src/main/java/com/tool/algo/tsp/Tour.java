package com.tool.algo.tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: zhangyu
 */

public class Tour {
    /** Holds our citiesList of cities*/
    private ArrayList<City> citiesList ; // Cache
    private int distance = 0;

    public Tour() {
        citiesList = new ArrayList<City>();
    }


    /**
     * Constructs a citiesList from another citiesList
     * */
    public Tour(ArrayList<City> tour){
        citiesList = new ArrayList<City>();
        for (City city : tour) {
            this.citiesList.add(city);
        }
    }

    /** Returns citiesList information*/
    public ArrayList<City> getCitiesList(){
        return citiesList;
    }

    /** Creates a random individual*/
    public Tour generateIndividual() {
        // Loop through all our destination cities and add them to our citiesList
        for (int cityIndex = 0; cityIndex < citiesList.size(); cityIndex++) {
            setCity(cityIndex, this.getCity(cityIndex));
        }
        // Randomly reorder the citiesList
        Collections.shuffle(citiesList);
        return this;
    }

    /**Create new neighbour tour*/
    public Tour generateNeighourTour(){
        Tour newSolution = new Tour(this.citiesList);
        // Get a random positions in the tour
        int tourPos1 = (int) (newSolution.numberOfCities() * Math
                .random());
        int tourPos2 = (int) (newSolution.numberOfCities() * Math
                .random());
        // Get the cities at selected positions in the tour
        City citySwap1 = newSolution.getCity(tourPos1);
        City citySwap2 = newSolution.getCity(tourPos2);

        // Swap them
        newSolution.setCity(tourPos2, citySwap1);
        newSolution.setCity(tourPos1, citySwap2);
        return newSolution;
    }

    /** Gets a city from the citiesList*/
    public City getCity(int tourPosition) {
        return (City)citiesList.get(tourPosition);
    }

    /** Sets a city in a certain position within a citiesList*/
    public void setCity(int tourPosition, City city) {
        citiesList.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        distance = 0;
    }

    public Tour addCity(City city) {
        citiesList.add(city);
        return this;
    }

   /* public ArrayList<City> getAllCities() {
        return citiesList;
    }*/

    /** Gets the total distance of the citiesList*/
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our citiesList's cities
            for (int cityIndex=0; cityIndex < numberOfCities(); cityIndex++) {
                // Get city we're traveling from
                City fromCity = getCity(cityIndex);
                // City we're traveling to
                City destinationCity;
                // Check we're not on our citiesList's last city, if we are set our
                // citiesList's final destination city to our starting city
                if(cityIndex+1 < numberOfCities()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    /** Get number of cities on our citiesList*/
    public int numberOfCities() {
        return citiesList.size();
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < numberOfCities(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}

