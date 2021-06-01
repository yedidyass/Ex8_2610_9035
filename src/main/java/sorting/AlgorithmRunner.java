package sorting;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {
    @Inject
    @Named("bs")
    SortingAlgorithm<Integer> quadraticAlgorithm;
    @Inject
    @Named("qs")
    SortingAlgorithm<Integer> nlognAlgorithm;
    //SortingAlgorithm<Integer> quadraticAlgorithm = new BubbleSort();
    //SortingAlgorithm<Integer> nlognAlgorithm = new QuickSort();
    @Inject
    @Named("numElements")
    int numberOfElements;

    public void runAlgorithms() {
        Random rand = new Random();
        Integer[] ints = rand.ints(1, Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
    }
}
