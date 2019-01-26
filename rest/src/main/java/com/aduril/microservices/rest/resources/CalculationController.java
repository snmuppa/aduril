package com.aduril.microservices.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aduril.microservices.lib.model.Calculation;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Calculation controller
 * @author Sai-Mac
 *
 */
@RestController
@RequestMapping("calculation")
public class CalculationController {

	private static final String PATTERN = "^-?+\\d+\\.?+\\d*$";

	/**
	 * Calculates the power of the given base to a specified exponent value
	 * 
	 * @param base a number that is to be raised a power
	 * @param exponent a number used in the operation of raising to a power
	 * @return a number which raises base to the power of an exponent
	 */
	@RequestMapping("/power")
	public Calculation pow(@RequestParam(value = "base") String base,
			@RequestParam(value = "exponent") String exponent) {
		List<String> input = new ArrayList<>();
		input.add(base);
		input.add(exponent);
		List<String> output = new ArrayList<>();
		String powValue;
		if (base != null && exponent != null && base.matches(PATTERN) && exponent.matches(PATTERN)) {
			powValue = String.valueOf(Math.pow(Double.valueOf(base), Double.valueOf(exponent)));
		} else {
			powValue = "Base or/and Exponent is/are not set to numeric value.";
		}
		output.add(powValue);
		return new Calculation(input, output, "power");
	}

	/**
	 * Calculates the square root of a given number
	 * 
	 * @param aValue a number for which the square root must be calculated
	 * @return a square root value
	 */
	@RequestMapping(value = "/sqrt/{value:.+}", method = GET)
	public Calculation sqrt(@PathVariable(value = "value") String aValue) {
		List<String> input = new ArrayList<>();
		input.add(aValue);
		List<String> output = new ArrayList<>();
		String sqrtValue;
		if (aValue != null && aValue.matches(PATTERN)) {
			sqrtValue = String.valueOf(Math.sqrt(Double.valueOf(aValue)));
		} else {
			sqrtValue = "Input value is not set to numeric value.";
		}
		output.add(sqrtValue);
		return new Calculation(input, output, "sqrt");
	}

}
