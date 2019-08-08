package controller;

import static java.lang.Math.log10;
import static java.lang.Math.pow;

import java.text.DecimalFormat;

public class Calculator {
    public enum BiOperatorModes {
        normal, add, minus, multiply, divide , xpowerofy, xrootofy 
    }

    public enum MonoOperatorModes {
        square, squareRoot, oneDevidedBy, cos, sin, tan ,log , rate, abs, arccos, arcsin, arctan
    }

    private Double num1, num2;
    private BiOperatorModes mode = BiOperatorModes.normal;

    private Double calculateBiImpl() {
        if (mode == BiOperatorModes.normal) {
            return num2;
        }
        if (mode == BiOperatorModes.add) {
            return num1 + num2;
        }
        if (mode == BiOperatorModes.minus) {
            return num1 - num2;
        }
        if (mode == BiOperatorModes.multiply) {
            return num1 * num2;
        }
        if (mode == BiOperatorModes.divide) {
            return num1 / num2;
        }
        if (mode == BiOperatorModes.xpowerofy) {
            return pow(num1,num2);
        }
        if (mode == BiOperatorModes.xrootofy) {
        	DecimalFormat df = new DecimalFormat("#.############");
        	return Double.parseDouble(df.format(pow(num1, 1/num2)));
        }

        // never reach
        throw new Error();
    }

    public Double calculateBi(BiOperatorModes newMode, Double num) {
        if (mode == BiOperatorModes.normal) {
            num2 = 0.0;
            num1 = num;
            mode = newMode;
            return Double.NaN;
        } else {
            num2 = num;
            num1 = calculateBiImpl();
            mode = newMode;
            return num1;
        }
    }

    public Double calculateEqual(Double num) {
        return calculateBi(BiOperatorModes.normal, num);
    }

    public Double reset() {
        num2 = 0.0;
        num1 = 0.0;
        mode = BiOperatorModes.normal;

        return Double.NaN;
    }

    public Double calculateMono(MonoOperatorModes newMode, Double num) {
        if (newMode == MonoOperatorModes.square) {
            return num * num;
        }
        if (newMode == MonoOperatorModes.squareRoot) {
            return Math.sqrt(num);
        }
        if (newMode == MonoOperatorModes.oneDevidedBy) {
            return 1 / num;
        }
        if (newMode == MonoOperatorModes.cos) {
            return Math.cos(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.sin) {
            return Math.sin(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.tan) {
            return Math.tan(Math.toRadians(num));
        }
        if (newMode == MonoOperatorModes.arccos) {
        	DecimalFormat df = new DecimalFormat("#.############");
            return Double.parseDouble(df.format(Math.toDegrees(Math.acos(num))));
        }
        if (newMode == MonoOperatorModes.arcsin) {
        	DecimalFormat df = new DecimalFormat("#.############");
            return Double.parseDouble(df.format(Math.toDegrees(Math.asin(num))));
        }
        if (newMode == MonoOperatorModes.arctan) {
        	DecimalFormat df = new DecimalFormat("#.############");
           return Double.parseDouble(df.format(Math.toDegrees(Math.atan(num))));
        }
        if (newMode == MonoOperatorModes.log) {
            return log10(num);
        }
        if (newMode == MonoOperatorModes.rate) {
           return num / 100;
        }
        if(newMode == MonoOperatorModes.abs){
            return Math.abs(num);
        }
        


        // never reach
        throw new Error();
    }

}
