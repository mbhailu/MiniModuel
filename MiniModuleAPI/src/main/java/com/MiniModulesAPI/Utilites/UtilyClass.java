package com.MiniModulesAPI.Utilites;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
public class UtilyClass {
	
	private static String BASEPATH="E:/APIs/MiniModuleAPI/ModulesFiles/Log/";
	
	
	
	public static void writeLog(String message, Exception ex) throws ExceptionHandling {
		StringBuffer sb = new StringBuffer(message);
		sb.append("\n");
		if (ex != null && ex.getStackTrace() != null && ex.getStackTrace().length > 0) {
			for (StackTraceElement stackTrace : ex.getStackTrace()) {
				sb.append(stackTrace.getFileName()).append(" : ").append(stackTrace.getClassName()).append(" : ")
						.append(stackTrace.getMethodName()).append(" : ").append(stackTrace.getLineNumber())
						.append("\n");
			}
		}

		
			if (sb.length() > 0) {
				FileWriter fw;
				try {
					fw = new FileWriter(BASEPATH + "/log.txt", true);
					fw.write(Calendar.getInstance().getTime() + " : " + sb.toString());
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
	}
}
