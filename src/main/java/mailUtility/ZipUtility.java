package mailUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtility {
	
	private List<String> filelist;
	private static final String OUTPUT_ZIP_FILE=System.getProperty("user.dir")+"\\automationreport\\report.zip";
	
	private static final String SOURCE_FOLDER=System.getProperty("user.dir")+"\\automationreport";
	
	public ZipUtility() {
		filelist=new ArrayList<String>();
	}
	
	public void zipIt(String filename)
	{
	try {
		
		byte[] buffer=new byte[1024];
		
		
		String source=new File(SOURCE_FOLDER).getName();
		
		FileOutputStream fos=new FileOutputStream(filename);
		ZipOutputStream zos=new ZipOutputStream(fos);
		FileInputStream fileinput=null;
		try {
			
			
			for(String file:this.filelist)
			{
			ZipEntry ze=new ZipEntry(source+File.separator+file);
			
			zos.putNextEntry(ze);
				fileinput=new FileInputStream(SOURCE_FOLDER+File.separator+file);
				int len;
				while((len=fileinput.read(buffer))>0)

				{
				zos.write(buffer,0,len);
					
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			fileinput.close();
		}
		zos.closeEntry();
		
		System.out.println("Folder compressed sucessfully");
		
		zos.close();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	
		
		
	}
	
	
	
	public void generateFileList(File node)
	{
		
		try {
			
			if(node.isFile())
			{
				
				filelist.add(generatezipentry(node.toString()));
			}
			
			if(node.isDirectory())
			{
				
			String[] subnode=node.list();
			
			for(String filename:subnode)
			{
				
				generateFileList(new File(node,filename));
			}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private String generatezipentry(String file)
	{
		return file.substring(SOURCE_FOLDER.length()+1, file.length());
		
		
	}
	
	
	

}
