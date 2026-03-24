package co.edu.escuelaing;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ArrayList;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/collatz")
    public double collatz(@RequestParam double value){
        double x = 0;
        while (value != 1){
            if (value % 2==0) {
                x = value/2 ;
            } else{
                x = (3*value)+1;
            }
            return x;
        }
    }

    @GetMapping("/sum")
    public double sum(@RequestParam double value, @RequestParam double b) {
        return value + b;
    }

    @GetMapping("/div")
    public double div(@RequestParam double value, @RequestParam double b) {
        if (b == 0) throw new ArithmeticException("División por cero no permitida");
        return value / b;
    }
}
