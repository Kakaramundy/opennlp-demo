
package org.fogbeam.example.opennlp;

import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class TokenizerMain
{
	public static void main( String[] args ) throws Exception,FileNotFoundException, IOException
	{
		
		String archivoEntrada="Entrada.txt";
		String archivoSalida="Salida.txt";
		String cadena;
		StringBuilder contentBuilder = new StringBuilder();
        FileReader f = new FileReader("C:\\Users\\AlejandroDorta\\Downloads\\opennlp-demo-master\\src\\main\\java\\org\\fogbeam\\example\\opennlp\\" + archivoEntrada);
        BufferedReader b = new BufferedReader(f);
        
        while((cadena = b.readLine())!=null) {
            
            contentBuilder.append(cadena).append("\n");
        }
        b.close();
        System.out.println(contentBuilder.toString());
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		try
		{      
			TokenizerModel model = new TokenizerModel( modelIn );
			Tokenizer tokenizer = new TokenizerME(model);
				/* note what happens with the "three depending on which model you use */
			String[] tokens = tokenizer.tokenize( contentBuilder.toString()  );
			for( String token : tokens )
			{
				System.out.println( token );
			}
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
	}
}
