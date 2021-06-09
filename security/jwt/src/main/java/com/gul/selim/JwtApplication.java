package com.gul.selim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// https://medium.com/swlh/spring-boot-security-jwt-hello-world-example-b479e457664c

// SpringFramework'ün security mekanizmasına göre, tüm authorization kontroller aslında framework'ün kendisi tarafından
// SecurityContextHolder üzerinden gerçekleştirilir. Yapılan tanımlar (bean ve hangi endpoint'ler için authentication olacağı) ve 
// programatik kontroller SecurityContextHolder içindeki yapıların set edilmesini hedefler. 
// (resources/spring-security-architecture.jpg)

// 1. WebSecurityConfig::configure içerisinde;
//	  a) Hangi endpoint'lerin authentication kontrollerine tabi olup olmadığı belirtilir.
//    b) Authentication gereken endpoint'lere gerekli bilgiler sağlanmadığında alınacak hatanın handle edileceği yapı belirtilir.
//       Bu yapı ile istenen dönüş (Unauthorized vb.) set edilebilir.
//    c) Tüm requestlerin üzerinden geçeceği filtre tanımlanır.
//
// 2. WebSecurityConfig içerisinde tüm kontrolleri gerçekleştirecek AuthenticationManager'ın oluşturulması için bir bean tanımı yer alır.
//    Ayrıca AuthenticationManager'ın üretilmesinden sorumlu AuthenticationManagerBuilder'e kimlik doğrulama işlemlerinde kullanılacak 
//    UserDetailsService interface'inden türetilmiş nesnenin ve PasswordEncode işlemlerinde kullanılacak nesnenin instance'larının set
//    edildiği bir bölüm yer alır. AuthenticationManager kendine gelen user bilgisini implementation'ının bilmediği bu UserDetailsService'e
//	  verir ve yine kendine gelen password bilgisini encode ederek UserDetailsService'in kendisine ilettiği password ile karşılaştırır.
//    Şifrenin açık halinin saklanmadığı ve karşılaştırmada encode edilmiş halinin kullanılması önemlidir.
//
// 3. JwtRequestFilter içerisinde gelen her request içinde JWT olup olmadığı kontrol edilir.
//    a) Eğer token var ise token içerisindeki bilgileri kontrolü gerçekleştirilir. 
//       Bu noktada token'dan elde edilen username bilgisi JwtUserDetailsService üzerinde kontrol edilebilir. Ek olarak token'ın expire olup 
//       olmaması da kontrole eklenebilir. Nihayetinde amaç kontrol sonucu kullanıcının geçerki olduğu görülürse SecurityContextHolder
//       altındaki authentication nesnesinin set edilmesidir.
//    b) Eğer token yoksa ya daha önceden token alınmadan yapılan bir istek söz konusudur ki bu durumda Spring Framework izin vermeyecektir ve
//       WebSecurityConfig::configure içerisinde set ettiğimiz exception handler devreye girecektir ya da token almak için user/password ile yapılan 
//       bir istek söz konusudur. Bu durumda sadece AuthenticationManager nesnesinin authencate metodu bu user ve password ile çağrılır.
//       WebSecurityConfig::configure içerisinde yaptığımız tanım gereği AuthenticationManager authenticate işlemini nasıl yapacağını biliyordur.
//       Eğer bu noktada bir hata alınmamışsa JWT üretilip isteğe dönüş yapılır. 

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtApplication.class, args);
	}

}
