package com.netBanking.testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.netBanking.utilities.readConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	readConfig rd = new readConfig();
	
	
	public String baseURL=rd.getApplicationURL();
	public String username=rd.getUsername();
	public String password=rd.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	//Test Case 2 Data
	public String Name=rd.getName();
	public String Dob =rd.getDob();
	public String Address=rd.getAddress();
	public String City=rd.getCity();
	public String State=rd.getState();
	public String Email=rd.getEmail();
	
	
	@BeforeClass
	public void setup() throws IOException {
		
		//System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		//driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
			
		
		 logger = Logger.getLogger("ebanking");
		 PropertyConfigurator.configure("log4j.properties"); 
	}
	
	 @AfterClass
	 public void tearDown() {
		driver.quit();
	}  
	 public List<String> imagepath= new ArrayList<String>();
	 public List<String> description= new ArrayList<String>();
	 int x=0;
	 public void takeSnapShot(WebDriver driver, String Description) throws IOException {
		 	x=x+1;
			String path="C:\\Users\\102789\\eclipse-workspace\\netBankingV2\\Screenshots\\captureScreens"+"\\test"+x+".png";
			imagepath.add(path);
			description.add(Description);
			TakesScreenshot scrShot =(TakesScreenshot)driver;
	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);	
	        File DestFile=new File(path);
	        FileUtils.copyFile(SrcFile, DestFile);
 }
	 
	 
	 int y=0;
	 //PDF Result File----
	 public void PDF(List<String> imageFiles, String TestCaseName, List<String> Description) throws FileNotFoundException, MalformedURLException {	
		 
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String curDate = dtf.format(now).toString();
		   System.out.println(curDate); 
		   y=y+1;
		 
		 String path="C://Users//102789//eclipse-workspace//netBankingV2//Screenshots/"+" "+TestCaseName+curDate+".pdf";
		 
		 float [] pointColumnWidths = {200f};
	     Table table = new Table(pointColumnWidths);
	     PdfWriter pdfwriter = new PdfWriter(path);
	     PdfDocument pdfDoc = new PdfDocument(pdfwriter);
	     Document doc = new Document(pdfDoc);
		for(int i=0;i<imageFiles.size() && i<Description.size() ;i++) {	
				Cell cell1 = new Cell(); 
				ImageData data = ImageDataFactory.create(imageFiles.get(i));         
				Image img = new Image(data);             
				cell1.add(img.scaleAbsolute(400f,150f)); 
				cell1.add(new Paragraph(Description.get(i)));
				cell1.setMarginBottom(2);
				table.addCell(cell1); 		    
		}
	    doc.add(table) ;
		doc.close();	 
		
	}
	 

}
