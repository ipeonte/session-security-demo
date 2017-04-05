# Demo client and server to test Common Session Security layer from previous project.

Prerequisites:

Build common-session-secuirty project
mvn clean install

The demo steps are next:

## 1. Running client in dev mode without security.

  1.a. Compile both client and server with default

    mvn clean install

  1.b. Start client only

    java -jar security-demo-client/target/client-1.0.0-RELEASE.jar
  
  1.b. By default client doesn't have security layer included so all endpoints are open. Navigate on

    http://localhost:8082/client/info

It will be no output because session is empty.

  1.c Start Apache (or nodejs) server with session-mgr project included. Navigate on

    http://localhost/session_mgr

Set next session parameters:
  Key: userName
  Value: demo
  
Click submit

1.d. Return on localhost:8082/client/info. It should show next output

## 2. Running client in real mode with security.

  2.a. Compile both client and server with security profile

    mvn clean install -P secure

  2.b. Start both client and server. Pay attention that client jar file now have word "secure"

    java -jar security-demo-client/target/client-secure-1.0.0-RELEASE.jar
    java -jar security-demo-auth-server/target/auth-server-1.0.0-RELEASE.jar 
    
  2.c. Open incognito(anonymous) browser window and navigate on

    http://localhost:8082/client/info

Check for 403 error returned.

  2.d. Open another tab and navigate on

    http://localhost:8082/server/login

  2.e. Login with user/password

  2.f. Switch back on first tab and refresh link

    http://localhost:8082/client/info

  2.g. Check that both tabs have same userName session parameter and same session id

  2.h. Repeat steps 2.c - 2g for different credentials: 
  test/password
  admin/password
