package co.edu.escuelaing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/collatz")
    public CollatzResponse collatz(@RequestParam int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("El número debe ser un entero positivo.");
        }

        List<Integer> sequence = new ArrayList<>();
        sequence.add(value);

        while (value != 1) {
            if (value % 2 == 0) {
                value = value / 2;
            } else {
                value = 3 * value + 1;
            }
            sequence.add(value);
        }

        String output = String.join(" -> ", sequence.stream().map(String::valueOf).toArray(String[]::new));

        return new CollatzResponse("collatzsequence", sequence.get(0), output);
    }

    @GetMapping("/sum")
    public double sum(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/div")
    public double div(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new ArithmeticException("División por cero no permitida");
        return a / b;
    }

    public static class CollatzResponse {
        private String operation;
        private int input;
        private String output;

        public CollatzResponse(String operation, int input, String output) {
            this.operation = operation;
            this.input = input;
            this.output = output;
        }

        public String getOperation() {
            return operation;
        }

        public int getInput() {
            return input;
        }

        public String getOutput() {
            return output;
        }
    }
}