package com.example.Areas.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seq_usuario" ,sequenceName ="seq_usuario" ,allocationSize = 1 )
public class Areas implements Serializable{
	
	




		private static final long serialVersionUID = 1L;
	   
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "seq_usuario")
		
		private long id;
		
		private String nome;


		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}


	}



