package br.univali.celine.lms.core.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public class FileHandler {

	private static final String folder = "/br/univali/celine/lms/";
	private String content; 

	public FileHandler(HttpServletRequest request, String fileName) throws IOException {

		InputStream inputStream = getClass().getResourceAsStream(folder + fileName);
		BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
		
		StringBuilder sb = new StringBuilder();
        while (true)
        {
            String line = in.readLine();
            if (line == null)
            {
                break;
            }
            
            if (line.contains("CONTEXTPATH")) {
            	line = line.replaceFirst("CONTEXTPATH", request.getContextPath());
            }
            
            sb.append("\n" + line);
            
        }
        
        this.content = sb.toString();
		
	}

	public String getContent() { return this.content; }
}
