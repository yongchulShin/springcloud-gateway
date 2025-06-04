# Spring Cloud Gateway

Spring Cloud Gateway는 API Gateway 서비스를 구현한 프로젝트입니다. Spring Cloud Gateway를 사용하여 마이크로서비스 아키텍처에서 라우팅, 필터링, 로드밸런싱 등의 기능을 제공합니다.

## 기술 스택

- Java
- Spring Boot
- Spring Cloud Gateway
- Maven

## 프로젝트 구조

```
springcloud-gateway/
├── .mvn/wrapper/         # Maven Wrapper 설정
├── src/                  # 소스 코드
├── .gitignore           # Git 무시 파일 설정
├── mvnw                 # Maven Wrapper 스크립트 (Unix)
├── mvnw.cmd             # Maven Wrapper 스크립트 (Windows)
└── pom.xml              # Maven 프로젝트 설정
```

## 시작하기

### 필수 조건

- JDK 11 이상
- Maven 3.6 이상

### 설치 및 실행

1. 레포지토리 클론
```bash
git clone https://github.com/yongchulShin/springcloud-gateway.git
```

2. 프로젝트 디렉토리로 이동
```bash
cd springcloud-gateway
```

3. 프로젝트 빌드
```bash
./mvnw clean install
```

4. 애플리케이션 실행
```bash
./mvnw spring-boot:run
```

## 주요 기능

- API 라우팅
- 요청/응답 필터링
- 로드 밸런싱
- 서비스 디스커버리 연동
- 보안 설정

## 라이선스

This project is licensed under the MIT License - see the LICENSE file for details.
