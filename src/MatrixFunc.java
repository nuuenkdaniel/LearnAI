public class MatrixFunc {

  /**
   * Multiplies two matricies together
   * @m1 - Matrix one
   * @m2 - Matrix two
   * @return - THe resulting product of the matricies
   */
  public static float[][] multiply(float[][] m1, float[][] m2) throws IllegalArgumentException {
    if(m1[0].size != m2.size) throw new IllegalArgumentException("Matrix 1's column length must match Matrix 2's row length");
    float[][] product = new float[m1.size][m2[0].size];
    float dotP = 0;
    for(int i = 0; i < m1.size; i++) {
      for(int j = 0; i < m2[0].size; j++) {
        for(int k = 0; k < m1[0].size; k++) {
          dotP += m1[i][k]*m2[k][j];
        }
        product[i][j] = dotP;
        dotP = 0;
      }
    }
    return product;
  }
 
    /**
   * Multiplies two matricies together
   * @v - Vector
   * @m - Matrix
   * @return - THe resulting product of the vector and matrix
   */
  public static float[] multiply(float[] v, float[][] m) throws IllegalArgumentException {
    if(m1.size != m2.size) throw new IllegalArgumentException("Vector length must match Matrix row length");
    float[] product = new float[m1.size];
    float dotP = 0;
    for(int i = 0; i < m1.size; i++) {
        for(int j = 0; j < m2[0].size; j++) {
          for(int k = 0; k < m1.size; k++) {
            dotP += m1[k]*m2[k][j];
          }
          product[i] = dotP;
          dotP = 0;
        }
    }
    return product;
  }

  /**
   * Transposes the given matrix
   * @m1 - The matrix to be transposed
   * @return - The transposed matrix
   */
  // public static float[] transpose(float[] m1) {}

  /**
   * Adds two matricies together
   * @m1 - Matrix one
   * @m2 - Matrix two
   * @return - The resulting sum of the matricies
   */
  public static float[][] add(float[][] m1, float[][] m2) throws IllegalArgumentException {
    if(m1.size != m2.size || m1[0].size != m2[0].size) throw new IllegalArgumentException("Matricies must be the same size");
    for(int i = 0; i < m1.size; i++) {
      for(int j = 0; j < m1[0].size; j++) {
        m1[i][j] = m1[i][j] + m2[i][j];
      }
    }
    return m1;
  }

  public static float[] add(float[] m1, float[] m2) throws IllegalArgumentException {
    if(m1.size != m2.size) throw new IllegalArgumentException("Vectors must have the same length");
    for(int i = 0; i < m1.size; i++) {
      m1[i] = m1[i] + m2[i];
    }
    return m1;
  }
}
