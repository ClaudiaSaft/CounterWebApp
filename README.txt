$ mvn archetype:generate -DgroupId=com.mkyong 
	-DartifactId=CounterWebApp 
	-DarchetypeArtifactId=maven-archetype-webapp 
	-DinteractiveMode=false

-adicionando jboss no projeto
clicar com direito no projeto > properties > java build path > Add library > server runtime > Jboss 7.0 runtime

-adicionando configurações jsf no projeto (nao incluir nada no pom.xml, pois as bibliotecas já estão no jboss)
http://imasters.com.br/linguagens/java/criando-projeto-jsf-com-maven-eclipse/

-Configurar mysql no jboss.
https://lucianomolinari.wordpress.com/2012/02/23/criando-um-datasource-no-jboss-7/

-Criar datasource no jboss
-Acessar localhost:8080 > administrador console > criar o datasource.

-configurar persistence.xml no projeto
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">
	<persistence-unit name="testPU">
		<provider>org.hibernate.ejb.HibernatePersistence</provider>
		
		<jta-data-source>java:jboss/datasources/test-ds</jta-data-source>
	
	</persistence-unit>
	
</persistence>

-incluindo JSF
weapp > WEB-INF > faces-config.xml

<?xml version="1.0" encoding="UTF-8"?>

<faces-config
    xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd"
    version="2.0">

</faces-config>


--para habilitar CDI e permitir injection, deve ser criado o arquivo beans.xml dentro da pasta WEB-INF
