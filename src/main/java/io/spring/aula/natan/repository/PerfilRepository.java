package io.spring.aula.natan.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import io.spring.aula.natan.entity.Perfil;


public interface PerfilRepository extends MongoRepository<Perfil, String> {

	 Perfil findByNome(String role_admin);
}
