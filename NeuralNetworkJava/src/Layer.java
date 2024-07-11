import java.util.Random;

public class Layer {
  public float[][] weights;
  public float[] biases;

  /**
   * Initializes new layer with the specified inputs and neurons
   * @nInputs - The sample size of the inputs
   * @nNeurons - The number of neurons in the layer
   */
  public Layer(int nInputs, int nNeurons) {
    Random rand = new Random();
    weights = new float[nInputs][nNeurons];
    biases = new float[nNeurons];
    
    //Populates the weights with random numbers from -0.1 to 0.1
    for(int i = 0; i < weights.length; i++) {
      for(int j = 0; j < weights[0].length; j++) {
        weights[i][j] = rand.nextFloat()*0.2f - 0.1f;
      }
    }
  }

  /**
   * Creates a layer based off of the given weights and biases
   * @initWeights - The weights to be initialized with
   * @initBiases - The biases to be initialized with
   */
  public Layer(float[][] initWeights, float[] initBiases) {
    weights = initWeights;
    biases = initBiases;
  }
  
  /**
   * Takes in the matrix of inputs and alters the input with the weights and biases
   * @inputs - The inputs being passed in to the layer
   * @return - A matrix of the altered data
   */
  public float[][] pass(float[][] inputs) {
    return MatrixFunc.add(MatrixFunc.multiply(inputs, weights), biases);
  }
  
  /**
   * Takes the vector input and alters the input with the weights and biases
   * @inputs - The inputs being passed in to the layer
   * @returns - A vector of the latered data
   */
  public float[] pass(float[] input) {
    return MatrixFunc.add(MatrixFunc.multiply(input, weights), biases);
  }

  /**
   * Using the Rectified Linear activation function to alter the output
   * @input - The output of the input after weights and bias
   * @return - The modified output
   */
  public static float[][] activFunc_ReLU(float[][] input) {
    for(int i = 0; i < input.length; i++) {
      for(int j = 0; j < input[0].length; j++) {
        if(input[i][j] < 0) input[i][j] = 0;
      }
    }
    return input;
  }
  /**
   * Using the Rectified Linear activation function to alter the output
   * @input - The output of the input after weights and bias
   * @return - The modified output
   */
  public static float[] activFunc_ReLU(float[] input) {
    for(int i = 0; i < input.length; i++) {
      if(input[i] < 0) input[i] = 0;
    }
    return input;
  }

  /**
   * Using the Soft Max activation function to remove the negatives and normalize the output
   * @input - The output of the input after weights and bias
   * @return - The modified output
   */
  public static float[][] activFunc_softMax(float[][] input) {
    float normVals;
    float max;
    for(int i = 0; i < input.length; i++) {
      normVals = 0;
      max = input[i][0];
      for(int j = 1; j < input.length; j++) {
        if(max < input[i][j]) max = input[i][j];
      }
      for(int k = 0; k < input[0].length; k++) {
        input[i][k] = (float)Math.exp(input[i][k]);
        normVals += input[i][k];
      }
      for(int l = 0; l < input[0].length; l++) {
        input[i][l] /= normVals;
      }
    }
    return input;
  }

  /**
   * Using the Soft Max activation function to remove the negatives and normalize the output
   * @input - The output of the input after weights and bias
   * @return - The modified output
   */
  public static float[] activFunc_softMax(float[] input) {
    float normVals = 0;
    float max = input[0];
    for(int i = 1; i < input.length; i++) {
      if(max < input[i]) max = input[i];
    }
    for(int j = 0; j < input.length; j++) {
      input[j] = (float)Math.exp(input[j]-max);
      normVals += input[j];
    }
    for(int k = 0; k < input.length; k++) {
      input[k] /= normVals;
    }
    return input;
  }
  
  /**
   * Prints the weights and biases of the Layer
   */
  public void printLayer() {
    System.out.println("Weights:");
    for(int i = 0; i < weights.length; i++) {
      System.out.print("[");
      for(int j = 0; j < weights[0].length; j++) {
        System.out.print(weights[i][j]);
        if(j != weights[0].length-1) System.out.print(" ");
      }
      System.out.println("]");
    }

    System.out.println("Biases:");
    System.out.print("[");
    for(int k = 0; k < biases.length; k++) {
      System.out.print(biases[k]);
      if(k != biases.length-1) System.out.print(" ");
    }
    System.out.println("]\n");
  }
}
