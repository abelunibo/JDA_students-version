package com.laneve.deadlock.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class FromClass2Txt {
	
	File sourceDir;
	File destDir;
	
	public FromClass2Txt(String soureDir, String destDir){
		this.sourceDir = new File(soureDir);
		this.destDir = new File(destDir);
	}
	
	public void convert() throws IOException{
		
		System.out.println("Reading on dir: "+ sourceDir.getAbsolutePath());
		System.out.println("writing on dir: "+ destDir.getAbsolutePath());

	    for (File fileEntry : sourceDir.listFiles()) {
	    	String filenameC = fileEntry.getName();
	    	String filenameT = filenameC.substring(0, fileEntry.getName().length()-6) + ".txt";
	    	
	    	System.out.println("Processing: "+ filenameC);
	    	System.out.println("Writing " + filenameT);
	    	
			System.out.println("Eseguo javap -c "+ filenameC);
			String[] cmd = {"javap","-c", "-v", "-private", sourceDir.getAbsolutePath()+"/"+filenameC};
			try {
				//TODO ATTENZIONE se esiste gia' un file <textFilePath>.txt verra' sovrascritto
				
				//per visualizzare l'output del comando javap su console invece che su file
				//Process p = new ProcessBuilder(cmd).redirectOutput(Redirect.INHERIT).redirectError(Redirect.INHERIT).start();
				Process p = new ProcessBuilder(cmd).redirectError(Redirect.INHERIT).redirectOutput(
						new File(destDir.getAbsolutePath() + "/"+ filenameT)).start();		
				p.waitFor(); // attendo la terminazione del processo
				
			} catch (IOException e) {
				System.err.println("Errore di I/O durante l'esecuzione del processo di \"javap\"");
				e.printStackTrace();
				System.exit(1);
			} catch (InterruptedException e) {
				System.err.println("Sono stato interrotto mentre attendevo che \"javap\" concludesse l'esecuzione");
				e.printStackTrace();
				System.exit(1);
			}
	    	
	    }
		
	}

}
