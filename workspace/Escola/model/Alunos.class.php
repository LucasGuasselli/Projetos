 <?PHP
		
	public class{

	private $matricula;
	private $nome;
	private	$email;
	private	$curso;
	
	public __construct(){
	}
	
	public __destruct(){
	
	}
	
	public function __set($atributo, $valor){
			$this->$atributo = $this->$valor;
	}//fecha set
	
	public function __get($valor){
		return $this->$valor;
	}//fecha get
	
	public function __toString(){
		return '<p>Matricula: '.$this->matricula.
				'<br>Nome: '.$this->nome.
				'<br>Email: '.$this->email.
				'<br>Curso: '.$this->curso.'</p>';
	}	
	
	}//fecha classe
 
 
 >