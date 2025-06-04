# 🌐 Spring Cloud Gateway 서비스

본 저장소는 Spring Cloud Gateway를 활용한 API Gateway 서비스 프로젝트입니다.  
마이크로서비스 아키텍처에서 라우팅, 필터링, 로드밸런싱 등의 핵심 기능을 제공합니다.

## 🧩 프로젝트 구성

```
springcloud-gateway/
├── .mvn/wrapper/         # Maven Wrapper 설정
├── src/                  # 소스 코드
├── .gitignore           # Git 무시 파일 설정
├── mvnw                 # Maven Wrapper 스크립트 (Unix)
├── mvnw.cmd             # Maven Wrapper 스크립트 (Windows)
└── pom.xml              # Maven 프로젝트 설정
```

## 🛠 사용 기술

* Java 11+
* Spring Boot
* Spring Cloud Gateway
* Maven 3.6+
* Spring Cloud Netflix

## 🚀 시작하기

### 1. 저장소 클론
```bash
git clone https://github.com/yongchulShin/springcloud-gateway.git
cd springcloud-gateway
```

### 2. 프로젝트 빌드
```bash
./mvnw clean install
```

### 3. 애플리케이션 실행
```bash
./mvnw spring-boot:run
```

## ⚡ 주요 기능

* **라우팅**
  - 동적 라우트 설정
  - 서비스 디스커버리 연동
  - URL 기반 라우팅

* **필터링**
  - 요청/응답 변형
  - 헤더 수정
  - 로깅

* **로드밸런싱**
  - Round Robin
  - Weight 기반 분산
  - 서비스 인스턴스 동적 관리

* **보안**
  - JWT 토큰 검증
  - Rate Limiting
  - CORS 설정

## 📋 API 문서

API 문서는 Swagger를 통해 제공됩니다:
```
http://localhost:8080/swagger-ui.html
```

## 🙋‍♂️ About Me

신용철 (Yongchul Shin)  
전 서든어택 프로게이머 → 백엔드 개발자  
GitHub: github.com/yongchulShin  
Email: prozernim@gmail.com 
