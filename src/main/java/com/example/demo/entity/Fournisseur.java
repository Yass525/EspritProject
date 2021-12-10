package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fournisseur implements Serialisable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idFournisseur;
	private int codeFournisseur;
	private String libelleFournisseur;
	private String emailFournisseur;
}
