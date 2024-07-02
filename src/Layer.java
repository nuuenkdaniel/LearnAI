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
    rand = new Random();
    weights = new float[nInputs][nNeurons];
    biases = new float[nNeurons];
    
    //Populates the weights with random numbers from -0.1 to 0.1
    for(int i = 0; i < weights.size; i++) {
      for(int j = 0; i < weights[0].size; j++) {
        weights[i][j] = rand.nextFloat()*0.2f - 0.1f;
      }
    }
  }
  
  /**
   * Takes in the matrix of inputs and alters the input with the weights and biases
   * @inputs - The inputs being passed in to the layer
   * @return - A matrix of the altered data
   */
  public float[][] pass(float[][] inputs) {
    
  }
  
  /**
   * Takes the vector input and alters the input with the weights and biases
   * @inputs - The inputs being passed in to the layer
   * @returns - A vector of the latered data
   */
  public float[] pass(float[] input) {
  }
}
