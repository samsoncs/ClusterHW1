package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import api.Task;

public class TaskEuclideanTsp implements Task<List<Integer>> {

	double[][] cities;

	public TaskEuclideanTsp(double[][] cities) {
		this.cities = cities;
	}

	@Override
	public List<Integer> execute() {

		double[][] adj = calcAdjacencyMatrix(cities);
		int[] path = tsp(adj);
		
		List<Integer> pathList = new ArrayList<Integer>();		
		for (int index = 0; index < path.length; index++) {
			pathList.add(path[index]);
		}

		return pathList;
	}

	public double[][] calcAdjacencyMatrix(double[][] cities) {

		int numberOfCities = cities.length;
		double[][] matrix = new double[numberOfCities][numberOfCities];

		for (int i = 0; i < numberOfCities; i++) {
			double x1 = cities[i][0];
			double y1 = cities[i][1];

			for (int j = 0; j < numberOfCities; j++) {
				double x2 = cities[j][0];
				double y2 = cities[j][1];

				double distance = Math.sqrt(((x2 - x1) * (x2 - x1))
						+ ((y2 - y1) * (y2 - y1)));

				matrix[i][j] = distance;
			}
		}

		return matrix;

	}

	public static int[] tsp(double adjacencyMatrix[][]) {

		int[] path = new int[adjacencyMatrix[0].length];

		path[0] = 0;
		int currentCity = 0;

		int i = 1;
		while (i < path.length) {
			// find next city
			int nextCity = findMin(adjacencyMatrix[currentCity], path);
			// if the city is not -1 (meaning if there is a city to be visited
			if (nextCity != -1) {
				// add the city to the path
				path[i] = nextCity;
				// update currentCity and i
				currentCity = nextCity;
				i++;
			}
		}

		return path;
	}

	private static int findMin(double[] row, int[] path) {

		int nextCity = -1;
		int i = 0;
		double min = Integer.MAX_VALUE;

		while (i < row.length) {
			if (isCityInPath(path, i) == false && row[i] < min) {
				min = row[i];
				nextCity = i;
			}
			i++;
		}
		return nextCity;
	}

	public static boolean isCityInPath(int[] path, int city) {
		for (int i = 0; i < path.length; i++) {
			if (path[i] == city) {
				return true;
			}
		}
		return false;
	}

}
