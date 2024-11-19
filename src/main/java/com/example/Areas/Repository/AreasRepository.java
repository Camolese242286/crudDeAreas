package com.example.Areas.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Areas.Model.Areas;

@Repository 
public interface AreasRepository extends JpaRepository<Areas, Long>  {

	
	@Query(value="select u from usuario u where u.nome like %?1%")
   List<Areas> buscarPorNome(String nome);


}
