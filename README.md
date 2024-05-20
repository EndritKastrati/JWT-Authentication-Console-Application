<p align="center">
  <a href="https://silasrodrigues.vercel.app">
    <img src="logo1.png" alt="Logo" height="40">
  </a>

<h3 align="center">JWT Authentication</h3>
</p>


## Përmbledhje

Ky projekt demonstron një aplikacion të thjeshtë klient-server duke përdorur JSON Web Tokens (JWT) për autentifikim. Serveri verifikon kredencialet e përdoruesit, gjeneron një token JWT pas hyrjes së suksesshme, dhe lejon klientin të kërkojë të dhëna të mbrojtura duke përdorur këtë token.

## Struktura/files e Projektit

- `JwtUtil.java`: Menaxhon krijimin, validimin dhe nxjerrjen e pretendimeve nga JWT.
- `Client.java`: Implementon një klient të thjeshtë që lidhet me serverin, autentifikohet duke përdorur një emër përdoruesi dhe fjalëkalim, dhe mund të kërkojë të dhëna të mbrojtura duke përdorur një token JWT.
- `Server.java`: Implementon serverin që dëgjon për lidhje nga klientët, verifikon kredencialet, gjeneron token JWT, dhe i përgjigjet kërkesave të klientit.

## Tools të nevojshme

- Java Development Kit (JDK) 
- IntelliJ IDEA (ose çfarëdo IDE për Java)
  
## Shembuj të ekzekutimit
### 1) Rasti i kërkimit të të dhënave :
#### Pjesa e serverit:
![Screenshot (62)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/52afe9bb-638c-4b6a-ab6b-48c70b5471ca)
#### Pjesa e klientit:
![Screenshot (63)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/47c68e5d-38e2-4f4a-bd21-b137e684ffa6)

### 2) Rasti i qkyqjes :
#### Pjesa e serverit:
![Screenshot (59)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/495c5304-8c07-4f9c-9ba2-6a5f62d2ad06)
#### Pjesa e klientit:
![Screenshot (58)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/fc1a2952-6616-4cb0-b487-3f326830c877)

### 3) Rasti i kredencialeve te gabuara :
#### Pjesa e serverit:
![Screenshot (60)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/621bbde8-a151-41b6-9911-532e2074ff78)
#### Pjesa e klientit:
![Screenshot (61)](https://github.com/EndritKastrati/JWT-Authentication-Console-Application/assets/122494705/8f1253f8-5d49-4d13-a765-cef6c56b1cf4)






## Marrja e projektit

### Klononi Repositorin

```sh
git@github.com:EndritKastrati/JWT-Authentication-Console-Application.git
```

<a href="#top">Shko në fillim ↑</a>


