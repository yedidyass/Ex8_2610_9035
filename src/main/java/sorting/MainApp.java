package sorting;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class MainApp {
    public static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        //AlgorithmRunner algorithmRunner = new AlgorithmRunner();
        algorithmRunner.runAlgorithms();
    }

    @Produces
    @Named("qs")
    SortingAlgorithm<Integer> QSsortingAlgorithmGenerator() {
        return container.select(QuickSort.class).get();
    }

    @Produces
    @Named("bs")
    SortingAlgorithm<Integer> BSsortingAlgorithmGenerator() {
        return container.select(BubbleSort.class).get();
    }

    @Produces
    @Named("numElements")
    int numElementInjection() {
        return 1000;
    }
}
