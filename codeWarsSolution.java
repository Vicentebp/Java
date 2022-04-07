// Multiples of 3 or 5
public class Solution {

  public int solution(int in) {
    int total = 0;
      // Se i  for menor que input, somar + 1
      for (int i = 1; i < in; i ++) {
        // se restante da divisão de i for 0 soma +1 no total
        if ((i % 3 == 0) || ( i % 5 == 0)) {
          total += i;
        }
      } 
      return total;
  }
}
