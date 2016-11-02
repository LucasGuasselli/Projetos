package Projeto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CSVReader<T> {
	private Scanner arquivo;
	private Parser<T> parser;

	public CSVReader(String filename, Parser<T> parser)
			throws FileNotFoundException
	{
		this.arquivo = new Scanner( new BufferedReader(	new FileReader(filename)));
		this.parser = parser;		
	}//fecha contrutor
	
	public boolean hasNext() {
		return arquivo.hasNext();
	}//fecha hasNext
	
	public void skipLine() {
		arquivo.nextLine();
	}//fecha skipLine

	public T readObject() {
		return parser.parse(arquivo.nextLine());
	}//readObject
	
	public void close() {
		arquivo.close();
	}//fecha close
}//fecha classe
