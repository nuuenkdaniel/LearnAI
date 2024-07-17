public class Main {

  public static void printLayers(Layer[] layers) {
    for(int i = 0; i < layers.length; i++) {
      layers[i].printLayer();
    }
  }

  public static void printVector(float[] v) {
    System.out.print("[");
    for(int i = 0; i < v.length-1; i++) {
      System.out.print(v[i]+", ");
    }
    System.out.println(v[v.length-1]+"]");
  }

  public static void run(Layer[] layers, float[] input, int[] catLabels) {
    System.out.println("Input:");
    printVector(input);
    System.out.println();

    for(int i = 0; i < layers.length-1; i++) {
      System.out.println("Layer "+i+":");
      input = layers[i].pass(input);
      System.out.print("  Before ReLU:\n  ");
      printVector(input);
      input = Layer.activFunc_ReLU(input);
      System.out.print("  ReLU:\n  ");
      printVector(input);
    }
    int index = layers.length-1;
    System.out.println("Layer "+index+": ");
    input = layers[layers.length-1].pass(input);
    System.out.print("  Before SoftMax:\n  ");
    printVector(input);
    input = Layer.activFunc_softMax(input);
    System.out.print("  SoftMax:\n  ");
    printVector(input);

    System.out.println();
    float loss[] = Layer.catCrossEntropy(input, catLabels);
    System.out.println("Loss: ");
    printVector(loss);
  }

  public static void main(String[] args) {
    
    float[] input = new float[] {200f, 2f};
    float[][] input2 = new float[0][0];

    Layer[] layers = new Layer[5];
    layers[0] = new Layer(2, 3);
    layers[1] = new Layer(3, 3);
    layers[2] = new Layer(3, 3);
    layers[3] = new Layer(3, 3);
    layers[4] = new Layer(3, 2);

    run(layers, input, new int[] {0});
  }
}
