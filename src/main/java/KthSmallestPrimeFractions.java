import java.util.ArrayList;
import java.util.Comparator;

public class KthSmallestPrimeFractions {

    private static class FractionResults {
        int i;
        int j;
        double result;

        public FractionResults(int i, int j, double result) {
            this.i = i;
            this.j = j;
            this.result = result;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        final ArrayList<FractionResults> fractionResults = this.getFractionResults(arr);
        fractionResults.sort(Comparator.comparingDouble(fr -> fr.result));
        final FractionResults kthSmallest = fractionResults.get(k - 1);
        return new int[]{arr[kthSmallest.i], arr[kthSmallest.j]};
    }

    private ArrayList<FractionResults> getFractionResults(int[] arr) {
        final ArrayList<FractionResults> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                results.add(new FractionResults(i, j, arr[i] * 1.0 / arr[j]));
            }
        }
        return results;
    }
}
