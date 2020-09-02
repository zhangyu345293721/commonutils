package com.tool.algo.tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: zhangyu
 */

public class Tour {
    /**
     * 城市缓存
     */
    private ArrayList<City> citiesList; // Cache
    /**
     * 距离初始值
     */
    private int distance = 0;

    public Tour() {
        citiesList = new ArrayList<City>();
    }


    public Tour(ArrayList<City> tour) {
        citiesList = new ArrayList<City>();
        for (City city : tour) {
            this.citiesList.add(city);
        }
    }

    public ArrayList<City> getCitiesList() {
        return citiesList;
    }

    public Tour generateIndividual() {
        for (int cityIndex = 0; cityIndex < citiesList.size(); cityIndex++) {
            setCity(cityIndex, this.getCity(cityIndex));
        }
        Collections.shuffle(citiesList);
        return this;
    }

    public Tour generateNeighourTour() {
        Tour newSolution = new Tour(this.citiesList);
        int tourPos1 = (int) (newSolution.numberOfCities() * Math
                .random());
        int tourPos2 = (int) (newSolution.numberOfCities() * Math
                .random());
        City citySwap1 = newSolution.getCity(tourPos1);
        City citySwap2 = newSolution.getCity(tourPos2);

        newSolution.setCity(tourPos2, citySwap1);
        newSolution.setCity(tourPos1, citySwap2);
        return newSolution;
    }

    public City getCity(int tourPosition) {
        return (City) citiesList.get(tourPosition);
    }

    public void setCity(int tourPosition, City city) {
        citiesList.set(tourPosition, city);
        distance = 0;
    }

    public Tour addCity(City city) {
        citiesList.add(city);
        return this;
    }


    /**
     * 获取距离
     *
     * @return int值
     */
    public int getDistance() {
        if (distance == 0) {
            int tourDistance = 0;
            for (int cityIndex = 0; cityIndex < numberOfCities(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if (cityIndex + 1 < numberOfCities()) {
                    destinationCity = getCity(cityIndex + 1);
                } else {
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    /**
     * 获取城市的个数
     *
     * @return 城市数量
     */
    public int numberOfCities() {
        return citiesList.size();
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < numberOfCities(); i++) {
            geneString += getCity(i) + "|";
        }
        return geneString;
    }
}

