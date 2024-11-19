package com.example.Areas.Controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Areas.Model.Areas;
import com.example.Areas.Repository.AreasRepository;

@RestController
@CrossOrigin("*")
public class AreasController {

	
	@Autowired
	private AreasRepository areasRepositoy;
	
	
	@RequestMapping(value="mostrarnome/{nome}",method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String greetingText(@PathVariable String nome) {
		
		
		Areas areas1= new Areas();
		areas1.setNome(nome);
		
		areasRepositoy.save(areas1);
		
		return "nome " + nome ;
	}


	@GetMapping(value= "listtatodos")
	@ResponseBody
	public ResponseEntity< java.util.List<Areas> > listaUsuario(){
		
	java.util.List<Areas> areas=	areasRepositoy.findAll();
	
	return new ResponseEntity<java.util.List<Areas>>(areas, HttpStatus.OK);
	}


	@PostMapping(value= "salvar")
	@ResponseBody
	public ResponseEntity<Areas> salvar (@RequestBody Areas areas){
		
		Areas areas1 =areasRepositoy.save(areas); 
	
	return  new ResponseEntity<Areas>(areas, HttpStatus.OK);
	}
	
	@DeleteMapping(value= "delete")
	@ResponseBody
	public ResponseEntity<String> deletar (@RequestParam long idareas){
		
		areasRepositoy.deleteById(idareas);
	
	return  new ResponseEntity<String>("requisito deletado com suceso ", HttpStatus.OK);
	}
	
	
	
	@GetMapping(value= "atualizar")
	@ResponseBody
	public ResponseEntity<Areas> atualizar (@RequestParam Areas areas){
		
		Areas areas1 = areasRepositoy.save(areas);
	
	return  new ResponseEntity<Areas>(areas1, HttpStatus.OK);
	}	

	
	@PutMapping(value= "buscaruserid")
	@ResponseBody
	public ResponseEntity<Areas> buscaruserid (@RequestParam(name="idareas") long idareas){
		
		Areas areas =  areasRepositoy.findById(idareas).get();
	
	return  new ResponseEntity<Areas>(areas, HttpStatus.OK);
	}
	
	
	@PutMapping(value= "buscarPorNome")
	@ResponseBody
	public ResponseEntity<java.util.List<Areas>> buscarPorNome (@RequestParam(name="nome") String nome){
		
    java.util.List<Areas> areas =  areasRepositoy.buscarPorNome(nome);
	
	return  new ResponseEntity<java.util.List<Areas>>(areas, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	public AreasRepository getUsuarioRepositoy() {
		return areasRepositoy;
	}


	public void setUsuarioRepositoy(AreasRepository usuarioRepositoy) {
		this.areasRepositoy = usuarioRepositoy;
	}

}
