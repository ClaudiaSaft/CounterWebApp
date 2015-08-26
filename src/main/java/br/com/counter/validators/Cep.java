package br.com.counter.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CepValidator.class)
@Documented
@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {

	String message() default "Cep inválido";
	
	//PARA QUE SERVEM ESSES DOIS METODOS????
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };

	//SE NAO COLOCAR DEFAULT, O VALOR VAI SER OBRIGATORIO
	String value() default "";
}
