package com.zhang.ortools;

/**
 * @program: utilsdemo
 * @description: 线性规划例子
 * @author: zhangyu
 * @create: 2019-06-26 10:45
 */

import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

/**
 * Simple linear programming example.
 */
public class LinearProgrammingExample {
    static {
        System.loadLibrary("jniortools");
    }

    public static void main(String[] args) throws Exception {
        MPSolver solver = new MPSolver(
                "LinearProgrammingExample", MPSolver.OptimizationProblemType.GLOP_LINEAR_PROGRAMMING);

        double infinity = java.lang.Double.POSITIVE_INFINITY;
        // x and y are continuous non-negative variables.
        MPVariable x = solver.makeNumVar(0.0, infinity, "x");
        MPVariable y = solver.makeNumVar(0.0, infinity, "y");
        System.out.println("Number of variables = " + solver.numVariables());

        // x + 2*y <= 14.
        MPConstraint c0 = solver.makeConstraint(-infinity, 14.0, "c0");
        c0.setCoefficient(x, 1);
        c0.setCoefficient(y, 2);

        // 3*x - y >= 0.
        MPConstraint c1 = solver.makeConstraint(0.0, infinity, "c1");
        c1.setCoefficient(x, 3);
        c1.setCoefficient(y, -1);

        // x - y <= 2.
        MPConstraint c2 = solver.makeConstraint(-infinity, 2.0, "c2");
        c2.setCoefficient(x, 1);
        c2.setCoefficient(y, -1);
        System.out.println("Number of constraints = " + solver.numConstraints());

        // Maximize 3 * x + 4 * y.
        MPObjective objective = solver.objective();
        objective.setCoefficient(x, 3);
        objective.setCoefficient(y, 4);
        objective.setMaximization();

        final MPSolver.ResultStatus resultStatus = solver.solve();
        // Check that the problem has an optimal solution.
        if (resultStatus != MPSolver.ResultStatus.OPTIMAL) {
            System.err.println("The problem does not have an optimal solution!");
            return;
        }

        // The value of each variable in the solution.
        System.out.println("Solution");
        System.out.println("x = " + Math.round(x.solutionValue()));
        System.out.println("y = " + Math.round(y.solutionValue()));

        // The objective value of the solution.
        System.out.println("Optimal objective value = " + Math.round(solver.objective().value()));
    }
}
