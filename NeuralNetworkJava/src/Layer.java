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
    for(int i = 0; i < input.length; i++) {
      normVals = 0;
      for(int j = 0; j < input[0].length; j++) {
        input[i][j] = (float)Math.exp(input[i][j]);
        normVals += input[i][j];
      }
      for(int k = 0; k < input[0].length; k++) {
        input[i][k] /= normVals;
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
    for(int i = 0; i < input.length; i++) {
      input[i] = (float)Math.exp(input[i]);
      normVals += input[i];
    }
    for(int j = 0; j < input.length; j++) {
      input[j] /= normVals;
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
        System.out.print(weights[i][j]+" ");
      }
      System.out.println("]");
    }

    System.out.println("Biases:");
    System.out.print("[");
    for(int j = 0; j < biases.length; j++) {
      System.out.print(biases[j]+" ");
    }
    System.out.println("]\n");
  }
}
