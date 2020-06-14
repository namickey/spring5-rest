# spring5-rest
* Spring5を使ってRESTfulなWEBサービスを作る  
* HTTPメソッド（GET, POST, DELETE, etc）を使い分ける  
* パラメータを受け取る  
* パラメータのバリデーションを行う  
* curl（httpクライアントの1つ）を使う  

## Environment
* JDK 11
* Maven 3
* curl

## Dependencies
```
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.6.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>org.hibernate.validator</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>6.1.5.Final</version>
    </dependency>
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.11.0</version>
    </dependency>
    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.12</version>
      <scope>provided</scope>
    </dependency>
```

## plugins
```
      <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.4.19.v20190610</version>
      </plugin>
```

## Tree
```
├── README.md
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── demo
│       │       ├── IndexController.java
│       │       ├── item
│       │       │   ├── ItemController.java
│       │       │   └── ItemDto.java
│       │       └── task
│       │           ├── TaskController.java
│       │           ├── TaskDto.java
│       │           └── TaskForm.java
│       ├── resources
│       │   └── META-INF
│       │       ├── messages
│       │       │   ├── messages.properties
│       │       │   └── messages_ja.properties
│       │       └── spring
│       │           ├── applicationContext-beans.xml
│       │           └── applicationContext-webmvc.xml
│       └── webapp
│           ├── WEB-INF
│           │   └── web.xml
│           └── index.jsp
├── item.sh
└── task.sh
```

## Start Command
Open the Command Prompt.  
```
「pom.xml」ファイルが存在するディレクトリへ移動する。
cd spring5-rest
```
```
mvn jetty:run
```

## ブラウザで動かす
ブラウザで以下のURLにアクセスする。  
http://localhost:8080/  

## curlで動かす
```
一覧取得
curl -X GET localhost:8080/tasks

登録し、一覧取得
curl -X POST -H "Content-Type: application/json" -d '{"name":"def"}' localhost:8080/tasks
curl -X GET localhost:8080/tasks

削除し、一覧取得
curl -X DELETE -w '%{http_code}\n' localhost:8080/tasks/0
curl -X GET localhost:8080/tasks
```

## Stop Command
```
ctrl + C
```