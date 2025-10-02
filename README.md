# Spring Authorization Server

This project is a Spring Authorization Server implementation that provides OAuth2 and OpenID Connect (OIDC) authentication flows.  
It issues JWT access tokens, refresh tokens, and ID tokens, and supports PKCE, consent screens, and OIDC discovery.

Built with **Java 21** and Spring Boot.

---

## 🚀 Prerequisites

- [Java JDK 21](https://adoptium.net/) installed and available on your system

```bash
java -version
```

should display version `21`.

- No need to install Maven globally. The project includes the **Maven Wrapper** (`mvnw`).

---

## ▶️ Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/your-username/auth-server.git
cd auth-server
```

### 2. Run with Maven Wrapper

On Linux / macOS:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw spring-boot:run
```

The Authorization Server will start at:

```text
http://localhost:9000
```

---

## 🛠️ Building the Project

### Package the JAR

```bash
./mvnw clean package
```

The compiled JAR will be located in:

```text
target/auth-server-0.0.1-SNAPSHOT.jar
```

### Run the JAR

```bash
java -jar target/auth-server-0.0.1-SNAPSHOT.jar
```

---

## 🔐 OAuth2 / OIDC Endpoints

The server provides the following endpoints:

| Endpoint                            | Description                                               |
| ----------------------------------- | --------------------------------------------------------- |
| `/.well-known/openid-configuration` | OIDC discovery metadata                                   |
| `/oauth2/authorize`                 | Authorization endpoint (Authorization Code + PKCE)        |
| `/oauth2/token`                     | Token endpoint (exchange code for tokens, refresh tokens) |
| `/userinfo`                         | UserInfo endpoint (OIDC claims)                           |
| `/oauth2/jwks`                      | JWKS endpoint (public keys for JWT verification)          |

---

## 🧪 Default Client Configuration

This project registers a demo client:

- **Client ID:** `oidc-client`
- **Client Secret:** `secret` (no-op encoded)
- **Redirect URI:** `http://localhost:5173/login/oauth2/code/oidc-client`
- **Post-Logout Redirect URI:** `http://localhost:5173`
- **Grant Types:** Authorization Code (with PKCE), Refresh Token
- **Scopes:** `openid`, `profile`
- **Consent Required:** ✅

---

## 🔧 Example Login Flow

1. Open browser to:

   ```text
   http://localhost:9000/oauth2/authorize?response_type=code&client_id=oidc-client&scope=openid%20profile&redirect_uri=http://localhost:5173/login/oauth2/code/oidc-client&code_challenge=xyz&code_challenge_method=S256&state=abc
   ```

2. Sign in with your credentials.
3. The server redirects back to the client with an authorization code.
4. Exchange the code at `/oauth2/token` to receive:

   - `access_token` (for APIs)
   - `id_token` (with user identity claims)
   - `refresh_token` (if requested)

---

## 📖 API Documentation

The OpenAPI 3 specification is served as a static file at:

```text
http://localhost:9000/api-docs.yml
```

You can load this file into [Swagger Editor](https://editor.swagger.io/) or any OpenAPI viewer.

---

## 🧹 Clean & Rebuild

```bash
./mvnw clean install
```

---

## 📦 Dependencies

- Spring Boot 3.x
- Spring Authorization Server
- Spring Security
- Lombok
- H2 Database (for demo persistence)
