public class Main {

  public static void main(String[] args) {
    //float[] v1 = new float[] {2f, 3f};
    //float[][] m1 = {
      //{4f, 2f},
      //{3f, 1f},
    //};
/*
    float[][] m3 = {
      {4f, 2f, 5f},
      {3f, 1f, 6f},
    };

    float[][] m2 = MatrixFunc.multiply(m1, m3);
    for(int i = 0; i < m2.length; i++) {
      for(int j = 0; j < m2[0].length; j++) {
        System.out.print(m2[i][j]+" ");
      }
      System.out.println();
    }*/

    Layer inp_layer = new Layer(2, 3);
    Layer layer1 = new Layer(3, 3);
    Layer layer2 = new Layer(3, 3);
    Layer layer3 = new Layer(3, 3);
    Layer out_layer = new Layer(3, 2);

    inp_layer.printLayer();
    layer1.printLayer();
    layer2.printLayer();
    layer3.printLayer();
    out_layer.printLayer();
  }
}
