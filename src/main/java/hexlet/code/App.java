package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "genDiff", mixinStandardHelpOptions = true, version = "genDiff 4.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Parameters(index = "0", defaultValue = "./src/test/resources/filepath1.json", description = "path to first file")
    private String filepath1;

    @Parameters(index = "1", defaultValue = "./src/test/resources/filepath2.json", description = "path to second file")
    private String filepath2;

    @Option(names = {"-f", "--format"}, paramLabel = "format",
            defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;


    /**
     * Only print method generate().
     *
     * ВОПРОС К ПРОВЕРЯЮЩЕМУ! Не понял как тестировать этот класс.
     *
     * Уверен, что вызывать System.out.println() в методе call() плохая идея, но не разобрался,
     * как по другому?
     */
    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generate(filepath1, filepath2, format));
        return 0;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
