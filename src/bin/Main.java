package bin;

import core.Perceptron;

public class Main {

	public static void main(String[] args) {
		// init
		Perceptron perceptron = new Perceptron(0.01);
		
		// set Trainingdata
		perceptron.setTrainingData(new int[][] {{0,0,0},{1,0,1},{0,1,1},{1,1,1}});
		
		// print
		perceptron.plotStatus();
		
		// train
		perceptron.train(10000);

		// plot
		perceptron.plotStatus();
	}

}
