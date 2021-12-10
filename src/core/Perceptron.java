package core;

import java.util.Random;

import lib.RandomMesh;

public class Perceptron {
	
	private double stepFac;
	private int[][] trainingData;
	private double[] wheights = new double[] {
			Math.random()-0.5,Math.random()-0.5,Math.random()-0.5
	};
	
	
	public Perceptron(double stepFac) {
		this.stepFac = stepFac;
	}
	
	public void setTrainingData(int[][] trainingData) {
		this.trainingData = trainingData;
	}

	private int calculate(int[] input) {
		if ((wheights[0]*input[0]+wheights[1]*input[1]+wheights[2])>0) {
			return 1;
		} else return 0;
	}
	
	public void train(int steps) {
		for (int i = 0; i < steps; i++) {
					int k = RandomMesh.randmIndex(new double[] {0.25,0.25,0.25,0.25});
					
					for (int j = 0; j < wheights.length; j++) {
						double t = trainingData[k][j];
					if(j==2)t=1;
					wheights[j] += stepFac*(trainingData[k][2] - calculate(trainingData[k])*t);
		}}
	}

	
	
	public void plotStatus() {
		
		String wheights = "Wheights: ";
		for (int i = 0; i < this.wheights.length; i++) {
			wheights += this.wheights[i] + " ";
		}
		
		String printThis = "Own and real: ";
		
		for (int i = 0; i < trainingData.length; i++) {
			printThis += calculate(trainingData[i])+ " " + trainingData[i][2]+ "   ";
		}
		
		System.out.println(wheights);
		System.out.println(printThis);
	}
	
	
	
	
}
