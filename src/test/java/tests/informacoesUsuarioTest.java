package tests;

import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.nio.cs.Surrogate;
import suporte.Screenshot;
import suporte.generator;

import java.util.concurrent.TimeUnit;

public class informacoesUsuarioTest {
    private  WebDriver navegador;
    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp() {
        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jfmacedo\\divers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando para a página do TaskIt
        navegador.get("http://www.juliodelima.com.br/taskit");

        //Clicar no Link que Possui o text "Sign in", Esse método é melhor aplicado quando for utilizado apenas uma vez
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Clicar no Campo com Name "Password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "More Data About you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();


    }

    //@Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Clicar no Link que Possui o text "Sign in", Esse método é melhor aplicado quando for utilizado apenas uma vez
        navegador.findElement(By.linkText("Sign in")).click();

        //Identificando o formulário de Login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do formulario de id "signinbox" o texto "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Clicar no Campo com Name "Password" que está dentro do formulário de id "signinbox" o texto "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        // clicar no link com o texto "SIGN IN"
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possui a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "More Data About you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

        // Clicar no botão através do seu xpath
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        // Identificar a pop-up onde está o formulário de id add more data
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        // no combo de nome "type" escolher a opção "phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone");

        // no campo de name "contact" digitar o "+551198766789"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+551198766789");

        // clicar no link de text "save" que está na pop up
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        Assert.assertEquals("Your contact has been added!", mensagem);
    }
        @Test
        public void removerUmContatoDeUmUsuario(){
        // clicar no elemento via xpath /span[text()="+5561984097999"]/following-sibling::a/
            navegador.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul/li[5]/a")).click();

        // confirmar janela JavaScript
            navegador.switchTo().alert().accept();

        // Validar mensagem apresentada foi "Rest in peace, dear phone"
            WebElement mensagemPop = navegador.findElement(By.id("toast-container"));
            String mensagem = mensagemPop.getText();
            Assert.assertEquals("Rest in peace, dear phone!", mensagem);

            //String screenshotArquivo = "/Users/jfmacedo/Desktop/test-support/" + generator.dataHoraParaArquivo() + test.getMethodName() = ".png";
           // Screenshot.tirar(navegador, screenshotArquivo);

        // Aguardar até 10 segundos para aque a janela desapareça
            WebDriverWait aguardar = new WebDriverWait(navegador, 10);
            aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
        // clicar no link com texto logout
            navegador.findElement(By.linkText("Logout")).click();

        }


        @After
        public void tearDown() {
        // fechar o navegador

           // navegador.close();
    }
    }


