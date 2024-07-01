public class Main {

  public static void main(String[] args) {
    float[] inputs = new float[] {1.1f, 1.2f, 1.3f};
    float[] weights = new float[] {3.1f, 2.1f, 1.1f};
    float bias = 3f;
    
    float output = inputs[0]*weights[0] + inputs[1]*weights[1] + inputs[2]*weights[2] + bias;
    System.out.println(output);
  }
}
