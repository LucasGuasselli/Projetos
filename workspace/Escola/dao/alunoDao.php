<?php
	require '../persistencia/conexaoBanco.php';

	class alunoDao{
		private $conexao = null;

		public function __construct(){
			$this->conexao = conexaoBanco::getInstancia();
		}

		public function __destruct(){
			$this->conexao = null;
		}

		public function cadastrarAluno($a){
			try {
				
				$stat = $this->conexao->prepare("insert into aluno(matricula, nome, email, curso) values(null, ?, ?, ?)");

				$stat->bindValue(1, $a->nome);
				$stat->bindValue(2, $a->email);
				$stat->bindValue(3, $a->curso);

				$stat->execute();

			} catch (Exception $e) {
				echo 'Erro ao cadastrar aluno. Erro: '.$e;
			}
		}//close method for new aluno

		public function alterarAluno($a){

			try {

				$stat = $this->conexao->prepare("");
				
			} catch (Exception $e) {
				echo 'Erro ao alterar aluno. Erro: '.$e;
			}

		}//close method for alter aluno

		public function deletarAluno($mat){

			try {

				$stat = $this->conexao->prepare("delete from aluno where matricula=?");

				$stat->bindValue(1, $mat);

				$stat->execute();
				
			} catch (Exception $e) {
				echo 'Erro ao deletar aluno. Erro: '.$e;
			}

		}//close method for delete aluno

	}//close class