package com.tool.algo.tsp;

/**
 * SimulatedAnnealing类
 *
 * @author: zhangyu
 */
public class SimulatedAnnealing {

    /**
     * Set initial temp
     */
    private double currentTemperature = 5000;
    /**
     * minimal temperature to cool
     */
    private double minTemperature = 0.0001;
    private double internalLoop = 10;
    /**
     * Cooling rate
     */
    private double coolingRate = 0.001;
    /**
     * Initialize intial solution
     */
    private Tour currentSolution;

    /**
     * set a random initial tour
     */
    public void initTour() {
        Tour tour = new Tour();
        tour.addCity(new City(60, 200))
                .addCity(new City(180, 200))
                .addCity(new City(80, 180))
                .addCity(new City(140, 180))
                .addCity(new City(20, 160))
                .addCity(new City(100, 160))
                .addCity(new City(200, 160))
                .addCity(new City(140, 140))
                .addCity(new City(40, 120))
                .addCity(new City(100, 120));
              /*  .addCity(new City(180, 100))
                .addCity(new City(60, 80))
                .addCity(new City(120, 80))
                .addCity(new City(180, 60))
                .addCity(new City(20, 40))
                .addCity(new City(100, 40))
                .addCity(new City(200, 40))
                .addCity(new City(20, 20))
                .addCity(new City(60, 20))
                .addCity(new City(160, 20));*/
        currentSolution = tour.generateIndividual();
        System.out.println("Initial solution distance: " + currentSolution.getDistance());
    }

    /**
     * iterate for getting the best Tour
     *
     * @return best tour
     */
    public Tour anneal() {

        long tp = 0;

        Tour bestSolution = new Tour(currentSolution.getCitiesList());
        Tour newSolution = null;
        // Loop until system has cooled
        while (currentTemperature > minTemperature) {
            for (int i = 0; i < internalLoop; i++) {
                //get a solution from neighbour
                newSolution = currentSolution.generateNeighourTour();
                // Get energy of solutions
                int currentEnergy = currentSolution.getDistance();
                int neighbourEnergy = newSolution.getDistance();

                // Decide if we should accept the neighbour
                if (acceptanceProbability(currentEnergy, neighbourEnergy,
                        currentTemperature) > Math.random()) {
                    currentSolution = new Tour(newSolution.getCitiesList());
                }

                // Keep track of the best solution found
                if (currentSolution.getDistance() < bestSolution.getDistance()) {
                    bestSolution = new Tour(currentSolution.getCitiesList());
                }
            }
            // Cool system
            currentTemperature *= 1 - coolingRate;

            long millis = System.currentTimeMillis();
            if (millis - tp > 300) {
                tp = millis;
                //ddWindow.addData(millis, bestSolution.getDistance());
            }
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bestSolution;
    }

    /**
     * Calculate the acceptance probability
     **/
    private double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        SimulatedAnnealing sa = new SimulatedAnnealing();
        sa.initTour();
        Tour besTour = sa.anneal();
        System.out.println("Final solution distance: " + besTour.getDistance());
        System.out.println("Tour: " + besTour);
        long endTime = System.currentTimeMillis();
        System.out.println("运行时间:" + (endTime - startTime) / 1000 + "s");
    }
}
