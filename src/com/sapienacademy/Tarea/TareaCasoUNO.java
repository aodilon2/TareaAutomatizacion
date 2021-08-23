package com.sapienacademy.Tarea;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TareaCasoUNO {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

			//Ruta de Webdriver
			System.setProperty("webdriver.chrome.driver", "D:\\CURSO\\chromedriver.exe" );
			 
			//Instancia del navegador
			WebDriver customDriver = new ChromeDriver();
			
			//Ingresar a la p�gina principal y Maximizar la pantalla
			customDriver.get("https://winstoncastillo.com/robot-selenium/index.php?route=common/home");
			customDriver.manage().window().maximize();
			
			//Obtener n�mero de elementos para a�adir al carrito
			WebElement listaDeProductos = customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]"));
			List <WebElement> productosMostrados = listaDeProductos.findElements(By.tagName("h4"));
			System.out.println("N�mero de productos listados en feature :" + " " + productosMostrados.size());
			
			//Obtenci�n y comparaci�n n�mero de Items y precio
			System.out.println("El carrito tiene: " + " " + customDriver.findElement(By.id("cart-total")).getText() + " Puedes proceder");
			Assert.assertEquals(customDriver.findElement(By.id("cart-total")).getText(), "0 item(s) - $0.00");
			
			//Agregar a lista lista de deseos y obtener mensaje de error
			customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[2]")).click();
			Thread.sleep(2000);
			//System.out.println(customDriver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]")).getText());
			//Assert.assertEquals(customDriver.findElement(By.xpath("//*[@id=\"common-home\"]/div[1]")).getText(), "You must login or create an account to save MacBook Pro to your wish list! X"); 
			
			//Agregar Item al carrito y verificar cantidad y Precio
			customDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[3]/button[1]")).click();
			Thread.sleep(2000);
			System.out.println("El carrito tiene: " + " " + customDriver.findElement(By.id("cart-total")).getText());
			Assert.assertEquals(customDriver.findElement(By.id("cart-total")).getText(), "1 item(s) - $602.00");
			System.out.println("Compra compra compra...");
			
			//customDriver.close();
	}

}
