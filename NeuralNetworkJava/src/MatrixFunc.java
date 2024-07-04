public class MatrixFunc {

  /**
   * Multiplies two matricies together
   * @m1 - Matrix one
   * @m2 - Matrix two
   * @return - THe resulting product of the matricies
   */
  public static float[][] multiply(float[][] m1, float[][] m2) throws IllegalArgumentException {
    if(m1[0].length != m2.length) throw new IllegalArgumentException("Matrix 1's column length must match Matrix 2's row length");
    float[][] product = new float[m1.length][m2[0].length];
    float dotP = 0;
    for(int i = 0; i < m1.length; i++) {
      for(int j = 0; j < m2[0].length; j++) {
        for(int k = 0; k < m1[0].length; k++) {
          dotP += m1[i][k]*m2[k][j];
        }
        product[i][j] = dotP;
        dotP = 0;
      }
    }
    return product;
  }
 
    /**
   * Multiplies a vector and matrix together
   * @v - Vector
   * @m - Matrix
   * @return - THe resulting product of the vector and matrix
   */
  public static float[] multiply(float[] v, float[][] m) throws IllegalArgumentException {
    if(v.length != m.length) throw new IllegalArgumentException("Vector length must match Matrix row length");
    float[] product = new float[m[0].length];
    float dotP = 0;
    for(int i = 0; i < v.length; i++) {
      for(int j = 0; j < m[0].length; j++) {
        for(int k = 0; k < v.length; k++) {
          dotP += v[k]*m[k][j];
        }
        product[j] = dotP;
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
    if(m1.length != m2.length || m1[0].length != m2[0].length) throw new IllegalArgumentException("Matricies must be the same size");
    for(int i = 0; i < m1.length; i++) {
      for(int j = 0; j < m1[0].length; j++) {
        m1[i][j] = m1[i][j] + m2[i][j];
      }
    }
    return m1;
  }

  /**
   * Adds two vectors together
   * @v1 - The first vector
   * @v2- The second vector
   * @return - A vector of the sum of the two vectors
   */
  public static float[] add(float[] v1, float[] v2) throws IllegalArgumentException {
    if(v1.length != v2.length) throw new IllegalArgumentException("Vectors must have the same length");
    for(int i = 0; i < v1.length; i++) {
      v1[i] = v1[i] + v2[i];
    }
    return v1;
  }

  public static float[][] add(float[][] m, float[] v) throws IllegalArgumentException {
    if(m[0].length != v.length) throw new IllegalArgumentException("Matrix column length and vector length must be the same");
    for(int i = 0; i < m.length; i++) {
      for(int j = 0; j < v.length; j++) {
        m[i][j] += v[j];
      }
    }
    return m;
  }
}
