<?php
class ConexaoBanco extends PDO{
	
   private static $instancia=null;
	
   public function ConexaoBanco($dsn,$usuario,$senha){
		parent::__construct($dsn,$usuario,$senha);
   }
	
   public static function getInstancia(){
   	if(!isset(self::$instancia)){
		try{
			self::$instancia = new ConexaoBanco("mysql:dbname=escola;host=localhost","root","usbw");
		}catch(Exception $e){
			echo 'Erro ao conectar';
		    exit();				
		}//fecha catch
	}//fecha if
	return self::$instancia;
   }//fecha método

}//fecha classe