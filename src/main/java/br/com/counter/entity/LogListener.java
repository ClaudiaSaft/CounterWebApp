package br.com.counter.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;

public class LogListener implements Serializable{

	private static final long serialVersionUID = 1L;

	@PrePersist
	public void changeDate(Audit audit){
		System.out.println("PRE PERSIST: ");
		audit.setDataCadastro(new Date());
	}
}
