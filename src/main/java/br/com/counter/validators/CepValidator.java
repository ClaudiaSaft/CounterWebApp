package br.com.counter.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CepValidator implements ConstraintValidator<Cep, String>{

	private Pattern pattern =  Pattern.compile("[0-9]{5}-[0-9]{3}");
	
	private String value;
	
	@Override
	public void initialize(Cep cep) {
		value = cep.value();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println(this.value);
		
		if (value == null || value.isEmpty()) {
			return true;
		}
		
		Matcher m = pattern.matcher(value);
	    return m.matches();
	}

}
